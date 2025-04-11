/**
 *
 * @author aluno
 */
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Criando uma instância do sistema
        PublicacaoIA sistema = new PublicacaoIA();
        Scanner scanner = new Scanner(System.in);
        
        boolean executando = true;
        
        while (executando) {
            System.out.println("\n=== SISTEMA DE REDE SOCIAL DE IAs ===");
            System.out.println("1. Cadastrar nova IA");
            System.out.println("2. Listar IAs cadastradas");
            System.out.println("3. Criar nova publicação");
            System.out.println("4. Listar publicações");
            System.out.println("5. Curtir publicação");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = 0;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }
            
            switch (opcao) {
                case 1:
                    cadastrarIA(sistema, scanner);
                    break;
                case 2:
                    listarIAs(sistema);
                    break;
                case 3:
                    criarPublicacao(sistema, scanner);
                    break;
                case 4:
                    listarPublicacoes(sistema);
                    break;
                case 5:
                    curtirPublicacao(sistema, scanner);
                    break;
                case 6:
                    executando = false;
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha entre 1 e 6.");
            }
        }
        
        scanner.close();
    }
    
    private static void cadastrarIA(PublicacaoIA sistema, Scanner scanner) {
        System.out.println("\n=== CADASTRAR NOVA IA ===");
        System.out.print("Digite o nome da IA: ");
        String nome = scanner.nextLine();
        
        IA novaIA = sistema.cadastrar_ia(nome);
        if (novaIA != null) {
            System.out.println("IA cadastrada com sucesso! ID: " + novaIA.getId());
        } else {
            System.out.println("Erro ao cadastrar IA.");
        }
    }
    
    private static void listarIAs(PublicacaoIA sistema) {
        System.out.println("\n=== LISTA DE IAs CADASTRADAS ===");
        ArrayList<String> ias = sistema.consultar_ia();
        if (ias.isEmpty()) {
            System.out.println("Nenhuma IA cadastrada.");
        } else {
            for (String ia : ias) {
                System.out.println(ia);
            }
        }
    }
    
    private static void criarPublicacao(PublicacaoIA sistema, Scanner scanner) {
        System.out.println("\n=== CRIAR NOVA PUBLICAÇÃO ===");
        
        // Listar IAs disponíveis
        ArrayList<String> ias = sistema.consultar_ia();
        if (ias.isEmpty()) {
            System.out.println("Nenhuma IA cadastrada. Cadastre uma IA primeiro.");
            return;
        }
        
        System.out.println("IAs disponíveis:");
        for (String ia : ias) {
            System.out.println(ia);
        }
        
        System.out.print("Digite o ID da IA que criará a publicação: ");
        int idIA = 0;
        try {
            idIA = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido! Digite um número.");
            return;
        }
        
        System.out.print("Digite o título da publicação: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Digite o conteúdo da publicação: ");
        String conteudo = scanner.nextLine();
        
        Publicacao novaPub = sistema.cadastrar_publicacao(idIA, titulo, conteudo);
        if (novaPub != null) {
            System.out.println("Publicação criada com sucesso! ID: " + novaPub.getId());
        } else {
            System.out.println("Erro ao criar publicação. Verifique se o ID da IA está correto.");
        }
    }
    
    private static void listarPublicacoes(PublicacaoIA sistema) {
        System.out.println("\n=== LISTA DE PUBLICAÇÕES ===");
        ArrayList<String> publicacoes = sistema.consultar_publicacao();
        if (publicacoes.isEmpty()) {
            System.out.println("Nenhuma publicação cadastrada.");
        } else {
            for (String pub : publicacoes) {
                System.out.println(pub);
            }
        }
    }
    
    private static void curtirPublicacao(PublicacaoIA sistema, Scanner scanner) {
        System.out.println("\n=== CURTIR PUBLICAÇÃO ===");
        
        // Listar publicações disponíveis
        ArrayList<String> publicacoes = sistema.consultar_publicacao();
        if (publicacoes.isEmpty()) {
            System.out.println("Nenhuma publicação cadastrada.");
            return;
        }
        
        System.out.println("Publicações disponíveis:");
        for (String pub : publicacoes) {
            System.out.println(pub);
        }
        
        System.out.print("Digite o ID da publicação que deseja curtir: ");
        int idPublicacao = 0;
        try {
            idPublicacao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido! Digite um número.");
            return;
        }
        
        sistema.curtir_publicacao(idPublicacao);
        System.out.println("Publicação curtida com sucesso!");
    }
} 