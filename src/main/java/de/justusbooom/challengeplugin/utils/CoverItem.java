package de.justusbooom.challengeplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CoverItem {

    private ItemStack item;
    private String itemName;
    private ChatColor color;
    private int itemNumber;
    private ItemMeta coverMeta;
    private Inventory inv;
    private int invPosition;

    public CoverItem(ItemStack i,String itemName, ChatColor color, int itemNumber){
        this.item = i;
        this.itemName = itemName;
        this.color = color;
        this.itemNumber = itemNumber;


    }
    public CoverItem(ItemStack i,String itemName, ChatColor color, int itemNumber, Inventory inv, int invPosition){
        this.item = i;
        this.itemName = itemName;
        this.color = color;
        this.itemNumber = itemNumber;
        this.inv = inv;
        this.invPosition = invPosition;
        this.coverMeta = this.item.getItemMeta();

        this.coverMeta.setDisplayName(this.color + this.itemName);
        this.item.setAmount(this.itemNumber);
        this.item.setItemMeta(this.coverMeta);
        this.inv.setItem(this.invPosition,this.item);

    }
}
