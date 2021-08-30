package de.wichtigesyt.inventoryes;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {

    public static void clickCityBuild(Player player) {

        player.closeInventory();

        World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("CityBuild.world"));
        double x = Main.getInstance().getConfig().getDouble("CityBuild.X");
        double y = Main.getInstance().getConfig().getDouble("CityBuild.Y");
        double z = Main.getInstance().getConfig().getDouble("CityBuild.Z");
        float yaw = (float) Main.getInstance().getConfig().getDouble("CityBuild.Yaw");
        float pitch = (float) Main.getInstance().getConfig().getDouble("CityBuild.Pitch");
        Location loc = new Location(world, x, y, z, yaw, pitch);
        player.teleport(loc);

    }

    public static void clickSpawn(Player player) {

        player.closeInventory();

        World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("Spawn.world"));
        double x = Main.getInstance().getConfig().getDouble("Spawn.X");
        double y = Main.getInstance().getConfig().getDouble("Spawn.Y");
        double z = Main.getInstance().getConfig().getDouble("Spawn.Z");
        float yaw = (float) Main.getInstance().getConfig().getDouble("Spawn.Yaw");
        float pitch = (float) Main.getInstance().getConfig().getDouble("Spawn.Pitch");
        Location loc = new Location(world, x, y, z, yaw, pitch);
        player.teleport(loc);

    }

    public static void clickSkyBlock(Player player){

        player.closeInventory();

        World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("SkyBlock.world"));
        double x = Main.getInstance().getConfig().getDouble("SkyBlock.X");
        double y = Main.getInstance().getConfig().getDouble("SkyBlock.Y");
        double z = Main.getInstance().getConfig().getDouble("SkyBlock.Z");
        float yaw = (float) Main.getInstance().getConfig().getDouble("SkyBlock.Yaw");
        float pitch = (float) Main.getInstance().getConfig().getDouble("SkyBlock.Pitch");
        Location loc = new Location(world, x, y, z, yaw, pitch);
        player.teleport(loc);

    }

    public static void clickCores(Player player) {

        player.closeInventory();

        World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("Cores.world"));
        double x = Main.getInstance().getConfig().getDouble("Cores.X");
        double y = Main.getInstance().getConfig().getDouble("Cores.Y");
        double z = Main.getInstance().getConfig().getDouble("Cores.Z");
        float yaw = (float) Main.getInstance().getConfig().getDouble("Cores.Yaw");
        float pitch = (float) Main.getInstance().getConfig().getDouble("Cores.Pitch");
        Location loc = new Location(world, x, y, z, yaw, pitch);
        player.teleport(loc);

    }

    public static void clickGunGame(Player player) {

        player.closeInventory();

        World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("GunGame.world"));
        double x = Main.getInstance().getConfig().getDouble("GunGame.X");
        double y = Main.getInstance().getConfig().getDouble("GunGame.Y");
        double z = Main.getInstance().getConfig().getDouble("GunGame.Z");
        float yaw = (float) Main.getInstance().getConfig().getDouble("GunGame.Yaw");
        float pitch = (float) Main.getInstance().getConfig().getDouble("GunGame.Pitch");
        Location loc = new Location(world, x, y, z, yaw, pitch);
        player.teleport(loc);

    }

    public static void clickEvent(Player player) {

        player.closeInventory();

        World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("Event.world"));
        double x = Main.getInstance().getConfig().getDouble("Event.X");
        double y = Main.getInstance().getConfig().getDouble("Event.Y");
        double z = Main.getInstance().getConfig().getDouble("Event.Z");
        float yaw = (float) Main.getInstance().getConfig().getDouble("Event.Yaw");
        float pitch = (float) Main.getInstance().getConfig().getDouble("Event.Pitch");
        Location loc = new Location(world, x, y, z, yaw, pitch);
        player.teleport(loc);

    }

    public static void clickCommingSoon(Player player) {

        player.closeInventory();

        player.sendMessage(Main.getInstance().prefix + "§cIn Arbeit");

    }

    public static void clickAll_Hider(Player player) {

        player.closeInventory();

        for (Player all:Bukkit.getOnlinePlayers()) {

            player.showPlayer(all);

        }

        Main.getInstance().getAll_Hider().add(player);

        if (Main.getInstance().getNothing_Hider().contains(player)) {

            Main.getInstance().getNothing_Hider().remove(player);

        }

        if (Main.getInstance().getYt_Hider().contains(player)) {

            Main.getInstance().getYt_Hider().remove(player);

        }

        player.sendMessage(Main.getInstance().prefix + "§aDu siehst jetzt nun wieder alle.");

    }

    public static void clickYT_Hider(Player player) {

        player.closeInventory();

        if (!Main.getInstance().getYt_Hider().contains(player)) {

            for (Player all:Bukkit.getOnlinePlayers()) {

                if (!all.hasPermission("jepcraft.lobby.yt")) {

                    player.hidePlayer(all);

                }

            }

            Main.getInstance().getYt_Hider().add(player);

            if (Main.getInstance().getNothing_Hider().contains(player)) {

                Main.getInstance().getNothing_Hider().remove(player);

                for (Player all:Bukkit.getOnlinePlayers()) {

                    if (!all.hasPermission("jepcraft.lobby.yt")) {

                        player.hidePlayer(all);

                    }

                }

            }

            if (Main.getInstance().getAll_Hider().contains(player)) {

                Main.getInstance().getAll_Hider().remove(player);

            }

            player.sendMessage(Main.getInstance().prefix + "§aDu siehst jetzt nur noch die YouTuber und die Teammitglieder.");

        }

    }

    public static void clickNothing_Hider(Player player) {

        player.closeInventory();

        if (!Main.getInstance().getNothing_Hider().contains(player)) {

            for (Player all:Bukkit.getOnlinePlayers()) {

                player.hidePlayer(all);

            }

            Main.getInstance().getNothing_Hider().add(player);

            if (Main.getInstance().getAll_Hider().contains(player)) {

                Main.getInstance().getAll_Hider().remove(player);

            }

            if (Main.getInstance().getYt_Hider().contains(player)) {

                Main.getInstance().getYt_Hider().remove(player);

            }

            player.sendMessage(Main.getInstance().prefix + "§aDu siehst jetzt niemanden mehr.");

        }

    }

    public static void clickSpielzeug(Player player) {

        player.closeInventory();

        InventoryManager.gadget_gadgetInv(player);

    }

    public static void clickFish(Player player) {

        player.closeInventory();

        ItemStack fish = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishMeta = fish.getItemMeta();
        fishMeta.setDisplayName("§bGrappling Hook");
        fish.setItemMeta(fishMeta);

        player.getInventory().setItem(3, fish);

        Main.getInstance().getFish().add(player);

    }

    public static void clickKoepf(Player player) {

        player.closeInventory();

        InventoryManager.gadget_kopfInv(player);

    }

    public static void clickPartikel(Player player) {

        player.closeInventory();

        InventoryManager.gadget_partikelInv(player);

    }

    public static void clickGadgetDelete(Player player) {

        player.closeInventory();

        if (Main.getInstance().getElytra().contains(player)) {

            Main.getInstance().getElytra().remove(player);

            player.getInventory().clear();

            InventoryManager.giveJoinInv(player);

        } else if (Main.getInstance().getFish().contains(player)) {

            Main.getInstance().getFish().remove(player);

            player.getInventory().clear();

            InventoryManager.giveJoinInv(player);

        }

    }

}
