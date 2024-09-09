import java.util.ArrayList;

public class Grafo {
    private ArrayList<Vertice> verticeList;
    private ArrayList<Arista> aristaList;
    private boolean dirigido;
    
    public Grafo(boolean dirigido) {
        this.verticeList = new ArrayList<Vertice>();
        this.aristaList = new ArrayList<Arista>();
        this.dirigido = dirigido;
    }

    public Grafo(ArrayList<Vertice> verticeList, ArrayList<Arista> aristaList, boolean dirigido) {
        this(dirigido);
        this.verticeList = verticeList;
        this.aristaList = aristaList;
    }

    public void printGrafo() {
        System.out.println("Grafo - " + (this.dirigido ? "Dirigido" : "No Dirigido"));
        for (Vertice vertice : verticeList) {
            System.out.print(vertice.getIdVertice() + ": ");
            ArrayList<String> adyacentes = new ArrayList<>();
            for (Arista arista : aristaList) {
                String verticeA = arista.getVertice(false).getIdVertice();
                String verticeB = arista.getVertice(true).getIdVertice();
                int peso = (int) arista.getArista().get(1);
                if (vertice.getIdVertice().equals(verticeA)) {
                    adyacentes.add(verticeB + (peso != 0 ? " (Peso: " + peso + ")" : ""));
                }
                if (!dirigido && vertice.getIdVertice().equals(verticeB)) {
                    adyacentes.add(verticeA + (peso != 0 ? " (Peso: " + peso + ")" : ""));
                }
            }
            System.out.println(String.join(", ", adyacentes));
        }
    }
    

    public boolean addVertice(Vertice nuevoVertice) {
        try {
            this.verticeList.add(nuevoVertice);
            return true;
        } catch (Exception e) {
            System.out.println("No se puedo aniadir el vertice: " +
                nuevoVertice.getIdVertice() +
                "\n se capturo la excepcion: " +
                e.getMessage());
            return false;
        }
    }

    public boolean addArista(Arista nuevaArista) {
        try {
            this.aristaList.add(nuevaArista);
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo añadir la arista: [" + 
                nuevaArista.getVertice(false).getIdVertice() + ", " + 
                nuevaArista.getVertice(true).getIdVertice() + "]\n" + 
                "Se capturó la excepción: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Vertice> getverticeList() {
        return this.verticeList;
    }
}