package physiodesk.physiodesk_backend.iam.interfaces.rest.transform;


import physiodesk.physiodesk_backend.iam.domain.model.commands.SignUpCommand;
import physiodesk.physiodesk_backend.iam.domain.model.entities.Role;
import physiodesk.physiodesk_backend.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(String.valueOf(name))).toList() : new ArrayList<Role>();
        return new SignUpCommand(roles, resource.name(), resource.lastname(),
                resource.phone(), resource.email(), resource.address(), resource.city());
    }
}
