package demo;

import demo.exeptions.ResourceNotFoundException;
import demo.model.Coin;
import demo.model.CoinData;
import demo.repository.CoinRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coins")
public class Controller {
    @Autowired
    CoinRepository coinRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Coin> read(@PathVariable("id") int id) throws ResourceNotFoundException {
        var coin = coinRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(coin);
    }

    @GetMapping("/")
    public List<Coin> readAll() {
        return coinRepository.findAll();
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public int create(@RequestBody CoinData coinData) {
        var coin = new Coin(coinData);
        coinRepository.save(coin);
        return coin.getId();
    }

    @PutMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> update(@RequestBody Coin coinData) throws ResourceNotFoundException {
        var coin = coinRepository.findById(coinData.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + coinData.getId()));
        coin.setType(coinData.getType());
        coin.setValue(coinData.getValue());
        final Coin updatedCoin = coinRepository.save(coin);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        var coin = coinRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        coinRepository.delete(coin);
        return ResponseEntity.ok(true);
    }
}
