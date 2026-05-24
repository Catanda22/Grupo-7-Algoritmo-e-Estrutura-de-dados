package primos;

public class FactorizacaoInteiros {


    public static void factorizar(int numero) {

        System.out.print("\nFactores primos: ");


        int divisor = 2;

        while (numero > 1) {

            while (numero % divisor == 0) {

                System.out.print(divisor + " ");

                numero = numero / divisor;
            }

            divisor++;
        }

        System.out.println();
    }
}