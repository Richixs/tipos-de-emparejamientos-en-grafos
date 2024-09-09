public class Vertice {

    private String idVertice;

    public Vertice(String idVertice) {
        this.idVertice = idVertice;
    }

    public Vertice(Integer idNumeroVertice) {
        this(idNumeroVertice.toString());
    }

    @Override
    public String toString() {
        return this.idVertice;
    }
}
