package physiodesk.physiodesk_backend.iam.interfaces.rest.resources;

import java.util.List;

public record UserResource(Long id, List<String> roles, String name, String lastname,
                           Long phone, String email, String address, String city) {
}
