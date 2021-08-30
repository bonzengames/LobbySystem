package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class NoBlockBreak implements Listener {

    @EventHandler
    public void blockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        if (Main.getInstance().getBuilders().contains(player)) {

            event.setCancelled(false);

        } else {

            event.setCancelled(true);

        }

    }

}
