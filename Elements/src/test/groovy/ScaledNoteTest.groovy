import be.dafke.GuitarAid.Elements.Note
import be.dafke.GuitarAid.Elements.ScaledNote
import org.junit.Test;

public class ScaledNoteTest {

    @Test
    void 'test constructor'(){
        Note note = new Note(name: 'A')
        ScaledNote scaledNote = new ScaledNote(note: note, octave: 2)
        assert scaledNote.name == 'A2'
    }

}
