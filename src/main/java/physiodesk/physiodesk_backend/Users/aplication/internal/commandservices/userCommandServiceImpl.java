package physiodesk.physiodesk_backend.Users.aplication.internal.commandservices;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import physiodesk.physiodesk_backend.Users.domain.model.aggregates.user;
import physiodesk.physiodesk_backend.Users.domain.model.commands.CreateUserCommand;
import physiodesk.physiodesk_backend.Users.domain.services.userCommandService;
import physiodesk.physiodesk_backend.Users.infraestructure.persistance.jpa.userRepository;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

@Service
public class userCommandServiceImpl implements userCommandService {
    private final userRepository UserRepository;
    private final Key jwtSecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long jwtExpirationMs = 86400000; // 24 horas

    public userCommandServiceImpl(userRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public Optional<user> handle(CreateUserCommand command) {
        if (UserRepository.existsById(command.id())) {
            throw new IllegalArgumentException("user already exists");
        }
        var user = new user(command);
        var createduser = UserRepository.save(user);

        String jwtToken = generateJwtToken(user);
        return Optional.of(createduser);
    }

    private String generateJwtToken(user user) {
        Date expirationDate = new Date(System.currentTimeMillis() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(Long.toString(user.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(jwtSecretKey)
                .compact();
    }

    @Override
    public boolean deleteUserById(Long id) {
        if (!UserRepository.existsById(id)) {
            return false; // El usuario con el ID dado no existe, por lo que no se puede eliminar
        }
        UserRepository.deleteById(id);
        return true; // Eliminación exitosa
    }
}
