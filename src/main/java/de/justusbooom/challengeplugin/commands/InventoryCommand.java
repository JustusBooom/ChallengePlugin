package de.justusbooom.challengeplugin.commands;

import de.justusbooom.challengeplugin.files.Config;
import de.justusbooom.challengeplugin.utils.Button;
import de.justusbooom.challengeplugin.utils.CoverItem;
import de.justusbooom.challengeplugin.utils.InventoryCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryCommand implements CommandExecutor {

    private CoverItem jumpRandomMobCover;
    private ItemMeta jRMM;

    public static Button jumpRandomMob;
    public static InventoryCreator inv = new InventoryCreator(6,new ItemStack(Material.BLACK_STAINED_GLASS_PANE),"Settings");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.isOp() || p.hasPermission("challenge.inv")){
                if(label.equals("challenges")){
                    jumpRandomMob = new Button(Config.getCfg().getBoolean("jumpRandomMob"));
                    jumpRandomMobCover = new CoverItem(new ItemStack(Material.CREEPER_HEAD),"Random Mob at Jumping",ChatColor.GREEN,1,inv.getInv(),20);
                    inv.getInv().setItem(29,jumpRandomMob.getButton());

                    

                    inv.openInv(p);
                }else{p.sendMessage(ChatColor.RED+ "Use " + ChatColor.GOLD + "/challenges" + ChatColor.RED + "!");}
            }else {p.sendMessage(ChatColor.RED + "You need the permission to use the command!");}
        }else{sender.sendMessage(ChatColor.RED + "You must be a Player to perform this command!");}

        return false;
    }
}
