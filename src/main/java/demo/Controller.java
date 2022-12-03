package demo;

import demo.exeptions.ResourceNotFoundException;
import demo.model.Coin;
import demo.model.CoinData;
import demo.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coins")
public class Controller {

    @Autowired
    private CoinService coinService;

    @GetMapping("/{id}")
    public ResponseEntity<Coin> read(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return coinService.read(id);
    }

    @GetMapping("/")
    public List<Coin> readAll() {
        return coinService.read();
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> create(@RequestBody CoinData coinData) {
        return coinService.saveCoin(coinData);
    }

    @PutMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> update(@RequestBody Coin coin) throws ResourceNotFoundException {
        return coinService.update(coin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return coinService.delete(id);
    }
}
