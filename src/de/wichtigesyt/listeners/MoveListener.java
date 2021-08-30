package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        if (player.getLocation().getWorld().equals("world")) {

            World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("Spawn.world"));
            double x = Main.getInstance().getConfig().getDouble("Spawn.X");
            double y = Main.getInstance().getConfig().getDouble("Spawn.Y");
            double z = Main.getInstance().getConfig().getDouble("Spawn.Z");
            float yaw = (float) Main.getInstance().getConfig().getDouble("Spawn.Yaw");
            float pitch = (float) Main.getInstance().getConfig().getDouble("Spawn.Pitch");
            Location loc = new Location(world, x, y, z, yaw, pitch);
            player.teleport(loc);

        }

    }

}
