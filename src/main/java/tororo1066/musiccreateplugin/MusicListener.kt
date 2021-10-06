package tororo1066.musiccreateplugin

import org.bukkit.NamespacedKey
import org.bukkit.block.data.type.NoteBlock
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.persistence.PersistentDataType

object MusicListener : Listener {

    @EventHandler
    fun onClick(e : PlayerInteractEvent){
        if (e.hand != EquipmentSlot.HAND)return
        val item = e.item ?:return
        val block = e.clickedBlock ?:return
        if (!item.itemMeta.persistentDataContainer.has(NamespacedKey(MusicCreatePlugin.plugin,"music"),
                PersistentDataType.STRING))return
        if (block.blockData !is NoteBlock)return

        val note = block.blockData as NoteBlock
        e.player.sendMessage(MusicUtils.noteToDoremi(note.note))
    }
}