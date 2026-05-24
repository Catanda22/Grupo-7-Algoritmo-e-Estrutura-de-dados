package mdc;

public class MaximoDivisorComum {

    // Método para calcular o MDC
    public static int calcularMDC(int n1, int n2) {

        int menor;
        int mdc = 1;

        // Descobrir o menor número
        if (n1 < n2) {
            menor = n1;
        } else {
            menor = n2;
        }

        // Procurar divisores comuns
        for (int i = 1; i <= menor; i++) {

            if (n1 % i == 0 && n2 % i == 0) {
                mdc = i;
            }
        }

        return mdc;
    }
}