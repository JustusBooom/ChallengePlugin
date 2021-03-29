package de.justusbooom.challengeplugin.commands;

import de.justusbooom.challengeplugin.utils.InventoryCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.isOp() || p.hasPermission("challenge.inv")){
                if(label.equals("challenges")){
                    InventoryCreator inv = new InventoryCreator(5,new ItemStack(Material.BLACK_STAINED_GLASS_PANE),"Settings");
                    

                    inv.openInv(p);
                }else{p.sendMessage(ChatColor.RED+ "Use " + ChatColor.GOLD + "/challenges" + ChatColor.RED + "!");}
            }else {p.sendMessage(ChatColor.RED + "You need the permission to use the command!");}
        }else{sender.sendMessage(ChatColor.RED + "You must be a Player to perform this command!");}

        return false;
    }
}
