package presentation.navigation_inside_class.helper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductAttributeDB {
    private ValueDB value;
    private Map<String, ValueDB> languagedValue;
}
