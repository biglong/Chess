package chess;

import junit.framework.TestCase;
import util.StringUtil;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/16/14
 * Time: 3:22 PM
 * CopyRight com.tom.ule
 */
public class StringUtilTest extends TestCase {

    public void testNewLine() throws Exception {
        assertEquals("\r\n", StringUtil.NEW_LINE);
    }
}
