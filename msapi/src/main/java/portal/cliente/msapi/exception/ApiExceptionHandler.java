package portal.cliente.msapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(TokenInvalidException.class)
    public ResponseEntity<?> handleTokenInvalidException(TokenInvalidException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", HttpStatus.UNAUTHORIZED.value(),
                        "title", "Sem autorização",
                        "message", ex.getMessage(),
                        "path", request.getDescription(false)
                )
        );
    }

    @ExceptionHandler(UsuarioDeniedException.class)
    public ResponseEntity<?> handleUsuarioDeniedException(UsuarioDeniedException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", HttpStatus.FORBIDDEN.value(),
                        "title", "Acesso negado",
                        "message", ex.getMessage(),
                        "path", request.getDescription(false)
                )
        );
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<?> handleUsuarioNotFoundException(UsuarioNotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", HttpStatus.NOT_FOUND.value(),
                        "title", "Não encontrado",
                        "message", ex.getMessage(),
                        "path", request.getDescription(false)
                )
        );
    }
}
