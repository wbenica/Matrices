public class Rational {

    private int     num;
    private int     den;
    private boolean isInteger;

    @Override
    public int hashCode ( ) {

        return this.num * 100 + den;
    }

    public Rational ( int n, int d ) {

        if ( d == 0 ) {
            throw new IllegalArgumentException ( );
        }
        int gcd = gcd ( n, d );
        this.num = n / gcd;
        this.den = d / gcd;
        this.isInteger = ( den == 1 );
    }

    public Rational ( int n ) {

        this ( n, 1 );
    }

    public int getNum ( ) {

        return num;
    }

    public int getDen ( ) {

        return den;
    }

    public Rational plus ( Rational rhs ) {

        return new Rational ( this.num * rhs.den + rhs.num * this.den,
                this.den *
                        rhs.den );
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

    @Override
    public boolean equals ( Object obj ) {

        if ( obj == this ) {
            return true;
        }

        if ( obj instanceof Rational ) {
            return ( ( ( Rational ) obj ).getNum ( ) == this.getNum ( ) &&
                    ( ( Rational ) obj ).getDen ( ) == this.getDen ( ) );
        }
        else {
            return false;
        }
    }

    private static int gcd ( int l, int r ) {

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
