package demo.model.dice;

import demo.data.DiceEnum;
import demo.data.WeaponEnum;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class DamageDice {

    private int diceAmount;
    private DiceEnum diceType;
    private WeaponEnum.DamageType damageType;
}