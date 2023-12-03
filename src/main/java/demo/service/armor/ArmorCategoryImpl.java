package demo.service.armor;

import demo.exeptions.ResourceNotFoundException;
import demo.model.armor.armorCategory.ArmorCategory;
import demo.model.armor.armorCategory.ArmorCategoryData;
import demo.repository.armor.ArmorCategoryRepo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmorCategoryImpl implements ArmorCategoryService {

    @Autowired
    private ArmorCategoryRepo armorCategoryRepo;

    @Override
    public ResponseEntity<Integer> save(ArmorCategoryData armorCategoryData) {
        Optional<ArmorCategory> maxArmorOptional = armorCategoryRepo.findTopByOrderByIdDesc();
        var id = maxArmorOptional.map(category -> category.getId() + 1).orElse(1);
        var category = new ArmorCategory(id, armorCategoryData);
        armorCategoryRepo.save(category);
        return ResponseEntity.ok(category.getId());
    }

    @Override
    public ResponseEntity<ArmorCategory> read(Integer id) throws ResourceNotFoundException {
        var armorCategory = armorCategoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ArmorCategory not found for this id :: " + id));
        return ResponseEntity.ok().body(armorCategory);
    }

    @Override
    public List<ArmorCategory> read() {
        return armorCategoryRepo.findAll();
    }

    @Override
    public ResponseEntity<Boolean> update(ArmorCategory armorCategory) throws ResourceNotFoundException {
        var armor = armorCategoryRepo.findById(armorCategory.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ArmorCategory not found for this id :: " + armorCategory.getId()));
        if (armorCategory.getName() != null)
            armor.setName(armorCategory.getName());
        if (armorCategory.getDonTimeSec() != null)
            armor.setDonTimeSec(armorCategory.getDonTimeSec());
        if (armorCategory.getDofTimeSec() != null)
            armor.setDofTimeSec(armorCategory.getDofTimeSec());
        armorCategoryRepo.save(armor);
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException {
        var armorCategory = armorCategoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ArmorCategory not found for this id :: " + id));
        armorCategoryRepo.delete(armorCategory);
        return ResponseEntity.ok(true);
    }
}