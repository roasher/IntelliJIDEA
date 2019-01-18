package presentation.navigation_inside_class.helper.dto;

import lombok.Data;

import java.util.Map;

@Data
public class Value {
    private String productId;
    private Map<String, Attribute> attributes;
}