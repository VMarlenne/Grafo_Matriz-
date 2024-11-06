package com.mycompany.grafomatriz;

public class GrafoMatriz {
    public static void main(String[] args) {
        int[][] matrizAdyacencia = {
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };

        ListaAdyacencia grafo = new ListaAdyacencia(matrizAdyacencia.length);

        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = i + 1; j < matrizAdyacencia.length; j++) {
                if (matrizAdyacencia[i][j] == 1) {
                    grafo.agregarArista(i, j);
                }
            }
        }

        grafo.mostrarGrafo();
    }
}

class ListaAdyacencia {
    private final String[] vertices;
    private final String[][] adyacencias;

    public ListaAdyacencia(int numVertices) {
        vertices = new String[numVertices];
        adyacencias = new String[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            vertices[i] = "V" + i;
        }

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adyacencias[i][j] = "No hay conexión";
            }
        }
    }

    public void agregarArista(int origen, int destino) {
        adyacencias[origen][destino] = "Conexión";
        adyacencias[destino][origen] = "Conexión";
    }

    public void mostrarGrafo() {
        for (int i = 0; i < vertices.length; i++) {
            System.out.print("Vértice " + vertices[i] + " tiene conexiones con: ");
            for (int j = 0; j < vertices.length; j++) {
                if (adyacencias[i][j].equals("Conexión")) {
                    System.out.print(vertices[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
