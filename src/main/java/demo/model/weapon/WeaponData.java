package demo.model.weapon;

import demo.data.WeaponEnum;
import demo.model.dice.DamageDice;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class WeaponData {

    private String name;
    private WeaponEnum.WeaponType weapontype;
    private Integer cost;
    private List<DamageDice> damageDice;
    private WeaponEnum.AttackType attackType;
    private Integer weight;
    private Integer range;
    private Integer maxRange;
    private List<WeaponEnum.WeaponTag> properties;
}
