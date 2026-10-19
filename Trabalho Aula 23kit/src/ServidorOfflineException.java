// Exceção Unchecked (não verificada): herda de RuntimeException, então o compilador não obriga try-catch 26007770-2
public class ServidorOfflineException extends RuntimeException {

    // Construtor que repassa a mensagem de erro para a classe pai 26007770-2
    public ServidorOfflineException(String mensagem) {
        super(mensagem); // Chama o construtor de RuntimeException com a mensagem 26007770-2
    }
}
