import lombok.var;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CoinServiceIml implements CoinService {

    List<Coin> coins = new ArrayList(Arrays.asList(
            new Coin(1, "Copper", 10),
            new Coin(2, "Silver", 100),
            new Coin(3, "Eleclrum", 500),
            new Coin(4, "Gold", 1000),
            new Coin(5, "Platinum", 10000)));

    @Override
    public int create(CoinData coinData) {
        var id = coins.stream().max(Comparator.comparing(Coin::getId)).get().getId() + 1;
        coins.add(new Coin(id, coinData));
        return id;
    }

    @Override
    public Optional<Coin> read(int id) {
        return coins
                .stream()
                .filter((coin) -> coin.getId() == id)
                .findFirst();
    }

    @Override
    public List<Coin> read() {
        return coins;
    }

    @Override
    public boolean update(Coin coinData) {
        var coin = coins
                .stream()
                .filter((c) -> c.getId() == coinData.getId())
                .findFirst().get();
        coin.setType(coinData.getType());
        coin.setValue(coinData.getValue());
        var index = coins.indexOf(coin);
        coins.set(index, coin);
        return true;
    }

    @Override
    public boolean delete(int id) {
        var coin = coins
                .stream()
                .filter((c) -> c.getId() == id)
                .findFirst().get();
        coins.remove(coin);
        return true;
    }

}
