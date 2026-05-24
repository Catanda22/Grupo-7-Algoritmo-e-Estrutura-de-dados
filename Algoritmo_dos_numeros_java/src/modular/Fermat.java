package modular;

public class Fermat {

    // Método para verificar o Pequeno Teorema de Fermat
    public static boolean verificarFermat(int a, int p) {


        long resultado = 1;

        for (int i = 1; i <= p - 1; i++) {
            resultado = (resultado * a) % p;
        }

        return resultado == 1;
    }
}