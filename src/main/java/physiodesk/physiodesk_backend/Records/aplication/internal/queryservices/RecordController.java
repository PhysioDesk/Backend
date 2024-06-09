package physiodesk.physiodesk_backend.Records.aplication.internal.queryservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import physiodesk.physiodesk_backend.Records.domain.model.aggregates.Records;
import physiodesk.physiodesk_backend.Records.domain.model.queries.GetAllRecordsQuery;
import physiodesk.physiodesk_backend.Records.domain.model.queries.GetRecordByFecha;
import physiodesk.physiodesk_backend.Records.domain.model.queries.GetRecordById;
import physiodesk.physiodesk_backend.Records.domain.services.RecordCommandService;
import physiodesk.physiodesk_backend.Records.domain.services.RecordQueryService;
import physiodesk.physiodesk_backend.Records.interfaces.rest.resources.CreateRecordResource;
import physiodesk.physiodesk_backend.Records.interfaces.rest.resources.RecordResource;
import physiodesk.physiodesk_backend.Records.interfaces.rest.transform.CreateRecordCommandFromResourceAssembler;
import physiodesk.physiodesk_backend.Records.interfaces.rest.transform.RecordResourceFromEntityAssembler;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/records")
public class RecordController {

    private final RecordQueryService recordQueryService;
    private final RecordCommandService recordCommandService;

    public RecordController(RecordQueryService recordQueryService, RecordCommandService recordCommandService) {
        this.recordQueryService = recordQueryService;
        this.recordCommandService = recordCommandService;
    }

    @PostMapping
    public ResponseEntity<RecordResource> createRecord(@RequestBody CreateRecordResource resource) {
        Optional<Records> record = recordCommandService.handle(CreateRecordCommandFromResourceAssembler.fromResource(resource));
        return record.map(source -> new ResponseEntity<>(RecordResourceFromEntityAssembler.fromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordResource> getRecordById(@PathVariable Long id) {
        Optional<Records> record = recordQueryService.handle(new GetRecordById(id));
        return record.map(source -> new ResponseEntity<>(RecordResourceFromEntityAssembler.fromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{fecha}")
    public ResponseEntity<RecordResource> getRecordByFecha(@PathVariable String fecha) {
        Optional<Records> record = recordQueryService.handle(new GetRecordByFecha(fecha));
        return record.map(source -> new ResponseEntity<>(RecordResourceFromEntityAssembler.fromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<RecordResource>> getAllRecords() {
            var records = recordQueryService.handle(new GetAllRecordsQuery());
            if (records.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            var recordResources = records.stream()
                    .map(RecordResourceFromEntityAssembler::fromEntity)
                    .toList();
            return ResponseEntity.ok(recordResources);
    }

}
