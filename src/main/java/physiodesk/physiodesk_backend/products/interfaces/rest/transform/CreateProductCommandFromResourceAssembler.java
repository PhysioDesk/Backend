package physiodesk.physiodesk_backend.Products.interfaces.rest.transform;

import physiodesk.physiodesk_backend.Products.domain.model.commands.CreateProductCommand;
import physiodesk.physiodesk_backend.Products.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand fromResource(CreateProductResource resource) {
        return new CreateProductCommand(resource.id(), resource.name(), resource.description(), resource.price(), resource.imageUrl());
    }
}
