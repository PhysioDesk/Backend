package physiodesk.physiodesk_backend.iam.interfaces.rest.resources;

import physiodesk.physiodesk_backend.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpResource(List<Role> roles, String name, String lastname,
                             Long phone, String email, String address, String city) {
}
