package de.wichtigesyt.inventoryes;

import de.wichtigesyt.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullManager {

    public static void clickWichtigesYT(Player player) {

        ItemStack wichtigesyt = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta wichtigesytmeta = (SkullMeta) wichtigesyt.getItemMeta();
        wichtigesytmeta.setOwner(Main.getInstance().kopfOneUsername);
        wichtigesytmeta.setDisplayName(Main.getInstance().kopfOneDisplayname);
        wichtigesyt.setItemMeta(wichtigesytmeta);

        player.getInventory().setHelmet(wichtigesyt);

        player.closeInventory();

    }

    public static void clickjoshi(Player player) {

        ItemStack wichtigesyt = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta wichtigesytmeta = (SkullMeta) wichtigesyt.getItemMeta();
        wichtigesytmeta.setOwner(Main.getInstance().kopfTwoUsername);
        wichtigesytmeta.setDisplayName(Main.getInstance().kopfTwoDisplayname);
        wichtigesyt.setItemMeta(wichtigesytmeta);

        player.getInventory().setHelmet(wichtigesyt);

        player.closeInventory();

    }

    public static void clickGremgom(Player player) {

        ItemStack wichtigesyt = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta wichtigesytmeta = (SkullMeta) wichtigesyt.getItemMeta();
        wichtigesytmeta.setOwner(Main.getInstance().kopfThreeUsername);
        wichtigesytmeta.setDisplayName(Main.getInstance().kopfThreeDisplayname);
        wichtigesyt.setItemMeta(wichtigesytmeta);

        player.getInventory().setHelmet(wichtigesyt);

        player.closeInventory();

    }

    public static void clickEnte(Player player) {

        ItemStack wichtigesyt = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta wichtigesytmeta = (SkullMeta) wichtigesyt.getItemMeta();
        wichtigesytmeta.setOwner(Main.getInstance().kopfFourUsername);
        wichtigesytmeta.setDisplayName(Main.getInstance().kopfFourDisplayname);
        wichtigesyt.setItemMeta(wichtigesytmeta);

        player.getInventory().setHelmet(wichtigesyt);

        player.closeInventory();

    }

    public static void clickrobert(Player player) {

        ItemStack wichtigesyt = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta wichtigesytmeta = (SkullMeta) wichtigesyt.getItemMeta();
        wichtigesytmeta.setOwner(Main.getInstance().kopfFiveUsername);
        wichtigesytmeta.setDisplayName(Main.getInstance().kopfFiveDisplayname);
        wichtigesyt.setItemMeta(wichtigesytmeta);

        player.getInventory().setHelmet(wichtigesyt);

        player.closeInventory();

    }

    public static void clickjulian(Player player) {

        ItemStack wichtigesyt = new ItemStack(Material.SKULL_ITEM ,1, (byte) 3);
        SkullMeta wichtigesytmeta = (SkullMeta) wichtigesyt.getItemMeta();
        wichtigesytmeta.setOwner(Main.getInstance().kopfSixUsername);
        wichtigesytmeta.setDisplayName(Main.getInstance().kopfSixDisplayname);
        wichtigesyt.setItemMeta(wichtigesytmeta);

        player.getInventory().setHelmet(wichtigesyt);

        player.closeInventory();

    }

}
