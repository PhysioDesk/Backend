package physiodesk.physiodesk_backend.Records.domain.services;

import physiodesk.physiodesk_backend.Records.domain.model.aggregates.Records;
import physiodesk.physiodesk_backend.Records.domain.model.queries.GetAllRecordsQuery;
import physiodesk.physiodesk_backend.Records.domain.model.queries.GetRecordByFecha;
import physiodesk.physiodesk_backend.Records.domain.model.queries.GetRecordById;

import java.util.List;
import java.util.Optional;

public interface RecordQueryService {

    List<Records> handle(GetAllRecordsQuery query);
    Optional<Records> handle(GetRecordByFecha query);
    Optional<Records> handle(GetRecordById query);
}
