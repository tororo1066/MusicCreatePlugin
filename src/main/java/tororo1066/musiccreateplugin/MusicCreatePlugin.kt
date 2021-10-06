package tororo1066.musiccreateplugin

import tororo1066.musiccreateplugin.Utils.SItemStack
import tororo1066.musiccreateplugin.Utils.SStringBuilder
import org.bukkit.*
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import tororo1066.musiccreateplugin.commands.MusicCommand
import java.io.File

class MusicCreatePlugin : JavaPlugin() {

    companion object{
        val musicDatas = HashMap<String,MusicData>()
        lateinit var plugin : MusicCreatePlugin
        val prefix = SStringBuilder.hexColor("E60012")+"M"+SStringBuilder.hexColor("FFF100")+"u"+SStringBuilder.hexColor("009944")+"s"+SStringBuilder.hexColor("0068B7")+"i"+SStringBuilder.hexColor("920783")+"c"+"§ePlugin"
        lateinit var item : ItemStack
    }

    override fun onEnable() {
        saveDefaultConfig()
        plugin = this
        getCommand("music")?.setExecutor(MusicCommand())
        getCommand("music")?.tabCompleter = MusicCommand()
        server.pluginManager.registerEvents(MusicListener,this)
        item = SItemStack(Material.STICK).addEnchantment(Enchantment.LUCK,1).setDisplayName("§bNote Stick").setCustomData(
            plugin,"music","music").build()
        MusicUtils.reload()
    }



}