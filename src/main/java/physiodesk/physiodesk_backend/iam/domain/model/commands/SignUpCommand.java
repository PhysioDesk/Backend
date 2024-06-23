package physiodesk.physiodesk_backend.iam.domain.model.commands;

import physiodesk.physiodesk_backend.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(List<Role> roles, String name, String lastname,
                            Long phone, String email, String address, String city) {
}
