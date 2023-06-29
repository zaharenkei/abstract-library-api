package demo.repository;

import demo.model.armorCategory.ArmorCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArmorCategoryRepo extends MongoRepository<ArmorCategory, Integer> {
}