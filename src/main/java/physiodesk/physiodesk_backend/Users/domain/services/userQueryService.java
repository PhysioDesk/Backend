package physiodesk.physiodesk_backend.Users.domain.services;

import physiodesk.physiodesk_backend.Users.domain.model.aggregates.user;
import physiodesk.physiodesk_backend.Users.domain.model.queries.GetAllUsersQuery;
import physiodesk.physiodesk_backend.Users.domain.model.queries.GetUserById;

import java.util.List;
import java.util.Optional;

public interface userQueryService {

    List<user> handle(GetAllUsersQuery query);
    Optional<user> handle(GetUserById query);
}
