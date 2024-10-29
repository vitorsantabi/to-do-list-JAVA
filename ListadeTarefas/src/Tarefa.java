import java.io.Serializable;

public class Tarefa implements Serializable {
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private boolean concluida;

    public enum Prioridade { ALTA, MEDIA, BAIXA }

    public Tarefa(String titulo, String descricao, Prioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = false;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Prioridade getPrioridade() { return prioridade; }
    public boolean isConcluida() { return concluida; }

    @Override
    public String toString() {
        return String.format("Tarefa: %s [%s] - %s - %s",
                titulo, prioridade, concluida ? "Concluída" : "Pendente", descricao);
    }
}
