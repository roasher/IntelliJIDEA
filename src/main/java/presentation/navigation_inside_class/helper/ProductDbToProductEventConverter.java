package presentation.navigation_inside_class.helper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import presentation.navigation_inside_class.helper.dto.*;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductDbToProductEventConverter implements Converter<ProductDB, ProductItem> {
    @Override
    public ProductItem convert(ProductDB productDB) {
        ProductItem productItem = new ProductItem();
        productItem.setProductId(productDB.getProductId());
        productItem.setAttributes(productDB.getAttributes().entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, productDbEntry -> {
                    ProductAttributeDB productDbEntryValue = productDbEntry.getValue();

                    Attribute attribute = new Attribute();
                    Optional.ofNullable(productDbEntryValue.getValue())
                            .map(ValueDB::getPublicationValue)
                            .ifPresent(attribute::setValues);

                    Optional.ofNullable(productDbEntryValue.getLanguagedValue())
                            .map(langValue -> langValue.entrySet()
                                    .stream()
                                    .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getPublicationValue())))
                            .ifPresent(attribute::setLanguagedValue);
                    return attribute;
                })));
        return productItem;
    }
}
