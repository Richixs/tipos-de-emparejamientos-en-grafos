import java.util.ArrayList;

public class Grafo {
    private ArrayList<Vertice> verticeList;
    private ArrayList arristaList;
    
    public Grafo() {
        this.verticeList = new ArrayList<Vertice>();
        this.arristaList = new ArrayList<Arista>();
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
            this.arristaList.add(nuevaArista);
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo añadir la arista: [" + 
                nuevaArista.getVertice(false).getIdVertice() + ", " + 
                nuevaArista.getVertice(true).getIdVertice() + "]\n" + 
                "Se capturó la excepción: " + e.getMessage());
            return false;
        }
    }
}