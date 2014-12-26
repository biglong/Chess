package chess;

import junit.framework.TestSuite;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/15/14
 * Time: 2:31 PM
 * CopyRight com.tom.ule
 */
public class AllTests{

    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(BoardTest.class);
        suite.addTestSuite(PawnTest.class);
        suite.addTestSuite(CharacterTest.class);
        suite.addTestSuite(StringUtilTest.class);
        suite.addTestSuite(PieceTest.class);
        suite.addTestSuite(GameTest.class);
        return suite;
    }

}
