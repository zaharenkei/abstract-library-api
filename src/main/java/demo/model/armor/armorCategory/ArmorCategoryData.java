package demo.model.armor.armorCategory;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ArmorCategoryData {

    private String name;
    private Integer donTimeSec;
    private Integer dofTimeSec;
}