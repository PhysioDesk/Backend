package physiodesk.physiodesk_backend.Records.domain.services;

import physiodesk.physiodesk_backend.Records.domain.model.aggregates.Records;
import physiodesk.physiodesk_backend.Records.domain.model.commands.CreateRecordCommand;

import java.util.Optional;

public interface RecordCommandService {

    Optional<Records> handle(CreateRecordCommand command);
    boolean deleteRecordById(Long id);

}
