package org.benica.rational;

public class Rational implements Comparable<Rational> {

    private Integer num;
    private Integer den;

    public Rational ( int n,
                      int d ) {

        if ( d == 0 ) {
            throw new IllegalArgumentException ( );
        }
        int gcd = gcd ( n, d );
        this.num = n / gcd;
        this.den = d / gcd;
    }

    public Rational ( int n ) {

        this ( n, 1 );
    }

    public Integer getNum ( ) {

        return num;
    }

    public Integer getDen ( ) {

        return den;
    }

    public boolean isInteger ( ) {

        return den == 1;

    }

    @Override
    public int hashCode ( ) {

        return this.num * 100 + den;
    }

    @Override
    public boolean equals ( Object obj ) {

        if ( obj == this ) {
            return true;
        }

        if ( obj instanceof Integer ) {
            return ( obj.equals ( this.getNum ( ) ) && this
                    .getDen ( )
                    == 1 );
        }

        if ( obj instanceof Rational ) {
            return ( ( ( Rational ) obj ).getNum ( )
                    .equals ( this.getNum ( ) ) &&
                    ( ( Rational ) obj ).getDen ( )
                            .equals ( this.getDen ( ) ) );
        }
        else {
            return false;
        }
    }

    public Rational plus ( Rational rhs ) {

        return new Rational ( this.num * rhs.den + rhs.num * this.den,
                this.den * rhs.den );
    }

    public Rational plus ( int rhs ) {

        return this.plus ( new Rational ( rhs ) );
    }

    public Rational minus ( Rational rhs ) {

        return new Rational ( this.num * rhs.den - rhs.num * this.den, this
                .den * rhs.den );
    }

    public Rational minus ( int rhs ) {

        return this.minus ( new Rational ( rhs ) );
    }

    public Rational times ( Rational rhs ) {

        return new Rational ( this.num * rhs.num, this.den * rhs.den );
    }

    public Rational times ( int rhs ) {

        return this.times ( new Rational ( rhs ) );
    }

    public Rational divide ( Rational rhs ) {

        return new Rational ( this.num * rhs.den, this.den * rhs.num );
    }

    public Rational divide ( int rhs ) {

        return this.divide ( new Rational ( rhs ) );
    }

    public int compareTo ( Rational o ) {

        return this.getNum ( ) * o.getDen ( ) - o.getNum ( ) * this.getDen ( );
    }

    static int gcd ( int l,
                     int r ) {

        if ( l == r ) {
            if ( l == 0 ) {
                throw new IllegalArgumentException ( );
            }
            return l;
        }
        else {
            int max = Math.max ( l, r );
            int min = Math.min ( l, r );

            if ( min == 0 ) {
                return max;
            }
            else {
                return gcd ( max - min, min );
            }
        }
    }
}
