package demo.service.armor;

import demo.exeptions.ResourceNotFoundException;
import demo.model.armor.Armor;
import demo.model.armor.ArmorData;
import demo.repository.armor.ArmorRepo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmorServiceImpl implements ArmorService {

    @Autowired
    private ArmorRepo armorRepo;

    @Override
    public ResponseEntity<Integer> save(ArmorData armorData) {
        Optional<Armor> maxArmorOptional = armorRepo.findTopByOrderByIdDesc();
        var id = maxArmorOptional.map(armor -> armor.getId() + 1).orElse(1);
        var armor = new Armor(id, armorData);
        armorRepo.save(armor);
        return ResponseEntity.ok().body(armor.getId());
    }

    @Override
    public ResponseEntity<Armor> read(Integer id) throws ResourceNotFoundException {
        var armor = armorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Armor not found for this id :: " + id));
        return ResponseEntity.ok().body(armor);
    }

    @Override
    public ResponseEntity<Boolean> update(Armor armorData) throws ResourceNotFoundException {
        var armor = armorRepo.findById(armorData.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Armor not found for this id :: " + armorData.getId()));
        if (armorData.getArmorName() != null)
            armor.setArmorName(armorData.getArmorName());
        if (armorData.getCost() != null)
            armor.setCost(armorData.getCost());
        if (armorData.getArmorClass() != null)
            armor.setArmorClass(armorData.getArmorClass());
        if (armorData.getStrengthRequirement() != null)
            armor.setStrengthRequirement(armorData.getStrengthRequirement());
        if (armorData.getStealthDisadvantage() != null)
            armor.setStealthDisadvantage(armorData.getStealthDisadvantage());
        if (armorData.getWeight() != null)
            armor.setWeight(armorData.getWeight());
        if (armorData.getCategoryId() != null)
            armor.setCategoryId(armorData.getCategoryId());
        armorRepo.save(armor);
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException {
        var armor = armorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Armor not found for this id :: " + id));
        armorRepo.delete(armor);
        return ResponseEntity.ok(true);
    }

    @Override
    public List<Armor> read() {
        return armorRepo.findAll();
    }
}