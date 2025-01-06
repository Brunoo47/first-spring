package com.my_first_projecto.demo.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(
            User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String Token = JWT.create()
                    .withIssuer("login-auth-api") // quem emite o token - API
                    .withSubject(user.getEmail()) // quem ta sendo o sujeito que recebe o token
                    .withExpiresAt(this.GenerateExpirationTime()) // tempo de expiração
                    .sign(algorithm); // gerar o token
            return Token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("error generating token");
        }
    }
    public String ValidateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String Token = JWT.create()
                    .withIssuer("login-auth-api") // quem emite o token - API
                    //.withSubject() // quem ta sendo o sujeito que recebe o token
                    .withExpiresAt(this.GenerateExpirationTime()) // tempo de expiração
                    .sign(algorithm); // gerar o token
            return JWT.require(algorithm)
                    .withIssuer("login-auth-api")
                    .build()
                    .verify(Token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return null;
        }
    }
    private Date GenerateExpirationTime() {
        return Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneOffset.UTC).toInstant());
    }
}
