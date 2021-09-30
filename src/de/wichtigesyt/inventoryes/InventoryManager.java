package de.wichtigesyt.inventoryes;

import de.wichtigesyt.Main;
import de.wichtigesyt.manager.MySQLManager;
import de.wichtigesyt.manager.TablistManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Collections;

public class InventoryManager {

    public static void giveJoinInv(Player player) {

        Inventory inv = player.getInventory();
        inv.clear();

        TablistManager.setPrefix(player);

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compasMeta = compass.getItemMeta();
        compasMeta.setDisplayName("§bTeleporter");
        compass.setItemMeta(compasMeta);

        ItemStack kopf = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta kopfMeta = (SkullMeta) kopf.getItemMeta();
        kopfMeta.setDisplayName("§6Profil");
        kopfMeta.setOwner(player.getName());
        kopf.setItemMeta(kopfMeta);

        ItemStack noGadget = new ItemStack(Material.FIREWORK_CHARGE);
        ItemMeta noGadgetMeta = noGadget.getItemMeta();
        noGadgetMeta.setDisplayName("§cKein Gadget ausgewählt");
        noGadget.setItemMeta(noGadgetMeta);

        ItemStack gadget = new ItemStack(Material.CHEST);
        ItemMeta gadgetMeta = gadget.getItemMeta();
        gadgetMeta.setDisplayName("§eGadgets");
        gadget.setItemMeta(gadgetMeta);

        ItemStack hide_tool = new ItemStack(Material.BLAZE_ROD);
        ItemMeta hide_toolMeta = hide_tool.getItemMeta();
        hide_toolMeta.setDisplayName("§cSpieler Verstecker");
        hide_tool.setItemMeta(hide_toolMeta);

        /*ItemStack lobbyselector = new ItemStack(Material.NETHER_STAR);
        ItemMeta lobbyselectorMeta = lobbyselector.getItemMeta();
        lobbyselectorMeta.setDisplayName("§3Lobby Selector");
        lobbyselector.setItemMeta(lobbyselectorMeta);*/

        inv.setItem(0, compass);
        inv.setItem(7, hide_tool);
        inv.setItem(3, noGadget);
        inv.setItem(5, gadget);
        ///inv.setItem(7, lobbyselector);
        inv.setItem(8, kopf);

    }

    public static void compassInv(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§bTeleporter");

        ItemStack cityBuild = new ItemStack(Material.GRASS);
        ItemMeta cityBuildMeta = cityBuild.getItemMeta();
        cityBuildMeta.setDisplayName("§aSkyBlock");
        cityBuildMeta.setLore(Collections.singletonList("Teleportiere dich zu SkyBlock."));
        cityBuild.setItemMeta(cityBuildMeta);

        ItemStack cores = new ItemStack(Material.NETHERRACK);
        ItemMeta coresMeta = cores.getItemMeta();
        coresMeta.setDisplayName("§4Nether");
        coresMeta.setLore(Collections.singletonList("Teleportiere dich zu Nether."));
        cores.setItemMeta(coresMeta);

        ItemStack skyBlock = new ItemStack(Material.DIAMOND);
        ItemMeta skyBlockMeta = skyBlock.getItemMeta();
        skyBlockMeta.setDisplayName("§fCityBuild");
        skyBlockMeta.setLore(Collections.singletonList("Teleportiere dich zu CityBuild."));
        skyBlock.setItemMeta(skyBlockMeta);

        ItemStack gunGame = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta gunGameMeta = gunGame.getItemMeta();
        gunGameMeta.setDisplayName("§aFarmwelt");
        gunGameMeta.setLore(Collections.singletonList("Teleportiere dich zu Farmwelt."));
        gunGame.setItemMeta(gunGameMeta);

        ItemStack spawn = new ItemStack(Material.NETHER_STAR);
        ItemMeta spawnMeta = spawn.getItemMeta();
        spawnMeta.setDisplayName("§cSpawn");
        spawnMeta.setLore(Collections.singletonList("Teleportiere dich zum Spawn."));
        spawn.setItemMeta(spawnMeta);

        ItemStack comming_soon = new ItemStack(Material.BARRIER);
        ItemMeta comming_soonMeta = comming_soon.getItemMeta();
        comming_soonMeta.setDisplayName("§4In Entwicklung");
        comming_soon.setItemMeta(comming_soonMeta);

        ItemStack event = new ItemStack(Material.FIREWORK);
        ItemMeta event_meta = event.getItemMeta();
        event_meta.setDisplayName("§dEvent");
        event.setItemMeta(event_meta);

        ItemStack bedwars = new ItemStack(Material.BED);
        ItemMeta bedwars_meta = bedwars.getItemMeta();
        bedwars_meta.setDisplayName("§cBedWars");
        bedwars.setItemMeta(bedwars_meta);

        inv.setItem(1, cores);
        inv.setItem(7, cityBuild);
        inv.setItem(9, comming_soon);
        inv.setItem(11, bedwars);
        inv.setItem(13, spawn);
        inv.setItem(15, event);
        inv.setItem(17, comming_soon);
        inv.setItem(19, skyBlock);
        inv.setItem(25, gunGame);

        player.openInventory(inv);

    }

    public static void profilInv(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§6Profil");

        MySQLManager mySQLManager = new MySQLManager(Main.mySQL, "geld");

        ItemStack muenzen = new ItemStack(Material.EMERALD);
        ItemMeta muenzenMeta = muenzen.getItemMeta();
        muenzenMeta.setDisplayName("§6Münzen");
        muenzenMeta.setLore(Collections.singletonList("§aDeine Coins betragen §c" + mySQLManager.getMoney(player, "geld")));
        muenzen.setItemMeta(muenzenMeta);

        ItemStack level = new ItemStack(Material.EXP_BOTTLE);
        ItemMeta levelMeta = level.getItemMeta();
        levelMeta.setDisplayName("§cRang Shop");
        levelMeta.setLore(Collections.singletonList("§aKaufe dir einen Rang mit Ingame Coins"));
        level.setItemMeta(levelMeta);

        /*ItemStack freund = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta freundMeta = (SkullMeta) freund.getItemMeta();
        freundMeta.setDisplayName("§bFreunde");
        freundMeta.setOwner(player.getName());
        freundMeta.setLore(Collections.singletonList("§aZeige deine Freundes Liste"));
        freund.setItemMeta(freundMeta);

        ItemStack onlinetime = new ItemStack(Material.REDSTONE);
        ItemMeta onlinetimeMeta = onlinetime.getItemMeta();
        onlinetimeMeta.setDisplayName("§cOnlinezeit");
        onlinetimeMeta.setLore(Collections.singletonList("§aDeine Onlinezeit beträgt §c" + TimeUnit.MILLISECONDS.toDays(banPlayer.getOnlineTime()) + " Stunden"));
        onlinetime.setItemMeta(onlinetimeMeta);*/

        ItemStack daily = new ItemStack(Material.DIAMOND);
        ItemMeta dailymeta = daily.getItemMeta();
        dailymeta.setDisplayName("§3Tägliche Belohnung");
        dailymeta.setLore(Collections.singletonList("§aHier kannst du deine Tägliche Belohnung abholen"));
        daily.setItemMeta(dailymeta);

        /*ItemStack rang = new ItemStack(Material.NAME_TAG);
        ItemMeta rangMeta = rang.getItemMeta();
        rangMeta.setDisplayName("§eRang");
        rangMeta.setLore(Collections.singletonList("§aDein Rang ist§c " + permPlayer.getHighestGroup().getName()));
        rang.setItemMeta(rangMeta);*/

        inv.setItem(10, muenzen);
        inv.setItem(16, level);
        ///inv.setItem(13, freund);
        ///inv.setItem(19, onlinetime);
        inv.setItem(13, daily);
        ///inv.setItem(25, rang);

        player.openInventory(inv);

    }

    public static void hide_toolinv(Player player) {

        Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, "§cSpieler Verstecker");

        ItemStack all = new ItemStack(Material.GLASS, 1, (byte)13);
        ItemMeta allMeta = all.getItemMeta();
        allMeta.setDisplayName("§aAlle anzeigen");
        allMeta.setLore(Collections.singletonList("§aHier kannst du dir alle Spieler anzeigen lassen"));
        all.setItemMeta(allMeta);

        ItemStack yt = new ItemStack(Material.GLASS, 1, (byte)6);
        ItemMeta ytMeta = yt.getItemMeta();
        ytMeta.setDisplayName("§5YTer/Team anzeigen");
        ytMeta.setLore(Collections.singletonList("§5Hier kannst du dir alle YouTuber und Teammitglieder anzeigen lassen"));
        yt.setItemMeta(ytMeta);

        ItemStack nothing = new ItemStack(Material.GLASS, 1, (byte)14);
        ItemMeta nothingMeta = nothing.getItemMeta();
        nothingMeta.setDisplayName("§cKeinen anzeigen");
        nothingMeta.setLore(Collections.singletonList("§cHier kannst du dir keinen anzeigen lassen"));
        nothing.setItemMeta(nothingMeta);

        if (Main.getInstance().getAll_Hider().contains(player)) {

            ItemStack auswahl = new ItemStack(Material.GLASS, 1, (byte)13);
            ItemMeta auswahlMeta = auswahl.getItemMeta();
            auswahlMeta.setDisplayName("§aDeine aktuelle auswahl");
            auswahlMeta.setLore(Collections.singletonList("§aAlle Spieler werden dir angezeigt"));
            auswahl.setItemMeta(auswahlMeta);

            inv.setItem(3, auswahl);

        } else if (Main.getInstance().getYt_Hider().contains(player)) {

            ItemStack auswahl = new ItemStack(Material.GLASS, 1, (byte)6);
            ItemMeta auswahlMeta = auswahl.getItemMeta();
            auswahlMeta.setDisplayName("§aDeine aktuelle auswahl");
            auswahlMeta.setLore(Collections.singletonList("§aEs werden dir nur YouTuber und Teammitglieder angezeigt"));
            auswahl.setItemMeta(auswahlMeta);

            inv.setItem(3, auswahl);

        } else if (Main.getInstance().getNothing_Hider().contains(player)) {

            ItemStack auswahl = new ItemStack(Material.GLASS, 1, (byte) 14);
            ItemMeta auswahlMeta = auswahl.getItemMeta();
            auswahlMeta.setDisplayName("§aDeine aktuelle auswahl");
            auswahlMeta.setLore(Collections.singletonList("§aDu siehst niemanden"));
            auswahl.setItemMeta(auswahlMeta);

            inv.setItem(3, auswahl);

        }

        inv.setItem(0, all);
        inv.setItem(1, yt);
        inv.setItem(2, nothing);

        player.openInventory(inv);

    }

    public static void lobbyselectorInv(Player player) {



    }

}
