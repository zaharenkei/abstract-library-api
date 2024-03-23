package demo.repository.weapon;

import demo.model.weapon.Weapon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WeaponRepo extends MongoRepository<Weapon, Integer> {

    Optional<Weapon> findTopByOrderByIdDesc();
}