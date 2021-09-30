package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import de.wichtigesyt.manager.ScoreBoard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    private int sek = 3;
    private int task;

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        event.setQuitMessage("");

       task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                if (sek == 0) {

                    for (Player all : Bukkit.getOnlinePlayers()) {

                        ScoreBoard.setLobbyScore(all);

                    }

                    sek = 3;

                    Bukkit.getScheduler().cancelTask(task);

                }

                sek--;

            }
        },0,20);

    }
}
