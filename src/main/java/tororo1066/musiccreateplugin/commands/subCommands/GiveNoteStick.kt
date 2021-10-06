package tororo1066.musiccreateplugin.commands.subCommands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import tororo1066.musiccreateplugin.MusicCreatePlugin

class GiveNoteStick : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (!sender.isOp)return true
        if (sender !is Player) return true
        sender.inventory.setItemInMainHand(MusicCreatePlugin.item)
        sender.sendMessage("付与")
        return true
    }
}