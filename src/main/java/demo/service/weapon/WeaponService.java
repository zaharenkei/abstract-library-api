package demo.service.weapon;

import demo.exeptions.ResourceNotFoundException;
import demo.model.weapon.Weapon;
import demo.model.weapon.WeaponData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WeaponService {
    ResponseEntity<Integer> save(WeaponData weaponData);

    ResponseEntity<Weapon> read(Integer id) throws ResourceNotFoundException;

    List<Weapon> read();

    ResponseEntity<Boolean> update(Weapon weapon) throws ResourceNotFoundException;

    ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException;
}
