package physiodesk.physiodesk_backend.Products.domain.services;

import physiodesk.physiodesk_backend.Products.domain.model.aggregates.Product;
import physiodesk.physiodesk_backend.Products.domain.model.commands.CreateProductCommand;

import java.util.Optional;

public interface IProductCommandService {

    Optional<Product> handle(CreateProductCommand command);

}
