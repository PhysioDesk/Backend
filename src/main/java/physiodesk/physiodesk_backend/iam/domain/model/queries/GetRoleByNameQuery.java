package physiodesk.physiodesk_backend.iam.domain.model.queries;

import physiodesk.physiodesk_backend.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
