package main.java;

import main.java.Coin;

import java.util.List;

public interface CoinService {
    List<Coin> getCoinByType(String category);
}
