package chess;

import junit.framework.TestCase;
import static util.StringUtil.NEW_LINE;

import java.math.BigDecimal;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/15/14
 * Time: 1:48 PM
 * CopyRight com.tom.ule
 */
public class BoardTest extends TestCase {
    public static final String BLACK_LINE = "PPPPPPPP"+ NEW_LINE;
    public static final String WHITE_LINE = "pppppppp"+NEW_LINE;
    public static final String EMPTY_LINE = "........"+NEW_LINE;
    public static final String FIRST_LINE = "rnbqkbnr"+NEW_LINE;
    public static final String LAST_LINE = "RNBQKBNR"+NEW_LINE;
    Board board;
    @Override
    public void setUp(){
        board = new Board();
    }

    public void testCreate() {
//        assertEquals(32, board.PiecesCount());
//        assertEquals(WHITE_LINE,board.getView(2));
//        assertEquals(BLACK_LINE,board.getView(7));
//        assertEquals("",board.getView(0));
//        assertEquals(FIRST_LINE,board.getView(1));
//        assertEquals(LAST_LINE,board.getView(8));
//        assertEquals(
//                LAST_LINE
//                +BLACK_LINE
//                +EMPTY_LINE
//                +EMPTY_LINE
//                +EMPTY_LINE
//                +EMPTY_LINE
//                +WHITE_LINE
//                +FIRST_LINE
//                ,board.print());
//        System.out.println("The initial board:\n" + board.print());
//        assertTrue(board.getPiece(8, 1).isBlack());
//        assertTrue(board.getPiece(1, 1).isWhite());
        assertEquals(0,board.PiecesCount());

    }

//    public void testAddPawn(){
//        Board board = new Board();
//        board.addPawn(new Pawn(Pawn.Color.WHITE),1,1);
//        assertEquals(1,board.PiecesCount());
//        board.addPawn(new Pawn(Pawn.Color.BLACK),8,1);
//        assertEquals(2,board.PiecesCount());
//    }

    public void testCount(){
//        assertEquals(8,board.count(Piece.Color.BLACK,Piece.view(Piece.Color.BLACK, Piece.Role.PAWN)));
//        assertEquals(2,board.count(Piece.Color.BLACK,Piece.view(Piece.Color.BLACK, Piece.Role.ROOK)));
//        assertEquals(1,board.count(Piece.Color.BLACK,Piece.view(Piece.Color.BLACK, Piece.Role.KING)));
//        assertEquals(1,board.count(Piece.Color.BLACK,Piece.view(Piece.Color.BLACK, Piece.Role.QUEEN)));
//        assertEquals(8,board.count(Piece.Color.WHITE,Piece.view(Piece.Color.WHITE, Piece.Role.PAWN)));
//        assertEquals(2,board.count(Piece.Color.WHITE,Piece.view(Piece.Color.WHITE, Piece.Role.ROOK)));
//        assertEquals(1,board.count(Piece.Color.WHITE,Piece.view(Piece.Color.WHITE, Piece.Role.KING)));
//        assertEquals(1,board.count(Piece.Color.WHITE,Piece.view(Piece.Color.WHITE, Piece.Role.QUEEN)));
        assertEquals(64,board.count(Piece.Color.NO_PIECE,Piece.view(Piece.Color.NO_PIECE, Piece.Role.NO_PIECE)));
    }

    public void testSetPiece(){
        Block piece = Piece.createBlackKing(board,"b6");
        assertEquals(piece,board.getPiece("b6"));
    }

    public void testGetPiece(){
//        assertEquals(board.getPiece("e1"),Piece.createWhiteKing());
//        assertEquals(board.getPiece("a8"),Piece.createBlackRook());
//        board.revise();
//        assertEquals(board.getPiece("e1"),Piece.createBlackKing());
//        assertEquals(board.getPiece("a8"),Piece.createWhiteRook());
    }

    public void testCountPoint(){
        Piece.createBlackKing(board,"b8");
        assertEquals(BigDecimal.ZERO, board.countBlackPoint());
        Piece.createBlackRook(board,"c8");
        assertEquals(new BigDecimal("5"), board.countBlackPoint());
        Piece.createBlackPawn(board,"a7");
        assertEquals(new BigDecimal("6"),board.countBlackPoint());
        Piece.createBlackPawn(board,"c7");
        assertEquals(new BigDecimal("7"),board.countBlackPoint());
        Piece.createBlackPawn(board,"b6");
        assertEquals(new BigDecimal("8"), board.countBlackPoint());
        Piece.createBlackBishop(board,"d7");
        assertEquals(new BigDecimal ("11"),board.countBlackPoint());
        Piece.createBlackQueen(board,"e6");
        assertEquals(new BigDecimal("16"),board.countBlackPoint());

        assertEquals(new BigDecimal("0"), board.countWhitePoint());
        Piece.createWhiteKnight(board,"f4");
        assertEquals(new BigDecimal("2.5"),board.countWhitePoint());
        Piece.createWhiteQueen(board,"g4");
        assertEquals(new BigDecimal("7.5"),board.countWhitePoint());
        Piece.createWhitePawn(board,"f3");
        assertEquals(new BigDecimal("8.5"),board.countWhitePoint());
        Piece.createWhitePawn(board,"h3");
        assertEquals(new BigDecimal("9.5"),board.countWhitePoint());
        Piece.createWhitePawn(board,"f2");
        assertEquals(new BigDecimal("9.5"),board.countWhitePoint());
        Piece.createWhitePawn(board,"g2");
        assertEquals(new BigDecimal("10.5"),board.countWhitePoint());
        Piece.createWhiteRook(board,"e1");
        assertEquals(new BigDecimal("15.5"),board.countWhitePoint());
        Piece.createWhiteKing(board,"f1");
        assertEquals(new BigDecimal("15.5"),board.countWhitePoint());

        for (int i = 0; i < board.getBlackPiece().size()-1; i++) {
            Block piece = board.getBlackPiece().get(i);
            Block piece2 = board.getBlackPiece().get(i+1);
            assertTrue(piece2.getPoint().compareTo(piece.getPoint())>0 ||piece2.getPoint().compareTo(piece.getPoint())==0);
        }

        for (int i = 0; i < board.getWhitePiece().size()-1; i++) {
            Block piece = board.getWhitePiece().get(i);
            Block piece2 = board.getWhitePiece().get(i+1);
            assertTrue(piece2.getPoint().compareTo(piece.getPoint())>0
                    ||piece2.getPoint().compareTo(piece.getPoint())==0);
        }

    }

}
