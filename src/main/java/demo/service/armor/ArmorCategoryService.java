package demo.service.armor;

import demo.exeptions.ResourceNotFoundException;
import demo.model.armor.armorCategory.ArmorCategory;
import demo.model.armor.armorCategory.ArmorCategoryData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArmorCategoryService {

    ResponseEntity<Integer> save(ArmorCategoryData armorCategoryData);

    ResponseEntity<ArmorCategory> read(Integer id) throws ResourceNotFoundException;

    List<ArmorCategory> read();

    ResponseEntity<Boolean> update(ArmorCategory armorCategory) throws ResourceNotFoundException;

    ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException;
}