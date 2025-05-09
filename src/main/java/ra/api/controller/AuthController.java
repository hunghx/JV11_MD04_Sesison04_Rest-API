package ra.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.api.model.dto.request.FormLogin;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/sign-in")
    public ResponseEntity<?> handleLogin(@RequestBody FormLogin formLogin){
        Authentication auth;
        try{
            auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(formLogin.getUsername(), formLogin.getPassword()));
        }catch (AuthenticationException e){
            return new ResponseEntity<>("thoog tin tk ko đúng", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(auth.getPrincipal(), HttpStatus.OK);
    }
}
