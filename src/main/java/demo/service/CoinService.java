package demo.service;

import demo.exeptions.ResourceNotFoundException;
import demo.model.Coin;
import demo.model.CoinData;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoinService {

    ResponseEntity<Integer> saveCoin(CoinData coinData);

    ResponseEntity<Coin> read(Integer id) throws ResourceNotFoundException;

    Page<Coin> read(int offset, int pageSize);

    ResponseEntity<Boolean> update(Coin coin) throws ResourceNotFoundException;

    ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException;
}
