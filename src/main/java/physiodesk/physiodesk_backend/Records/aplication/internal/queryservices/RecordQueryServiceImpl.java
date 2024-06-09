package physiodesk.physiodesk_backend.Records.aplication.internal.queryservices;

import org.springframework.stereotype.Service;
import physiodesk.physiodesk_backend.Records.domain.model.aggregates.Records;
import physiodesk.physiodesk_backend.Records.domain.model.queries.GetAllRecordsQuery;
import physiodesk.physiodesk_backend.Records.domain.model.queries.GetRecordByFecha;
import physiodesk.physiodesk_backend.Records.domain.model.queries.GetRecordById;
import physiodesk.physiodesk_backend.Records.domain.services.RecordQueryService;
import physiodesk.physiodesk_backend.Records.infraestructure.persistance.jpa.RecordRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecordQueryServiceImpl implements RecordQueryService {

    public static RecordRepository recordRepository;
    public RecordQueryServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public List<Records> handle(GetAllRecordsQuery query){
        return recordRepository.getAllRecords();
    }

    @Override
    public List<Records> handle(GetRecordByFecha query) {
        return recordRepository.getRecordByFecha(query.fecha());
    }

    @Override
    public Optional<Records> handle(GetRecordById query){
        return recordRepository.getRecordById(query.id());
    }

}
