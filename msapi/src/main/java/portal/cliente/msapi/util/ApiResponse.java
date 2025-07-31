package portal.cliente.msapi.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private int code;
    private String message;
    private T dados;


    public static <T> ResponseEntity<T> _200(T t) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(t, responseHeaders, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> _201(T t) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(t, responseHeaders, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<T> _500(T t, String msg) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(t, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
