/**
 *
 * @author Isiy - Rodrigo Mesquita
 */
public class Publicacao {
    private String titulo;
    private int id;
    private int curtidas;
    private String conteudo;
    private int id_ia;

    public Publicacao(String titulo, int id, int curtidas, String conteudo, int id_ia) {
        this.titulo = titulo;
        this.id = id;
        this.curtidas = curtidas;
        this.conteudo = conteudo;
        this.id_ia = id_ia;
    }

    public int getId() {
        return id;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public int getId_ia() {
        return id_ia;
    }

    public String getConteudo() {
        return conteudo;
    }
    
    public String getTitulo() {
        return titulo;
    }
}
