package modular;

public class TCR {

    public static int resolver(
            int resto1,
            int modulo1,
            int resto2,
            int modulo2) {

        int x = 0;

        while (true) {

            if (x % modulo1 == resto1 &&
                    x % modulo2 == resto2) {

                return x;
            }

            x++;
        }
    }
}