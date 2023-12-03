package demo.controllers.weapon;

import demo.exeptions.ResourceNotFoundException;
import demo.model.weapon.Weapon;
import demo.model.weapon.WeaponData;
import demo.service.weapon.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("weapon")
public class WeaponController {

    @Autowired
    private WeaponService weaponService;

    @GetMapping("/{id}")
    public ResponseEntity<Weapon> read(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return weaponService.read(id);
    }

    @GetMapping("/")
    public List<Weapon> readAll() {
        return weaponService.read();
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> create(@RequestBody WeaponData weaponData) {
        return weaponService.save(weaponData);
    }

    @PutMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> update(@RequestBody Weapon weapon) throws ResourceNotFoundException {
        return weaponService.update(weapon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return weaponService.delete(id);
    }
}
