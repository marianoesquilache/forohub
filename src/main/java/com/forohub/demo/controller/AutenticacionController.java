package com.forohub.demo.controller;

import com.forohub.demo.domain.usuario.DatosAutenticacionUsuario;
import com.forohub.demo.domain.usuario.Usuario;
import com.forohub.demo.infra.security.DatosTokenJWT;
import com.forohub.demo.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        var authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),datosAutenticacionUsuario.clave());
        var authentication = authenticationManager.authenticate(authToken);
        System.out.println("A punto de generar token");
        var tokenJWT = tokenService.generarToken((Usuario) authentication.getPrincipal());
        System.out.println("Generado el token " + tokenJWT);
        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }

}
