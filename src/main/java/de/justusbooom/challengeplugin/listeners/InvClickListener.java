package de.justusbooom.challengeplugin.listeners;

import de.justusbooom.challengeplugin.ChallengePlugin;
import de.justusbooom.challengeplugin.commands.InventoryCommand;
import de.justusbooom.challengeplugin.files.Config;
import de.justusbooom.challengeplugin.utils.Button;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class InvClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (e.getClickedInventory() == InventoryCommand.inv.getInv()){
            if (e.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                Button.buttonSwitchConfig(InventoryCommand.jumpRandomMob, Config.getCfg(), "jumpRandomMob");
                e.getCurrentItem().setType(Material.RED_STAINED_GLASS_PANE);
                ItemMeta meta = e.getCurrentItem().getItemMeta();
                meta.setDisplayName(ChatColor.RED + "OFF");
                e.getCurrentItem().setItemMeta(meta);
            }else if(e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE){
                Button.buttonSwitchConfig(InventoryCommand.jumpRandomMob, Config.getCfg(), "jumpRandomMob");
                e.getCurrentItem().setType(Material.LIME_STAINED_GLASS_PANE);
                ItemMeta meta = e.getCurrentItem().getItemMeta();
                meta.setDisplayName(ChatColor.GREEN + "ON");
                e.getCurrentItem().setItemMeta(meta);

            }
            e.setCancelled(true);
        }

    }

}
