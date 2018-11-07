package malikin.github.io.jared.rest;

import malikin.github.io.jared.dao.NoteRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    private final NoteRepository repository;

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }


}
