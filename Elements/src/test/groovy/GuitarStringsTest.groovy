import org.junit.Test

class GuitarStringsTest {

    @Test
    void 'test low E string'(){
        testString('E-low', 'E', 2, 'D', 4)
    }

    @Test
    void 'test A string'(){
        testString('A', 'A', 2, 'G', 4)
    }

    @Test
    void 'test D string'(){
        testString('D', 'D', 3, 'C', 5)
    }

    @Test
    void 'test G string'(){
        testString('G', 'G', 3, 'F', 5)
    }

    @Test
    void 'test B string'(){
        testString('B', 'B', 3, 'A', 5)
    }

    @Test
    void 'test high E string'(){
        testString('E-high', 'E', 4, 'D', 6)
    }

    static void testString(String name, String startNote, Integer startOctave, String endNote, Integer endOctave){
        GuitarString guitarString = GuitarStrings.guitarStrings.get(name)
        List<ScaledNote> notes = guitarString.notes
        assert notes.size() == 23

        ScaledNote firstScaledNote = notes.get(0)
        assert firstScaledNote.name == "${startNote}${startOctave}"
        assert firstScaledNote.octave == startOctave
        Note firstNote = firstScaledNote.note
        assert firstNote.name == startNote

        ScaledNote lastScaledNote = notes.get(22)
        assert lastScaledNote.name == "${endNote}${endOctave}"
        assert lastScaledNote.octave == endOctave
        Note lastNote = lastScaledNote.note
        assert lastNote.name == endNote
    }
}
