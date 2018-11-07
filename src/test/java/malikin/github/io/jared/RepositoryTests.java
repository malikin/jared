package malikin.github.io.jared;

import malikin.github.io.jared.dao.NoteRepository;
import malikin.github.io.jared.model.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTests {

    @Autowired
    private NoteRepository repository;

	@Test
	public void createSaveAndFindNote() {

	    Note testNote = new Note("testNote");
	    repository.save(testNote);
	    List<Note> notesFounded = repository.findByName("testNote");

	    assertFalse(notesFounded.isEmpty());
	}
}
