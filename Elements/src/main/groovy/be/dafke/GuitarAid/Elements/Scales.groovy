package be.dafke.GuitarAid.Elements

class Scales {
    static HashMap<String, Scale> majorScales = [:]
    static HashMap<String, Scale> minorScales = [:]

    static ArrayList<Integer> major7Steps = [2,2,1,2,2,2,1]
    static ArrayList<Integer> minor7Steps = [2,1,2,2,1,2,2]

    static {
        Notes.noteNames.each {
            majorScales.put(it, new Scale(Notes.notes.get(it), major7Steps))
            minorScales.put(it, new Scale(Notes.notes.get(it), minor7Steps))
        }
    }
}
