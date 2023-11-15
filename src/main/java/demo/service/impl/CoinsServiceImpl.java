package demo.service.impl;

import demo.exeptions.ResourceNotFoundException;
import demo.model.coin.Coin;
import demo.model.coin.CoinData;
import demo.repository.CoinRepo;
import demo.service.CoinService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class CoinsServiceImpl implements CoinService {

    @Autowired
    private CoinRepo coinRepo;

    @Override
    public ResponseEntity<Integer> saveCoin(CoinData coinData) {
        Optional<Coin> maxCoinOptional = coinRepo.findAll().stream().max(Comparator.comparing(Coin::getId));
        var id = maxCoinOptional.map(coin -> coin.getId() + 1).orElse(1);
        var coin = new Coin(id, coinData);
        coinRepo.save(coin);
        return ResponseEntity.ok().body(coin.getId());
    }

    @Override
    public ResponseEntity<Coin> read(Integer id) throws ResourceNotFoundException {
        var coin = coinRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coin not found for this id :: " + id));
        return ResponseEntity.ok().body(coin);
    }

    @Override
    public Page<Coin> read(Pageable pageable) {
        return coinRepo.findAll(pageable);
    }

    public ResponseEntity<Boolean> update(Coin coinData) throws ResourceNotFoundException {
        var coin = coinRepo.findById(coinData.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Coin not found for this id :: " + coinData.getId()));
        if (coinData.getType() != null)
            coin.setType(coinData.getType());
        if (coinData.getValue() != null)
            coin.setValue(coinData.getValue());
        coinRepo.save(coin);
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException {
        var coin = coinRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coin not found for this id :: " + id));
        coinRepo.delete(coin);
        return ResponseEntity.ok(true);
    }
}
