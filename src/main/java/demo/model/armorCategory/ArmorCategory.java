package demo.model.armorCategory;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ArmorCategory extends ArmorCategoryData {

    @Id
    private int id;

    public ArmorCategory(int id, ArmorCategoryData armorCategoryData) {
        setId(id);
        setName(armorCategoryData.getName());
        setDon(armorCategoryData.getDon());
        setDoff(armorCategoryData.getDoff());
    }

    public ArmorCategory() {
    }
}