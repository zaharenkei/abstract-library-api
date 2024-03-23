package demo.repository.armor;

import demo.model.armor.Armor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArmorRepo extends MongoRepository<Armor, Integer> {

    Optional<Armor> findTopByOrderByIdDesc();
}