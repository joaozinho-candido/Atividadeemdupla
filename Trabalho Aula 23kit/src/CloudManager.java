import java.util.HashMap; // Implementação de Map baseada em Hash (alta performance) 26007770-2
import java.util.HashSet; // Implementação de Set baseada em Hash (sem duplicação e sem ordem) 26007770-2
import java.util.Map; // Interface Map (chave -> valor) 26007770-2
import java.util.Set; // Interface Set (conjunto sem repetição) 26007770-2

// Classe que funciona como o banco de dados principal da NexusCloud 26007770-2
public class CloudManager {

    // Mapa: chave = Cliente, valor = conjunto de Servidores do cliente; instanciado na declaração (RN02) 26007770-2
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // Registra um cliente no banco, criando para ele um conjunto vazio de servidores 26007770-2
    public void registrarCliente(Cliente c) {
        bancoDeDados.putIfAbsent(c, new HashSet<>()); // Só insere se o cliente (mesmo CPF) ainda não existir 26007770-2
    }

    // Associa um servidor a um cliente já registrado 26007770-2
    public void adicionarServidor(Cliente c, Servidor s) {
        registrarCliente(c); // Garante que o cliente exista, evitando NullPointerException 26007770-2
        bancoDeDados.get(c).add(s); // Adiciona o servidor ao conjunto (o Set ignora IPs duplicados) 26007770-2
    }

    // RN04: soma o preço por hora apenas dos servidores LIGADOS do cliente, usando Streams 26007770-2
    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados.getOrDefault(c, new HashSet<>()) // Pega os servidores do cliente (ou conjunto vazio se não existir) 26007770-2
                .stream() // Transforma o conjunto em um stream 26007770-2
                .filter(Servidor::isStatusLigado) // Deixa passar APENAS os servidores ligados 26007770-2
                .mapToDouble(Servidor::getPrecoPorHora) // Extrai o preço por hora de cada um 26007770-2
                .sum(); // Soma tudo e devolve a fatura 26007770-2
    }

    // Getter do banco de dados 26007770-2
    public Map<Cliente, Set<Servidor>> getBancoDeDados() {
        return bancoDeDados; // Devolve o mapa 26007770-2
    }
}
