package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerVanishListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        for(Player all : Bukkit.getOnlinePlayers()) {

            if(Main.getInstance().getNothing_Hider().contains(player)) {

                player.hidePlayer(all);

            } else if(Main.getInstance().getYt_Hider().contains(player)){

                if (!all.hasPermission("jepcraft.lobby.yt")) {

                    player.hidePlayer(all);

                }

            } else {
                player.showPlayer(all);
            }

        }

    }

}
