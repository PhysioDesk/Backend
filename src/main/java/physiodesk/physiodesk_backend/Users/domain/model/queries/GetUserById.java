package physiodesk.physiodesk_backend.Users.domain.model.queries;

public record GetUserById(Long id) {

    public GetUserById {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
