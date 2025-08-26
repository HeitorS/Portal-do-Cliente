package portal.cliente.msapi.exception;

public class UsuarioDeniedException extends Exception {
    public UsuarioDeniedException() {
        super("Seu usuário não tem permissão para acessar este recurso");
    }
}
