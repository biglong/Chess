package chess;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/18/14
 * Time: 2:51 PM
 * CopyRight com.tom.ule
 */
public class Game {
    private Board board;

    public Game() {
        this.board = new Board();
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }




    public void moveKing(Block.Color color, Board.Move move){
        Block king;
        if(Piece.Color.BLACK == color){
            king = board.getPieces(Piece.Color.BLACK, Piece.Role.KING).get(0);
        }else{
            king = board.getPieces(Piece.Color.WHITE, Piece.Role.KING).get(0);
        }

        switch (move){
            case UP:board.addPiece(king,king.getRank()+1,king.getRow());Piece.noPiece(board,king.getRank()-1,king.getRow());break;
            case DOWN:board.addPiece(king,king.getRank()-1,king.getRow());Piece.noPiece(board,king.getRank()+1,king.getRow());break;
            case LEFT:board.addPiece(king,king.getRank(),king.getRow()-1);Piece.noPiece(board,king.getRank(), king.getRow() + 1);break;
            case RIGHT:board.addPiece(king,king.getRank(),king.getRow()+1);Piece.noPiece(board,king.getRank(),king.getRow()-1);break;
        }
    }
}
