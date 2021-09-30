package de.wichtigesyt.manager;

import de.wichtigesyt.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public String lizens;

    public String mysql_ip;
    public String mysql_port;
    public String mysql_user;
    public String mysql_password;
    public String mysql_database;

    public void MySQLFile(){

        File file = new File(Main.getInstance().getDataFolder(), "mysql.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                config.set("mysql.ip", "127.0.0.1");
                config.set("mysql.port", 3306);
                config.set("mysql.user", "USERNAME");
                config.set("mysql.password", "PASSWORD");
                config.set("mysql.database", "DATABASE");
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            mysql_ip = config.getString("mysql.ip");
            mysql_port = config.getString("mysql.port");
            mysql_user = config.getString("mysql.user");
            mysql_password = config.getString("mysql.password");
            mysql_database = config.getString("mysql.database");
        }

    }

}
