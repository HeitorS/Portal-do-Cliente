package portal.cliente.msapi.exception;

public class TokenInvalidException extends Exception {
    public TokenInvalidException() {
        super("Seu token é inválido ou expirou.");
    }
}
