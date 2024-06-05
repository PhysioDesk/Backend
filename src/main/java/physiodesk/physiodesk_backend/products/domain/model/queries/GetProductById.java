package physiodesk.physiodesk_backend.Products.domain.model.queries;

public record GetProductById(Long id) {

    public GetProductById {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
