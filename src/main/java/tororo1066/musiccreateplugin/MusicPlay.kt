package tororo1066.musiccreateplugin

import org.bukkit.Bukkit
import org.bukkit.Note

class MusicPlay(private val musicData: MusicData) : Thread() {


    override fun run() {

        for (lyrics in musicData.lyrics){
            if (musicData.stop)break
            if (lyrics == null) {
                sleep((60.0/musicData.bpm.toDouble()  * 1000.0).toLong())
                continue
            }
            for (player in Bukkit.getOnlinePlayers()){
                for (loop in lyrics.instrument.indices){
                    player.playNote(player.location, lyrics.instrument[loop], Note(lyrics.octave[loop],lyrics.tone[loop],lyrics.shape[loop]))
                }
            }
            sleep((60.0/musicData.bpm.toDouble()  * 1000.0).toLong())
        }
    }
}