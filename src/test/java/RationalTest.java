import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RationalTest {

    @Test
    public void plus ( ) {
        Rational lhs = new Rational ( 3, 4 );
        Rational rhs = new Rational ( 2, 16 );
        Rational res = new Rational ( 7, 8 );
        assertEquals ( lhs.plus ( rhs ), res );
    }

    @Test
    public void minus ( ) {
        Rational lhs = new Rational ( 3, 4 );
        Rational rhs = new Rational ( 1, 8 );
        Rational res = new Rational ( 5, 8 );
        assertEquals ( lhs.minus ( rhs ), res );

    }

    @Test
    public void times ( ) {
        Rational lhs = new Rational ( 3, 4 );
        Rational rhs = new Rational ( 1, 8 );
        Rational res = new Rational ( 3, 32 );
        assertEquals ( lhs.times ( rhs ), res );

    }

    @Test
    public void divide ( ) {
        Rational lhs = new Rational ( 3, 4 );
        Rational rhs = new Rational ( 1, 8 );
        Rational res = new Rational ( 6, 1 );
        assertEquals ( lhs.divide ( rhs ), res );

    }

    @Test
    public void getNum ( ) {
        Rational test = new Rational ( 3, 4 );
        assertEquals ( test.getNum (), 3 );

    }

    @Test
    public void getDen ( ) {
        Rational test = new Rational ( 3, 4 );
        assertEquals ( test.getDen (), 4 );
    }

    @Test
    public void equals ( ) {
        Rational lhs = new Rational ( 5, 25 );
        Rational rhs = new Rational ( 1, 5 );
        assertEquals ( lhs, rhs );
        assertEquals ( lhs, lhs );
        Rational badTest = new Rational ( 2, 5 );
        assertNotEquals ( badTest, rhs );
    }

    @Test
    public void testHashCode ( ) {

        Rational test = new Rational ( 5, 25 );
        assertEquals ( 105, test.hashCode ( ) );
    }

}