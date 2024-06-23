package physiodesk.physiodesk_backend.iam.domain.services;

import physiodesk.physiodesk_backend.iam.domain.model.entities.Role;
import physiodesk.physiodesk_backend.iam.domain.model.queries.GetAllRolesQuery;
import physiodesk.physiodesk_backend.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}
