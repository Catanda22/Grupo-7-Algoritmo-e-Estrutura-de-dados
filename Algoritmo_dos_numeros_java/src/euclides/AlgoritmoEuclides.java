package euclides;

public class AlgoritmoEuclides {

    /*
     * Implementação do Algoritmo de Euclides
     * para cálculo do MDC.
     */
    public static int calcularMDC(int a, int b) {
        // Enquanto existir resto repetir
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }

        return a;
    }
}