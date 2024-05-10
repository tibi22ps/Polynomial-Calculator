package Teste;

import org.example.Polinom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Teste {
    String poly1="1x^3+2x^2+3x^1+5x^0", poly2="4x^2+6x^1";

    @Test
    public void testSuma(){
        assertEquals("+5x^0+9x^1+6x^2+1x^3", Polinom.adunare(poly1,poly2).afisare());
    }


    @Test
    public void testDiferenta(){
        assertEquals("+5x^0-3x^1-2x^2+1x^3",Polinom.scadere(poly1,poly2).afisare());
    }


    @Test
    public void testInmultire(){
        assertEquals("+30x^1+38x^2+24x^3+14x^4+4x^5",Polinom.multiplication(poly1,poly2).afisare());
    }


    @Test
    public void testImpartire(){
        assertEquals("+2x^0+1x^2",Polinom.impartire("1x^4+3x^2+3x^1", "1x^2+1x^0").afisare());
    }


    @Test
    public void testDerivare(){
        assertEquals("+3x^0+4x^1+3x^2", Polinom.derivare(poly1).afisare());
    }


    @Test
    public void testIntegrare(){
        assertEquals("+5/1x^1+3/2x^2+2/3x^3+1/4x^4",Polinom.integrare(poly1));
    }
}
