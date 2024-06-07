package physiodesk.physiodesk_backend.Users.interfaces.rest.resources.user;

public record CreateUserResource(long id,String name, String lastname,Long phone,String email, String address, String city) {
    public CreateUserResource {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be greater than or equal to 0");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (lastname == null || lastname.isBlank()) {
            throw new IllegalArgumentException("UserCode cannot be null or empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
    }
}
