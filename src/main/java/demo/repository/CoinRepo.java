package demo.repository;

import demo.model.coin.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoinRepo extends MongoRepository<Coin, Integer> {
}
