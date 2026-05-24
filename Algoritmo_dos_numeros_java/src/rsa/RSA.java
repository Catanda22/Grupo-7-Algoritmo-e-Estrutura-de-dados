package rsa;
import javax.crypto.Cipher;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.PublicKey;
import java.security.PrivateKey;
//import package rsa.RSA;
public class RSA {

    public static final String PATH_CHAVE_PUBLICA = "chavePublica.key";
    public static final String PATH_CHAVE_PRIVADA = "chavePrivada.key";

    public static void geraChave() {

        try {
            KeyPairGenerator gerador = KeyPairGenerator.getInstance("RSA");
            gerador.initialize(2048);
            KeyPair parDeChaves = gerador.generateKeyPair();
            PublicKey chavePublica = (PublicKey) parDeChaves.getPublic();
            PrivateKey chavePrivada = parDeChaves.getPrivate();
            ObjectOutputStream outputStream;

            // Guarda chave pública
            outputStream = new ObjectOutputStream(new FileOutputStream(PATH_CHAVE_PUBLICA));
            outputStream.writeObject(chavePublica);
            outputStream.close();

            // Guarda chave privada
            outputStream = new ObjectOutputStream(new FileOutputStream(PATH_CHAVE_PRIVADA));
            outputStream.writeObject(chavePrivada);
            outputStream.close();
            System.out.println("Cvave gerada...");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // Verifica se as chaves existem
    public static boolean verificaSeExisteChavesNoSo() {

        File chavePublica =new File(PATH_CHAVE_PUBLICA);

        File chavePrivada =new File(PATH_CHAVE_PRIVADA);

        return chavePublica.exists() && chavePrivada.exists();
    }

    // Criptografa o texto gerado
    public static byte[] criptografa(String texto, PublicKey chave) {

        byte[] cifraText = null;

        try {

            final Cipher cifra = Cipher.getInstance("RSA");

            cifra.init( Cipher.ENCRYPT_MODE, (Key) chave );

            cifraText = cifra.doFinal(texto.getBytes(StandardCharsets.UTF_8));

        } catch (Exception e) { e.printStackTrace();
        }

        return cifraText;
    }

    // Decriptografa texto
    public static String decriptografa(byte[] texto, PrivateKey chave) {

        byte[] decifrarTexto = null;

        try {
            final Cipher cipher = Cipher.getInstance("RSA");

            cipher.init(Cipher.DECRYPT_MODE, (Key) chave);

            decifrarTexto = cipher.doFinal(texto);

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return new String(
                decifrarTexto,
                StandardCharsets.UTF_8
        );
    }

}

