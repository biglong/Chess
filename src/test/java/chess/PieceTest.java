package chess;

import junit.framework.TestCase;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/16/14
 * Time: 3:27 PM
 * CopyRight com.tom.ule
 */
public class PieceTest extends TestCase {

    Board board;

    @Override
    public void setUp() throws Exception {
        board = new Board();
    }

    public void testCreate() throws Exception {
        Piece piece = Piece.create(board,"b1",Piece.Color.BLACK,Piece.Role.PAWN);
        assertEquals(Piece.Color.BLACK,piece.getColor());
        assertEquals(Piece.Role.PAWN,piece.getRole());
        verifyCreation(Piece.createBlackPawn(board,"a2"),Piece.createWhitePawn(board,"a7"), Piece.Role.PAWN,Piece.view(Piece.Color.BLACK, Piece.Role.PAWN),Piece.view(Piece.Color.WHITE, Piece.Role.PAWN));
        verifyCreation(Piece.createBlackRook(board,"a1"),Piece.createWhiteRook(board,"a8"), Piece.Role.ROOK,Piece.view(Piece.Color.BLACK, Piece.Role.ROOK),Piece.view(Piece.Color.WHITE, Piece.Role.ROOK));
        verifyCreation(Piece.createBlackKnight(board,"b1"),Piece.createWhiteKnight(board,"b8"), Piece.Role.KNIGHT,Piece.view(Piece.Color.BLACK, Piece.Role.KNIGHT),Piece.view(Piece.Color.WHITE, Piece.Role.KNIGHT));
        verifyCreation(Piece.createBlackBishop(board,"c1"),Piece.createWhiteBishop(board,"c8"), Piece.Role.BISHOP,Piece.view(Piece.Color.BLACK, Piece.Role.BISHOP),Piece.view(Piece.Color.WHITE, Piece.Role.BISHOP));
        verifyCreation(Piece.createBlackKing(board,"d1"),Piece.createWhiteKing(board,"d8"), Piece.Role.KING,Piece.view(Piece.Color.BLACK, Piece.Role.KING),Piece.view(Piece.Color.WHITE, Piece.Role.KING));
        verifyCreation(Piece.createBlackQueen(board,"e1"),Piece.createWhiteQueen(board,"e8"), Piece.Role.QUEEN,Piece.view(Piece.Color.BLACK, Piece.Role.QUEEN),Piece.view(Piece.Color.WHITE, Piece.Role.QUEEN));
        Piece blank = Piece.noPiece(board,"a3");
        assertEquals(Block.Representation.NO_PIECE.toString(), blank.getRepresentation().toString());
        assertEquals(Piece.Color.NO_PIECE,blank.getColor());
        assertEquals(Piece.Role.NO_PIECE,blank.getRole());

    }



    private void verifyCreation(Piece blackPawn, Piece whitePawn, Piece.Role type, Block.Representation blackRepresentation, Block.Representation whiteRepresentation) {
        assertTrue(whitePawn.isWhite());
        assertEquals(type,whitePawn.getRole());
        assertEquals(whiteRepresentation,whitePawn.getRepresentation());

        assertTrue(blackPawn.isBlack());
        assertEquals(type,blackPawn.getRole());
        assertEquals(blackRepresentation,blackPawn.getRepresentation());
    }
}
