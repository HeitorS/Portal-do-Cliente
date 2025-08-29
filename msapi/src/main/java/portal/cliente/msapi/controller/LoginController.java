package portal.cliente.msapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portal.cliente.msapi.dto.LoginDTO;
import portal.cliente.msapi.dto.TokenDTO;
import portal.cliente.msapi.service.LoginService;
import portal.cliente.msapi.util.ApiResponse;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid() LoginDTO login) {
        try {
        var token = this.loginService.login(login.username(), login.password());
            return ApiResponse._200(token);
        } catch (Exception e) {
            return ApiResponse._401();

        }
    }
}
