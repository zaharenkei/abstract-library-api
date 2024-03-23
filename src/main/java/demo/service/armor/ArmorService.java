package demo.service.armor;

import demo.exeptions.ResourceNotFoundException;
import demo.model.armor.Armor;
import demo.model.armor.ArmorData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArmorService {

    ResponseEntity<Integer> save(ArmorData armorData);

    ResponseEntity<Armor> read(Integer id) throws ResourceNotFoundException;

    List<Armor> read();

    ResponseEntity<Boolean> update(Armor armor) throws ResourceNotFoundException;

    ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException;
}