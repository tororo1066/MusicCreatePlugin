package tororo1066.musiccreateplugin.commands


import tororo1066.musiccreateplugin.MusicCreatePlugin
import tororo1066.musiccreateplugin.Utils.SCommandRouter.SCommandArgument
import tororo1066.musiccreateplugin.Utils.SCommandRouter.SCommandArgumentType
import tororo1066.musiccreateplugin.Utils.SCommandRouter.SCommandObject
import tororo1066.musiccreateplugin.Utils.SCommandRouter.SCommandRouter
import tororo1066.musiccreateplugin.commands.subCommands.GiveNoteStick
import tororo1066.musiccreateplugin.commands.subCommands.PlayMusic

class MusicCommand : SCommandRouter() {

    init {
        pluginPrefix = MusicCreatePlugin.prefix
        registerEvents()
        registerCommands()
    }

    private fun registerEvents(){
        setNoPermissionEvent { it.sender.sendMessage("§4権限がありません") }
        setOnNoCommandFoundEvent { it.sender.sendMessage("§4コマンドが存在しません") }
    }

    private fun registerCommands(){
        addCommand(SCommandObject().
        addArgument(SCommandArgument().addAllowedString("give")).
        addRequiredPermission("op").addExplanation("test").
        setExecutor(GiveNoteStick()))

        addCommand(SCommandObject().
        addArgument(SCommandArgument().addAllowedString("play")).
        addArgument(SCommandArgument().addAllowedType(SCommandArgumentType.STRING).addAlias("曲名")).
        addRequiredPermission("op").addExplanation("test2").
        setExecutor(PlayMusic()))
    }
}