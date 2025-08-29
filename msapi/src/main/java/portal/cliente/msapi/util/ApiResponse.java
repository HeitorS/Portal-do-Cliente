package portal.cliente.msapi.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseEntity<T> _200(T t) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(t, responseHeaders, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> _201() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(null, responseHeaders, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<T> _204() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(null, responseHeaders, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<T> _400(T t) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(t, responseHeaders, HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<T> _401() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(null, responseHeaders, HttpStatus.UNAUTHORIZED);
    }

    public static <T> ResponseEntity<T> _403(T t) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(null, responseHeaders, HttpStatus.FORBIDDEN);
    }

    public static <T> ResponseEntity<T> _404(T t) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(null, responseHeaders, HttpStatus.NOT_FOUND);
    }
}
