package org.benica.matrix;

import org.benica.rational.Rational;

public class Matrix {

    private Rational[][] theMatrix;
    // private Rational[][] refMatrix;
    // private Rational[][] rrefMatrix;
    private Size         size;

    public Matrix ( int numRows,
                    int numCols ) {

        theMatrix = new Rational[ numRows ][ numCols ];
        for ( int row = 0; row < numRows; row++ ) {
            for ( int col = 0; col < numCols; col++ ) {
                theMatrix[ row ][ col ] = new Rational ( 0, 1 );
            }
        }
        size = new Size ( numRows, numCols );
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

        this ( values.length, values[ 0 ].length );
        this.theMatrix = values;
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

    public Matrix ( int[][] values ) {

        this ( values.length, values[ 0 ].length );
        for ( int row = 0; row < this.getNumRows ( ); row++ ) {
            for ( int col = 0; col < this.getNumCols ( ); col++ ) {
                this.theMatrix[ row ][ col ] = new Rational ( values[ row ][
                        col ] );
            }
        }
    }

    public int getNumCols ( ) {

        return this.size.numCols;
    }

    public int getNumRows ( ) {

        return this.size.numRows;
    }

    @Override
    public int hashCode ( ) {

        return this.getNumCols ( ) + this.getNumRows ( );
    }

    @Override
    public boolean equals ( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        else if ( obj == null ) {
            return false;
        }
        else if ( obj instanceof Matrix &&
                this.sameSize ( ( Matrix ) obj ) ) {

            for ( int row = 0; row < this.getNumRows ( ); row++ ) {
                for ( int col = 0; col < this.getNumCols ( ); col++ ) {
                    if ( !( ( ( Matrix ) obj ).get ( row, col ).equals (
                            this.get ( row, col ) ) ) ) {
                        return false;
                    }
                }
            }

            return true;
        }

        return false;
    }

    public boolean sameSize ( Matrix rhs ) {

        return ( this.getNumRows ( ) == rhs.getNumRows ( ) &&
                this.getNumCols ( ) == rhs.getNumCols ( ) );
    }

    public Matrix add ( Matrix rhs ) {

        if ( !this.sameSize ( rhs ) ) {
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

    private class Size {

        Integer numRows;
        Integer numCols;

        Size ( Integer rows,
               Integer cols ) {

            this.numRows = rows;
            this.numCols = cols;
        }
    }
}
