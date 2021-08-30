package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import de.wichtigesyt.ScoreBoard;
import de.wichtigesyt.inventoryes.InventoryManager;
import de.wichtigesyt.utils.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Iterator;

public class JoinListener implements Listener {

    private static int task;
    private static int sek = 5;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("Spawn.world"));
        double x = Main.getInstance().getConfig().getDouble("Spawn.X");
        double y = Main.getInstance().getConfig().getDouble("Spawn.Y");
        double z = Main.getInstance().getConfig().getDouble("Spawn.Z");
        float yaw = (float) Main.getInstance().getConfig().getDouble("Spawn.Yaw");
        float pitch = (float) Main.getInstance().getConfig().getDouble("Spawn.Pitch");
        Location loc = new Location(world, x, y, z, yaw, pitch);
        player.teleport(loc);

        if (player.getLocation().getWorld().equals("world")) {

            player.teleport(loc);

        }

        player.setGameMode(GameMode.SURVIVAL);

        InventoryManager.giveJoinInv(player);

        event.setJoinMessage("");

        if (!PlayerManager.config.contains(player.getUniqueId().toString())) {

            player.sendTitle("§c§lWillkomen", " §3§lAuf §4§lBonzen§5§lGames");

            PlayerManager.addPlayer(player);

        }

        /*for (Player all : Bukkit.getOnlinePlayers()) {

            ScoreBoard.setLobbyScore(all);

        }

        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                if (sek == 0) {

                    for (Player all : Bukkit.getOnlinePlayers()) {

                        ScoreBoard.setLobbyScore(all);

                    }

                    Bukkit.getScheduler().cancelTask(task);

                }

                sek--;

            }
        },0,20);*/

    }

}
