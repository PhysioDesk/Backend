package physiodesk.physiodesk_backend.iam.domain.model.queries;

public record GetUserByIdQuery(Long id) {
    public GetUserByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
