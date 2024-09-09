import java.util.ArrayList;

public class Arista {

    private ArrayList arista;
    private Vertice[] vertices;
    private int peso;
    private boolean dirigido;

    public Arista(Vertice verticeA, Vertice verticeB) {
        this.arista = new ArrayList<>(4);
        vertices = new Vertice[] {verticeA, verticeB};
        this.dirigido = false;
        this.peso = 0;
        arista.add(0, vertices);
        arista.add(1, this.dirigido);
        arista.add(2, peso);
    }

    public Arista(Vertice verticeA, Vertice verticeB, boolean dirigido) {
        this(verticeA, verticeB);
        this.dirigido = dirigido;
    }

    public Arista(Vertice verticeA, Vertice verticeB, int peso) {
        this(verticeA, verticeB); 
        this.peso = peso;
    }

    public Arista(Vertice verticeA, Vertice verticeB, int peso, boolean dirigido) {
        this(verticeA, verticeB, peso); 
        this.dirigido = dirigido;
    }

    public ArrayList getArista() {
        return this.arista;
    }

    public Vertice getVertice(boolean vertice) {
        
        return vertice ? this.vertices[1] : this.vertices[0];
    }
}
