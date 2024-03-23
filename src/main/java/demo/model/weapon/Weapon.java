package demo.model.weapon;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Weapon extends WeaponData {

    @Id
    private int id;

    public Weapon(int id, WeaponData weaponData) {
        setId(id);
        setName(weaponData.getName());
        setWeapontype(weaponData.getWeapontype());
        setCost(weaponData.getCost());
        setDamageDice(weaponData.getDamageDice());
        setAttackType(weaponData.getAttackType());
        setWeight(weaponData.getWeight());
        setRange(weaponData.getRange());
        setMaxRange(weaponData.getMaxRange());
        setProperties(weaponData.getProperties());
    }

    public Weapon() {
    }
}
