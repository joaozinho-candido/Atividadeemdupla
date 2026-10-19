import java.util.Objects; // Importa a classe utilitária Objects, usada para gerar equals/hashCode de forma segura 26007770-2

// Classe POJO que representa um cliente da NexusCloud 26007770-2
public class Cliente {

    // Atributo privado (encapsulamento): CPF, que é a identidade lógica do cliente 26007770-2
    private String cpf;
    // Atributo privado: nome ou razão social do cliente 26007770-2
    private String nome;

    // Construtor que recebe todos os dados do cliente e os atribui aos atributos 26007770-2
    public Cliente(String cpf, String nome) {
        this.cpf = cpf; // Guarda o CPF informado 26007770-2
        this.nome = nome; // Guarda o nome informado 26007770-2
    }

    // Getter do CPF: permite leitura controlada do atributo privado 26007770-2
    public String getCpf() {
        return cpf; // Devolve o CPF 26007770-2
    }

    // Setter do CPF: permite alterar o CPF de forma controlada 26007770-2
    public void setCpf(String cpf) {
        this.cpf = cpf; // Atualiza o CPF 26007770-2
    }

    // Getter do nome 26007770-2
    public String getNome() {
        return nome; // Devolve o nome 26007770-2
    }

    // Setter do nome 26007770-2
    public void setNome(String nome) {
        this.nome = nome; // Atualiza o nome 26007770-2
    }

    // Sobrescreve equals: dois clientes são iguais se tiverem o mesmo CPF (RN01) 26007770-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Mesmo endereço de memória: obviamente iguais 26007770-2
        if (o == null || getClass() != o.getClass()) return false; // Nulo ou de outra classe: diferentes 26007770-2
        Cliente outro = (Cliente) o; // Converte o Object para Cliente para poder comparar 26007770-2
        return Objects.equals(cpf, outro.cpf); // Compara somente o CPF, a regra de negócio 26007770-2
    }

    // Sobrescreve hashCode: deve usar o mesmo campo do equals (CPF) para o HashMap funcionar 26007770-2
    @Override
    public int hashCode() {
        return Objects.hash(cpf); // Gera o hash a partir do CPF 26007770-2
    }

    // toString para imprimir o cliente de forma legível 26007770-2
    @Override
    public String toString() {
        return "Cliente{cpf='" + cpf + "', nome='" + nome + "'}"; // Monta o texto de exibição 26007770-2
    }
}
