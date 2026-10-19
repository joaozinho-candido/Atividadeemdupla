// Classe executável que roda o roteiro de testes do enunciado 26007770-2
public class MainCloud {

    public static void main(String[] args) {

        // Passo 1: instancia o CloudManager (banco de dados principal) 26007770-2
        CloudManager manager = new CloudManager();

        // Passo 2: instancia um cliente com CPF e nome 26007770-2
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // Passo 3: instancia um servidor com IP, RAM total de 16 GB e preço de R$ 5,50 por hora 26007770-2
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // Passo 4: registra o cliente no manager e associa o servidor a ele 26007770-2
        manager.registrarCliente(cliente);
        manager.adicionarServidor(cliente, servidor);

        // Passo 5: instancia dois containers diferentes 26007770-2
        Container c1 = new Container("C-01", 10.0);
        Container c2 = new Container("C-02", 8.0);

        // Passo 6: teste da falha Unchecked; o servidor nasce desligado, então estoura ServidorOfflineException. 26007770-2
        // Esta linha está comentada para o programa poder prosseguir (descomente para ver o erro vermelho) 26007770-2
        // servidor.alocarContainer(c1); 26007770-2

        // Passo 7: liga o servidor para permitir alocações 26007770-2
        servidor.ligar();

        // Passo 8: aloca o Container 1 com sucesso (10 GB de 16 GB); try-catch obrigatório pois a exceção é Checked 26007770-2
        try {
            servidor.alocarContainer(c1); // Tenta alocar o C-01 26007770-2
            System.out.println("Container " + c1.getId() + " alocado com sucesso."); // Confirma no console 26007770-2
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage()); // Não deve ocorrer aqui, mas o compilador exige o tratamento 26007770-2
        }

        // Passo 9: teste da falha Checked; 10 + 8 = 18 GB passa dos 16 GB, então cai no catch 26007770-2
        try {
            servidor.alocarContainer(c2); // Tenta alocar o C-02, que deve falhar 26007770-2
            System.out.println("Container " + c2.getId() + " alocado com sucesso."); // Não deve ser impresso 26007770-2
        } catch (CapacidadeExcedidaException e) {
            System.out.println("Erro tratado: " + e.getMessage()); // Imprime o erro de forma elegante sem derrubar o programa 26007770-2
        }

        // Passo 10: imprime a fatura ativa do cliente (servidor ligado, então deve ser 5.50) 26007770-2
        System.out.println("Fatura ativa de " + cliente.getNome() + ": R$ " + manager.calcularFaturaAtiva(cliente));
    }
}
