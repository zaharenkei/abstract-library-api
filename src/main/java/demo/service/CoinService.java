package demo.service;

import demo.exeptions.ResourceNotFoundException;
import demo.model.Coin;
import demo.model.CoinData;
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
