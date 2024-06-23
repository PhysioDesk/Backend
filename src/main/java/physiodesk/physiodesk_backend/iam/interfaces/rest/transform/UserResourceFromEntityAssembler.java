package physiodesk.physiodesk_backend.iam.interfaces.rest.transform;


import physiodesk.physiodesk_backend.iam.domain.model.aggregates.User;
import physiodesk.physiodesk_backend.iam.domain.model.entities.Role;
import physiodesk.physiodesk_backend.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), roles, user.getName(), user.getLastname(),
                user.getPhone(),user.getEmail(), user.getAddress(), user.getCity());
    }
}
