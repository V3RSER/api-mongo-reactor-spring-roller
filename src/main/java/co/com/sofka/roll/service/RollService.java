package co.com.sofka.roll.service;

import co.com.sofka.roll.dto.RequestDTO;
import co.com.sofka.roll.model.Roll;
import co.com.sofka.roll.repository.RollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;

@Service
public class RollService {
    @Autowired
    private RollRepository repository;

    public Mono<Roll> roll(RequestDTO request) {
        return Mono.just(new Roll()).map(entity -> {
            entity.setDate(new Date());
            try {
                entity.setName(request.getName().trim().isEmpty() ?
                        "Anónimo" : StringUtils.capitalize(request.getName().trim()));
            } catch (Exception e) {
                entity.setName("Anónimo");
            }
            return entity;
        }).map(entity -> {
            var randomDices = new ArrayList<Integer>();
            randomDices.add((int) (Math.random() * ((6 - 1) + 1)) + 1);
            randomDices.add((int) (Math.random() * ((6 - 1) + 1)) + 1);

            entity.setDices(randomDices);
            entity.setTotal(randomDices.stream().mapToInt(dice -> dice).sum());
            return entity;
        }).flatMap(repository::save);
    }


    public Flux<Roll> getRolls() {
        return repository.findAll()
                .buffer(100)
                .limitRate(100)
                .flatMap(roll -> Flux.fromStream(roll.parallelStream()));
    }
}
