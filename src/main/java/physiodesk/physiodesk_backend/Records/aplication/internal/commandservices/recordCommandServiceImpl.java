package physiodesk.physiodesk_backend.Records.aplication.internal.commandservices;

import org.springframework.stereotype.Service;
import physiodesk.physiodesk_backend.Records.domain.model.commands.CreateRecordCommand;
import physiodesk.physiodesk_backend.Records.domain.services.RecordCommandService;
import physiodesk.physiodesk_backend.Records.infraestructure.persistance.jpa.RecordRepository;

import java.util.Optional;

@Service
public class recordCommandServiceImpl implements RecordCommandService {

    private final RecordRepository recordRepository;

    public recordCommandServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public Optional<Record> handle(CreateRecordCommand command) {
        if (recordRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Record already exists");
        }
        var record = new Record(command);
        var createdRecord = recordRepository.save(record);
        return Optional.of(createdRecord);
    }

}
