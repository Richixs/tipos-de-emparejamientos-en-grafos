import java.util.ArrayList;

public class Arista {

    private ArrayList arista;
    private Vertice[] vertices;
    private int peso;

    public Arista(Vertice verticeA, Vertice verticeB) {
        this.arista = new ArrayList<>(4);
        vertices = new Vertice[] {verticeA, verticeB};
        this.peso = 0;
        arista.add(0, vertices);
        arista.add(1, peso);
    }

    public Arista(Vertice verticeA, Vertice verticeB, int peso) {
        this(verticeA, verticeB); 
        this.peso = peso;
    }

    public ArrayList getArista() {
        return this.arista;
    }

    public Vertice getVertice(boolean vertice) {
        
        return vertice ? this.vertices[1] : this.vertices[0];
    }
}
