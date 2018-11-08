package malikin.github.io.jared.rest;

import malikin.github.io.jared.dao.NoteRepository;
import malikin.github.io.jared.model.Note;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    private final NoteRepository repository;

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/notes/all")
    public List<Note> getAllNotes() {
        return repository.findAll();
    }
}
