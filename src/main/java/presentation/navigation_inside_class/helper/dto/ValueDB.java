package presentation.navigation_inside_class.helper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValueDB {
    private List<String> publicationValue;
    private List<String> draftValue;
}
