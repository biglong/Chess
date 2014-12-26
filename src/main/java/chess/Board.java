package chess;

import util.StringUtil;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p>Description: This is the chess board </p>
 *
 * @author: huangshaolong
 * Date: 4/15/14
 * Time: 1:52 PM
 * CopyRight com.tom.ule
 */

public class Board implements Notifier{
    public static final int ROW_NUM = 8;
    public static final  int COLUMN_NUM = 8;
    public static final char EMPTY_GRID = '.';
    private List<List<Block>> checkers;
    private List<Block> blackPiece = new ArrayList<Block>();
    private List<Block> whitePiece = new ArrayList<Block>();

    public enum Move{UP,DOWN,LEFT,RIGHT}

    public Map<Block.Role,BigDecimal> blockPoint;

    public Board() {
        initialize();
    }

    private void initialize() {
        checkers = new ArrayList<List<Block>>(8);
        for (int i = 1; i < ROW_NUM+1; i++) {
            List<Block> linePiece = new ArrayList<Block>(8);
            checkers.add(linePiece);
            for (int j = 1; j < ROW_NUM+1; j++) {
                Block piece = getInitPiece(this,i,j);

                linePiece.add(piece);
            }
        }


    }

    private Block getInitPiece(Board board,int rank, int row) {
//        if(row == 1){
//          switch (column){
//              case 1:return Piece.create(Piece.Color.WHITE, Piece.Role.ROOK);
//              case 2:return Piece.create(Piece.Color.WHITE, Piece.Role.KNIGHT);
//              case 3:return Piece.create(Piece.Color.WHITE, Piece.Role.BISHOP);
//              case 4:return Piece.create(Piece.Color.WHITE, Piece.Role.QUEEN);
//              case 5:return Piece.create(Piece.Color.WHITE, Piece.Role.KING);
//              case 6:return Piece.create(Piece.Color.WHITE, Piece.Role.BISHOP);
//              case 7:return Piece.create(Piece.Color.WHITE, Piece.Role.KNIGHT);
//              case 8:return Piece.create(Piece.Color.WHITE, Piece.Role.ROOK);
//
//          }
//        }else if (row == 2)
//            return  Piece.create(Piece.Color.WHITE, Piece.Role.PAWN);
//        else if(row == ROW_NUM - 1)
//            return Piece.create(Piece.Color.BLACK, Piece.Role.PAWN);
//        else if(row == 8){
//            switch (column){
//                case 1:return Piece.create(Piece.Color.BLACK, Piece.Role.ROOK);
//                case 2:return Piece.create(Piece.Color.BLACK, Piece.Role.KNIGHT);
//                case 3:return Piece.create(Piece.Color.BLACK, Piece.Role.BISHOP);
//                case 4:return Piece.create(Piece.Color.BLACK, Piece.Role.QUEEN);
//                case 5:return Piece.create(Piece.Color.BLACK, Piece.Role.KING);
//                case 6:return Piece.create(Piece.Color.BLACK, Piece.Role.BISHOP);
//                case 7:return Piece.create(Piece.Color.BLACK, Piece.Role.KNIGHT);
//                case 8:return Piece.create(Piece.Color.BLACK, Piece.Role.ROOK);
//            }
//        }
        return Piece.noPiece(board,rank,row);
    }

    /**
     *
     * @return the number of Pieces
     */
    public int PiecesCount() {
        int num = 0;
        for (List<Block> checker : checkers) {
            for (Block piece : checker) {
                if(piece.getRole() != Piece.Role.NO_PIECE)
                    num++;
            }
        }
        return num;
    }


    /**
     * To add Piece to the board
     * @param block the Piece
     * @param rank  the row number
     * @param row the column number
     */
    public void addPiece(Block block, int rank, int row) {
        attach(block);
        addToBoard(block,rank,row);
        block.link(this, rank, row);
        addToPointList(block);
    }

    protected void addToPointList(Block piece) {
        if(piece.isBlack()){
            blackPiece.add(piece);
            Collections.sort(blackPiece);
        }else {
            whitePiece.add(piece);
            Collections.sort(whitePiece);
        }
    }

    private void addToBoard(Block piece, int rank, int row) {
        rank=actualNum(rank);
        row=actualNum(row);
        if(rank<0||rank> ROW_NUM -1||row<0||row> ROW_NUM -1)
            return;
        checkers.get(rank).set(row, piece);
    }

    public String getView(int line) {
        line = actualNum(line);
        StringBuilder buffer = new StringBuilder();
        if(line<0||line>checkers.size()-1)
            return buffer.toString();
        List<Block> theLine = checkers.get(line);
        for (Block piece : theLine) {
            if(piece!=null) buffer.append(piece.getRepresentation());
            else buffer.append(EMPTY_GRID);
        }
        return buffer.toString()+ StringUtil.NEW_LINE;
    }

    public String print() {
        StringBuilder buffer = new StringBuilder();
        for (int i = checkers.size(); i > 0; i--) {
            buffer.append(getView(i));
        }
        return buffer.toString();
    }

    private int actualNum(int num){
        return --num;
    }


    public Block getPiece(int rank, int row) {
        rank = actualNum(rank);
        row = actualNum(row);
        if (rank < 0 || rank > 7 || row < 0 || row > 7)
            return null;

        return checkers.get(rank).get(row);

    }

    public int count(Piece.Color color,  Block.Representation representation) {
        int count = 0;
        for (int i = 0; i < checkers.size(); i++) {
            List<Block> pieces = checkers.get(i);
            for (int j = 0; j < pieces.size(); j++) {
                Block piece = pieces.get(j);
                if(piece.getColor().equals(color)&&representation.equals(piece.getRepresentation())){
                    count++;
                }
            }
        }
        return count;
    }

    public Block getPiece(String position) {
       if(position==null||position.length()!=2)
           return null;

        int[] positions = parsePosition(position);

        return getPiece(positions[0],positions[1]);

    }

    protected int[] parsePosition(String position){
        int[] positions = new int[2];
        int row =  Character.getNumericValue(Character.toUpperCase(position.charAt(0)))-9;
        int rank = position.charAt(1)-48;
        positions[0] = rank;
        positions[1] = row;
        return positions;
    }

    public void revise() {
        List newList = new ArrayList(8);
        for (int i = 0; i < checkers.size(); i++) {
            newList.add(checkers.get(7-i));
        }

        checkers = newList;
    }

    public void addPiece(Block piece,String position) {
        int[] positions = parsePosition(position);
        addPiece(piece, positions[0], positions[1]);
    }

    public BigDecimal countBlackPoint() {
        refreshPoints();
        BigDecimal point = BigDecimal.ZERO;
        for (int i = 0; i < blackPiece.size(); i++) {
            Block piece = blackPiece.get(i);
            point = point.add(piece.getPoint());
        }
        return point;
    }

    public BigDecimal countWhitePoint() {
        refreshPoints();
        BigDecimal point = BigDecimal.ZERO;
        for (int i = 0; i < whitePiece.size(); i++) {
            Block piece = whitePiece.get(i);
            point = point.add(piece.getPoint());
        }
        return point;
    }

    public List<Block> getBlackPiece() {
        return blackPiece;
    }

    public void setBlackPiece(List<Block> blackPiece) {
        this.blackPiece = blackPiece;
    }

    public List<Block> getWhitePiece() {
        return whitePiece;
    }

    public void setWhitePiece(List<Block> whitePiece) {
        this.whitePiece = whitePiece;
    }

    public void refreshPoints(){
        for (int i = 0; i < checkers.size(); i++) {
            List<Block> pieces = checkers.get(i);
            for (int j = 0; j < pieces.size(); j++) {
                Block piece = pieces.get(j);
                piece.setPoint(piece.countPoint());
            }
        }
    }

    public List<Block> getPieces(Piece.Color color, Piece.Role role){
        List<Block> result = new ArrayList<Block>();
        for (int i = 0; i < checkers.size(); i++) {
            List<Block> blocks = checkers.get(i);
            for (int j = 0; j < blocks.size(); j++) {
                Block block = blocks.get(j);
                if(block.getColor() == color&&block.getRole() == role){
                    result.add(block);
                }
            }
        }
        return result;
    }



    public BigDecimal getPoint(int rank,int row) {
        Block piece = getPiece(rank,row);
        if(blockPoint == null){
            initialBlockPoint();
        }else if(Block.Role.PAWN == piece.getRole()){
            refreshPoints();
        }
        return piece.getPoint();
    }


    private void initialBlockPoint() {
        blockPoint = new HashMap<Block.Role,BigDecimal>();
        blockPoint.put(Block.Role.KING,BigDecimal.ZERO);
        blockPoint.put(Block.Role.QUEEN,new BigDecimal("5"));
        blockPoint.put(Block.Role.ROOK,new BigDecimal("5"));
        blockPoint.put(Block.Role.BISHOP,new BigDecimal("3"));
        blockPoint.put(Block.Role.KNIGHT,new BigDecimal("2.5"));
        blockPoint.put(Block.Role.PAWN,BigDecimal.ONE);
        blockPoint.put(Block.Role.NO_PIECE,BigDecimal.ZERO);
    }

    public Map<Block.Role, BigDecimal> getBlockPoint() {
        if(blockPoint == null){
            initialBlockPoint();
        }
        return blockPoint;
    }

    @Override
    public void attach(Listener listener) {
        //todo
    }

    @Override
    public void detach(Listener listener) {
        //todo
    }

    @Override
    public void toNotify() {
        //todo
    }
}


