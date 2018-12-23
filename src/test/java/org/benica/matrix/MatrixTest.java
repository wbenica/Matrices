package org.benica.matrix;

import org.benica.rational.Rational;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    Matrix test1 = new Matrix ( 5, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,
                                               10 } );
    Matrix test2 = new Matrix ( 2, new int[] { 1, 2, 3, 4 } );
    Matrix test3 = new Matrix (
            new int[][] { new int[] { 4, 3 }, new int[] { 2, 1 } } );
    Matrix test4 = new Matrix ( 2, new Rational[] { new Rational ( 5 ),
                                                    new Rational ( 5 ),
                                                    new Rational ( 5 ),
                                                    new Rational ( 5 ) } );
    Matrix test5 = new Matrix ( 2, 2 );

    @Test
    public void getters ( ) {

        assertEquals ( 2,
                test1.getNumCols ( ) );

        assertEquals ( 5,
                test1.getNumRows ( ) );

        assertEquals ( new Rational ( 8 ),
                test1.get ( 3, 1 ) );

        assertArrayEquals (
                new Rational[] { new Rational ( 5 ), new Rational ( 6 ) },
                test1.getRow ( 2 ) );

        assertArrayEquals ( new Rational[] {
                        new Rational ( 1 ), new Rational ( 3 ), new Rational
                        ( 5 ),
                        new Rational ( 7 ), new Rational ( 9 ) },
                test1.getCol ( 0 ) );
    }

    @Test
    public void add ( ) {

        assertEquals ( test4, test2.add (
                test3 ) );
    }

    @Test( expected = IllegalArgumentException.class )
    public void addException ( ) {

        test1.add ( test2 );
    }

    @Test
    public void equals ( ) {

        assertEquals ( test2, new Matrix ( 2, new int[] { 1, 2, 3, 4 } ) );

        // equals self?
        assertEquals ( test5, test5 );

        // same size, different values
        assertNotEquals ( test2, test3 );

        // doesn't equal null
        assertNotEquals ( test2, null );

        // not a matrix
        assertNotEquals ( test5, 3 );

        // different size matrices
        assertNotEquals ( test1, test4 );
    }

    @Test
    public void hashTest ( ) {

        assertEquals ( 4, test2.hashCode ( ) );
    }
}