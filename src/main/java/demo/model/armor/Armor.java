package demo.model.armor;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Armor extends ArmorData {

    @Id
    private int id;

    public Armor(int id, ArmorData armorData) {
        setId(id);
        setArmorName(armorData.getArmorName());
        setCoast(armorData.getCoast());
        setArmorClass(armorData.getArmorClass());
        setStrengthRequirement(armorData.getStrengthRequirement());
        setStealth(armorData.getStealth());
        setWeight(armorData.getWeight());
        setCategoryId(armorData.getCategoryId());
        setCategoryName(armorData.getCategoryName());
    }

    public Armor() {
    }
}