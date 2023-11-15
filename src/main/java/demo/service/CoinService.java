package demo.service;

import demo.exeptions.ResourceNotFoundException;
import demo.model.coin.Coin;
import demo.model.coin.CoinData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CoinService {

    ResponseEntity<Integer> saveCoin(CoinData coinData);

    Page<Coin> read(Pageable pageable);

    ResponseEntity<Coin> read(Integer id) throws ResourceNotFoundException;

    ResponseEntity<Boolean> update(Coin coin) throws ResourceNotFoundException;

    ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException;
}
