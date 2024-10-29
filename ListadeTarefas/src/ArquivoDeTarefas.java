import java.io.*;
import java.util.List;

public class ArquivoDeTarefas {
    private static final String FILE_PATH = "tarefas.dat";

    public static void salvarTarefas(List<Tarefa> tarefas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(tarefas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    public static List<Tarefa> carregarTarefas() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Tarefa>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhuma tarefa encontrada ou erro ao carregar.");
            return null;
        }
    }
}
