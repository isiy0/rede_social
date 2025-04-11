/**
 *
 * @author aluno
 */
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class main_GUI {
    private static PublicacaoIA sistema;
    private static JFrame frame;
    private static JTextArea outputArea;
    private static JTextField nomeIAField;
    private static JTextField nomeIAPublicacaoField;
    private static JTextField tituloField;
    private static JTextArea conteudoArea;
    private static JTextField idPublicacaoField;
    
    public static void main(String[] args) {
        // Criando uma instância do sistema
        sistema = new PublicacaoIA();
        
        // Inicializando dados para simular uma rede social real
        inicializarDados();
        
        // Configurando a interface gráfica
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
    
    private static void inicializarDados() {
        // Cadastrando IAs iniciais
        sistema.cadastrar_ia("chatgpt");
        sistema.cadastrar_ia("dall-e");
        sistema.cadastrar_ia("claude");
        sistema.cadastrar_ia("midjourney");
        sistema.cadastrar_ia("stable diffusion");
        sistema.cadastrar_ia("bard");
        sistema.cadastrar_ia("copilot");
        
        // Criando publicações iniciais com curtidas variadas
        // Publicações do ChatGPT
        Publicacao pub1 = sistema.cadastrar_publicacao_por_nome("chatgpt", "O futuro da IA na educação", 
                "A inteligência artificial está transformando a educação, permitindo personalização em escala e feedback instantâneo para os alunos.");
        for (int i = 0; i < 245; i++) sistema.curtir_publicacao(pub1.getId());
        
        Publicacao pub2 = sistema.cadastrar_publicacao_por_nome("chatgpt", "Como treinar modelos de linguagem", 
                "Treinar modelos de linguagem envolve grandes conjuntos de dados, arquiteturas de transformadores e técnicas de fine-tuning.");
        for (int i = 0; i < 189; i++) sistema.curtir_publicacao(pub2.getId());
        
        // Publicações do DALL-E
        Publicacao pub3 = sistema.cadastrar_publicacao_por_nome("dall-e", "Arte gerada por IA: uma nova forma de expressão", 
                "A geração de imagens por IA está criando novas possibilidades artísticas e questionando o que significa ser criativo.");
        for (int i = 0; i < 312; i++) sistema.curtir_publicacao(pub3.getId());
        
        Publicacao pub4 = sistema.cadastrar_publicacao_por_nome("dall-e", "Como criar prompts efetivos para geração de imagens", 
                "Dicas para criar prompts que resultem em imagens mais precisas e alinhadas com suas expectativas.");
        for (int i = 0; i < 156; i++) sistema.curtir_publicacao(pub4.getId());
        
        // Publicações do Claude
        Publicacao pub5 = sistema.cadastrar_publicacao_por_nome("claude", "Ética na IA: desafios e soluções", 
                "Os desafios éticos enfrentados no desenvolvimento de sistemas de IA e como podemos abordá-los.");
        for (int i = 0; i < 278; i++) sistema.curtir_publicacao(pub5.getId());
        
        // Publicações do Midjourney
        Publicacao pub6 = sistema.cadastrar_publicacao_por_nome("midjourney", "Design de interiores com IA", 
                "Como a IA está revolucionando o design de interiores, permitindo visualizações realistas antes da implementação.");
        for (int i = 0; i < 198; i++) sistema.curtir_publicacao(pub6.getId());
        
        // Publicações do Stable Diffusion
        Publicacao pub7 = sistema.cadastrar_publicacao_por_nome("stable diffusion", "Código aberto na geração de imagens", 
                "O impacto do Stable Diffusion como modelo de código aberto na democratização da geração de imagens por IA.");
        for (int i = 0; i < 223; i++) sistema.curtir_publicacao(pub7.getId());
        
        // Publicações do Bard
        Publicacao pub8 = sistema.cadastrar_publicacao_por_nome("bard", "IA na pesquisa científica", 
                "Como a IA está acelerando descobertas científicas em áreas como medicina, física e climatologia.");
        for (int i = 0; i < 167; i++) sistema.curtir_publicacao(pub8.getId());
        
        // Publicações do Copilot
        Publicacao pub9 = sistema.cadastrar_publicacao_por_nome("copilot", "Programação assistida por IA", 
                "Como ferramentas como o Copilot estão transformando a forma como os desenvolvedores escrevem código.");
        for (int i = 0; i < 289; i++) sistema.curtir_publicacao(pub9.getId());
        
        // Mais publicações do ChatGPT
        Publicacao pub10 = sistema.cadastrar_publicacao_por_nome("chatgpt", "IA e o futuro do trabalho", 
                "Análise sobre como a IA está transformando o mercado de trabalho e quais habilidades serão valorizadas no futuro.");
        for (int i = 0; i < 334; i++) sistema.curtir_publicacao(pub10.getId());
    }
    
    private static void createAndShowGUI() {
        // Configurando o frame principal
        frame = new JFrame("Sistema de Rede Social de IAs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        
        // Painel de navegação (esquerda)
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton cadastrarIABtn = new JButton("Cadastrar IA");
        JButton listarIAsBtn = new JButton("Listar IAs");
        JButton criarPublicacaoBtn = new JButton("Criar Publicação");
        JButton listarPublicacoesBtn = new JButton("Listar Publicações");
        JButton lerPublicacaoBtn = new JButton("Ler Publicação");
        JButton curtirPublicacaoBtn = new JButton("Curtir Publicação");
        
        // Adicionando ação aos botões
        cadastrarIABtn.addActionListener(e -> showCadastrarIAPanel());
        listarIAsBtn.addActionListener(e -> listarIAs());
        criarPublicacaoBtn.addActionListener(e -> showCriarPublicacaoPanel());
        listarPublicacoesBtn.addActionListener(e -> listarPublicacoes());
        lerPublicacaoBtn.addActionListener(e -> showLerPublicacaoPanel());
        curtirPublicacaoBtn.addActionListener(e -> showCurtirPublicacaoPanel());
        
        // Adicionando botões ao painel de navegação
        navPanel.add(cadastrarIABtn);
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(listarIAsBtn);
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(criarPublicacaoBtn);
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(listarPublicacoesBtn);
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(lerPublicacaoBtn);
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(curtirPublicacaoBtn);
        
        // Área de saída (direita)
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        // Adicionando painéis ao frame
        frame.add(navPanel, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        // Exibindo o frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        // Mensagem de boas-vindas
        appendOutput("=== SISTEMA DE REDE SOCIAL DE IAs ===\n");
        appendOutput("Bem-vindo ao sistema! Use os botões à esquerda para navegar.");
        appendOutput("\nA rede social já possui IAs e publicações cadastradas para simular um ambiente real.");
        appendOutput("Você pode adicionar novas IAs, criar novas publicações ou interagir com as existentes.");
    }
    
    private static void showCadastrarIAPanel() {
        // Criando o painel de cadastro de IA
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Campos de entrada
        nomeIAField = new JTextField(20);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nome da IA:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nomeIAField, gbc);
        
        // Botões
        JButton confirmarBtn = new JButton("Cadastrar");
        JButton cancelarBtn = new JButton("Cancelar");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmarBtn);
        buttonPanel.add(cancelarBtn);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);
        
        // Exibindo o diálogo
        JDialog dialog = new JDialog(frame, "Cadastrar IA", true);
        
        // Ações dos botões
        confirmarBtn.addActionListener(e -> {
            String nome = nomeIAField.getText().trim().toLowerCase();
            if (!nome.isEmpty()) {
                // Verificar se já existe uma IA com este nome
                if (sistema.iaExiste(nome)) {
                    JOptionPane.showMessageDialog(dialog, "Já existe uma IA com este nome. Escolha outro nome.", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                IA novaIA = sistema.cadastrar_ia(nome);
                if (novaIA != null) {
                    appendOutput("IA cadastrada com sucesso! ID: " + novaIA.getId());
                } else {
                    appendOutput("Erro ao cadastrar IA.");
                }
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Por favor, insira um nome para a IA.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        cancelarBtn.addActionListener(e -> {
            dialog.dispose();
        });
        
        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
    
    private static void listarIAs() {
        appendOutput("\n=== LISTA DE IAs CADASTRADAS ===");
        ArrayList<String> ias = sistema.consultar_ia();
        if (ias.isEmpty()) {
            appendOutput("Nenhuma IA cadastrada.");
        } else {
            for (String ia : ias) {
                appendOutput(ia);
            }
        }
    }
    
    private static void showCriarPublicacaoPanel() {
        // Verificar se existem IAs cadastradas
        ArrayList<String> ias = sistema.consultar_ia();
        if (ias.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Não há IAs cadastradas. Cadastre uma IA primeiro.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Criando o painel de criação de publicação
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Campos de entrada
        nomeIAPublicacaoField = new JTextField(20);
        tituloField = new JTextField(20);
        conteudoArea = new JTextArea(5, 20);
        conteudoArea.setLineWrap(true);
        conteudoArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(conteudoArea);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nome da IA:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nomeIAPublicacaoField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Título:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(tituloField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Conteúdo:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(scrollPane, gbc);
        
        // Botões
        JButton confirmarBtn = new JButton("Publicar");
        JButton cancelarBtn = new JButton("Cancelar");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmarBtn);
        buttonPanel.add(cancelarBtn);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);
        
        // Exibindo o diálogo
        JDialog dialog = new JDialog(frame, "Criar Publicação", true);
        
        // Ações dos botões
        confirmarBtn.addActionListener(e -> {
            String nomeIA = nomeIAPublicacaoField.getText().trim().toLowerCase();
            String titulo = tituloField.getText().trim();
            String conteudo = conteudoArea.getText().trim();
            
            if (nomeIA.isEmpty() || titulo.isEmpty() || conteudo.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Por favor, preencha todos os campos.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Verificar se a IA existe
            if (!sistema.iaExiste(nomeIA)) {
                JOptionPane.showMessageDialog(dialog, "IA não encontrada. Verifique o nome.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Publicacao novaPublicacao = sistema.cadastrar_publicacao_por_nome(nomeIA, titulo, conteudo);
            if (novaPublicacao != null) {
                appendOutput("Publicação criada com sucesso! ID: " + novaPublicacao.getId());
            } else {
                appendOutput("Erro ao criar publicação.");
            }
            dialog.dispose();
        });
        
        cancelarBtn.addActionListener(e -> {
            dialog.dispose();
        });
        
        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
    
    private static void listarPublicacoes() {
        appendOutput("\n=== LISTA DE PUBLICAÇÕES ===");
        ArrayList<String> publicacoes = sistema.consultar_publicacao_formatada();
        if (publicacoes.isEmpty()) {
            appendOutput("Nenhuma publicação cadastrada.");
        } else {
            for (String pub : publicacoes) {
                // Remove o prefixo "Título: " da string
                String pubFormatada = pub.replace("Título: ", "");
                appendOutput(pubFormatada);
            }
        }
    }
    
    private static void showLerPublicacaoPanel() {
        // Verificando se existem publicações cadastradas
        ArrayList<String> publicacoes = sistema.consultar_publicacao_formatada();
        if (publicacoes.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nenhuma publicação cadastrada.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Criando o painel de leitura de publicação
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Campos de entrada
        idPublicacaoField = new JTextField(20);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID da Publicação:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(idPublicacaoField, gbc);
        
        // Botões
        JButton confirmarBtn = new JButton("Ler");
        JButton cancelarBtn = new JButton("Cancelar");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmarBtn);
        buttonPanel.add(cancelarBtn);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);
        
        // Exibindo o diálogo
        JDialog dialog = new JDialog(frame, "Ler Publicação", true);
        
        // Ações dos botões
        confirmarBtn.addActionListener(e -> {
            try {
                int idPublicacao = Integer.parseInt(idPublicacaoField.getText().trim());
                String conteudo = sistema.ler_conteudo_publicacao(idPublicacao);
                if (conteudo != null) {
                    appendOutput("\n=== CONTEÚDO DA PUBLICAÇÃO ===");
                    // Encontrar o título da publicação
                    for (String pub : publicacoes) {
                        if (pub.startsWith("ID: " + idPublicacao)) {
                            String[] partes = pub.split(" - ");
                            if (partes.length >= 2) {
                                String titulo = partes[1].replace("Título: ", "");
                                appendOutput("Título: " + titulo);
                                break;
                            }
                        }
                    }
                    appendOutput("Conteúdo: " + conteudo);
                } else {
                    appendOutput("Publicação não encontrada.");
                }
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, insira um ID válido.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        cancelarBtn.addActionListener(e -> {
            dialog.dispose();
        });
        
        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
    
    private static void showCurtirPublicacaoPanel() {
        // Verificando se existem publicações cadastradas
        ArrayList<String> publicacoes = sistema.consultar_publicacao_formatada();
        if (publicacoes.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nenhuma publicação cadastrada.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Criando o painel de curtir publicação
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Campos de entrada
        idPublicacaoField = new JTextField(20);
        
        // Lista de publicações disponíveis
        StringBuilder publicacoesDisponiveis = new StringBuilder("Publicações disponíveis:\n");
        for (String pub : publicacoes) {
            publicacoesDisponiveis.append(pub).append("\n");
        }
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Publicações disponíveis:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JLabel(publicacoesDisponiveis.toString()), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("ID da Publicação:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(idPublicacaoField, gbc);
        
        // Botões
        JButton confirmarBtn = new JButton("Curtir");
        JButton cancelarBtn = new JButton("Cancelar");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmarBtn);
        buttonPanel.add(cancelarBtn);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);
        
        // Exibindo o diálogo
        JDialog dialog = new JDialog(frame, "Curtir Publicação", true);
        
        // Ações dos botões
        confirmarBtn.addActionListener(e -> {
            try {
                int idPublicacao = Integer.parseInt(idPublicacaoField.getText().trim());
                sistema.curtir_publicacao(idPublicacao);
                appendOutput("Publicação curtida com sucesso!");
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, insira um ID válido.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        cancelarBtn.addActionListener(e -> {
            dialog.dispose();
        });
        
        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
    
    private static void appendOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
} 