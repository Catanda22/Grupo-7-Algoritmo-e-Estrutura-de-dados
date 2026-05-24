
//importação de todos os pacotes e classes
import euclides.AlgoritmoEuclides;
import euler.TotienteEuler;
import mdc.MaximoDivisorComum;
import modular.Congruencia;
import modular.Fermat;
import modular.TCR;
import primos.FactorizacaoInteiros;
import primos.TestePrimalidade;
import rsa.RSA;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

import static rsa.RSA.PATH_CHAVE_PRIVADA;
import static rsa.RSA.PATH_CHAVE_PUBLICA;

public class Main {

    public static void main(String[] args) {

        Scanner B = new Scanner(System.in);

        int opcao;

        do {
            System.out.println(" ALGORITMOS DOS NÚMEROS EM JAVA ");
            System.out.println("1- MDC\n2- EUCLIDES\n3- PRIMOS\n4- MODULAR\n5- EULER\n6- RSA\n0- SAIR\n Escolha uma opção:");
            opcao = B.nextInt();

            switch (opcao) {

                case 1:

                    int n1, n2, resultado;

                    System.out.print("Digite o primeiro número: ");
                    n1 = B.nextInt();

                    System.out.print("Digite o segundo número: ");
                    n2 = B.nextInt();

                    resultado = MaximoDivisorComum.calcularMDC(n1, n2);

                    System.out.println("O MDC entre " + n1 + " e " + n2 + " é: " + resultado);

                    break;

                case 2:

                    int valor1, valor2, mdcEuclides;

                    System.out.print("Digite o primeiro número: ");
                    valor1 = B.nextInt();

                    System.out.print("Digite o segundo número: ");
                    valor2 = B.nextInt();

                    mdcEuclides =  AlgoritmoEuclides.calcularMDC(valor1, valor2);

                    System.out.println("O MDC entre " + valor1 + " e " + valor2 + " é: " + mdcEuclides);

                    break;

                case 3:
                    System.out.println(":::::: PRIMOS :::::\nEscolhe uma opcao:\n1- Factoracao\n2- Teste de primalidade");
                    int escolheOpcao = B.nextInt();
                    switch (escolheOpcao)
                    {
                        case 1:
                            int numero;

                            int numeroFactorizar;
                            System.out.print("Digite um número: ");
                            numeroFactorizar = B.nextInt();

                            System.out.println("Factorização do número "+ numeroFactorizar + ":");
                            FactorizacaoInteiros.factorizar(numeroFactorizar);
                            break;

                            case 2:
                                System.out.print("Digite um número: ");
                                numero = B.nextInt();

                                boolean primo = TestePrimalidade.verificarPrimo(numero);

                                if (primo) {

                                    System.out.println("O número " + numero + " é primo.");

                                } else {

                                    System.out.println("O número " + numero + " NÃO é primo.");
                                }
                                break;
                        default:
                            System.out.println("Entrada invalida");

                    }

                case 4:

                    System.out.println(":::::: MODULAR ::::::");
                    System.out.println("1-CONGRUENCIA\n2-FERMAT\n3-TEORIA CHINES DO RESTO\nEscolhe uma opcao:");
                    int escolher = B.nextInt();

                    switch (escolher) {
                        case 1:
                            int a, b, modulo;

                            System.out.print("Digite o primeiro número: ");
                            a = B.nextInt();

                            System.out.print("Digite o segundo número: ");
                            b = B.nextInt();

                            System.out.print("Digite o módulo: ");
                            modulo = B.nextInt();
                            boolean congruente = Congruencia.verificarCongruencia(a,b,modulo);

                            if (congruente) {
                                System.out.println("\n" + a + " é congruente a "+ b+ " módulo "+ modulo);

                            } else {

                                System.out.println("\n" +a+ " NÃO é congruente a "+ b + " módulo "+ modulo);
                            }

                            break;
                            case 2:
                                int base, Primo;

                                System.out.print("Digite o valor de a: ");
                                base = B.nextInt();

                                System.out.print("Digite o número primo p: ");
                                Primo = B.nextInt();

                                boolean fermat = Fermat.verificarFermat(base, Primo);

                                if (fermat) {
                                    System.out.println("O Pequeno Teorema de Fermat é válido.");

                                } else {

                                    System.out.println("O Pequeno Teorema de Fermat NÃO é válido.");
                                }

                                break;
                                case 3:
                                    int resto1, modulo1;
                                    int resto2, modulo2;

                                    System.out.print("Digite o primeiro resto: ");
                                    resto1 = B.nextInt();

                                    System.out.print("Digite o primeiro módulo: ");
                                    modulo1 = B.nextInt();

                                    System.out.print("Digite o segundo resto: ");
                                    resto2 = B.nextInt();

                                    System.out.print("Digite o segundo módulo: ");
                                    modulo2 = B.nextInt();

                                    int solucao = TCR.resolver(resto1, modulo1, resto2,modulo2);

                                    System.out.println("A solução é x = " + solucao);

                                    break;
                        default:
                            System.out.println("Escolha invalida");

                    }

                case 5:
                    int n;

                    System.out.print("Digite um número: ");
                    n = B.nextInt();

                    int resultadoEuler = TotienteEuler.calcularTotiente(n);
                    System.out.println("(" + n + ") = " + resultadoEuler);

                    break;

                case 6:
                    try {
                        System.out.println("::::::: RSA :::::::");

                        //verifica se a chaves
                        if (!RSA.verificaSeExisteChavesNoSo()) {

                            RSA.geraChave();
                        }

                        // Entrada
                        System.out.println("Digite uma Mensagem...");
                        String mensagemOriginal = B.next();
                        ObjectInputStream inputStream;

                        // chave pública
                        inputStream = new ObjectInputStream(new FileInputStream(PATH_CHAVE_PUBLICA));
                        PublicKey chavePublica = (PublicKey) inputStream.readObject();
                        inputStream.close();

                        // criptografa
                        byte[] textoCriptografado =
                                RSA.criptografa(mensagemOriginal, chavePublica);

                        // chave privada
                        inputStream = new ObjectInputStream(new FileInputStream( PATH_CHAVE_PRIVADA));
                        PrivateKey chavePrivada = (PrivateKey) inputStream.readObject();

                        inputStream.close();

                        // descriptografa
                        String textoPuro = RSA.decriptografa(textoCriptografado, chavePrivada);

                        System.out.println("\nMensagem Original: " + mensagemOriginal);
                        System.out.println("\nMensagem Criptografada: " + Base64.getEncoder().encodeToString(textoCriptografado )
                        );
                        System.out.println("\nMensagem Decriptografada: " + textoPuro );

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;

                case 0:
                    System.out.println("Fim.");
                    break;

                default:
                    System.out.println("Escolha invalida");
            }

        } while (opcao != 0);

        B.close();
    }
}