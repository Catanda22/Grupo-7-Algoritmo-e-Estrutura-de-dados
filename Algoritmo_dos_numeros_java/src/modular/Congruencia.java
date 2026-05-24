package modular;

public class Congruencia {


    public static boolean verificarCongruencia(
            int a,
            int b,
            int modulo) {

        return (a % modulo) == (b % modulo);
    }
}