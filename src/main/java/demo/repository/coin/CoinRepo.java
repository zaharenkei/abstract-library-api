package demo.repository.coin;

import demo.model.coin.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CoinRepo extends MongoRepository<Coin, Integer> {

    Optional<Coin> findTopByOrderByIdDesc();
}
