package demo.service.weapon;

import demo.exeptions.ResourceNotFoundException;
import demo.model.weapon.Weapon;
import demo.model.weapon.WeaponData;
import demo.repository.weapon.WeaponRepo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeaponServiceImpl implements WeaponService {

    @Autowired
    private WeaponRepo weaponRepo;

    @Override
    public ResponseEntity<Integer> save(WeaponData weaponData) {
        Optional<Weapon> maxWeaponOptional = weaponRepo.findTopByOrderByIdDesc();
        var id = maxWeaponOptional.map(weapon -> weapon.getId() + 1).orElse(1);
        var weapon = new Weapon(id, weaponData);
        weaponRepo.save(weapon);
        return ResponseEntity.ok().body(weapon.getId());
    }

    @Override
    public ResponseEntity<Weapon> read(Integer id) throws ResourceNotFoundException {
        var weapon = weaponRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Weapon not found for this id :: " + id));
        return ResponseEntity.ok().body(weapon);
    }

    @Override
    public ResponseEntity<Boolean> update(Weapon weaponData) throws ResourceNotFoundException {
        var weapon = weaponRepo.findById(weaponData.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Weapon not found for this id :: " + weaponData.getId()));
        if (weaponData.getName() != null)
            weapon.setName(weaponData.getName());
        if (weaponData.getWeapontype() != null)
            weapon.setWeapontype(weaponData.getWeapontype());
        if (weaponData.getCost() != null)
            weapon.setCost(weaponData.getCost());
        if (weaponData.getDamageDice() != null)
            weapon.setDamageDice(weaponData.getDamageDice());
        if (weaponData.getAttackType() != null)
            weapon.setAttackType(weaponData.getAttackType());
        if (weaponData.getWeight() != null)
            weapon.setWeight(weaponData.getWeight());
        if (weaponData.getRange() != null)
            weapon.setRange(weaponData.getRange());
        if (weaponData.getMaxRange() != null)
            weapon.setMaxRange(weaponData.getMaxRange());
        if (weaponData.getProperties() != null)
            weapon.setProperties(weaponData.getProperties());
        weaponRepo.save(weapon);
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException {
        var weapon = weaponRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Weapon not found for this id :: " + id));
        weaponRepo.delete(weapon);
        return ResponseEntity.ok(true);
    }

    @Override
    public List<Weapon> read() {
        return weaponRepo.findAll();
    }
}