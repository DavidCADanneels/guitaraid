import be.dafke.GuitarAid.Elements.Note
import be.dafke.GuitarAid.Elements.Notes
import org.junit.Test;

class NotesTest {

    @Test
    void 'test constructor'(){
        assert Notes.notes.size() == 12
        Notes.noteNames.each { name ->
            assert Notes.notes.containsKey(name)
            Note note = Notes.notes.get(name)
            note.name == name
            print name
        }
    }

}
