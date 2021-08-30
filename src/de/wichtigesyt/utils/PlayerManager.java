package de.wichtigesyt.utils;

import de.wichtigesyt.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerManager {

    private static PlayerManager instance;

    private static File file = new File(Main.getInstance().getDataFolder(), "joinedPlayer.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public static void createPlayerFile() {

        if (!file.exists()) {

            try {
                config.set("null", "null");
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void addPlayer(Player player) {

        try {
            config.set(player.getUniqueId().toString(), "true");
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static PlayerManager getInstance() {
        return instance;
    }
}
