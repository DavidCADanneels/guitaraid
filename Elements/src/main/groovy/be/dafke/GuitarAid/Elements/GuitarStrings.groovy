package be.dafke.GuitarAid.Elements

class GuitarStrings {
    static HashMap<String, GuitarString> guitarStrings = new HashMap<>()
    static ArrayList<GuitarString> ordenedStrings = new ArrayList<>()

    static {
        def lowE = new GuitarString(name: 'E-low', notes: ScaledNotes.scaledNotes.subList(0, 23))
        def A = new GuitarString(name: 'A', notes: ScaledNotes.scaledNotes.subList(5, 28))
        def D = new GuitarString(name: 'D', notes: ScaledNotes.scaledNotes.subList(10, 33))
        def G = new GuitarString(name: 'G', notes: ScaledNotes.scaledNotes.subList(15, 38))
        def B = new GuitarString(name: 'B', notes: ScaledNotes.scaledNotes.subList(19, 42))
        def highE = new GuitarString(name: 'E-high', notes: ScaledNotes.scaledNotes.subList(24, 47))
        guitarStrings.put 'E-low', lowE
        guitarStrings.put 'A', A
        guitarStrings.put 'D', D
        guitarStrings.put 'G', G
        guitarStrings.put 'B', B
        guitarStrings.put 'E-high', highE
        ordenedStrings.add highE
        ordenedStrings.add B
        ordenedStrings.add G
        ordenedStrings.add D
        ordenedStrings.add A
        ordenedStrings.add lowE
    }
}
