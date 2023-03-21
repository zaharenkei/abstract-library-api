package demo.controllers;

import demo.exeptions.ResourceNotFoundException;
import demo.model.Coin;
import demo.model.CoinData;
import demo.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coins")
public class CoinsController {

    @Autowired
    private CoinService coinService;

    @GetMapping("/{id}")
    public ResponseEntity<Coin> read(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return coinService.read(id);
    }

    @GetMapping("/")
    public Page<Coin> userList(Model model, Pageable pageable) {
        Page<Coin> pages = coinService.read(pageable);
        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("size", pages.getSize());
        model.addAttribute("users", pages.getContent());
        return coinService.read(pageable);
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
