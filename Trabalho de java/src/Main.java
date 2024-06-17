import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LojaArvores loja = new LojaArvores();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarArvore();
                    break;
                case 2:
                    listarArvores();
                    break;
                case 3:
                    visualizarArvore();
                    break;
                case 4:
                    excluirArvore();
                    break;
                case 5:
                    editarArvore();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }
        } while (opcao != 6);
    }

    private static void exibirMenu() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1. Cadastrar Árvore");
        System.out.println("2. Listar Árvores");
        System.out.println("3. Visualizar Árvore por ID");
        System.out.println("4. Excluir Árvore por ID");
        System.out.println("5. Editar Árvore por ID");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarArvore() {
        System.out.println("\n=== Cadastro de Árvore ===");
        System.out.print("Informe o tipo de árvore (1 - Natalina, 2 - Frutífera): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Informe o nome da árvore: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o preço da árvore: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner

        Arvore novaArvore;
        if (tipo == 1) {
            System.out.print("Informe a altura da árvore de Natal (em cm): ");
            int altura = scanner.nextInt();
            novaArvore = new ArvoreNatalina(gerarNovoId(), nome, preco, altura);
        } else {
            System.out.print("Informe a fruta produzida pela árvore frutífera: ");
            String fruta = scanner.nextLine();
            novaArvore = new ArvoreFrutifera(gerarNovoId(), nome, preco, fruta);
        }

        loja.cadastrarArvore(novaArvore);
        System.out.println("Árvore cadastrada com sucesso!");
    }

    private static void listarArvores() {
        System.out.println("\n=== Lista de Árvores na Loja ===");
        loja.listarArvores();
    }

    private static void visualizarArvore() {
        System.out.println("\n=== Visualizar Árvore por ID ===");
        System.out.print("Informe o ID da árvore: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Arvore arvore = loja.buscarArvorePorId(id);
        if (arvore != null) {
            arvore.exibirInformacoes();
        } else {
            System.out.println("Árvore não encontrada com o ID informado.");
        }
    }

    private static void excluirArvore() {
        System.out.println("\n=== Excluir Árvore por ID ===");
        System.out.print("Informe o ID da árvore que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        loja.excluirArvore(id);
        System.out.println("Árvore excluída com sucesso!");
    }

    private static void editarArvore() {
        System.out.println("\n=== Editar Árvore por ID ===");
        System.out.print("Informe o ID da árvore que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Arvore arvoreExistente = loja.buscarArvorePorId(id);
        if (arvoreExistente == null) {
            System.out.println("Árvore não encontrada com o ID informado.");
            return;
        }

        System.out.println("Árvore encontrada:");
        arvoreExistente.exibirInformacoes();

        System.out.print("Informe o novo nome da árvore: ");
        String novoNome = scanner.nextLine();
        arvoreExistente.setNome(novoNome);

        System.out.print("Informe o novo preço da árvore: ");
        double novoPreco = scanner.nextDouble();
        arvoreExistente.setPreco(novoPreco);

       
        loja.editarArvore(id, arvoreExistente);
        System.out.println("Árvore editada com sucesso!");
    }

    private static int gerarNovoId() {
        
        return (int) (Math.random() * 1000) + 1;
    }
}
