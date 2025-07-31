package portal.cliente.msapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import portal.cliente.msapi.dto.TokenDTO;

import portal.cliente.msapi.service.LoginService;
import portal.cliente.msapi.util.ApiResponse;
import portal.cliente.msapi.dto.LoginDTO;

import java.sql.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200/*")
@RequestMapping("v1/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO login){
        try {
            TokenDTO token = loginService.login(login.email(), login.senha());
            return ApiResponse._200(token);
        } catch (Exception e) {
            return ApiResponse._500(login, e.getMessage());
        }
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkToken() {

        return ResponseEntity.ok("Token válido para o usuário: ");
    }
}
