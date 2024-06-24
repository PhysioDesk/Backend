package physiodesk.physiodesk_backend.productBC.products.domain.model.commands;

public record CreateProductCommand(long id, String name, String description, double price, String imageUrl,String rating, String dimensiones){

    public CreateProductCommand{
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if(description == null || description.isBlank()){
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if(price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if(imageUrl == null || imageUrl.isBlank()){
            throw new IllegalArgumentException("Image URL cannot be null or empty");
        }
        if(rating == null || rating.isBlank()){
            throw new IllegalArgumentException("Rating cannot be null or empty");
        }
        if(dimensiones == null || dimensiones.isBlank()){
            throw new IllegalArgumentException("Dimensiones cannot be null or empty");
        }
    }


}
