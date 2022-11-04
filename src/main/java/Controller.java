import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("coins")
public class Controller {
    @Autowired
    CoinService coinService;

    @GetMapping("/{id}")
    public Optional<Coin> read(@PathVariable("id") int id) {
        return coinService.read(id);
    }

    @GetMapping("/")
    public List<Coin> readAll() {
        return coinService.read();
    }

    @PostMapping(value ="/", consumes = "application/json", produces = "application/json")
    public int create(@RequestBody CoinData coin) {
       return coinService.create(coin);
    }

    @PutMapping(value ="/", consumes = "application/json", produces = "application/json")
    public boolean update(@RequestBody Coin coin) {
        return coinService.update(coin);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return coinService.delete(id);
    }
}
