package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import de.wichtigesyt.inventoryes.GadgetManager;
import de.wichtigesyt.inventoryes.InventoryManager;
import de.wichtigesyt.manager.MySQLManager;
import de.wichtigesyt.manager.ScoreBoard;
import de.wichtigesyt.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    MySQLManager moneyManager = new MySQLManager(Main.mySQL, "geld");
    MySQLManager mySQLManager = new MySQLManager(Main.mySQL, "gagets");

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

        moneyManager.addPlayer(player);

        event.setJoinMessage("");

        player.setLevel(2021);

        if (!PlayerManager.config.contains(player.getUniqueId().toString())) {

            player.sendTitle("§c§lWillkommen", " §3§lAuf §4§lBonzen§5§lGames");

            PlayerManager.addPlayer(player);

        }

        for (Player all : Bukkit.getOnlinePlayers()) {

            ScoreBoard.setLobbyScore(all);

        }

        getAktiveGagets(player);

    }

    private void getAktiveGagets(Player player) {

        ///Schuhe
        if (mySQLManager.getGadget(player, "schuhe_standard").equalsIgnoreCase("aktive")) {

            GadgetManager.clickStandartdSchuhe(player);

        }
        if (mySQLManager.getGadget(player, "schuhe_premium").equalsIgnoreCase("aktive")) {

            GadgetManager.clickPremiumSchuhe(player);

        }
        if (mySQLManager.getGadget(player, "schuhe_ultra").equalsIgnoreCase("aktive")) {

            GadgetManager.clickUltraSchuhe(player);

        }
        if (mySQLManager.getGadget(player, "schuhe_team").equalsIgnoreCase("aktive")) {

            GadgetManager.clickTeamSchuhe(player);

        }

        ///partikel
        if (mySQLManager.getGadget(player, "partikel_herz").equalsIgnoreCase("aktive")) {

            GadgetManager.clickHerz(player);

        }
        if (mySQLManager.getGadget(player, "partikel_water").equalsIgnoreCase("aktive")) {

            GadgetManager.clickWasser(player);

        }
        if (mySQLManager.getGadget(player, "partikel_lava").equalsIgnoreCase("aktive")) {

            GadgetManager.clickLava(player);

        }
        if (mySQLManager.getGadget(player, "partikel_tnt").equalsIgnoreCase("aktive")) {

            GadgetManager.clickTnt(player);

        }

        ///gadgets
        if (mySQLManager.getGadget(player, "gadget_grappling").equalsIgnoreCase("aktive")) {

            GadgetManager.giveGrapplingItem(player);

        }
        if (mySQLManager.getGadget(player, "gadget_elytra").equalsIgnoreCase("aktive")) {

            GadgetManager.giveElytraGadget(player);

        }

    }

}
