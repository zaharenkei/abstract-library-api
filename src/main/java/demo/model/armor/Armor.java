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
        setCost(armorData.getCost());
        setArmorClass(armorData.getArmorClass());
        setDexModifier(armorData.getDexModifier());
        setMaxDexModifier(armorData.getMaxDexModifier());
        setStealthDisadvantage(armorData.getStealthDisadvantage());
        setStrengthRequirement(armorData.getStrengthRequirement());
        setWeight(armorData.getWeight());
        setCategoryId(armorData.getCategoryId());
    }

    public Armor() {
    }
}