package malikin.github.io.jared.rest;

import malikin.github.io.jared.dao.NoteRepository;
import malikin.github.io.jared.model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/notes")
public class NoteController {

    private final NoteRepository repository;

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public Collection<Note> getAllNotes() {
        return repository.findAll();
    }

    @GetMapping("")
    public Collection<Note> findNoteByName(@RequestParam String name) {
        return repository.findByName(name);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void postNewNote(@Valid @RequestBody Note newNote) {
        repository.save(newNote);
    }
}
