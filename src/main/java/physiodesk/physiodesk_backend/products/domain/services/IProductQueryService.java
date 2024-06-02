package physiodesk.physiodesk_backend.products.domain.services;

import physiodesk.physiodesk_backend.products.domain.model.aggregates.Product;
import physiodesk.physiodesk_backend.products.domain.model.queries.GetAllQuery;
import physiodesk.physiodesk_backend.products.domain.model.queries.GetProductById;

import java.util.List;
import java.util.Optional;

public interface IProductQueryService {

    List<Product> handle(GetAllQuery query);

    Optional<Product> handle(GetProductById query);
}
