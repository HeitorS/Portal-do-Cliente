package portal.cliente.msapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        // Implement your login logic here
        return ResponseEntity.ok("Login successful");
    }
}
