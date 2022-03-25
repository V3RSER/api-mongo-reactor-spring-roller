package co.com.sofka.roll.repository;

import co.com.sofka.roll.model.Roll;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RollRepository extends ReactiveCrudRepository<Roll, String> {
    
}
