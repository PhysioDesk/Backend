package physiodesk.physiodesk_backend.Records.interfaces.rest.transform;

import physiodesk.physiodesk_backend.Records.domain.model.commands.CreateRecordCommand;
import physiodesk.physiodesk_backend.Records.interfaces.rest.resources.CreateRecordResource;

public class CreateRecordCommandFromResourceAssembler {

    public static CreateRecordCommand fromResource(CreateRecordResource resource) {
        return new CreateRecordCommand(resource.id(), resource.date(), resource.name(), resource.duration(), resource.access());
    }

}
