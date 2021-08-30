package de.wichtigesyt.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChange implements Listener {

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {

        event.setCancelled(true);

        event.setFoodLevel(20);

    }

}
