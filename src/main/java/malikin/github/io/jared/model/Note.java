package malikin.github.io.jared.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1, message="Name should have at least 1 character")
    private String name;

    protected Note() {}

    public Note(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
