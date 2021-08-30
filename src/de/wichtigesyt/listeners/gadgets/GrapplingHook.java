package de.wichtigesyt.listeners.gadgets;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.util.Vector;

public class GrapplingHook implements Listener {
    public GrapplingHook() {
    }

    @EventHandler
    public static void onFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        Fish h = event.getHook();
        if ((event.getState().equals(State.IN_GROUND) || event.getState().equals(State.CAUGHT_ENTITY) || event.getState().equals(State.FAILED_ATTEMPT)) && Bukkit.getWorld(event.getPlayer().getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType() != Material.AIR && Bukkit.getWorld(event.getPlayer().getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType() != Material.STATIONARY_WATER) {
            Location lc = player.getLocation();
            Location to = event.getHook().getLocation();
            lc.setY(lc.getY() + 0.5D);
            player.teleport(lc);
            lc.setY(lc.getY() + 0.5D);
            player.teleport(lc);
            double g = -0.08D;
            double d = to.distance(lc);
            double v_x = (1.0D + 0.07D * d) * (to.getX() - lc.getX()) / d;
            double v_y = (1.0D + 0.03D * d) * (to.getY() - lc.getY()) / d - 0.5D * g * d;
            double v_z = (1.0D + 0.07D * d) * (to.getZ() - lc.getZ()) / d;
            Vector v = player.getVelocity();
            v.setX(v_x);
            v.setY(v_y);
            v.setZ(v_z);
            player.setVelocity(v);

            player.getItemInHand().setDurability((short) 99999);

        }

    }
}
