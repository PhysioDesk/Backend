package physiodesk.physiodesk_backend.Records.infraestructure.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long>{
    @Query("SELECT r FROM Record r WHERE r.id = :id")
    Optional<Record> getRecordById(@Param("id") Long id);
    @Query("SELECT r FROM Record r")
    List<Record> getAllRecords();
}
