package de.wichtigesyt.shop;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class ShopManager {

    private static Villager villager;

    public static void spawnVillager(Player player) {

        World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("Villager.world"));
        double x = Main.getInstance().getConfig().getDouble("Villager.X");
        double y = Main.getInstance().getConfig().getDouble("Villager.Y");
        double z = Main.getInstance().getConfig().getDouble("Villager.Z");

        Location loc = new Location(world, x, y, z);

        villager = (Villager) world.spawnEntity(loc, EntityType.VILLAGER);
        villager.setCustomName("§cRang Shop");

    }

    public static void clickVillager(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§cRang Shop");

        ItemStack premium = new ItemStack(Material.GOLD_INGOT);
        ItemMeta premiumMeta = premium.getItemMeta();
        premiumMeta.setDisplayName("§6Premium Rang");
        premiumMeta.setLore(Collections.singletonList("Klicke um die Dauer aus zu wählen"));
        premium.setItemMeta(premiumMeta);

        ItemStack upgardes = new ItemStack(Material.BEACON);
        ItemMeta upgradesMeta = upgardes.getItemMeta();
        upgradesMeta.setDisplayName("§eRang Upgrades");
        upgradesMeta.setLore(Collections.singletonList("Kaufe dir ein Rang Upgrade"));
        upgardes.setItemMeta(upgradesMeta);

        ItemStack ultra = new ItemStack(Material.DIAMOND);
        ItemMeta ultraMeta = ultra.getItemMeta();
        ultraMeta.setDisplayName("§3Ultra Rang");
        ultraMeta.setLore(Collections.singletonList("Klicke um die Dauer aus zu wählen"));
        ultra.setItemMeta(ultraMeta);

        inv.setItem(11, premium);
        inv.setItem(15, ultra);

        player.openInventory(inv);

    }

    public static void clickPremium(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§6Premium Rang");

        ItemStack one = new ItemStack(Material.GOLD_INGOT);
        ItemMeta oneMeta = one.getItemMeta();
        oneMeta.setDisplayName("§61 Monat Premium");
        oneMeta.setLore(Collections.singletonList("§6Preis: 1.000"));
        one.setItemMeta(oneMeta);

        ItemStack drei = new ItemStack(Material.GOLD_INGOT);
        ItemMeta dreiMeta = drei.getItemMeta();
        dreiMeta.setDisplayName("§63 Monat Premium");
        dreiMeta.setLore(Collections.singletonList("§6Preis: 2.500"));
        drei.setItemMeta(dreiMeta);

        ItemStack sechs = new ItemStack(Material.GOLD_INGOT);
        ItemMeta sechsMeta = sechs.getItemMeta();
        sechsMeta.setDisplayName("§66 Monat Premium");
        sechsMeta.setLore(Collections.singletonList("§6Preis: 4.500"));
        sechs.setItemMeta(sechsMeta);

        ItemStack livetime = new ItemStack(Material.GOLD_INGOT);
        ItemMeta livetimeMeta = livetime.getItemMeta();
        livetimeMeta.setDisplayName("§6Lifetime Premium");
        livetimeMeta.setLore(Collections.singletonList("§6Preis: 10.000"));
        livetime.setItemMeta(livetimeMeta);

        inv.setItem(10, one);
        inv.setItem(12, drei);
        inv.setItem(14, sechs);
        inv.setItem(16, livetime);

        player.openInventory(inv);

    }

    public static void clickUltra(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§3Ultra Rang");

        ItemStack one = new ItemStack(Material.DIAMOND);
        ItemMeta oneMeta = one.getItemMeta();
        oneMeta.setDisplayName("§31 Monat Ultra");
        oneMeta.setLore(Collections.singletonList("§3Preis: 2.000"));
        one.setItemMeta(oneMeta);

        ItemStack drei = new ItemStack(Material.DIAMOND);
        ItemMeta dreiMeta = drei.getItemMeta();
        dreiMeta.setDisplayName("§33 Monat Ultra");
        dreiMeta.setLore(Collections.singletonList("§3Preis: 5.500"));
        drei.setItemMeta(dreiMeta);

        ItemStack sechs = new ItemStack(Material.DIAMOND);
        ItemMeta sechsMeta = sechs.getItemMeta();
        sechsMeta.setDisplayName("§36 Monat Ultra");
        sechsMeta.setLore(Collections.singletonList("§3Preis: 10.500"));
        sechs.setItemMeta(sechsMeta);

        ItemStack livetime = new ItemStack(Material.DIAMOND);
        ItemMeta livetimeMeta = livetime.getItemMeta();
        livetimeMeta.setDisplayName("§3Lifetime Ultra");
        livetimeMeta.setLore(Collections.singletonList("§3Preis: 20.000"));
        livetime.setItemMeta(livetimeMeta);

        inv.setItem(10, one);
        inv.setItem(12, drei);
        inv.setItem(14, sechs);
        inv.setItem(16, livetime);

        player.openInventory(inv);

    }

    public static void clickUpgrade(){



    }

    public static void onePremium(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§61 Monat Premium");

        ItemStack ja = new ItemStack(Material.GLASS, 1, (byte)13);
        ItemMeta jaMeta = ja.getItemMeta();
        jaMeta.setDisplayName("§aJa");
        jaMeta.setLore(Collections.singletonList("§aBezahle 1.000 Coins"));
        ja.setItemMeta(jaMeta);

        ItemStack nein = new ItemStack(Material.GLASS, 1, (byte)14);
        ItemMeta neinMeta = nein.getItemMeta();
        neinMeta.setDisplayName("§cNein");
        neinMeta.setLore(Collections.singletonList("§cIch möchte den Kauf abbrechen"));
        nein.setItemMeta(neinMeta);

        inv.setItem(11, ja);
        inv.setItem(15, nein);

        player.openInventory(inv);

    }

    public static void dreiPremium(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§63 Monat Premium");

        ItemStack ja = new ItemStack(Material.GLASS, 1, (byte)13);
        ItemMeta jaMeta = ja.getItemMeta();
        jaMeta.setDisplayName("§aJa");
        jaMeta.setLore(Collections.singletonList("§aBezahle 2.500 Coins"));
        ja.setItemMeta(jaMeta);

        ItemStack nein = new ItemStack(Material.GLASS, 1, (byte)14);
        ItemMeta neinMeta = nein.getItemMeta();
        neinMeta.setDisplayName("§cNein");
        neinMeta.setLore(Collections.singletonList("§cIch möchte den Kauf abbrechen"));
        nein.setItemMeta(neinMeta);

        inv.setItem(11, ja);
        inv.setItem(15, nein);

        player.openInventory(inv);

    }

    public static void sechsPremium(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§66 Monat Premium");

        ItemStack ja = new ItemStack(Material.GLASS, 1, (byte)13);
        ItemMeta jaMeta = ja.getItemMeta();
        jaMeta.setDisplayName("§aJa");
        jaMeta.setLore(Collections.singletonList("§aBezahle 4.500 Coins"));
        ja.setItemMeta(jaMeta);

        ItemStack nein = new ItemStack(Material.GLASS, 1, (byte)14);
        ItemMeta neinMeta = nein.getItemMeta();
        neinMeta.setDisplayName("§cNein");
        neinMeta.setLore(Collections.singletonList("§cIch möchte den Kauf abbrechen"));
        nein.setItemMeta(neinMeta);

        inv.setItem(11, ja);
        inv.setItem(15, nein);

        player.openInventory(inv);

    }

    public static void livetimePremium(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§6Lifetime Premium");

        ItemStack ja = new ItemStack(Material.GLASS, 1, (byte)13);
        ItemMeta jaMeta = ja.getItemMeta();
        jaMeta.setDisplayName("§aJa");
        jaMeta.setLore(Collections.singletonList("§aBezahle 10.000 Coins"));
        ja.setItemMeta(jaMeta);

        ItemStack nein = new ItemStack(Material.GLASS, 1, (byte)14);
        ItemMeta neinMeta = nein.getItemMeta();
        neinMeta.setDisplayName("§cNein");
        neinMeta.setLore(Collections.singletonList("§cIch möchte den Kauf abbrechen"));
        nein.setItemMeta(neinMeta);

        inv.setItem(11, ja);
        inv.setItem(15, nein);

        player.openInventory(inv);

    }

    public static void oneUltra(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§31 Monat Ultra");

        ItemStack ja = new ItemStack(Material.GLASS, 1, (byte)13);
        ItemMeta jaMeta = ja.getItemMeta();
        jaMeta.setDisplayName("§aJa");
        jaMeta.setLore(Collections.singletonList("§aBezahle 2.000 Coins"));
        ja.setItemMeta(jaMeta);

        ItemStack nein = new ItemStack(Material.GLASS, 1, (byte)14);
        ItemMeta neinMeta = nein.getItemMeta();
        neinMeta.setDisplayName("§cNein");
        neinMeta.setLore(Collections.singletonList("§cIch möchte den Kauf abbrechen"));
        nein.setItemMeta(neinMeta);

        inv.setItem(11, ja);
        inv.setItem(15, nein);

        player.openInventory(inv);

    }

    public static void dreiUltra(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§33 Monat Ultra");

        ItemStack ja = new ItemStack(Material.GLASS, 1, (byte)13);
        ItemMeta jaMeta = ja.getItemMeta();
        jaMeta.setDisplayName("§aJa");
        jaMeta.setLore(Collections.singletonList("§aBezahle 5.500 Coins"));
        ja.setItemMeta(jaMeta);

        ItemStack nein = new ItemStack(Material.GLASS, 1, (byte)14);
        ItemMeta neinMeta = nein.getItemMeta();
        neinMeta.setDisplayName("§cNein");
        neinMeta.setLore(Collections.singletonList("§cIch möchte den Kauf abbrechen"));
        nein.setItemMeta(neinMeta);

        inv.setItem(11, ja);
        inv.setItem(15, nein);

        player.openInventory(inv);

    }

    public static void sechsUltra(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§36 Monat Ultra");

        ItemStack ja = new ItemStack(Material.GLASS, 1, (byte)13);
        ItemMeta jaMeta = ja.getItemMeta();
        jaMeta.setDisplayName("§aJa");
        jaMeta.setLore(Collections.singletonList("§aBezahle 10.500 Coins"));
        ja.setItemMeta(jaMeta);

        ItemStack nein = new ItemStack(Material.GLASS, 1, (byte)14);
        ItemMeta neinMeta = nein.getItemMeta();
        neinMeta.setDisplayName("§cNein");
        neinMeta.setLore(Collections.singletonList("§cIch möchte den Kauf abbrechen"));
        nein.setItemMeta(neinMeta);

        inv.setItem(11, ja);
        inv.setItem(15, nein);

        player.openInventory(inv);

    }

    public static void livetimeUltra(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*3, "§3Lifetime Ultra");

        ItemStack ja = new ItemStack(Material.GLASS, 1, (byte)13);
        ItemMeta jaMeta = ja.getItemMeta();
        jaMeta.setDisplayName("§aJa");
        jaMeta.setLore(Collections.singletonList("§aBezahle 20.000 Coins"));
        ja.setItemMeta(jaMeta);

        ItemStack nein = new ItemStack(Material.GLASS, 1, (byte)14);
        ItemMeta neinMeta = nein.getItemMeta();
        neinMeta.setDisplayName("§cNein");
        neinMeta.setLore(Collections.singletonList("§cIch möchte den Kauf abbrechen"));
        nein.setItemMeta(neinMeta);

        inv.setItem(11, ja);
        inv.setItem(15, nein);

        player.openInventory(inv);

    }

}
