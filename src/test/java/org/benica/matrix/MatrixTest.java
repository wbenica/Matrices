package org.benica.matrix;

import org.benica.rational.Rational;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatrixTest {

    Matrix test = new Matrix ( 5, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,
                                              10 } );

    Matrix test2 = new Matrix ( 2, new int[] { 1, 2, 3, 4 } );

    Matrix test3 = new Matrix ( 2, new int[] { 4, 3, 2, 1 } );

    @Test
    public void getNumCols ( ) {

        assertEquals ( 2,
                test.getNumCols ( ) );
    }

    @Test
    public void getNumRows ( ) {

        assertEquals ( 5,
                test.getNumRows ( ) );
    }

    @Test
    public void get ( ) {

        assertEquals ( new Rational ( 8 ),
                test.get ( 3, 1 ) );
    }

    @Test
    public void getRow ( ) {

        assertArrayEquals (
                new Rational[] { new Rational ( 5 ), new Rational ( 6 ) },
                test.getRow ( 2 ) );
    }

    @Test
    public void getCol ( ) {

        assertArrayEquals ( new Rational[] {
                        new Rational ( 1 ), new Rational ( 3 ), new Rational
                        ( 5 ),
                        new Rational ( 7 ), new Rational ( 9 ) },
                test.getCol ( 0 ) );
    }

    @Test
    public void add ( ) {

        assertEquals ( new Matrix ( 2, new int[] { 5, 5, 5, 5 } ), test2.add (
                test3 ) );
    }

    @Test( expected = IllegalArgumentException.class )
    public void addException ( ) {

        test.add ( test2 );
    }

    @Test
    public void equals ( ) {

        assertEquals ( test2, new Matrix ( 2, new int[] { 1, 2, 3, 4 } ) );
    }

    @Test

    public void equalsSelf ( ) {

        assertEquals ( test2, test2 );
    }
}