package de.wichtigesyt;

import de.wichtigesyt.commands.*;
import de.wichtigesyt.commands.money.*;
import de.wichtigesyt.inventoryes.listeners.*;
import de.wichtigesyt.listeners.*;
import de.wichtigesyt.listeners.gadgets.*;
import de.wichtigesyt.lizens.*;
import de.wichtigesyt.manager.*;
import de.wichtigesyt.shop.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static Main instance;

    public String prefix;
    public String noPerms;
    public String noPlayer;

    public ArrayList builders = new ArrayList();
    public ArrayList flyers = new ArrayList();

    public ArrayList nothing_Hider = new ArrayList();
    public ArrayList Yt_Hider = new ArrayList();
    public ArrayList all_Hider = new ArrayList();

    public static DailyLoginReward dailyLoginReward;

    public String kopfOneUsername;
    public String kopfOneDisplayname;
    public String kopfTwoUsername;
    public String kopfTwoDisplayname;
    public String kopfThreeUsername;
    public String kopfThreeDisplayname;
    public String kopfFourUsername;
    public String kopfFourDisplayname;
    public String kopfFiveUsername;
    public String kopfFiveDisplayname;
    public String kopfSixUsername;
    public String kopfSixDisplayname;

    public static FileConfiguration config;
    public static File file;

    public static MySQL mySQL;

    @Override
    public void onEnable() {

        instance = this;

        checkLizens();

        regCommand();
        regEvents(Bukkit.getPluginManager());

        Main.dailyLoginReward = new DailyLoginReward();
        
        file = new File(getDataFolder(), "messages.yml");
        
        config = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                createConfig();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        loadConfig();

        PlayerManager.createPlayerFile();

        TablistManager.setSb();

    }

    @Override
    public void onDisable() {
    }

    private void regCommand() {

        getCommand("build").setExecutor(new BuildCommand());
        getCommand("set").setExecutor(new SetCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gm").setExecutor(new GmCommand());
        getCommand("scoreboard").setExecutor(new ScoreboardCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("money").setExecutor(new MoneyCommand());
        getCommand("money-admin").setExecutor(new MoneyAdminCommand());
        getCommand("pp").setExecutor(new PluginsCommand());

    }

    private void regEvents(PluginManager pluginManager) {

        pluginManager.registerEvents(new InvMove(), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new DamageListener(), this);
        pluginManager.registerEvents(new FoodLevelChange(), this);
        pluginManager.registerEvents(new NoBlockBreak(), this);
        pluginManager.registerEvents(new NoBlockPlace(), this);
        pluginManager.registerEvents(new ClickListener(), this);
        pluginManager.registerEvents(new InteractListener(), this);
        pluginManager.registerEvents(new DropListener(), this);
        pluginManager.registerEvents(new PlayerVanishListener(), this);
        pluginManager.registerEvents(new GrapplingHook(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new CommandListener(), this);
        pluginManager.registerEvents(new WeatherChangeListener(), this);
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
        pluginManager.registerEvents(new GadgetClickListener(), this);

    }

    private void checkLizens() {

        LizensFile.createFile();
        LizensFile.loadConfig();

        if (!new LizensManager(LizensFile.lizens, "https://wichtigesyt.de/lizens/verify.php", this).register()) return;

        FileManager fileManager = new FileManager();
        fileManager.MySQLFile();

        try {
            mySQL = new MySQL(fileManager.mysql_ip, fileManager.mysql_port, fileManager.mysql_user, fileManager.mysql_password, fileManager.mysql_database);
            Bukkit.getConsoleSender().sendMessage("??8[??7MySQL??8] ??aVerbindung hergestellt");
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("??8[??7MySQL??8] ??cVerbindung konnte nicht hergestellt werden");
        }

        ScoreBoard.startupdate();

    }

    private void createConfig() throws IOException {
        
        config.set("messages.prefix", "&8BonzenGames &7:");
        config.set("messages.noperms", "%prefix% Du hast keine Rechte dazu");
        config.set("messages.noplayer", "%prefix% Du bist kein Spieler");

        config.set("kopf.one.username", "WichtigesYT");
        config.set("kopf.one.displayname", "&4Leitung: WichtigesYT");
        config.set("kopf.two.username", "WichtigesYT");
        config.set("kopf.two.displayname", "&4Leitung: WichtigesYT");
        config.set("kopf.three.username", "WichtigesYT");
        config.set("kopf.three.displayname", "&4Leitung: WichtigesYT");
        config.set("kopf.four.username", "WichtigesYT");
        config.set("kopf.four.displayname", "&4Leitung: WichtigesYT");
        config.set("kopf.five.username", "WichtigesYT");
        config.set("kopf.five.displayname", "&4Leitung: WichtigesYT");
        config.set("kopf.six.username", "WichtigesYT");
        config.set("kopf.six.displayname", "&4Leitung: WichtigesYT");

        config.save(file);

    }

    private void loadConfig() {

        prefix = config.get("messages.prefix").toString().replace("&", "??");
        noPerms = config.get("messages.noperms").toString().replace("&", "??").replaceAll("%prefix%", Main.getInstance().prefix);
        noPlayer = config.get("messages.noplayer").toString().replace("&", "??").replaceAll("%prefix%", Main.getInstance().prefix);

        kopfOneUsername = config.get("kopf.one.username").toString().replace("&", "??");
        kopfOneDisplayname = config.get("kopf.one.displayname").toString().replace("&", "??");
        kopfTwoUsername = config.get("kopf.two.username").toString().replace("&", "??");
        kopfTwoDisplayname = config.get("kopf.two.displayname").toString().replace("&", "??");
        kopfThreeUsername = config.get("kopf.three.username").toString().replace("&", "??");
        kopfThreeDisplayname = config.get("kopf.three.displayname").toString().replace("&", "??");
        kopfFourUsername = config.get("kopf.four.username").toString().replace("&", "??");
        kopfFourDisplayname = config.get("kopf.four.displayname").toString().replace("&", "??");
        kopfFiveUsername = config.get("kopf.five.username").toString().replace("&", "??");
        kopfFiveDisplayname = config.get("kopf.five.displayname").toString().replace("&", "??");
        kopfSixUsername = config.get("kopf.six.username").toString().replace("&", "??");
        kopfSixDisplayname = config.get("kopf.six.displayname").toString().replace("&", "??");

    }

    public static Main getInstance() {
        return instance;
    }

    public ArrayList getBuilders() {
        return builders;
    }

    public ArrayList getNothing_Hider() {
        return nothing_Hider;
    }

    public ArrayList getYt_Hider() {
        return Yt_Hider;
    }

    public ArrayList getFlyers() {
        return flyers;
    }

    public ArrayList getAll_Hider() {
        return all_Hider;
    }

}
