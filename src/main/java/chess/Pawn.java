package chess;

/**
 * <p>Description: This is the pawn </p>
 *
 * @author: huangshaolong
 * Date: 4/15/14
 * Time: 9:51 AM
 * CopyRight com.tom.ule
 */
public class Pawn {




    public static enum Color{BLACK,WHITE};
    public static enum OutPrint{
        BLACK('P'),WHITE('p');
        private char out;

        private OutPrint(char out) {
            this.out = out;
        }

        @Override
        public String toString() {
            return String.valueOf(out);
        }
    }

    private Color color = Color.WHITE;
    private OutPrint stdOut = OutPrint.WHITE;

    public Pawn(Color color, OutPrint stdOut) {
        this.color = color;
        this.stdOut = stdOut;

    }
    public Pawn() {
    }


    public Pawn(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public OutPrint getStdOut() {
        return stdOut;
    }

    public void setStdOut(OutPrint stdOut) {
        this.stdOut = stdOut;
    }
}
