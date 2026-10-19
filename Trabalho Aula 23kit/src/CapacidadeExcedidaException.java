// Exceção Checked (verificada): herda de Exception, então o compilador OBRIGA tratar ou declarar com throws 26007770-2
public class CapacidadeExcedidaException extends Exception {

    // Construtor que repassa a mensagem de erro para a classe pai 26007770-2
    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem); // Chama o construtor de Exception com a mensagem 26007770-2
    }
}
