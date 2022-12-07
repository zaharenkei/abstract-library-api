package demo.service;

import demo.exeptions.ResourceNotFoundException;
import demo.model.Coin;
import demo.model.CoinData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoinService {

    ResponseEntity<Integer> saveCoin(CoinData coinData);

    ResponseEntity<Coin> read(Integer id) throws ResourceNotFoundException;

    List<Coin> read();

    ResponseEntity<Boolean> update(Coin coin) throws ResourceNotFoundException;

    ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException;
}
