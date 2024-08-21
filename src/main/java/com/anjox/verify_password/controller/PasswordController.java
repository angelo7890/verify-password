package com.anjox.verify_password.controller;
import com.anjox.verify_password.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }
    @PostMapping("/password")
    public ResponseEntity<Fail> password(@RequestBody PasswordRequest passwordRequest) {

        var pass = passwordService.passwordCheck(passwordRequest.password());

        if (pass.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body(new Fail(pass));
    }
}
