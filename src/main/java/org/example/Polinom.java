package org.example;
import java.awt.font.ShapeGraphicAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.*;
import java.util.regex.Matcher;

public class Polinom {
    private Map<Integer,Integer> polinom;
    public Polinom(Map<Integer,Integer> polinom){
        this.polinom=polinom;
    }

    public Map<Integer,Integer> getPolinom(){
        return
                polinom;
    }

    public static Polinom formarePolinom(String input){
    Map<Integer, Integer> polinom = new HashMap<>();
        Pattern pattern = Pattern.compile("([-+]?\\d*)?x(\\^(\\d+))?");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
        String coeffString = matcher.group(1);
        String exponentString = matcher.group(3);

            int coeff;
            if (coeffString == null || coeffString.equals("+")) {
                coeff = 1;
            } else if (coeffString.equals("-")) {
                coeff = -1;
            } else {
                coeff = Integer.parseInt(coeffString);
            }

            int exponent;
            if (exponentString == null) {
                exponent = 1;
            } else {
                exponent = Integer.parseInt(exponentString);
            }

        polinom.put(exponent, coeff + polinom.getOrDefault(exponent, 0));
    }
        return new Polinom(polinom);
}

    public static Polinom adunare(String poly1, String poly2) {
        Polinom p1 = formarePolinom(poly1);
        Polinom p2 = formarePolinom(poly2);
        Map<Integer, Integer> sum = new HashMap<>();
        for (int exp : p1.getPolinom().keySet()) {
            int coeff1 = p1.getPolinom().get(exp);
            int coeff2 = p2.getPolinom().getOrDefault(exp, 0);
            int coeffSum = coeff1 + coeff2;
            if (coeffSum != 0) {
                sum.put(exp, coeffSum);
            }
        }
        for (int exp : p2.getPolinom().keySet()) {
            if (!p1.getPolinom().containsKey(exp)) {
                sum.put(exp, p2.getPolinom().get(exp));
            }
        }
        return new Polinom(sum);
    }

    public static Polinom scadere(String poly1, String poly2) {
        Polinom p1 = formarePolinom(poly1);
        Polinom p2 = formarePolinom(poly2);
        Map<Integer, Integer> dif = new HashMap<>();
        for (int exp : p1.getPolinom().keySet()) {
            int coeff1 = p1.getPolinom().get(exp);
            int coeff2 = p2.getPolinom().getOrDefault(exp, 0);
            int coeffDif = coeff1 - coeff2;
            if (coeffDif != 0) {
                dif.put(exp, coeffDif);
            }
        }
        for (int exp : p2.getPolinom().keySet()) {
            if (!p1.getPolinom().containsKey(exp)) {
                dif.put(exp,-p2.polinom.get(exp));
            }
        }
        return new Polinom(dif);
    }

    public static Polinom multiplication(String poly1, String poly2) {
        Polinom p1 = formarePolinom(poly1);
        Polinom p2 = formarePolinom(poly2);
        Map<Integer, Integer> mul = new HashMap<>();
        for(int i: p1.getPolinom().keySet()){ //exponent 1
            int coeff1 = p1.getPolinom().get(i);
            for(int j: p2.getPolinom().keySet()){ //exponent 2
                int coeff2 = p2.getPolinom().get(j);
                int coeffMul= coeff1*coeff2;
                int expMul= i + j;
                int coeffCrt= mul.getOrDefault(expMul, 0);
                mul.put(expMul, coeffMul + coeffCrt);
            }
        }
        return new Polinom(mul);
    }

    public static Polinom derivare(String poly1) {
        Polinom p1 = formarePolinom(poly1);
        Map<Integer, Integer> derivative = new HashMap<>();

        for (int exp : p1.getPolinom().keySet()) {
            if (exp == 0) {
                continue;
            }

            int coeff = p1.getPolinom().get(exp);
            derivative.put(exp - 1, coeff * exp);
        }

        return new Polinom(derivative);
    }

    public static String integrare(String poly1) {
        Polinom polinom = formarePolinom(poly1);
        //Map<Integer, Integer> integral = new HashMap<>();
        //integral.put(exp + 1, coeff / (exp + 1));

            String integralPoly = "";
            for (Map.Entry<Integer,Integer> exp : polinom.polinom.entrySet()) {
                if(exp.getValue() >0)
                integralPoly+= "+" + exp.getValue() + "/" + ( exp.getKey()+1) + "x^" + (exp.getKey()+1);
                else  integralPoly+=  exp.getValue() + "/" + ( exp.getKey()+1) + "x^" + (exp.getKey()+1);
            }
        return integralPoly;
        }

    public int grad() {
        if (polinom.isEmpty()) {
            return 0;
        }
        return polinom.keySet().stream().max(Integer::compareTo).get();
    }

    public double coeficientMaxim() {
        if (polinom.isEmpty()) {
            return 0.0;
        }
        return polinom.get(grad());
    }

    public static Polinom impartire(String poly1, String poly2) {
        Polinom p1 = formarePolinom(poly1);
        Polinom p2 = formarePolinom(poly2);
        Polinom cat = formarePolinom("");
        while (p1.grad() >= p2.grad()) {
            int coef = (int) p1.coeficientMaxim() / (int) p2.coeficientMaxim();
            int exp = p1.grad() - p2.grad();
            Polinom monomCat = formarePolinom("");
            monomCat.getPolinom().put(exp, coef);
            cat = adunare(cat.afisare(), monomCat.afisare());
            Polinom produs = multiplication(p2.afisare(), monomCat.afisare());
            Polinom diferenta = scadere(p1.afisare(), produs.afisare());
            if (diferenta.grad() >= p1.grad()) {
                break;
            }
            p1 = diferenta;
        }
        return cat;
    }

    public String afisare() {
        String rez="";
        for( Map.Entry<Integer,Integer> iterrator : this.polinom.entrySet()){
            if(iterrator.getValue() <0){
            rez=rez + iterrator.getValue()+"x^"+iterrator.getKey();}
            else{
                rez=rez + "+" + iterrator.getValue()+"x^"+iterrator.getKey();
                }
        }

        return rez;
    }
}

