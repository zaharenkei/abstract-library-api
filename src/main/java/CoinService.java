import java.util.List;
import java.util.Optional;

public interface CoinService {
    int create(CoinData coin);
    Optional<Coin> read(int id);
    List<Coin> read();
    boolean update (Coin coin);
    boolean delete(int id);
}
