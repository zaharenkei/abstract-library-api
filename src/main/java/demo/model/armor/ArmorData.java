package demo.model.armor;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ArmorData {

    private String armorName;
    private Integer cost;
    private Integer armorClass;
    private Boolean dexModifier;
    private Integer maxDexModifier;
    private Integer strengthRequirement;
    private Boolean stealthDisadvantage;
    private Integer weight;
    private Integer categoryId;
}