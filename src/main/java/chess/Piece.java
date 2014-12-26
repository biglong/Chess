package chess;


import java.math.BigDecimal;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/16/14
 * Time: 3:30 PM
 * CopyRight com.tom.ule
 */
public class Piece implements Block<Piece> {

    Board board;

    private Piece(Board board, int rank, int row, Color color, Role role) {
        this.color = color;
        this.role = role;
        this.representation = view(color, role);
        board.addPiece(this,rank,row);
//        this.board = board;
//        this.rank = rank;
//        this.row = row;
    }

    private Role role;
    private Color color;
    private Representation representation;
    private BigDecimal point = BigDecimal.ZERO;
    private int row;
    private int rank;


    public static Piece create(Board board, int rank, int row, Color color, Role role) {
        return new Piece(board, rank, row, color, role);
    }

    public static Piece create(Board board, String position, Color color, Role role) {
        int[] positions = board.parsePosition(position);
        return new Piece(board, positions[0], positions[1], color, role);
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public static Piece noPiece(Board board, int rank, int row) {
        return create(board, rank, row, Color.NO_PIECE, Role.NO_PIECE);
    }

    public static Piece noPiece(Board board, String position) {
        return create(board, position, Color.NO_PIECE, Role.NO_PIECE);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Piece) {
            Piece that = (Piece) obj;
            return this.getColor() == that.getColor() && this.getRole() == that.getRole();
        }
        return super.equals(obj);
    }

    public void link(Board board, int rank, int row) {
        setBoard(board);
        setRank(rank);
        setRow(row);
        setPoint(countPoint());
    }


    public static Representation view(Color color, Role role) {
        Representation view = Representation.NO_PIECE;
        switch (color) {
            case BLACK: {
                switch (role) {
                    case KING:
                        view = Representation.BLACK_KING;
                        break;
                    case QUEEN:
                        view = Representation.BLACK_QUEEN;
                        break;
                    case ROOK:
                        view = Representation.BLACK_ROOK;
                        break;
                    case KNIGHT:
                        view = Representation.BLACK_KNIGHT;
                        break;
                    case BISHOP:
                        view = Representation.BLACK_BISHOP;
                        break;
                    case PAWN:
                        view = Representation.BLACK_PAWN;
                        break;
                }
            }
            break;
            case WHITE: {
                switch (role) {
                    case KING:
                        view = Representation.WHITE_KING;
                        break;
                    case QUEEN:
                        view = Representation.WHITE_QUEEN;
                        break;
                    case ROOK:
                        view = Representation.WHITE_ROOK;
                        break;
                    case KNIGHT:
                        view = Representation.WHITE_KNIGHT;
                        break;
                    case BISHOP:
                        view = Representation.WHITE_BISHOP;
                        break;
                    case PAWN:
                        view = Representation.WHITE_PAWN;
                        break;
                }
            }
        }

        return view;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Representation getRepresentation() {
        if (representation == null) {
            setRepresentation(view(color, role));
        }
        return representation;
    }

    private void setRepresentation(Representation representation) {
        this.representation = representation;
    }

    public static Piece createWhitePawn(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.WHITE, Role.PAWN);
    }

    public static Piece createWhitePawn(Board board, String position) {
        return Piece.create(board, position, Color.WHITE, Role.PAWN);
    }

    public static Piece createWhiteRook(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.WHITE, Role.ROOK);
    }

    public static Piece createWhiteRook(Board board, String position) {
        int[] positions = board.parsePosition(position);
        return Piece.create(board, position, Color.WHITE, Role.ROOK);
    }

    public static Piece createWhiteKnight(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.WHITE, Role.KNIGHT);
    }

    public static Piece createWhiteKnight(Board board, String position) {
        int[] positions = board.parsePosition(position);
        return Piece.create(board, position, Color.WHITE, Role.KNIGHT);
    }

    public static Piece createWhiteBishop(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.WHITE, Role.BISHOP);
    }

    public static Piece createWhiteBishop(Board board, String position) {
        return Piece.create(board, position, Color.WHITE, Role.BISHOP);
    }

    public static Piece createWhiteKing(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.WHITE, Role.KING);
    }

    public static Piece createWhiteKing(Board board, String position) {
        int[] positions = board.parsePosition(position);
        return Piece.create(board, position, Color.WHITE, Role.KING);
    }

    public static Piece createWhiteQueen(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.WHITE, Role.QUEEN);
    }

    public static Piece createWhiteQueen(Board board, String position) {
        int[] positions = board.parsePosition(position);
        return Piece.create(board, position, Color.WHITE, Role.QUEEN);
    }

    public static Piece createBlackPawn(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.BLACK, Role.PAWN);
    }

    public static Piece createBlackPawn(Board board, String position) {
        return Piece.create(board, position, Color.BLACK, Role.PAWN);
    }

    public static Piece createBlackRook(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.BLACK, Role.ROOK);
    }

    public static Piece createBlackRook(Board board, String position) {
        return Piece.create(board, position, Color.BLACK, Role.ROOK);
    }

    public static Piece createBlackKnight(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.BLACK, Role.KNIGHT);
    }

    public static Piece createBlackKnight(Board board, String position) {
        return Piece.create(board, position, Color.BLACK, Role.KNIGHT);
    }

    public static Piece createBlackBishop(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.BLACK, Role.BISHOP);
    }

    public static Piece createBlackBishop(Board board, String position) {
        return Piece.create(board, position, Color.BLACK, Role.BISHOP);
    }

    public static Piece createBlackKing(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.BLACK, Role.KING);
    }

    public static Piece createBlackKing(Board board, String position) {
        return Piece.create(board, position, Color.BLACK, Role.KING);
    }

    public static Piece createBlackQueen(Board board, int rank, int row) {
        return Piece.create(board, rank, row, Color.BLACK, Role.QUEEN);
    }

    public static Piece createBlackQueen(Board board, String position) {
        return Piece.create(board, position, Color.BLACK, Role.QUEEN);
    }


    public BigDecimal countPointForPawn() {
        if (this.equals(board.getPiece(rank + 1, row)) || this.equals(board.getPiece(rank - 1, row))) {
            return new BigDecimal("0.5");
        } else {
            return BigDecimal.ONE;
        }

    }

    public BigDecimal countPoint() {
        Piece.Role role = getRole();
        switch (role) {
            case PAWN:
                return countPointForPawn();
            default:
                return board.getBlockPoint().get(role);
        }
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int compareTo(Piece that) {
        return this.getPoint().compareTo(that.getPoint());
    }

    @Override
    public void update() {
        //todo
    }
}
