import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();

        List<Tarefa> tarefasSalvas = ArquivoDeTarefas.carregarTarefas();
        if (tarefasSalvas != null) {
            for (Tarefa tarefa : tarefasSalvas) {
                gerenciador.adicionarTarefa(tarefa);
            }
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Remover Tarefa");
            System.out.println("3. Listar Tarefas");
            System.out.println("4. Marcar Tarefa como Concluída");
            System.out.println("5. Salvar e Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Prioridade (ALTA, MEDIA, BAIXA): ");
                    Tarefa.Prioridade prioridade = Tarefa.Prioridade.valueOf(scanner.nextLine().toUpperCase());
                    Tarefa novaTarefa = new Tarefa(titulo, descricao, prioridade);
                    gerenciador.adicionarTarefa(novaTarefa);
                    System.out.println("Tarefa adicionada!");
                    break;
                case 2:
                    System.out.print("Título da tarefa a remover: ");
                    String tituloRemover = scanner.nextLine();
                    gerenciador.removerTarefa(tituloRemover);
                    System.out.println("Tarefa removida!");
                    break;
                case 3:
                    System.out.println("Lista de Tarefas:");
                    gerenciador.listarTarefas();
                    break;
                case 4:
                    System.out.print("Título da tarefa a marcar como concluída: ");
                    String tituloConcluir = scanner.nextLine();
                    gerenciador.marcarComoConcluida(tituloConcluir);
                    break;
                case 5:
                    ArquivoDeTarefas.salvarTarefas(gerenciador.getTarefas());
                    System.out.println("Tarefas salvas! Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
