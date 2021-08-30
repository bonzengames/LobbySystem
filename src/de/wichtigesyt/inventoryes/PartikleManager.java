package de.wichtigesyt.inventoryes;

import de.wichtigesyt.Main;
import org.bukkit.entity.Player;

public class PartikleManager {

    public static void clickWasser(Player player) {

        Main.getInstance().getPartikelWasser().add(player);

        player.closeInventory();

    }

    public static void clickLava(Player player) {

        Main.getInstance().getPartikelLava().add(player);

        player.closeInventory();

    }

    public static void clickTnt(Player player) {

        Main.getInstance().getPartikelTnt().add(player);

        player.closeInventory();

    }

    public static void removePartikel(Player player) {

        if (Main.getInstance().getPartikelLava().contains(player)) {

            Main.getInstance().getPartikelLava().remove(player);

        } else if (Main.getInstance().getPartikelWasser().contains(player)) {

            Main.getInstance().getPartikelWasser().remove(player);

        } else if (Main.getInstance().getPartikelTnt().contains(player)) {

            Main.getInstance().getPartikelTnt().remove(player);

        }

        player.closeInventory();

    }

}
