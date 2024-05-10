package org.example;

import java.util.HashMap;
import java.util.Map;

public class Monom {
    private  Integer exponent;
    private Integer coefficient;

    public Monom(Integer exponent, Integer coefficient) {
       this.exponent=exponent;
       this.coefficient=coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public void setExponent(Integer exponent) {
        this.exponent = exponent;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public Integer getExponent() {
        return exponent;
    }

    public String toString() {
        if (exponent == 0) {
            return Integer.toString(coefficient);
        } else if (exponent == 1) {
            return coefficient + "x";
        } else {
            return coefficient + "x^" + exponent;
        }
    }



}
