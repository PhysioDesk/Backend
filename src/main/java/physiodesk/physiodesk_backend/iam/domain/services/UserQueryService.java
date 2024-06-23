package physiodesk.physiodesk_backend.iam.domain.services;

import physiodesk.physiodesk_backend.iam.domain.model.aggregates.User;
import physiodesk.physiodesk_backend.iam.domain.model.queries.GetAllUsersQuery;
import physiodesk.physiodesk_backend.iam.domain.model.queries.GetUserByIdQuery;
import physiodesk.physiodesk_backend.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);

}
