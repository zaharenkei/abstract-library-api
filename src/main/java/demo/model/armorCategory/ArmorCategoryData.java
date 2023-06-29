package demo.model.armorCategory;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ArmorCategoryData {

    private String name;
    private String don;
    private String doff;
}