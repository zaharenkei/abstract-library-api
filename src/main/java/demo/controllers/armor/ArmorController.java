package demo.controllers.armor;

import demo.exeptions.ResourceNotFoundException;
import demo.model.armor.Armor;
import demo.model.armor.ArmorData;
import demo.service.armor.ArmorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("armor")
public class ArmorController {

    @Autowired
    private ArmorService armorService;

    @GetMapping("/{id}")
    public ResponseEntity<Armor> read(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return armorService.read(id);
    }

    @GetMapping("/")
    public List<Armor> readAll() {
        return armorService.read();
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> create(@RequestBody ArmorData armorData) {
        return armorService.save(armorData);
    }

    @PutMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> update(@RequestBody Armor armor) throws ResourceNotFoundException {
        return armorService.update(armor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return armorService.delete(id);
    }
}
