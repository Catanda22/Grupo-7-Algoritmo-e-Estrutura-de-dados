import java.util.ArrayList;
import java.util.Scanner;

public class IP {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int totalZonas = 6;

        // Nomes dos bairros
        String[] bairros = new String[totalZonas];

        // Grafo: cada zona possui uma lista de zonas ligadas
        ArrayList<Integer>[] grafo = new ArrayList[totalZonas];

        // Marca se a zona foi visitada durante o BFS
        boolean[] visitado = new boolean[totalZonas];

        // Leitura dos nomes dos bairros
        for (int i = 0; i < totalZonas; i++) {
            System.out.print("Digite o nome do bairro " + i + ": ");
            bairros[i] = input.nextLine();
            grafo[i] = new ArrayList<>();
        }

        // Ligacoes com iluminacao publica (arestas do grafo)
        grafo[0].add(1);
        grafo[1].add(0);

        grafo[1].add(2);
        grafo[2].add(1);

        grafo[2].add(3);
        grafo[3].add(2);

        // Executa o algoritmo BFS a partir da zona 0
        bfs(grafo, visitado, totalZonas, 0);

        // Mostra zonas sem iluminacao publica adequada
        System.out.println("\nBairros com iluminacao publica inadequada:");
        for (int i = 0; i < totalZonas; i++) {
            if (!visitado[i]) {
                System.out.println(bairros[i]);
            }
        }

        input.close();
    }

    // Algoritmo de Busca em Largura (BFS)
    static void bfs(ArrayList<Integer>[] grafo,
                    boolean[] visitado,
                    int totalZonas,
                    int inicio) {

        int[] fila = new int[totalZonas];
        int inicioFila = 0;
        int fimFila = 0;

        fila[fimFila++] = inicio;
        visitado[inicio] = true;

        while (inicioFila < fimFila) {

            int atual = fila[inicioFila++];

            for (int vizinho : grafo[atual]) {
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila[fimFila++] = vizinho;
                }
            }
        }
    }
}
