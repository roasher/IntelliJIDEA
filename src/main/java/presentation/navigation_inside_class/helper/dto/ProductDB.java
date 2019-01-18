package presentation.navigation_inside_class.helper.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(exclude = "id")
@Document(collection = "products")
public class ProductDB {
    @Id
    public ObjectId id;
    @Indexed(unique = true)
    private String productId;
    private Map<String, ProductAttributeDB> attributes;
    @Version
    private Long version;

    public ProductDB(String productId, Map<String, ProductAttributeDB> attributes) {
        this.productId = productId;
        this.attributes = attributes;
    }

    public ProductDB(String productId) {
        this.productId = productId;
        attributes = new HashMap<>();
    }

    public ProductDB() {
    }
}
