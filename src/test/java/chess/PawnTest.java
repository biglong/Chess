package chess;

import junit.framework.TestCase;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/15/14
 * Time: 9:50 AM
 * CopyRight com.tom.ule
 */
public class PawnTest extends TestCase {

    @Override
    public void setUp(){

    }

    public void testCreate(){
        Pawn pawn = new Pawn();
        assertEquals(Pawn.Color.WHITE,pawn.getColor());
    }

    public void testNoColorPawn(){
        Pawn pawn = new Pawn(Pawn.Color.BLACK);
        assertEquals(Pawn.Color.BLACK,pawn.getColor());
    }

    public void testPrintPawn(){
        Pawn.OutPrint blackOut = Pawn.OutPrint.BLACK;
        Pawn.OutPrint whiteOut = Pawn.OutPrint.WHITE;
        Pawn blackPawn = new Pawn(Pawn.Color.BLACK, blackOut);
        assertEquals(blackOut, blackPawn.getStdOut());
        Pawn whitePawn = new Pawn(Pawn.Color.WHITE, whiteOut);
        assertEquals(whiteOut,whitePawn.getStdOut());
    }
}
