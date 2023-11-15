package demo.repository;

import demo.model.armor.Armor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArmorRepo extends MongoRepository<Armor, Integer> {
}