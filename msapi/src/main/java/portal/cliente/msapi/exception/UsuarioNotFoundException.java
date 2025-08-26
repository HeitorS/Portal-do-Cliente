package portal.cliente.msapi.exception;

public class UsuarioNotFoundException extends Exception {
    public UsuarioNotFoundException() {
        super("Não foi possível encontrar um usuário com os dados fornecidos.");
    }
}
