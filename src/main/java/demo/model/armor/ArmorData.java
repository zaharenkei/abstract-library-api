package demo.model.armor;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ArmorData {

    private String armorName;
    private Integer coast;
    private String armorClass;
    private Integer strengthRequirement;
    private String stealth;
    private Integer weight;
    private Integer categoryId;
    private String categoryName;
}