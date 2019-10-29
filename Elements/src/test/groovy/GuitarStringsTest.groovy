import org.junit.Test

class GuitarStringsTest {

    @Test
    void 'test constructor'(){
        def strings = new GuitarStrings()
        GuitarString lowE = strings.guitarStrings.get('E-low')
        ScaledNote firstScaledNote = lowE.notes.get(0)
        assert firstScaledNote.name == 'E2'
        assert firstScaledNote.octave == 2
        Note note = firstScaledNote.note
        assert note.name == 'E'
    }
}
