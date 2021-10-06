package tororo1066.musiccreateplugin.commands.subCommands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import tororo1066.musiccreateplugin.MusicCreatePlugin
import tororo1066.musiccreateplugin.MusicPlay
import tororo1066.musiccreateplugin.MusicUtils

class PlayMusic : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        MusicUtils.reload()
        if (MusicCreatePlugin.musicDatas.containsKey(args[1])){
            MusicPlay(MusicCreatePlugin.musicDatas[args[1]]!!).start()
        }

        return true
    }
}