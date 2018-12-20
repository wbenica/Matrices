import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    Matrix test = new Matrix ( 5, new Rational[] {
            new Rational ( 1 ),
            new Rational ( 2 ),
            new Rational ( 3 ),
            new Rational ( 4 ),
            new Rational ( 5 ),
            new Rational ( 6 ),
            new Rational ( 7 ),
            new Rational ( 8 ),
            new Rational ( 9 ),
            new Rational ( 10 ) } );

    @Test
    public void getNumCols ( ) {

        assertEquals ( test.getNumCols ( ), 2 );
    }

    @Test
    public void getNumRows ( ) {

        assertEquals ( test.getNumRows ( ), 5 );
    }

    @Test
    public void get ( ) {

        assertEquals ( test.get ( 3, 1 ), new Rational ( 8 ) );
    }

    @Test
    public void getRow ( ) {

        assertEquals ( test.getRow ( 2 ), new Rational[] {
                new Rational ( 5 ), new Rational ( 6 )
        } );
    }

    @Test
    public void getCol ( ) {

        assertEquals ( test.getCol ( 0 ), new Rational[] {
                new Rational ( 1 ), new Rational ( 3 ), new Rational ( 5 ),
                new Rational ( 7 ), new Rational ( 9 )
        } );
    }

//    @Test
//    public void getRow ( ) {
//
//    }
//
//    @Test
//    public void getCol ( ) {
//
//    }
}