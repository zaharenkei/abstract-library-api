package demo.service.impl;

import demo.exeptions.ResourceNotFoundException;
import demo.model.Coin;
import demo.model.CoinData;
import demo.repository.CoinRepository;
import demo.service.CoinService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CoinsServiceImpl implements CoinService {

    @Autowired
    private CoinRepository coinRepository;

    @Override
    public ResponseEntity<Integer> saveCoin(CoinData coinData) {
        var id = coinRepository.findAll().stream().max(Comparator.comparing(Coin::getId)).get().getId() + 1;
        var coin = new Coin(id,coinData);
        coinRepository.save(coin);
        return ResponseEntity.ok().body(coin.getId());
    }

    @Override
    public ResponseEntity<Coin> read(Integer id) throws ResourceNotFoundException {
        var coin = coinRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(coin);
    }

    @Override
    public List<Coin> read() {
        return coinRepository.findAll();
    }

    @Override
    public ResponseEntity<Boolean> update(Coin coinData) throws ResourceNotFoundException {
        var coin = coinRepository.findById(coinData.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + coinData.getId()));
        if (coinData.getType() != null)
            coin.setType(coinData.getType());
        coin.setType(coinData.getType());
        if (coinData.getValue() != null)
            coin.setValue(coinData.getValue());
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException {
        var coin = coinRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        coinRepository.delete(coin);
        return ResponseEntity.ok(true);
    }
}
