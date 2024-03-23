package demo.repository.armor;

import demo.model.armor.armorCategory.ArmorCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArmorCategoryRepo extends MongoRepository<ArmorCategory, Integer> {

    Optional<ArmorCategory> findTopByOrderByIdDesc();
}