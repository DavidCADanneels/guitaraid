import org.junit.Test

public class ScaledNotesTest {

    @Test
    void 'test constructor'(){
        ArrayList<ScaledNote> scaledNotes = ScaledNotes.scaledNotes
        assert scaledNotes.size() == 47
        assert scaledNotes.get(0).name == 'E2'
        assert scaledNotes.get(1).name == 'F2'
        assert scaledNotes.get(2).name == 'F#2'
        assert scaledNotes.get(3).name == 'G2'
        assert scaledNotes.get(4).name == 'G#2'
        assert scaledNotes.get(5).name == 'A2'
        assert scaledNotes.get(6).name == 'A#2'
        assert scaledNotes.get(7).name == 'B2'
        assert scaledNotes.get(8).name == 'C3'
        assert scaledNotes.get(9).name == 'C#3'
        assert scaledNotes.get(10).name == 'D3'
        assert scaledNotes.get(11).name == 'D#3'
        assert scaledNotes.get(12).name == 'E3'
        assert scaledNotes.get(13).name == 'F3'
        assert scaledNotes.get(14).name == 'F#3'
        assert scaledNotes.get(15).name == 'G3'
        assert scaledNotes.get(16).name == 'G#3'
        assert scaledNotes.get(17).name == 'A3'
        assert scaledNotes.get(18).name == 'A#3'
        assert scaledNotes.get(19).name == 'B3'
        assert scaledNotes.get(20).name == 'C4'
        assert scaledNotes.get(21).name == 'C#4'
        assert scaledNotes.get(22).name == 'D4'
        assert scaledNotes.get(23).name == 'D#4'
        assert scaledNotes.get(24).name == 'E4'
        assert scaledNotes.get(36).name == 'E5'
        assert scaledNotes.get(46).name == 'D6'
    }

}
