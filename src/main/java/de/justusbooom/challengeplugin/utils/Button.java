package de.justusbooom.challengeplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Button {

    private static boolean greenOrRed;
    private ItemStack item = new ItemStack(Material.AIR);
    private String itemName;
    private ItemMeta buttonMeta;


    public Button(boolean greenOrRed){
        this.greenOrRed = greenOrRed;

        if(this.greenOrRed){
            item.setType(Material.LIME_STAINED_GLASS_PANE);
            buttonMeta = item.getItemMeta();
            this.buttonMeta.setDisplayName(ChatColor.GREEN + "ON");
        }else {
            item.setType(Material.RED_STAINED_GLASS_PANE);
            buttonMeta = item.getItemMeta();
            this.buttonMeta.setDisplayName(ChatColor.RED + "OFF");
        }
        item.setItemMeta(buttonMeta);
    }

    public ItemStack getButton(){
        return this.item;
    }


    public static void buttonSwitchConfig(Button button, YamlConfiguration cfg, String path){
        if(button.greenOrRed == false){
            cfg.set(path,true);
            greenOrRed = true;

        }else if(button.greenOrRed == true){
            cfg.set(path,false);
            greenOrRed = false;
        }
    }

    public static void buttonSwitchItem(Button button){
        if(button.greenOrRed == false){
            button.getButton().setType(Material.LIME_STAINED_GLASS_PANE);

        }else if(button.greenOrRed == true){
            button.getButton().setType(Material.RED_STAINED_GLASS_PANE);
        }
    }
}
