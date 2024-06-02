package physiodesk.physiodesk_backend.products.application.internal.queryservices;

import org.springframework.stereotype.Service;
import physiodesk.physiodesk_backend.products.domain.model.aggregates.Product;
import physiodesk.physiodesk_backend.products.domain.model.queries.GetAllQuery;
import physiodesk.physiodesk_backend.products.domain.model.queries.GetProductById;
import physiodesk.physiodesk_backend.products.domain.services.IProductQueryService;
import physiodesk.physiodesk_backend.products.infrastructure.persistance.jpa.repositories.IProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements IProductQueryService {

    public static IProductRepository productRepository;

    public ProductQueryServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> handle(GetAllQuery query){
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> handle(GetProductById query){
        return productRepository.findById(query.id());
    }

}
