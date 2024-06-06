package physiodesk.physiodesk_backend.Users.aplication.internal.queryservices;

import org.springframework.stereotype.Service;
import physiodesk.physiodesk_backend.Users.domain.model.aggregates.user;
import physiodesk.physiodesk_backend.Users.domain.model.queries.GetAllUsersQuery;
import physiodesk.physiodesk_backend.Users.domain.model.queries.GetUserById;
import physiodesk.physiodesk_backend.Users.domain.services.userQueryService;
import physiodesk.physiodesk_backend.Users.infraestructure.persistance.jpa.userRepository;
import java.util.List;
import java.util.Optional;

@Service
public class userQueryServiceImpl implements userQueryService {

    public static userRepository userRepository;
    public userQueryServiceImpl(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<user> handle(GetAllUsersQuery query){
        return userRepository.findAll();
    }

    @Override
    public Optional<user> handle(GetUserById query){
        return userRepository.findById(query.id());
}
    }
