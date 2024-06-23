package physiodesk.physiodesk_backend.iam.interfaces.rest.transform;

import physiodesk.physiodesk_backend.iam.domain.model.aggregates.User;
import physiodesk.physiodesk_backend.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
