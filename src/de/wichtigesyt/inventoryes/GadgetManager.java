package de.wichtigesyt.inventoryes;

import de.wichtigesyt.*;
import de.wichtigesyt.manager.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import java.util.ArrayList;
import java.util.Collections;

public class GadgetManager {

    public static ArrayList<Player> wasser_partikel = new ArrayList<>();
    public static ArrayList<Player> lava_partikel = new ArrayList<>();
    public static ArrayList<Player> tnt_partikel = new ArrayList<>();
    public static ArrayList<Player> herz_partikel = new ArrayList<>();

    public static ArrayList<Player> schuhe_standard = new ArrayList<>();
    public static ArrayList<Player> schuhe_premium = new ArrayList<>();
    public static ArrayList<Player> schuhe_ultra = new ArrayList<>();
    public static ArrayList<Player> schuhe_team = new ArrayList<>();

    public static ArrayList<Player> grappling = new ArrayList<>();
    public static ArrayList<Player> elytra = new ArrayList<>();

    private static MySQLManager mySQLManager = new MySQLManager(Main.mySQL, "gagets");

    public static void gadgetInv(Player player) {

        player.closeInventory();

        Inventory inv = Bukkit.createInventory(null, 9*3, "§eGadgets");

        ItemStack spielzeug = new ItemStack(Material.FISHING_ROD);
        ItemMeta spielzeugMeta = spielzeug.getItemMeta();
        spielzeugMeta.setDisplayName("§dSpielzeuge");
        spielzeugMeta.setLore(Collections.singletonList("§aHier kannst du dir Gadgets/Spielzeuge auswählen"));
        spielzeug.setItemMeta(spielzeugMeta);

        ItemStack kopfe = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta kopfeMeta = (SkullMeta) kopfe.getItemMeta();
        kopfeMeta.setDisplayName("§3Köpfe");
        kopfeMeta.setOwner(player.getName());
        kopfeMeta.setLore(Collections.singletonList("§aHier kannst du dir Köpfe von Teammitglieder aufsetzen"));
        kopfe.setItemMeta(kopfeMeta);

        ItemStack partikel = new ItemStack(Material.FIREWORK_CHARGE);
        ItemMeta partikelMeta = partikel.getItemMeta();
        partikelMeta.setDisplayName("§bPartikel");
        partikelMeta.setLore(Collections.singletonList("§aHier kannst du dir Partikel hinterher fliegen lassen"));
        partikel.setItemMeta(partikelMeta);

        ItemStack schuhe = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta schuhe_meta = schuhe.getItemMeta();
        schuhe_meta.setDisplayName("§5Schuhe");
        schuhe_meta.setLore(Collections.singletonList("§aHier kannst du dir Schuhe anziehen"));
        schuhe.setItemMeta(schuhe_meta);

        inv.setItem(10, kopfe);
        inv.setItem(12, spielzeug);
        inv.setItem(14, partikel);
        inv.setItem(16, schuhe);

        player.openInventory(inv);

    }

    public static void gadget_kopfInv(Player player) {

        player.closeInventory();

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

    public static void gadget_gadgetInv(Player player) {

        player.closeInventory();

        Inventory inv = Bukkit.createInventory(null, 9*3, "§dSpielzeuge");

        getGrappling(player, inv);

        getElytra(player, inv);

        ItemStack delete = new ItemStack(Material.BARRIER);
        ItemMeta deleteMeta = delete.getItemMeta();
        deleteMeta.setDisplayName("§cLösche dein Gadget");
        delete.setItemMeta(deleteMeta);

        inv.setItem(26, delete);

        player.openInventory(inv);

    }

    public static void gadget_partikelInv(Player player) {

        player.closeInventory();

        Inventory inv = Bukkit.createInventory(null, 9*3, "§bPartikel");

        getWaterPartikel(player, inv);

        getTNTPartikel(player, inv);

        getHerzParikel(player, inv);

        getLavaPartikel(player, inv);

        ItemStack delete = new ItemStack(Material.BARRIER);
        ItemMeta deleteMeta = delete.getItemMeta();
        deleteMeta.setDisplayName("§cLösche deine Partikel");
        delete.setItemMeta(deleteMeta);

        inv.setItem(26, delete);

        player.openInventory(inv);

    }

    public static void gadget_schuheInv(Player player) {

        player.closeInventory();

        Inventory inv = Bukkit.createInventory(null, 9*3, "§bSchuhe");

        getDefaultSchuhe(player, inv);

        getPremiumSchuhe(player, inv);

        getUltraSchuhe(player, inv);

        getTeamSchuhe(player, inv);

        ItemStack loeschen = new ItemStack(Material.BARRIER);
        ItemMeta loeschen_meta = loeschen.getItemMeta();
        loeschen_meta.setDisplayName("§cZiehe deine Schuhe wieder aus");
        loeschen.setItemMeta(loeschen_meta);

        inv.setItem(26, loeschen);

        player.openInventory(inv);

    }

    public static void getElytra(Player player, Inventory inv) {
        
        if (mySQLManager.getGadget(player, "gadget_elytra").equalsIgnoreCase("false")) {

            ItemStack item = new ItemStack(Material.ELYTRA);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§bElytra Gadget §7➤ §cNicht gekauft");
            item_meta.setLore(Collections.singletonList("§6Preis: 5.000"));
            item.setItemMeta(item_meta);
            
            inv.setItem(14, item);

        } else if (mySQLManager.getGadget(player, "gadget_elytra").equalsIgnoreCase("true")) {

            ItemStack item = new ItemStack(Material.ELYTRA);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§bElytra Gadget §7➤ §cDeaktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(14, item);
            
        } else if (mySQLManager.getGadget(player, "gadget_elytra").equalsIgnoreCase("aktive")) {

            ItemStack item = new ItemStack(Material.ELYTRA);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§bElytra Gadget §7➤ §aAktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(14, item);

        }

    }

    public static void getGrappling(Player player, Inventory inv) {

        if (mySQLManager.getGadget(player, "gadget_grappling").equalsIgnoreCase("true")) {

            ItemStack item = new ItemStack(Material.FISHING_ROD);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§bGrappling Hook §7➤ §cDeaktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(12, item);

        } else if (mySQLManager.getGadget(player, "gadget_grappling").equalsIgnoreCase("aktive")) {

            ItemStack item = new ItemStack(Material.FISHING_ROD);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§bGrappling Hook §7➤ §aAktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(12, item);

        }

    }
    
    public static void getTNTPartikel(Player player, Inventory inv) {

        if (mySQLManager.getGadget(player, "partikel_tnt").equalsIgnoreCase("false")) {

            ItemStack item = new ItemStack(Material.TNT);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§cTNT Partikel §7➤ §cNicht gekauft");
            item_meta.setLore(Collections.singletonList("§6Preis: 1.000"));
            item.setItemMeta(item_meta);

            inv.setItem(12, item);

        } else if (mySQLManager.getGadget(player, "partikel_tnt").equalsIgnoreCase("true")) {

            ItemStack item = new ItemStack(Material.TNT);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§cTNT Partikel §7➤ §cDeaktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(12, item);

        } else if (mySQLManager.getGadget(player, "partikel_tnt").equalsIgnoreCase("aktive")) {

            ItemStack item = new ItemStack(Material.TNT);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§cTNT Partikel §7➤ §aAktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(12, item);

        }
        
    }

    public static void getHerzParikel(Player player, Inventory inv) {

        if (mySQLManager.getGadget(player, "partikel_herz").equalsIgnoreCase("false")) {

            ItemStack item = new ItemStack(Material.BED);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§4Herz Partikel §7➤ §cNicht gekauft");
            item_meta.setLore(Collections.singletonList("§6Preis: 1.000"));
            item.setItemMeta(item_meta);

            inv.setItem(14, item);

        } else if (mySQLManager.getGadget(player, "partikel_herz").equalsIgnoreCase("true")) {

            ItemStack item = new ItemStack(Material.BED);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§4Herz Partikel §7➤ §cDeaktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(14, item);

        } else if (mySQLManager.getGadget(player, "partikel_herz").equalsIgnoreCase("aktive")) {

            ItemStack item = new ItemStack(Material.BED);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§4Herz Partikel §7➤ §aAktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(14, item);

        }

    }

    public static void getLavaPartikel(Player player, Inventory inv) {

        if (mySQLManager.getGadget(player, "partikel_lava").equalsIgnoreCase("false")) {

            ItemStack item = new ItemStack(Material.LAVA_BUCKET);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§4Lava Partikel §7➤ §cNicht gekauft");
            item_meta.setLore(Collections.singletonList("§6Preis: 1.000"));
            item.setItemMeta(item_meta);

            inv.setItem(16, item);

        } else if (mySQLManager.getGadget(player, "partikel_lava").equalsIgnoreCase("true")) {

            ItemStack item = new ItemStack(Material.LAVA_BUCKET);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§4Lava Partikel §7➤ §cDeaktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(16, item);

        } else if (mySQLManager.getGadget(player, "partikel_lava").equalsIgnoreCase("aktive")) {

            ItemStack item = new ItemStack(Material.LAVA_BUCKET);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§4Lava Partikel §7➤ §aAktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(16, item);

        }

    }

    public static void getWaterPartikel(Player player, Inventory inv) {

        if (mySQLManager.getGadget(player, "partikel_water").equalsIgnoreCase("false")) {

            ItemStack item = new ItemStack(Material.WATER_BUCKET);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§3Wasser Partikel §7➤ §cNicht gekauft");
            item_meta.setLore(Collections.singletonList("§6Preis: 1.000"));
            item.setItemMeta(item_meta);

            inv.setItem(10, item);

        } else if (mySQLManager.getGadget(player, "partikel_water").equalsIgnoreCase("true")) {

            ItemStack item = new ItemStack(Material.WATER_BUCKET);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§3Wasser Partikel §7➤ §cDeaktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(10, item);

        } else if (mySQLManager.getGadget(player, "partikel_water").equalsIgnoreCase("aktive")) {

            ItemStack item = new ItemStack(Material.WATER_BUCKET);
            ItemMeta item_meta = item.getItemMeta();
            item_meta.setDisplayName("§3Wasser Partikel §7➤ §aAktiviert");
            item.setItemMeta(item_meta);

            inv.setItem(10, item);

        }

    }

    public static void getDefaultSchuhe(Player player, Inventory inv) {

        if (mySQLManager.getGadget(player, "schuhe_standard").equalsIgnoreCase("true")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§7Standard Schuhe §7➤ §cDeaktiviert");
            item_meta.setColor(Color.GRAY);
            item.setItemMeta(item_meta);

            inv.setItem(10, item);

        } else if (mySQLManager.getGadget(player, "schuhe_standard").equalsIgnoreCase("aktive")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§7Standard Schuhe §7➤ §aAktiviert");
            item_meta.setColor(Color.GRAY);
            item.setItemMeta(item_meta);

            inv.setItem(10, item);

        }

    }

    public static void getPremiumSchuhe(Player player, Inventory inv) {

        if (mySQLManager.getGadget(player, "schuhe_premium").equalsIgnoreCase("false")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§6Premium Schuhe §7➤ §cNicht gekauft");
            item_meta.setColor(Color.ORANGE);
            item_meta.setLore(Collections.singletonList("§6Preis: 1.000"));
            item.setItemMeta(item_meta);

            inv.setItem(12, item);

        } else if (mySQLManager.getGadget(player, "schuhe_premium").equalsIgnoreCase("true")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§6Premium Schuhe §7➤ §cDeaktiviert");
            item_meta.setColor(Color.ORANGE);
            item.setItemMeta(item_meta);

            inv.setItem(12, item);

        } else if (mySQLManager.getGadget(player, "schuhe_premium").equalsIgnoreCase("aktive")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§6Premium Schuhe §7➤ §aAktiviert");
            item_meta.setColor(Color.ORANGE);
            item.setItemMeta(item_meta);

            inv.setItem(12, item);

        }

    }

    public static void getUltraSchuhe(Player player, Inventory inv) {

        if (mySQLManager.getGadget(player, "schuhe_ultra").equalsIgnoreCase("false")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§3Ultra Schuhe §7➤ §cNicht gekauft");
            item_meta.setColor(Color.AQUA);
            item_meta.setLore(Collections.singletonList("§6Preis: 1.000"));
            item.setItemMeta(item_meta);

            inv.setItem(14, item);

        } else if (mySQLManager.getGadget(player, "schuhe_ultra").equalsIgnoreCase("true")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§3Ultra Schuhe §7➤ §cDeaktiviert");
            item_meta.setColor(Color.AQUA);
            item.setItemMeta(item_meta);

            inv.setItem(14, item);

        } else if (mySQLManager.getGadget(player, "schuhe_ultra").equalsIgnoreCase("aktive")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§3Ultra Schuhe §7➤ §aAktiviert");
            item_meta.setColor(Color.AQUA);
            item.setItemMeta(item_meta);

            inv.setItem(14, item);

        }

    }

    public static void getTeamSchuhe(Player player, Inventory inv) {

        if (mySQLManager.getGadget(player, "schuhe_team").equalsIgnoreCase("false")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§cTeam Schuhe §7➤ §cNicht gekauft");
            item_meta.setColor(Color.RED);
            item_meta.setLore(Collections.singletonList("§6Preis: 1.000 und du must im Team sein"));
            item.setItemMeta(item_meta);

            inv.setItem(16, item);

        } else if (mySQLManager.getGadget(player, "schuhe_team").equalsIgnoreCase("true")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§cTeam Schuhe §7➤ §cDeaktiviert");
            item_meta.setColor(Color.RED);
            item.setItemMeta(item_meta);

            inv.setItem(16, item);

        } else if (mySQLManager.getGadget(player, "schuhe_team").equalsIgnoreCase("aktive")) {

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setDisplayName("§cTeam Schuhe §7➤ §aAktiviert");
            item_meta.setColor(Color.RED);
            item.setItemMeta(item_meta);

            inv.setItem(16, item);

        }

    }

    public static void clickWasser(Player player) {

        player.closeInventory();

        if (!wasser_partikel.contains(player)) {

            wasser_partikel.add(player);

            mySQLManager.setGadget(player, "partikel_water", "aktive");

        }
        if (herz_partikel.contains(player)) {

            herz_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_herz", "true");

        }
        if (tnt_partikel.contains(player)) {

            tnt_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_tnt", "true");

        }
        if (lava_partikel.contains(player)) {

            lava_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_lava", "true");

        }

    }

    public static void clickLava(Player player) {

        player.closeInventory();

        if (wasser_partikel.contains(player)) {

            wasser_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_water", "true");

        }
        if (herz_partikel.contains(player)) {

            herz_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_herz", "true");

        }
        if (tnt_partikel.contains(player)) {

            tnt_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_tnt", "true");

        }
        if (!lava_partikel.contains(player)) {

            lava_partikel.add(player);

            mySQLManager.setGadget(player, "partikel_lava", "aktive");

        }

    }

    public static void clickTnt(Player player) {

        player.closeInventory();

        if (wasser_partikel.contains(player)) {

            wasser_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_water", "true");

        }
        if (herz_partikel.contains(player)) {

            herz_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_herz", "true");

        }
        if (!tnt_partikel.contains(player)) {

            tnt_partikel.add(player);

            mySQLManager.setGadget(player, "partikel_tnt", "aktive");

        }
        if (lava_partikel.contains(player)) {

            lava_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_lava", "true");

        }

    }

    public static void clickHerz(Player player) {

        player.closeInventory();

        if (wasser_partikel.contains(player)) {

            wasser_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_water", "true");

        }
        if (!herz_partikel.contains(player)) {

            herz_partikel.add(player);

            mySQLManager.setGadget(player, "partikel_herz", "aktive");

        }
        if (tnt_partikel.contains(player)) {

            tnt_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_tnt", "true");

        }
        if (lava_partikel.contains(player)) {

            lava_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_lava", "true");

        }

    }

    public static void removePartikel(Player player) {

        player.closeInventory();

        if (wasser_partikel.contains(player)) {

            wasser_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_water", "true");

        }
        if (herz_partikel.contains(player)) {

            herz_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_herz", "true");

        }
        if (tnt_partikel.contains(player)) {

            tnt_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_tnt", "true");

        }
        if (lava_partikel.contains(player)) {

            lava_partikel.remove(player);

            mySQLManager.setGadget(player, "partikel_lava", "true");

        }

    }

    public static void clickStandartdSchuhe(Player player) {

        if (!schuhe_standard.contains(player)) {

            schuhe_standard.add(player);

            mySQLManager.setGadget(player, "schuhe_standard", "aktive");

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setColor(Color.GRAY);
            item.setItemMeta(item_meta);

            player.getInventory().setBoots(item);

        }
        if (schuhe_premium.contains(player)) {

            schuhe_premium.remove(player);

            mySQLManager.setGadget(player, "schuhe_premium", "true");

            player.getInventory().setBoots(null);

        }
        if (schuhe_ultra.contains(player)) {

            schuhe_ultra.remove(player);

            mySQLManager.setGadget(player, "schuhe_ultra", "true");

            player.getInventory().setBoots(null);

        }
        if (schuhe_team.contains(player)) {

            schuhe_team.remove(player);

            mySQLManager.setGadget(player, "schuhe_team", "true");

            player.getInventory().setBoots(null);

        }

    }

    public static void clickPremiumSchuhe(Player player) {

        if (schuhe_standard.contains(player)) {

            schuhe_standard.remove(player);

            mySQLManager.setGadget(player, "schuhe_standard", "true");

            player.getInventory().setBoots(null);

        }
        if (!schuhe_premium.contains(player)) {

            schuhe_premium.add(player);

            mySQLManager.setGadget(player, "schuhe_premium", "aktive");

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setColor(Color.ORANGE);
            item.setItemMeta(item_meta);

            player.getInventory().setBoots(item);

        }
        if (schuhe_ultra.contains(player)) {

            schuhe_ultra.remove(player);

            mySQLManager.setGadget(player, "schuhe_ultra", "true");

            player.getInventory().setBoots(null);

        }
        if (schuhe_team.contains(player)) {

            schuhe_team.remove(player);

            mySQLManager.setGadget(player, "schuhe_team", "true");

            player.getInventory().setBoots(null);

        }

    }

    public static void clickUltraSchuhe(Player player) {

        if (schuhe_standard.contains(player)) {

            schuhe_standard.remove(player);

            mySQLManager.setGadget(player, "schuhe_standard", "true");

            player.getInventory().setBoots(null);

        }
        if (schuhe_premium.contains(player)) {

            schuhe_premium.remove(player);

            mySQLManager.setGadget(player, "schuhe_premium", "true");

            player.getInventory().setBoots(null);

        }
        if (!schuhe_ultra.contains(player)) {

            schuhe_ultra.add(player);

            mySQLManager.setGadget(player, "schuhe_ultra", "aktive");

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setColor(Color.AQUA);
            item.setItemMeta(item_meta);

            player.getInventory().setBoots(item);

        }
        if (schuhe_team.contains(player)) {

            schuhe_team.remove(player);

            mySQLManager.setGadget(player, "schuhe_team", "true");

            player.getInventory().setBoots(null);

        }

    }

    public static void clickTeamSchuhe(Player player) {

        if (schuhe_standard.contains(player)) {

            schuhe_standard.remove(player);

            mySQLManager.setGadget(player, "schuhe_standard", "true");

            player.getInventory().setBoots(null);

        }
        if (schuhe_premium.contains(player)) {

            schuhe_premium.remove(player);

            mySQLManager.setGadget(player, "schuhe_premium", "true");

            player.getInventory().setBoots(null);

        }
        if (schuhe_ultra.contains(player)) {

            schuhe_ultra.remove(player);

            mySQLManager.setGadget(player, "schuhe_ultra", "true");

            player.getInventory().setBoots(null);

        }
        if (!schuhe_team.contains(player)) {

            schuhe_team.add(player);

            mySQLManager.setGadget(player, "schuhe_team", "aktive");

            ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta item_meta = (LeatherArmorMeta) item.getItemMeta();
            item_meta.setColor(Color.RED);
            item.setItemMeta(item_meta);

            player.getInventory().setBoots(item);

        }

    }

    public static void clickRemoveSchuhe(Player player) {

        if (schuhe_standard.contains(player)) {

            schuhe_standard.remove(player);

            mySQLManager.setGadget(player, "schuhe_standard", "true");

            player.getInventory().setBoots(null);

        }
        if (schuhe_premium.contains(player)) {

            schuhe_premium.remove(player);

            mySQLManager.setGadget(player, "schuhe_premium", "true");

            player.getInventory().setBoots(null);

        }
        if (schuhe_ultra.contains(player)) {

            schuhe_ultra.remove(player);

            mySQLManager.setGadget(player, "schuhe_ultra", "true");

            player.getInventory().setBoots(null);

        }
        if (schuhe_team.contains(player)) {

            schuhe_team.remove(player);

            mySQLManager.setGadget(player, "schuhe_team", "true");

            player.getInventory().setBoots(null);

        }

    }

    public static void giveGrapplingItem(Player player) {

        player.closeInventory();

        ItemStack fish = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishMeta = fish.getItemMeta();
        fishMeta.setDisplayName("§bGrappling Hook");
        fish.setItemMeta(fishMeta);

        player.getInventory().setItem(3, fish);

        grappling.add(player);

        mySQLManager.setGadget(player, "gadget_grappling", "aktive");

    }

    public static void removeGrapplingItem(Player player) {

        if (grappling.contains(player)) {

            player.closeInventory();

            InventoryManager.giveJoinInv(player);

            mySQLManager.setGadget(player, "gadget_grappling", "true");

        }

    }

    public static void giveElytraGadget(Player player) {

        player.closeInventory();

        player.getInventory().setChestplate(new ItemStack(Material.ELYTRA));

        elytra.add(player);

        mySQLManager.setGadget(player, "gadget_elytra", "aktive");

    }

    public static void removeElytraGadget(Player player) {

        if (elytra.contains(player)) {

            elytra.remove(player);

            player.getInventory().setChestplate(null);

            mySQLManager.setGadget(player, "gadget_elytra", "true");

        }

    }

    public static void clickGadgetDelete(Player player) {

        player.closeInventory();

        if (elytra.contains(player)) {

            elytra.remove(player);

            player.getInventory().setChestplate(null);

            InventoryManager.giveJoinInv(player);

            mySQLManager.setGadget(player, "gadget_elytra", "true");

        } else if (grappling.contains(player)) {

            grappling.remove(player);

            InventoryManager.giveJoinInv(player);

            mySQLManager.setGadget(player, "gadget_grappling", "true");

        }

    }

}
