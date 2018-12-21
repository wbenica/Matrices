package org.benica.matrix;

import org.benica.rational.Rational;

public class Matrix {

    private Rational[][] theMatrix;
    private Rational[][] refMatrix;
    private Rational[][] rrefMatrix;

    public Matrix ( int numRows,
                    int numCols ) {

        theMatrix = new Rational[ numRows ][ numCols ];
        for ( int row = 0; row < numRows; row++ ) {
            for ( int col = 0; col < numCols; col++ ) {
                theMatrix[ row ][ col ] = new Rational ( 0, 1 );
            }
        }
    }

    public Matrix ( int numRows,
                    Rational[] values ) {

        this ( numRows, values.length / numRows );
        for ( int row = 0; row < numRows; row++ ) {
            for ( int col = 0; col < this.getNumCols ( ); col++ ) {
                this.theMatrix[ row ][ col ] = values[ row * this.getNumCols
                        ( ) + col ];
            }
        }
    }

    public Matrix ( Rational[][] values ) {

        this.theMatrix = values;
    }

    public Matrix ( int[][] values ) {

        this.theMatrix = new Rational[ values.length ][ values[ 0 ]
                .length ];
        for ( int row = 0; row < this.getNumRows ( ); row++ ) {
            for ( int col = 0; col < this.getNumCols ( ); col++ ) {
                this.theMatrix[ row ][ col ] = new Rational ( values[ row ][
                        col ] );
            }
        }
    }

    public Matrix ( int numRows,
                    int[] values ) {

        this ( numRows, values.length / numRows );
        for ( int row = 0; row < numRows; row++ ) {
            for ( int col = 0; col < this.getNumCols ( ); col++ ) {
                this.theMatrix[ row ][ col ] = new Rational ( values[ row * this
                        .getNumCols ( ) + col ] );
            }
        }
    }

    @Override
    public int hashCode ( ) {

        return super.hashCode ( );
    }

    @Override
    public boolean equals ( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        else if ( obj == null ) {
            return false;
        }
        else if ( obj instanceof Matrix ) {
            int lhsRows = this.getNumRows ( );
            int lhsCols = this.getNumCols ( );
            int rhsRows = ( ( Matrix ) obj ).getNumRows ( );
            int rhsCols = ( ( Matrix ) obj ).getNumCols ( );

            if ( lhsRows == rhsRows && lhsCols == rhsCols ) {

                for ( int row = 0; row < lhsRows; row++ ) {
                    for ( int col = 0; col < lhsCols; col++ ) {
                        if ( !( ( ( Matrix ) obj ).get ( row, col ).equals (
                                this.get ( row, col ) ) ) ) {
                            return false;
                        }
                    }
                }

                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public Matrix add ( Matrix rhs ) throws IllegalArgumentException {

        if ( this.getNumRows ( ) != rhs.getNumRows ( ) ||
                this.getNumCols ( ) != rhs.getNumCols ( ) ) {
            throw new IllegalArgumentException ( "Matrices must be the same " +
                    "size to add" );
        }
        else {
            Rational[][] sum = new Rational[ this.getNumRows ( ) ][ this
                    .getNumCols ( ) ];
            for ( int row = 0; row < this.getNumRows ( ); row++ ) {
                for ( int col = 0; col < this.getNumCols ( ); col++ ) {
                    sum[ row ][ col ] = this.get ( row, col ).plus ( rhs.get (
                            row, col ) );
                }
            }
            return new Matrix ( sum );
        }
    }

    public int getNumCols ( ) {

        return theMatrix[ 0 ].length;
    }

    public int getNumRows ( ) {

        return theMatrix.length;
    }

    public Rational get ( int row,
                          int col ) {

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
