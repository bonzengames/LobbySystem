package de.wichtigesyt.lizens;

import de.wichtigesyt.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LizensFile {

    public static FileConfiguration config;
    public static File file;

    public static String lizens;

    public static void createFile() {

        file = new File(Main.getInstance().getDataFolder(), "lizens.yml");

        config = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {

            try {
                generateConfig();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            loadConfig();

        }

    }

    public static void generateConfig() throws IOException {

        config.set("lizens", "DEINE LIZENS");

        config.save(file);

    }

    public static void loadConfig() {

        lizens = config.get("lizens").toString();

    }

}
