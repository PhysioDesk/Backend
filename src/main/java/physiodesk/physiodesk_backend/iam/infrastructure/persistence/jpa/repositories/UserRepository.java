package physiodesk.physiodesk_backend.iam.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import physiodesk.physiodesk_backend.Users.domain.model.aggregates.user;
import physiodesk.physiodesk_backend.iam.domain.model.aggregates.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    @Query("SELECT u FROM user u WHERE u.id = :id")
    Optional<user> GetUserById(@Param("id") Long id);
    @Query("SELECT u FROM user u")
    List<user> GetAllUsers();

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

}
