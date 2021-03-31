package de.justusbooom.challengeplugin.listeners;

import de.justusbooom.challengeplugin.ChallengePlugin;
import de.justusbooom.challengeplugin.files.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class JumpListener implements Listener {

    @EventHandler
    public void onJump(PlayerMoveEvent e){
        if(e.getPlayer().getLocation().getY()%1 == 0 && !e.getPlayer().isOnGround() && e.getFrom().getY() < e.getTo().getY() ){
            if(Config.getCfg().getBoolean("jumpRandomMob") == true){
                Random r = new Random();
                int random = r.nextInt(104);
                e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation(), ChallengePlugin.allEntities.get(random));

            }
        }
    }
}
