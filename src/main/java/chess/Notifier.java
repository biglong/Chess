package chess;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/18/14
 * Time: 5:43 PM
 * CopyRight com.tom.ule
 */
public interface Notifier {
    void attach(Listener listener);
    void detach(Listener listener);
    void toNotify();
}
