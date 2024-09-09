import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    public boolean addVertice(Vertice nuevoVertice) {
        try {
            this.verticeList.add(nuevoVertice);
            return true;
        } catch (Exception e) {
            System.out.println("No se puedo aniadir el vertice: " +
                nuevoVertice +
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
                nuevaArista.getVertice(false) + ", " + 
                nuevaArista.getVertice(true) + "]\n" + 
                "Se capturó la excepción: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Vertice> getverticeList() {
        return this.verticeList;
    }

    public void printGrafo() {
        System.out.println("Grafo - " + (this.dirigido ? "Dirigido" : "No Dirigido"));
        for (Vertice vertice : verticeList) {
            System.out.print(vertice + ": ");
            ArrayList<String> adyacentes = new ArrayList<>();
            for (Arista arista : aristaList) {
                String verticeA = arista.getVertice(false).toString();
                String verticeB = arista.getVertice(true).toString();
                int peso = (int) arista.getArista().get(1);
                if (vertice.toString().equals(verticeA)) {
                    adyacentes.add(verticeB + (peso != 0 ? " (Peso: " + peso + ")" : ""));
                }
                if (!dirigido && vertice.toString().equals(verticeB)) {
                    adyacentes.add(verticeA + (peso != 0 ? " (Peso: " + peso + ")" : ""));
                }
            }
            System.out.println(String.join(", ", adyacentes));
        }
    }

     public void printEmparejamientos() {
        ArrayList<Set<Vertice>> emparejamientos = new ArrayList<>();
        Set<Vertice> emparejamientoActual = new HashSet<>();
        for (Arista arista : aristaList) {
            Vertice v1 = arista.getVertice(false);
            Vertice v2 = arista.getVertice(true);
            if (!emparejamientoActual.contains(v1) && !emparejamientoActual.contains(v2)) {
                Set<Vertice> par = new HashSet<>();
                par.add(v1);
                par.add(v2);
                emparejamientos.add(par);
                emparejamientoActual.add(v1);
                emparejamientoActual.add(v2);
            }
        }
        System.out.println("Emparejamientos:");
        for (Set<Vertice> par : emparejamientos) {
            System.out.println(par);
        }
        boolean esMaximo = emparejamientoActual.size() == verticeList.size();
        boolean esMaximal = esEmparejamientoMaximal(emparejamientos);
        boolean esPerfecto = emparejamientoActual.size() == verticeList.size() && emparejamientoActual.size() % 2 == 0;
        System.out.println("Tipo de emparejamiento:");
        if (esPerfecto) {
            System.out.println("Emparejamiento perfecto");
        } else if (esMaximo) {
            System.out.println("Emparejamiento máximo");
        } else if (esMaximal) {
            System.out.println("Emparejamiento maximal");
        } else {
            System.out.println("Emparejamiento no es maximal ni máximo");
        }
    }

    private boolean esEmparejamientoMaximal(ArrayList<Set<Vertice>> emparejamientos) {
        Set<Vertice> emparejados = new HashSet<>();
        for (Set<Vertice> par : emparejamientos) {
            emparejados.addAll(par);
        }
        for (Vertice v : verticeList) {
            if (!emparejados.contains(v)) {
                for (Arista arista : aristaList) {
                    if (arista.getVertice(false).equals(v) || arista.getVertice(true).equals(v)) {
                        Vertice otro = arista.getVertice(false).equals(v) ? arista.getVertice(true) : arista.getVertice(false);
                        if (!emparejados.contains(otro)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}