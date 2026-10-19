import java.util.ArrayList; // Importa a lista redimensionável usada para guardar os containers 26007770-2
import java.util.List; // Importa a interface List (programar para a interface é boa prática) 26007770-2
import java.util.Objects; // Importa Objects para equals/hashCode 26007770-2

// Classe que representa um servidor virtual da NexusCloud 26007770-2
public class Servidor {

    // Endereço IP do servidor: é a identidade lógica dele 26007770-2
    private String ip;
    // Capacidade total de RAM do servidor (em GB) 26007770-2
    private double ramTotal;
    // Preço cobrado por hora de uso do servidor 26007770-2
    private double precoPorHora;
    // Indica se o servidor está ligado; o tipo boolean já nasce false (desligado) 26007770-2
    private boolean statusLigado;
    // Lista cronológica de containers; já inicializada na declaração para evitar NullPointerException (RN02) 26007770-2
    private List<Container> containers = new ArrayList<>();

    // Construtor: recebe IP, RAM total e preço; o servidor nasce desligado 26007770-2
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip; // Guarda o IP 26007770-2
        this.ramTotal = ramTotal; // Guarda a RAM total 26007770-2
        this.precoPorHora = precoPorHora; // Guarda o preço por hora 26007770-2
        this.statusLigado = false; // Define explicitamente que nasce desligado 26007770-2
    }

    // Liga o servidor, permitindo a alocação de containers 26007770-2
    public void ligar() {
        this.statusLigado = true; // Muda o status para ligado 26007770-2
    }

    // Desliga o servidor 26007770-2
    public void desligar() {
        this.statusLigado = false; // Muda o status para desligado 26007770-2
    }

    // Getter do IP 26007770-2
    public String getIp() {
        return ip; // Devolve o IP 26007770-2
    }

    // Setter do IP 26007770-2
    public void setIp(String ip) {
        this.ip = ip; // Atualiza o IP 26007770-2
    }

    // Getter da RAM total 26007770-2
    public double getRamTotal() {
        return ramTotal; // Devolve a RAM total 26007770-2
    }

    // Setter da RAM total 26007770-2
    public void setRamTotal(double ramTotal) {
        this.ramTotal = ramTotal; // Atualiza a RAM total 26007770-2
    }

    // Getter do preço por hora 26007770-2
    public double getPrecoPorHora() {
        return precoPorHora; // Devolve o preço por hora 26007770-2
    }

    // Setter do preço por hora 26007770-2
    public void setPrecoPorHora(double precoPorHora) {
        this.precoPorHora = precoPorHora; // Atualiza o preço por hora 26007770-2
    }

    // Getter do status; por convenção de boolean o nome é "is" 26007770-2
    public boolean isStatusLigado() {
        return statusLigado; // Devolve true se estiver ligado 26007770-2
    }

    // Setter do status 26007770-2
    public void setStatusLigado(boolean statusLigado) {
        this.statusLigado = statusLigado; // Atualiza o status 26007770-2
    }

    // Getter da lista de containers 26007770-2
    public List<Container> getContainers() {
        return containers; // Devolve a lista de containers alocados 26007770-2
    }

    // RN04: soma a RAM de todos os containers usando Streams, sem laços for/while 26007770-2
    public double calcularRamEmUso() {
        return containers.stream() // Transforma a lista em um fluxo (stream) de containers 26007770-2
                .mapToDouble(Container::getRamNecessaria) // Extrai a RAM de cada container como double 26007770-2
                .sum(); // Soma todos os valores e devolve o total 26007770-2
    }

    // RN03: aloca um container aplicando a política Fail-Fast (valida antes de adicionar) 26007770-2
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // Validação 1 (Unchecked): servidor desligado não aceita containers 26007770-2
        if (!statusLigado) {
            // Lança a exceção sem exigir try-catch, pois é Unchecked 26007770-2
            throw new ServidorOfflineException("Erro: Não é possível alocar containers em um servidor desligado.");
        }
        // Calcula a RAM que ficaria em uso se o novo container fosse aceito 26007770-2
        double ramAposAlocacao = calcularRamEmUso() + c.getRamNecessaria();
        // Validação 2 (Checked): se ultrapassar a RAM total, rejeita 26007770-2
        if (ramAposAlocacao > ramTotal) {
            // Lança a exceção Checked com a mensagem pedida, incluindo o IP do servidor 26007770-2
            throw new CapacidadeExcedidaException("Falha Crítica: Memória RAM insuficiente no servidor " + ip + ".");
        }
        // Passou nas duas validações: agora sim adiciona o container à lista 26007770-2
        containers.add(c);
    }

    // Dois servidores são iguais se tiverem o mesmo IP (RN01) 26007770-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Mesma referência: iguais 26007770-2
        if (o == null || getClass() != o.getClass()) return false; // Nulo ou outra classe: diferentes 26007770-2
        Servidor outro = (Servidor) o; // Converte para Servidor 26007770-2
        return Objects.equals(ip, outro.ip); // Compara apenas o IP 26007770-2
    }

    // hashCode coerente com o equals: baseado só no IP 26007770-2
    @Override
    public int hashCode() {
        return Objects.hash(ip); // Gera o hash a partir do IP 26007770-2
    }

    // toString para exibição 26007770-2
    @Override
    public String toString() {
        return "Servidor{ip='" + ip + "', ramTotal=" + ramTotal + ", precoPorHora=" + precoPorHora
                + ", ligado=" + statusLigado + "}"; // Texto de exibição 26007770-2
    }
}
