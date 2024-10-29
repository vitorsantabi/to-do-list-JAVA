import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void removerTarefa(String titulo) {
        tarefas.removeIf(tarefa -> tarefa.getTitulo().equalsIgnoreCase(titulo));
    }

    public void listarTarefas() {
        tarefas.sort((a, b) -> a.getPrioridade().compareTo(b.getPrioridade()));
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    public void marcarComoConcluida(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa.marcarComoConcluida();
                System.out.println("Tarefa marcada como concluída!");
                return;
            }
        }
        System.out.println("Tarefa não encontrada!");
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}
