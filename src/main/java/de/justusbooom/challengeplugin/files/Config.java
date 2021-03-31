package de.justusbooom.challengeplugin.files;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private static File config;
    private static YamlConfiguration cfg;

    public static void Setup(){
        config = new File(Bukkit.getServer().getPluginManager().getPlugin("ChallengePlugin").getDataFolder(),"config.yml");

        if(!config.exists()){
            try {
                config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cfg = YamlConfiguration.loadConfiguration(config);
    }

    public static YamlConfiguration getCfg(){return cfg;}

    public static void save(){
        try {
            cfg.save(config);
        } catch (IOException e) {
            System.out.println(ChatColor.RED+"Couldn't save the File!");
        }
    }

    public static void reload(){
        cfg = YamlConfiguration.loadConfiguration(config);
    }

}
