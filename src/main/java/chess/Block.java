package chess;

import java.math.BigDecimal;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 4/17/14
 * Time: 6:27 PM
 * CopyRight com.tom.ule
 */
public interface Block<T> extends Comparable<T> ,Listener{

    public boolean isBlack();

    public boolean isWhite();

    Piece.Role getRole();

    Piece.Representation getRepresentation();

    BigDecimal getPoint();

    BigDecimal countPoint();

    void setPoint(BigDecimal point);

    Color getColor();

    public void link(Board board, int rank, int row);

    public void setRow(int row);

    public int getRow();

    public void setRank(int rank);

    public int getRank();

    public enum Color {BLACK, WHITE, NO_PIECE}

    public enum Representation{
        BLACK_KING('K'),BLACK_QUEEN('Q'),BLACK_ROOK('R'),BLACK_KNIGHT('N'),BLACK_BISHOP('B'),BLACK_PAWN('P'),
        WHITE_KING('K'),WHITE_QUEEN('Q'),WHITE_ROOK('R'),WHITE_KNIGHT('N'),WHITE_BISHOP('B'),WHITE_PAWN('P'),NO_PIECE('.');
        private char representation;
        Representation(Character representation){
            this.representation = representation;
        }

        @Override
        public String toString() {
            return  Character.toString(representation);
        }
    }

    public  enum Role{
        KING('K'),QUEEN('Q'),ROOK('R'),KNIGHT('N'),BISHOP('B'),PAWN('P'),NO_PIECE('.');
        char view;
        Role(char view){
            this.view = view;
        }

        public void setView(char view) {
            this.view = view;
        }

        @Override
        public String toString() {
            return String.valueOf(view);
        }
    };


}
