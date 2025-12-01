package ru.golyakova.fractions;

public class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public double getValue() {
        return (double) numerator/denominator;
    }

    @Override
    public void setFraction(int numerator, int denominator) {
        if(denominator == 0){
            throw new IllegalStateException("Знаменатель не может быть 0");
        }

        if(denominator < 0){
            this.numerator = -numerator;
            this.denominator = -denominator;
        }else{
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public void setNumerator(int numerator) {
        setFraction(numerator, this.denominator);
    }

    public void setDenominator(int denominator) {
        setFraction(this.numerator, denominator);
    }

    public Fraction(int numerator, int denominator){
        setFraction(numerator,denominator);
    }
    @Override
    public String toString() {
        if(denominator == 1){
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }
}
