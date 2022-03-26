package co.com.sofka.roll.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "rolls")
public class Roll {
    @Id
    private String id;
    private Date date;
    private String name;
    private ArrayList<Integer> dices;
    private Integer total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getDices() {
        return dices;
    }

    public void setDices(ArrayList<Integer> dices) {
        this.dices = dices;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
