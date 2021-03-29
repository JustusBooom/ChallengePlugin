package de.justusbooom.challengeplugin.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Button {

    private boolean greenOrRed;
    private ItemStack button;
    private String itemName;
    private ItemMeta buttonMeta = button.getItemMeta();


    public Button(boolean greenOrRed, String itemName){
        this.greenOrRed = greenOrRed;
        this.itemName = itemName;

        if(this.greenOrRed){
            button.setType(Material.LIME_STAINED_GLASS_PANE);
        }else {
            button.setType(Material.RED_STAINED_GLASS_PANE);
        }
        buttonMeta.setDisplayName(this.itemName);
        button.setItemMeta(buttonMeta);
    }

    public ItemStack getButton(){
        return this.button;
    }
}
