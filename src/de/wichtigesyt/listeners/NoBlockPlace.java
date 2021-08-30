package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import jdk.Exported;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class NoBlockPlace implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        Player player = event.getPlayer();

        if (Main.getInstance().getBuilders().contains(player)) {

            event.setCancelled(false);

        } else {

            event.setCancelled(true);

        }

    }

}
