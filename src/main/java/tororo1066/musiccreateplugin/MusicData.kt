package tororo1066.musiccreateplugin

import org.bukkit.Instrument
import org.bukkit.Note
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class MusicData {

    var bpm = 60

    val lyrics = ArrayList<MusicBlock?>()

    var stop = false


    companion object{
        fun loadMusicYml(file : File): Boolean {
            val config = YamlConfiguration.loadConfiguration(file)
            if (!config.isString("lyrics"))return false

            val bpm = config.getInt("bpm",60)
            val lyricsString = config.getString("lyrics")!!
            val data = MusicData()
            data.bpm = bpm
            for (music in lyricsString.split("-")){
                data.lyrics.add(MusicUtils.codeToNote(music))
            }

            MusicCreatePlugin.musicDatas[file.nameWithoutExtension] = data
            return true
        }
    }

}

class MusicBlock{
    val instrument = ArrayList<Instrument>()
    val tone = ArrayList<Note.Tone>()
    val octave = ArrayList<Int>()
    val shape = ArrayList<Boolean>()
}