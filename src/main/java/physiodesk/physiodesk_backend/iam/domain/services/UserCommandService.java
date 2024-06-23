package physiodesk.physiodesk_backend.iam.domain.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import physiodesk.physiodesk_backend.iam.domain.model.aggregates.User;
import physiodesk.physiodesk_backend.iam.domain.model.commands.SignInCommand;
import physiodesk.physiodesk_backend.iam.domain.model.commands.SignUpCommand;

import java.util.Optional;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<User> handle(SignUpCommand command);
    boolean deleteUserById(Long id);


}
