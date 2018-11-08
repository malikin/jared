package malikin.github.io.jared.dao;

import malikin.github.io.jared.model.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findAll();

    List<Note> findByName(String name);
}
