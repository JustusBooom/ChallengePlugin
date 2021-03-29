package de.justusbooom.challengeplugin;

import de.justusbooom.challengeplugin.commands.InventoryCommand;
import de.justusbooom.challengeplugin.files.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChallengePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Config.Setup();
        Config.getCfg().options().copyDefaults(true);
        Config.save();
        registerCommands();
    }

    @Override
    public void onDisable() {
        Config.save();
    }

    public void registerCommands(){
        this.getCommand("challenges").setExecutor(new InventoryCommand());
    }
}
