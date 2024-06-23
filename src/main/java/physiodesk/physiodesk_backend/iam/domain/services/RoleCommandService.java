package physiodesk.physiodesk_backend.iam.domain.services;

import physiodesk.physiodesk_backend.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
