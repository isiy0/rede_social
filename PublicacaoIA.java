/**
 *
 * @author aluno
 */
import java.util.ArrayList;

public class PublicacaoIA {
    private ArrayList<IA> ias;
    private ArrayList<Publicacao> publicacoes;
    private int proximoIdIA;
    private int proximoIdPublicacao;

    public PublicacaoIA() {
        this.ias = new ArrayList<>();
        this.publicacoes = new ArrayList<>();
        this.proximoIdIA = 1;
        this.proximoIdPublicacao = 1;
    }

    public IA cadastrar_ia(String nome) {
        IA novaIA = new IA(nome, proximoIdIA);
        ias.add(novaIA);
        proximoIdIA++;
        return novaIA;
    }

    private IA encontrarIA(int idIA) {
        for (IA ia : ias) {
            if (ia.getId() == idIA) {
                return ia;
            }
        }
        return null;
    }
    
    private IA encontrarIAPorNome(String nome) {
        for (IA ia : ias) {
            if (ia.getNome().equals(nome)) {
                return ia;
            }
        }
        return null;
    }
    
    public boolean iaExiste(String nome) {
        return encontrarIAPorNome(nome) != null;
    }

    public Publicacao cadastrar_publicacao(int idIA, String titulo, String conteudo) {
        IA ia = encontrarIA(idIA);
        if (ia == null) {
            return null;
        }
        
        Publicacao novaPublicacao = new Publicacao(titulo, proximoIdPublicacao, 0, conteudo, idIA);
        publicacoes.add(novaPublicacao);
        proximoIdPublicacao++;
        return novaPublicacao;
    }
    
    public Publicacao cadastrar_publicacao_por_nome(String nomeIA, String titulo, String conteudo) {
        IA ia = encontrarIAPorNome(nomeIA);
        if (ia == null) {
            return null;
        }
        
        return cadastrar_publicacao(ia.getId(), titulo, conteudo);
    }

    public void curtir_publicacao(int idPublicacao) {
        for (Publicacao pub : publicacoes) {
            if (pub.getId() == idPublicacao) {
                pub.setCurtidas(pub.getCurtidas() + 1);
                break;
            }
        }
    }

    public ArrayList<String> consultar_ia() {
        ArrayList<String> resultado = new ArrayList<>();
        for (IA ia : ias) {
            String info = String.format("IA: %s (ID: %d)", ia.getNome(), ia.getId());
            resultado.add(info);
        }
        return resultado;
    }

    public ArrayList<String> consultar_publicacao() {
        ArrayList<String> resultado = new ArrayList<>();
        for (Publicacao pub : publicacoes) {
            IA ia = encontrarIA(pub.getId_ia());
            if (ia != null) {
                String info = String.format("Publicação ID: %d - IA: %s (ID: %d) - Curtidas: %d - Conteúdo: %s",
                    pub.getId(), ia.getNome(), ia.getId(), pub.getCurtidas(), pub.getConteudo());
                resultado.add(info);
            }
        }
        return resultado;
    }
    
    public ArrayList<String> consultar_publicacao_formatada() {
        ArrayList<String> resultado = new ArrayList<>();
        for (Publicacao pub : publicacoes) {
            IA ia = encontrarIA(pub.getId_ia());
            if (ia != null) {
                String info = String.format("ID: %d - Título: %s - Curtidas: %d - Autor: %s",
                    pub.getId(), pub.getTitulo(), pub.getCurtidas(), ia.getNome());
                resultado.add(info);
            }
        }
        return resultado;
    }
    
    public String ler_conteudo_publicacao(int idPublicacao) {
        for (Publicacao pub : publicacoes) {
            if (pub.getId() == idPublicacao) {
                return pub.getConteudo();
            }
        }
        return null;
    }
}
