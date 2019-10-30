import be.dafke.GuitarAid.Elements.Note
import org.junit.Test;

public class NoteTest {

    @Test
    void 'test constructor'(){
        Note note = new Note(name: 'A')
        assert note.name == 'A'
    }

}
