package Ex3;

public class Fraction {

    private int numerator;

    private int denominator;


    public Fraction(int num, int denom) {
        numerator = num;
        denominator = denom;
        this.reduce();
    }


    public Fraction(int num) {
        this(num, 1);
    }


    public Fraction() {

        this(0, 1);
    }


    public double toDouble() {
        return (double) numerator / denominator;
    }


    public float toFloat() {

        return (float) numerator / denominator;
    }


    public String toString() {
        if (denominator == 1) {
            return (String) String.valueOf(numerator);
        } else {
            return (String) String.valueOf(numerator) + "/" + String.valueOf(denominator);
        }
    }


    public int getDenominator() {

        return denominator;
    }


    public int getNumerator() {

        return numerator;
    }

    private void reduce() {
        int reducer = this.gcd();
        numerator = numerator / reducer;
        denominator = denominator / reducer;
    }

    private int gcd() {
        int max = Math.max(numerator, denominator);
        int i;
        for (i = max; i > 1; i--) {
            int rem1 = numerator % i;
            int rem2 = denominator % i;
            if (rem1 == 0 && rem2 == 0) {
                return i;
            }
        }
        return 1;
    }


    public Fraction add(Fraction f) {
        int num = numerator * f.denominator + f.numerator * denominator;
        int denom = denominator * f.denominator;

        return new Fraction(num, denom);
    }


    public Fraction subtract(Fraction f) {

        int num = numerator * f.denominator - f.numerator * denominator;
        int denom = denominator * f.denominator;

        return new Fraction(num, denom);
    }


    public Fraction divide(Fraction f) {
        int num = numerator * f.denominator;
        int denom = denominator * f.numerator;

        return new Fraction(num, denom);
    }


    public Fraction multiply(Fraction f) {
        int num = numerator * f.numerator;
        int denom = denominator * f.denominator;

        return new Fraction(num, denom);
    }


    public boolean equals(Fraction q) {
        return (numerator == q.getNumerator() &&
                denominator == q.getDenominator());
    }
}