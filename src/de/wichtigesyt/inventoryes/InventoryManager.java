package de.wichtigesyt.inventoryes;

import de.wichtigesyt.Main;
import net.minecraft.server.v1_12_R1.BlockGlass;
import net.minecraft.server.v1_12_R1.Slot;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class InventoryManager {

    public static void giveJoinInv(Player player) {

        Inventory inv = player.getInventory();
        inv.clear();

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compasMeta = compass.getItemMeta();
        compasMeta.setDisplayName("§bTeleporter");
        compass.setItemMeta(compasMeta);

        /*ItemStack kopf = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta kopfMeta = (SkullMeta) kopf.getItemMeta();
        kopfMeta.setDisplayName("§6Profil");
        kopfMeta.setOwner(player.getName());
        kopf.setItemMeta(kopfMeta);*/

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
        inv.setItem(8, hide_tool);
        inv.setItem(3, noGadget);
        inv.setItem(5, gadget);
        ///inv.setItem(7, lobbyselector);
        ///inv.setItem(8, kopf);

    }

    public static void compassInv(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§bTeleporter");

        ItemStack cityBuild = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta cityBuildMeta = cityBuild.getItemMeta();
        cityBuildMeta.setDisplayName("§2Survival");
        cityBuildMeta.setLore(Collections.singletonList("Teleportiere dich zu Survival."));
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

        ItemStack gunGame = new ItemStack(Material.GRASS);
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

        inv.setItem(1, cores);
        inv.setItem(7, cityBuild);
        inv.setItem(9, comming_soon);
        inv.setItem(11, comming_soon);
        inv.setItem(4, spawn);
        inv.setItem(22, event);
        inv.setItem(15, comming_soon);
        inv.setItem(17, comming_soon);
        inv.setItem(19, skyBlock);
        inv.setItem(25, gunGame);

        player.openInventory(inv);

    }

    /*public static void profilInv(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§6Profil");

        CoinPlayer coinPlayer = CoinSystem.getInstance().getPlayerManager().getPlayer(player.getUniqueId());

        ///NetworkPlayer banPlayer = BanSystem.getInstance().getPlayerManager().getPlayer(player.getUniqueId());

        PermissionPlayer permPlayer = PermissionPlayerManager.getInstance().getPermissionPlayer(player.getUniqueId());

        ItemStack muenzen = new ItemStack(Material.EMERALD);
        ItemMeta muenzenMeta = muenzen.getItemMeta();
        muenzenMeta.setDisplayName("§6Münzen");
        muenzenMeta.setLore(Collections.singletonList("§aDeine Münzen betragen §c" + coinPlayer.getCoins()));
        muenzen.setItemMeta(muenzenMeta);

        ItemStack level = new ItemStack(Material.EXP_BOTTLE);
        ItemMeta levelMeta = level.getItemMeta();
        levelMeta.setDisplayName("§cRang Shop");
        levelMeta.setLore(Collections.singletonList("§aKaufe dir einen Rang mit Ingame Coins"));
        level.setItemMeta(levelMeta);

        ItemStack freund = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta freundMeta = (SkullMeta) freund.getItemMeta();
        freundMeta.setDisplayName("§bFreunde");
        freundMeta.setOwner(player.getName());
        freundMeta.setLore(Collections.singletonList("§aZeige deine Freundes Liste"));
        freund.setItemMeta(freundMeta);

        /*ItemStack onlinetime = new ItemStack(Material.REDSTONE);
        ItemMeta onlinetimeMeta = onlinetime.getItemMeta();
        onlinetimeMeta.setDisplayName("§cOnlinezeit");
        onlinetimeMeta.setLore(Collections.singletonList("§aDeine Onlinezeit beträgt §c" + TimeUnit.MILLISECONDS.toDays(banPlayer.getOnlineTime()) + " Stunden"));
        onlinetime.setItemMeta(onlinetimeMeta);

        ItemStack daily = new ItemStack(Material.DIAMOND);
        ItemMeta dailymeta = daily.getItemMeta();
        dailymeta.setDisplayName("§3Tägliche Belohnung");
        dailymeta.setLore(Collections.singletonList("§aHier kannst du deine Tägliche Belohnung abholen"));
        daily.setItemMeta(dailymeta);

        ItemStack rang = new ItemStack(Material.NAME_TAG);
        ItemMeta rangMeta = rang.getItemMeta();
        rangMeta.setDisplayName("§eRang");
        rangMeta.setLore(Collections.singletonList("§aDein Rang ist§c " + permPlayer.getHighestGroup().getName()));
        rang.setItemMeta(rangMeta);

        inv.setItem(1, muenzen);
        inv.setItem(7, level);
        inv.setItem(13, freund);
        ///inv.setItem(19, onlinetime);
        inv.setItem(19, daily);
        inv.setItem(25, rang);

        player.openInventory(inv);

    }*/

    public static void gadgetInv(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§eGadgets");

        ItemStack spielzeug = new ItemStack(Material.FISHING_ROD);
        ItemMeta spielzeugMeta = spielzeug.getItemMeta();
        spielzeugMeta.setDisplayName("§dSpielzeuge");
        spielzeugMeta.setLore(Collections.singletonList("§aHier kannst du dir Gadgets/Spielzeuge auswählen"));
        spielzeug.setItemMeta(spielzeugMeta);

        ItemStack kopfe = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta kopfeMeta = (SkullMeta) kopfe.getItemMeta();
        kopfeMeta.setDisplayName("§3Köpfe");
        kopfeMeta.setLore(Collections.singletonList("§aHier kannst du dir Köpfe von Teammitglieder aufsetzen"));
        kopfe.setItemMeta(kopfeMeta);

        ItemStack partikel = new ItemStack(Material.FIREWORK_CHARGE);
        ItemMeta partikelMeta = partikel.getItemMeta();
        partikelMeta.setDisplayName("§bPartikel");
        partikelMeta.setLore(Collections.singletonList("§aHier kannst du dir Partikel hinterher fliegen lassen"));
        partikel.setItemMeta(partikelMeta);

        inv.setItem(11, kopfe);
        inv.setItem(15, spielzeug);
        ///inv.setItem(15, partikel);

        player.openInventory(inv);

    }

    public static void gadget_gadgetInv(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§dSpielzeuge");

        ItemStack grapling = new ItemStack(Material.FISHING_ROD);
        ItemMeta grapplingMeta = grapling.getItemMeta();
        grapplingMeta.setDisplayName("§bGrappling Hook");
        grapling.setItemMeta(grapplingMeta);

        ItemStack delete = new ItemStack(Material.BARRIER);
        ItemMeta deleteMeta = delete.getItemMeta();
        deleteMeta.setDisplayName("§cLösche dein Gadget");
        delete.setItemMeta(deleteMeta);

        inv.setItem(13, grapling);
        inv.setItem(26, delete);

        player.openInventory(inv);

    }

    public static void gadget_kopfInv(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§3Köpfe");

        ItemStack WichtigesYT = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta WichtigesYTMeta = (SkullMeta) WichtigesYT.getItemMeta();
        WichtigesYTMeta.setOwner(Main.getInstance().kopfOneUsername);
        WichtigesYTMeta.setDisplayName(Main.getInstance().kopfOneDisplayname);
        WichtigesYT.setItemMeta(WichtigesYTMeta);

        ItemStack Joshi_7 = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta Joshi_7Meta = (SkullMeta) Joshi_7.getItemMeta();
        Joshi_7Meta.setOwner(Main.getInstance().kopfTwoUsername);
        Joshi_7Meta.setDisplayName(Main.getInstance().kopfTwoDisplayname);
        Joshi_7.setItemMeta(Joshi_7Meta);

        ItemStack Gremgom = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta GremgomMeta = (SkullMeta) Gremgom.getItemMeta();
        GremgomMeta.setOwner(Main.getInstance().kopfThreeUsername);
        GremgomMeta.setDisplayName(Main.getInstance().kopfThreeDisplayname);
        Gremgom.setItemMeta(GremgomMeta);

        ItemStack AnonymeEnte8 = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta AnonymeEnte8Meta = (SkullMeta) AnonymeEnte8.getItemMeta();
        AnonymeEnte8Meta.setOwner(Main.getInstance().kopfFourUsername);
        AnonymeEnte8Meta.setDisplayName(Main.getInstance().kopfFourDisplayname);
        AnonymeEnte8.setItemMeta(AnonymeEnte8Meta);

        ItemStack Zocker_Robert = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta Zocker_RobertMeta = (SkullMeta) Zocker_Robert.getItemMeta();
        Zocker_RobertMeta.setOwner(Main.getInstance().kopfFiveUsername);
        Zocker_RobertMeta.setDisplayName(Main.getInstance().kopfFiveDisplayname);
        Zocker_Robert.setItemMeta(Zocker_RobertMeta);

        ItemStack Julian = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta JulianMeta = (SkullMeta) Julian.getItemMeta();
        JulianMeta.setOwner(Main.getInstance().kopfSixUsername);
        JulianMeta.setDisplayName(Main.getInstance().kopfSixDisplayname);
        Julian.setItemMeta(JulianMeta);

        ItemStack delete = new ItemStack(Material.BARRIER);
        ItemMeta deleteMeta = delete.getItemMeta();
        deleteMeta.setDisplayName("§cLösche dein Kopf");
        delete.setItemMeta(deleteMeta);

        inv.setItem(2, Joshi_7);
        inv.setItem(6, WichtigesYT);
        inv.setItem(10, Gremgom);
        inv.setItem(16, AnonymeEnte8);
        inv.setItem(20, Zocker_Robert);
        inv.setItem(24, Julian);
        inv.setItem(26, delete);

        player.openInventory(inv);

    }

    public static void gadget_partikelInv(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§bPartikel");

        ItemStack water = new ItemStack(Material.WATER_BUCKET);
        ItemMeta waterMeta = water.getItemMeta();
        waterMeta.setDisplayName("§3Wasser Partikel");
        water.setItemMeta(waterMeta);

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntMeta = tnt.getItemMeta();
        tntMeta.setDisplayName("§cTNT Partikel");
        tnt.setItemMeta(tntMeta);

        ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta lavaMeta = lava.getItemMeta();
        lavaMeta.setDisplayName("§4Lava Partikel");
        lava.setItemMeta(lavaMeta);

        ItemStack delete = new ItemStack(Material.BARRIER);
        ItemMeta deleteMeta = delete.getItemMeta();
        deleteMeta.setDisplayName("§cLösche deine Partikel");
        delete.setItemMeta(deleteMeta);

        inv.setItem(11, water);
        inv.setItem(13, tnt);
        inv.setItem(15, lava);
        inv.setItem(26, delete);

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
