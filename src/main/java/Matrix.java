public class Matrix {

    private Rational[][] theMatrix;

    public Matrix ( int numRows, int numCols ) {

        theMatrix = new Rational[ numRows ][ numCols ];
        for ( int row = 0; row < numRows; row++ ) {
            for ( int col = 0; col < numCols; col++ ) {
                theMatrix[ row ][ col ] = new Rational ( 0, 1 );
            }
        }
    }

    public Matrix ( int numRows, Rational[] values ) {

        this ( numRows, values.length / numRows );
        for ( int row = 0; row < numRows; row++ ) {
            for ( int col = 0; col < this.getNumCols ( ); col++ ) {
                this.theMatrix[ row ][ col ] = values[ row * this.getNumCols
                        ( ) + col ];
            }
        }
    }

    public int getNumCols ( ) {

        return theMatrix[ 0 ].length;
    }

    public int getNumRows ( ) {

        return theMatrix.length;
    }

    public Rational get ( int row, int col ) {

        return theMatrix[ row ][ col ];
    }

    public Rational[] getRow ( int row ) {

        return theMatrix[ row ];
    }

    public Rational[] getCol ( int col ) {

        Rational[] newCol = new Rational[ theMatrix.length ];
        for ( int row = 0; row < theMatrix.length; row++ ) {
            newCol[ row ] = theMatrix[ row ][ col ];
        }
        return newCol;
    }
}
