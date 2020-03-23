package ds.dataservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String value;

    public long getId() {
        return id;
    }

    public Configuration setId(long id) {
        this.id = id;
        return this;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public Configuration setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Configuration setValue(String value) {
        this.value = value;
        return this;
    }
}
