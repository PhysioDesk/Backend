package physiodesk.physiodesk_backend.iam.application.internal.commandservices;

import org.springframework.stereotype.Service;
import physiodesk.physiodesk_backend.iam.domain.model.commands.SeedRolesCommand;
import physiodesk.physiodesk_backend.iam.domain.model.entities.Role;
import physiodesk.physiodesk_backend.iam.domain.model.valueobjects.Roles;
import physiodesk.physiodesk_backend.iam.domain.services.RoleCommandService;
import physiodesk.physiodesk_backend.iam.infrastructure.persistence.jpa.repositories.RoleRepository;

import java.util.Arrays;

/**
 * Implementation of {@link RoleCommandService} to handle {@link SeedRolesCommand}
 */
@Service
public class RoleCommandServiceImpl implements RoleCommandService {

    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        } );
    }
}
