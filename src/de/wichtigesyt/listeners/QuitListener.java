package de.wichtigesyt.listeners;

import de.wichtigesyt.ScoreBoard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        event.setQuitMessage("");

       /* for (Player all : Bukkit.getOnlinePlayers()) {

            ScoreBoard.setLobbyScore(all);

        }*/

    }
}
