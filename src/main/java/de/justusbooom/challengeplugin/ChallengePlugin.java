package de.justusbooom.challengeplugin;

import de.justusbooom.challengeplugin.commands.InventoryCommand;
import de.justusbooom.challengeplugin.commands.TimerCommand;
import de.justusbooom.challengeplugin.files.Config;
import de.justusbooom.challengeplugin.listeners.InvClickListener;
import de.justusbooom.challengeplugin.listeners.JumpListener;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ChallengePlugin extends JavaPlugin {
    public static ArrayList<EntityType> allEntities= new ArrayList<>();
    public static boolean ChallengeActive;


    @Override
    public void onEnable() {
        Config.Setup();
        Config.getCfg().addDefault("jumpRandomMob",false);
        Config.getCfg().options().copyDefaults(true);
        Config.save();
        registerCommands();
        registerEvents();
        addAllEntities();
    }

    @Override
    public void onDisable() {
        Config.save();
    }

    public void registerCommands(){
        this.getCommand("challenges").setExecutor(new InventoryCommand());
        //this.getCommand("timer").setExecutor(new TimerCommand());
    }

    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new InvClickListener(),this);
        getServer().getPluginManager().registerEvents(new JumpListener(),this);
    }

    public void addAllEntities(){
        for (EntityType e: EntityType.values()){
            allEntities.add(e);
        }
        allEntities.remove(EntityType.PLAYER);
        allEntities.remove(EntityType.FISHING_HOOK);
        allEntities.remove(EntityType.LEASH_HITCH);
        allEntities.remove(EntityType.PAINTING);
        allEntities.remove(EntityType.ITEM_FRAME);

    }
}
