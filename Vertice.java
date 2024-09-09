public class Vertice {

    private String idVertice;

    public Vertice(String idVertice) {
        this.idVertice = idVertice;
    }

    public Vertice(Integer idNumeroVertice) {
        this(idNumeroVertice.toString());
    }

    public String getIdVertice() {
        return this.idVertice;
    }
}
