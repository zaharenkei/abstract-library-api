package main.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("coin")
public class Controller {
    @Autowired
    CoinService coinService;

    @GetMapping("type/{type}")
    public List<Coin> getCoinsByType(@PathVariable("type") String type) {
        return coinService.getCoinByType(type);
    }
}
