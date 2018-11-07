package malikin.github.io.jared.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    protected Note() {}

    public Note(String name) {
        this.name = name;
    }
}
