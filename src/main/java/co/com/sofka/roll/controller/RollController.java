package co.com.sofka.roll.controller;

import co.com.sofka.roll.dto.RequestDTO;
import co.com.sofka.roll.model.Roll;
import co.com.sofka.roll.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "https://v3rser.github.io")
@RequestMapping(value = "/api")
public class RollController {
    @Autowired
    private RollService service;

    @PostMapping("/roll")
    public Mono<Roll> rollDices(@RequestBody(required = false) RequestDTO request) {
        return service.roll(request);
    }

    @GetMapping("/rolls")
    public Flux<Roll> getHistory() {
        return service.getRolls();
    }
}
