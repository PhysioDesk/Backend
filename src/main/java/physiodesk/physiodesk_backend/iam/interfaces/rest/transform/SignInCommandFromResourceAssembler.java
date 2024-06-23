package physiodesk.physiodesk_backend.iam.interfaces.rest.transform;

import physiodesk.physiodesk_backend.iam.domain.model.commands.SignInCommand;
import physiodesk.physiodesk_backend.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(),
                signInResource.password());
    }
}
