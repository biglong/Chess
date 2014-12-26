package chess;

import junit.framework.TestCase;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/18/14
 * Time: 2:52 PM
 * CopyRight com.tom.ule
 */
public class GameTest extends TestCase {
    Game game;
    public void setUp() throws Exception {
        game = new Game();
    }

    public void testCreate(){

    }

    public void testMoveKing(){
        Block piece = Piece.createBlackKing(game.getBoard(),"b8");
        game.moveKing(Block.Color.BLACK, Board.Move.LEFT);
        assertEquals(piece,game.getBoard().getPiece("a8"));
        assertEquals(Block.Color.NO_PIECE,game.getBoard().getPiece("b8").getColor());
        assertEquals(Block.Role.NO_PIECE,game.getBoard().getPiece("b8").getRole());
    }
}
