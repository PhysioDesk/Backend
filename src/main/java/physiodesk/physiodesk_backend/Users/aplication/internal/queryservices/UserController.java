package physiodesk.physiodesk_backend.Users.aplication.internal.queryservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import physiodesk.physiodesk_backend.Security.JwtTokenProvider;
import physiodesk.physiodesk_backend.Users.domain.AuthResponse;
import physiodesk.physiodesk_backend.Users.domain.model.aggregates.user;
import physiodesk.physiodesk_backend.Users.domain.model.queries.GetAllUsersQuery;
import physiodesk.physiodesk_backend.Users.domain.model.queries.GetUserById;
import physiodesk.physiodesk_backend.Users.domain.services.userCommandService;
import physiodesk.physiodesk_backend.Users.domain.services.userQueryService;
import physiodesk.physiodesk_backend.Users.interfaces.rest.resources.CreateUserResource;
import physiodesk.physiodesk_backend.Users.interfaces.rest.resources.userResource;
import physiodesk.physiodesk_backend.Users.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import physiodesk.physiodesk_backend.Users.interfaces.rest.transform.userResourceFromEntityAssembler;
import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpStatus.CREATED;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final userQueryService userQueryService;
    private final userCommandService userCommandService;
    private final JwtTokenProvider jwtsTokenProvider;

    public UserController(userCommandService userCommandService, userQueryService userQueryService,JwtTokenProvider jwtsTokenProvider) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
        this.jwtsTokenProvider = jwtsTokenProvider;
    }

    @PostMapping
    public ResponseEntity<AuthResponse> createUser(@RequestBody CreateUserResource resource) {
        Optional<user> userOptional = userCommandService.handle(CreateUserCommandFromResourceAssembler.fromResource(resource));
        if (userOptional.isPresent()) {
            user newUser = userOptional.get();
            String token = jwtsTokenProvider.generateToken(newUser.getName()); // Generar el token JWT
            AuthResponse authResponse = new AuthResponse(token, newUser); // Crear un objeto de respuesta que incluya el token y los datos del usuario
            return ResponseEntity.status(HttpStatus.CREATED).body(authResponse);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    /*@PostMapping
    public ResponseEntity<userResource> createUser(@RequestBody CreateUserResource resource) {
        Optional<user> user = userCommandService.handle(CreateUserCommandFromResourceAssembler.fromResource(resource));
        return user.map(source -> new ResponseEntity<>(userResourceFromEntityAssembler.fromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<userResource> getUserById(@PathVariable Long id) {
        Optional<user> user = userQueryService.handle(new GetUserById(id));
        return user.map(source -> ResponseEntity.ok(userResourceFromEntityAssembler.fromEntity(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<userResource>> getAllUsers() {
        var users = userQueryService.handle(new GetAllUsersQuery());
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var userResources = users.stream()
                .map(userResourceFromEntityAssembler::fromEntity)
                .toList();
        return ResponseEntity.ok(userResources);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        boolean deleted = userCommandService.deleteUserById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
