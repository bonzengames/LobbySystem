package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat (PlayerChatEvent event) {

        Player player = event.getPlayer();
        
        String message = event.getMessage().replace("&", "§");
        
        event.setCancelled(true);

        if (player.hasPermission("tab.owner")) {

            Bukkit.broadcastMessage("§4Owner §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.admin")) {

            Bukkit.broadcastMessage("§cAdmin §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.team-leitung")) {

            Bukkit.broadcastMessage("§fTeamLeitung §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.developer")) {

            Bukkit.broadcastMessage("§bDeveloper §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.eventmanager")) {

            Bukkit.broadcastMessage("§9EManager §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.content")) {

            Bukkit.broadcastMessage("§6Content §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.mbuilder")) {

            Bukkit.broadcastMessage("§3MBuilder §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.moderator")) {

            Bukkit.broadcastMessage("§1Moderator §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.supporter")) {

            Bukkit.broadcastMessage("§2Supporter §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.tsupporter")) {

            Bukkit.broadcastMessage("§2T-Support §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.builder")) {

            Bukkit.broadcastMessage("§3Builder §7| " + player.getName() + " | " + message);

        } else if (player.hasPermission("tab.testbuilder")) {

            Bukkit.broadcastMessage("§3TBuilder §7| " + player.getName() + " | " + message);

        } else {

            player.sendMessage(Main.instance.prefix + "Du kannst keine Nachicht senden in der Lobby");

        }

    }

}
