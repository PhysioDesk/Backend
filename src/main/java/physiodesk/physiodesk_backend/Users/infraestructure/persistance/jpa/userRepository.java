package physiodesk.physiodesk_backend.Users.infraestructure.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import physiodesk.physiodesk_backend.Users.domain.model.aggregates.user;

import java.util.List;
import java.util.Optional;

public interface userRepository extends JpaRepository<user, Long> {
    @Query("SELECT u FROM user u WHERE u.id = :id")
    Optional<user> GetUserById(@Param("id") Long id);
    @Query("SELECT u FROM user u")
    List<user> GetAllUsers();
}
