package euler;

import euclides.AlgoritmoEuclides;

public class TotienteEuler {
    public static int calcularTotiente(int n) {
        int contador = 0;

        for (int i = 1; i < n; i++) {

            if (AlgoritmoEuclides.calcularMDC(i, n) == 1) {

                contador++;
            }
        }

        return contador;
    }
}