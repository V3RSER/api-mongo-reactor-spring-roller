package co.com.sofka.roll.dto;

import org.springframework.lang.Nullable;

import java.io.Serializable;

public class RequestDTO implements Serializable {
    @Nullable
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
