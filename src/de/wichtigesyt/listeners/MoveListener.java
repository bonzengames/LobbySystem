package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import de.wichtigesyt.inventoryes.GadgetManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
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

        if (GadgetManager.lava_partikel.contains(player)) {

            player.getLocation().getWorld().spawnParticle(Particle.LAVA, player.getLocation(), 1);

        } else if (GadgetManager.tnt_partikel.contains(player)) {

            player.getLocation().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, player.getLocation(), 1);

        } else if (GadgetManager.wasser_partikel.contains(player)) {

            player.getLocation().getWorld().spawnParticle(Particle.WATER_DROP, player.getLocation(), 1);

        } else if (GadgetManager.herz_partikel.contains(player)) {

            player.getLocation().getWorld().spawnParticle(Particle.HEART, player.getLocation(), 1);

        }

    }

}
