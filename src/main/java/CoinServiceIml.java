package main.java;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinServiceIml implements CoinService {

    @Override
    public List<Coin> getCoinByType(String coinType) {
        return getCoinList()
                .stream()
                .filter((coin) -> coin.getCoinType().equals(coinType))
                .collect(Collectors.toList());
    }

    private List<Coin> getCoinList() {
        return Arrays.asList(new Coin("Copper", 1, 1 / 10, 1 / 50, 1 / 100, 1 / 1000),
                new Coin("Silver", 10, 1, 1 / 5, 1 / 10, 1 / 100),
                new Coin("Eleclrum", 50, 5, 1, 1 / 2, 1 / 20),
                new Coin("Ferrari", 50, 5, 1, 1 / 2, 1 / 20),
                new Coin("Gold", 100, 10, 2, 1, 1 / 10),
                new Coin("Platinum", 1000, 100, 20, 10, 1));
    }

}
