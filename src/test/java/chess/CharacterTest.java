package chess;

import junit.framework.TestCase;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/15/14
 * Time: 3:46 PM
 * CopyRight com.tom.ule
 */
public class CharacterTest extends TestCase {

    @Override
    public void setUp() throws Exception {

    }

    public void testWhitespace() throws Exception {
//        assertEquals(true,'\n');
//        assertEquals(true,'\t');
//        assertEquals(true,' ');
        assertTrue(Character.isWhitespace('\n'));
        assertTrue(Character.isWhitespace('\t'));
        assertTrue(Character.isWhitespace(' '));
        assertFalse(Character.isWhitespace('n'));
    }
}
