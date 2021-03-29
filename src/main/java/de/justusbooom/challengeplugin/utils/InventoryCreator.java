package de.justusbooom.challengeplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryCreator {
    private final int columns = 9;
    private int rows;

    private ItemStack fillItem;

    private Inventory inv;

    private String title;

    public InventoryCreator(int rows,ItemStack fillItem, String title){
        this.rows = rows;
        this.fillItem = fillItem;
        this.title = title;

        inv = Bukkit.createInventory(null, this.columns * this.rows, this.title);

        for (int i = 0; i <= this.rows*this.columns-1;){
            if(inv.getItem(i) == null){
                inv.setItem(i,this.fillItem);
            }
            i++;
        }

    }


    public Inventory getInv(){
        return this.inv;
    }

    public void openInv(Player p){
        p.openInventory(this.inv);
    }
}
