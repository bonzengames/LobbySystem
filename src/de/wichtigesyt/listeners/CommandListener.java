package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Locale;

public class CommandListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {

        Player player = event.getPlayer();

        if (event.getMessage().toLowerCase(Locale.ROOT).startsWith("/gamemode") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/minecraft:gamemode")) {

            if (player.hasPermission("jepcraft.lobby.gamemode") || player.isOp()) {

                player.sendMessage(Main.getInstance().prefix + "§cBenutze /gm <0/1/2/3>");

            } else {

                player.sendMessage(Main.getInstance().noPerms);

            }

            event.setCancelled(true);

        }

    }

}
