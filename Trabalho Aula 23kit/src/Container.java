import java.util.Objects; // Importa Objects para auxiliar no equals/hashCode 26007770-2

// Classe POJO que representa uma aplicação (container) rodando em um servidor 26007770-2
public class Container {

    // Identificador único do container: é a identidade lógica dele 26007770-2
    private String id;
    // Quantidade de RAM (em GB) que o container precisa para rodar 26007770-2
    private double ramNecessaria;

    // Construtor que inicializa o id e a RAM necessária 26007770-2
    public Container(String id, double ramNecessaria) {
        this.id = id; // Guarda o id 26007770-2
        this.ramNecessaria = ramNecessaria; // Guarda a RAM necessária 26007770-2
    }

    // Getter do id 26007770-2
    public String getId() {
        return id; // Devolve o id 26007770-2
    }

    // Setter do id 26007770-2
    public void setId(String id) {
        this.id = id; // Atualiza o id 26007770-2
    }

    // Getter da RAM necessária 26007770-2
    public double getRamNecessaria() {
        return ramNecessaria; // Devolve a RAM necessária 26007770-2
    }

    // Setter da RAM necessária 26007770-2
    public void setRamNecessaria(double ramNecessaria) {
        this.ramNecessaria = ramNecessaria; // Atualiza a RAM necessária 26007770-2
    }

    // Dois containers são iguais se tiverem o mesmo ID (RN01) 26007770-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Mesma referência: iguais 26007770-2
        if (o == null || getClass() != o.getClass()) return false; // Nulo ou classe diferente: não são iguais 26007770-2
        Container outro = (Container) o; // Converte para Container 26007770-2
        return Objects.equals(id, outro.id); // Compara apenas o ID 26007770-2
    }

    // hashCode coerente com o equals: usa somente o ID 26007770-2
    @Override
    public int hashCode() {
        return Objects.hash(id); // Gera o hash a partir do ID 26007770-2
    }

    // toString para exibição 26007770-2
    @Override
    public String toString() {
        return "Container{id='" + id + "', ramNecessaria=" + ramNecessaria + "}"; // Texto de exibição 26007770-2
    }
}
