package org.benica.rational;

import org.junit.Test;

import static org.junit.Assert.*;

public class RationalTest {

    @Test
    public void plus ( ) {

        Rational lhs = new Rational ( 3, 4 );
        Rational rhs = new Rational ( 2, 16 );
        Rational res = new Rational ( 7, 8 );
        assertEquals ( lhs.plus ( rhs ), res );

        // plus integer
        Rational test = new Rational ( 0, 4 );
        assertEquals ( test.plus ( 2 ), new Rational ( 2 ) );
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
        assertEquals ( test.getNum ( ), new Integer ( 3 ) );

    }

    @Test
    public void getDen ( ) {

        Rational test = new Rational ( 3, 4 );
        assertEquals ( test.getDen ( ), new Integer ( 4 ) );
    }

    @Test
    public void equals ( ) {

        Rational lhs = new Rational ( 5, 25 );
        Rational rhs = new Rational ( 1, 5 );
        assertEquals ( lhs, rhs );

        // equals self
        assertEquals ( lhs, lhs );
        Rational badTest = new Rational ( 2, 5 );
        assertNotEquals ( badTest, rhs );

        // rational and integer
        assertEquals ( new Rational ( 4, 2 ), ( Object ) 2 );

        // rational and not rational/integer
        assertNotEquals ( lhs, "What" );
    }

    @Test
    public void testHashCode ( ) {

        Rational test = new Rational ( 5, 25 );
        assertEquals ( 105, test.hashCode ( ) );
    }

    @Test
    public void minus1 ( ) {

        Rational test = new Rational ( 24, 6 );
        assertEquals ( test.minus ( 1 ), new Rational ( 3 ) );
    }

    @Test
    public void times1 ( ) {

        Rational test = new Rational ( 33, 7 );
        assertEquals ( test.times ( 4 ), new Rational ( 132, 7 ) );
    }

    @Test
    public void divide1 ( ) {

        Rational test = new Rational ( 33, 7 );
        assertEquals ( test.divide ( 4 ), new Rational ( 33, 28 ) );
    }

    @Test
    public void hashTest ( ) {

        Rational test = new Rational ( 5, 2 );
        assertEquals ( 502, test.hashCode ( ) );
    }

    @Test
    public void compareToTest ( ) {

        Rational lhs = new Rational ( 31, 5 );
        Rational rhs = new Rational ( 23, 107 );
        assertTrue ( lhs.compareTo ( rhs ) > 0 );
    }

    @Test( expected = IllegalArgumentException.class )
    public void zeroDenominatorTest ( ) {

        new Rational ( 5, 0 );
    }

    @Test( expected = IllegalArgumentException.class )
    public void gcdZeroZero ( ) {

        Rational.gcd ( 0, 0 );
    }

    @Test
    public void isInteger ( ) {

        assertTrue ( new Rational ( 4, 1 ).isInteger ( ) );
        assertFalse ( new Rational ( 3, 17 ).isInteger ( ) );
    }
}