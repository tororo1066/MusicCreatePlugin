package tororo1066.musiccreateplugin

import org.bukkit.*

object MusicUtils {

    fun noteToDoremi(note : Note): String {
        val str = StringBuilder()
        when(note.tone){
            Note.Tone.A->str.append("ド")
            Note.Tone.B->str.append("レ")
            Note.Tone.C->str.append("ミ")
            Note.Tone.D->str.append("ファ")
            Note.Tone.E->str.append("ソ")
            Note.Tone.F->str.append("ラ")
            Note.Tone.G->str.append("シ")
        }

        if (note.isSharped) str.append("#")
        str.append(note.octave)

        return str.toString()
    }

    fun codeToNote(code : String): MusicBlock? {
        if (code == "000"){
            return null
        }

        val data = MusicBlock()
        for (loop in code.indices step 3){

            val codeInstrument = code.substring(loop..loop)
            val codeNote = code.substring(loop+1..loop+1)
            val codeSharp = code.substring(loop+2..loop+2)



            val instrument : Instrument = when(codeInstrument){
                "a"-> Instrument.BASS_GUITAR
                "b"-> Instrument.SNARE_DRUM
                "c"-> Instrument.STICKS
                "d"-> Instrument.BASS_DRUM
                "e"-> Instrument.BELL
                "f"-> Instrument.FLUTE
                "g"-> Instrument.CHIME
                "h"-> Instrument.GUITAR
                "i"-> Instrument.XYLOPHONE
                "j"-> Instrument.IRON_XYLOPHONE
                "k"-> Instrument.COW_BELL
                "l"-> Instrument.DIDGERIDOO
                "m"-> Instrument.BIT
                "n"-> Instrument.BANJO
                "o"-> Instrument.PLING
                "p"-> Instrument.PIANO
                else -> Instrument.PIANO
            }

            val tone : Note.Tone = when(codeNote){
                "1"-> Note.Tone.A
                "2"-> Note.Tone.B
                "3"-> Note.Tone.C
                "4"-> Note.Tone.D
                "5"-> Note.Tone.E
                "6"-> Note.Tone.F
                "7"-> Note.Tone.G
                else -> Note.Tone.A
            }

            val octave : Int = when(codeSharp){
                "1","2"-> 0
                "3","4"-> 1
                "5","6"-> 2
                else-> 0
            }

            val shape : Boolean = when(codeSharp){
                "1","3","5"-> false
                "2","4","6"-> true
                else-> false
            }



            data.instrument.add(instrument)
            data.octave.add(octave)
            data.tone.add(tone)
            data.shape.add(shape)
        }

        return data
    }

    fun reload(){
        for (file in MusicCreatePlugin.plugin.dataFolder.listFiles()?:return){
            MusicData.loadMusicYml(file)
        }
    }

}