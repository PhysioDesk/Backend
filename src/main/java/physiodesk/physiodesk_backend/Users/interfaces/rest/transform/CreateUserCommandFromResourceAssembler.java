package physiodesk.physiodesk_backend.Users.interfaces.rest.transform;

import physiodesk.physiodesk_backend.Users.domain.model.commands.CreateUserCommand;
import physiodesk.physiodesk_backend.Users.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand fromResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.id(), resource.name(), resource.lastname(), resource.phone(), resource.email(), resource.address(), resource.city());
    }
}
