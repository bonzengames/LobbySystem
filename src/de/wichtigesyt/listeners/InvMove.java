package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class InvMove implements Listener {

    @EventHandler
    public void onClick(InventoryMoveItemEvent event) {

        if (Main.getInstance().getBuilders().contains(event)) {

            event.setCancelled(false);

        } else {

            event.setCancelled(true);

        }

    }

}
