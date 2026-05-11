package com.exam.vehiclerental.web;

import com.exam.vehiclerental.dtos.LoginRequest;
import com.exam.vehiclerental.dtos.LoginResponse;
import com.exam.vehiclerental.entities.Utilisateur;
import com.exam.vehiclerental.repositories.UtilisateurRepository;
import com.exam.vehiclerental.security.JwtProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentification", description = "API d'authentification JWT")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtProvider jwtProvider,
                         UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    @Operation(summary = "Se connecter et obtenir un JWT token")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getMotdepasse()));

            String token = jwtProvider.generateToken(authentication);
            Utilisateur utilisateur = utilisateurRepository.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

            LoginResponse response = LoginResponse.builder()
                    .token(token)
                    .username(utilisateur.getUsername())
                    .role(utilisateur.getRole().name())
                    .build();

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    @Operation(summary = "S'enregistrer (créer un nouveau compte utilisateur)")
    public ResponseEntity<Utilisateur> register(@RequestBody LoginRequest registerRequest) {
        if (utilisateurRepository.existsByUsername(registerRequest.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Utilisateur utilisateur = Utilisateur.builder()
                .username(registerRequest.getUsername())
                .motdepasse(passwordEncoder.encode(registerRequest.getMotdepasse()))
                .role(com.exam.vehiclerental.enums.Role.ROLE_CLIENT)
                .enabled(true)
                .build();

        Utilisateur saved = utilisateurRepository.save(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
