package demo.service.impl;

import demo.exeptions.ResourceNotFoundException;
import demo.model.armor.Armor;
import demo.model.armor.ArmorData;
import demo.repository.ArmorRepo;
import demo.service.ArmorService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ArmorServiceImpl implements ArmorService {

    @Autowired
    private ArmorRepo armorRepo;

    @Override
    public ResponseEntity<Integer> save(ArmorData armorData) {
        Optional<Armor> maxArmorOptional = armorRepo.findAll().stream().max(Comparator.comparing(Armor::getId));
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
        if (armorData.getCoast() != null)
            armor.setCoast(armorData.getCoast());
        if (armorData.getArmorClass() != null)
            armor.setArmorClass(armorData.getArmorClass());
        if (armorData.getStrengthRequirement() != null)
            armor.setStrengthRequirement(armorData.getStrengthRequirement());
        if (armorData.getStealth() != null)
            armor.setStealth(armorData.getStealth());
        if (armorData.getWeight() != null)
            armor.setWeight(armorData.getWeight());
        if (armorData.getCategoryId() != null)
            armor.setCategoryId(armorData.getCategoryId());
        if (armorData.getCategoryName() != null)
            armor.setCategoryName(armorData.getCategoryName());
        armorRepo.save(armor);
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException {
        var coin = armorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Armor not found for this id :: " + id));
        armorRepo.delete(coin);
        return ResponseEntity.ok(true);
    }

    @Override
    public List<Armor> read() {
        return armorRepo.findAll();
    }
}