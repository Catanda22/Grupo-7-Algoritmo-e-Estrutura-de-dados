
import java.util.ArrayList;

public class iluminacaoPublica {

    public static void main(String[] args) {

        int totalZonas = 6;

        // Grafo: cada zona possui uma lista de zonas ligadas
        ArrayList<Integer>[] grafo = new ArrayList[totalZonas];

        // Marca se a zona foi visitada durante o BFS
        boolean[] visitado = new boolean[totalZonas];

        // Inicializa o grafo
        for (int i = 0; i < totalZonas; i++) {
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
        System.out.println("Zonas com iluminacao publica inadequada:");
        for (int i = 0; i < totalZonas; i++) {
            if (!visitado[i]) {
                System.out.println("Zona " + i);
            }
        }
    }

    // Algoritmo de Busca em Largura (BFS)
    static void bfs(ArrayList<Integer>[] grafo,
                    boolean[] visitado,
                    int totalZonas,
                    int inicio) {

        // Fila usada pelo BFS
        int[] fila = new int[totalZonas];
        int inicioFila = 0;
        int fimFila = 0;

        // Inicia o BFS pela zona inicial
        fila[fimFila++] = inicio;
        visitado[inicio] = true;

        // Enquanto houver zonas na fila
        while (inicioFila < fimFila) {

            // Retira a proxima zona da fila
            int atual = fila[inicioFila++];

            // Visita todas as zonas ligadas a zona atual
            for (int vizinho : grafo[atual]) {

                // Se ainda nao foi visitada
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila[fimFila++] = vizinho;
                }
            }
        }
    }
}
