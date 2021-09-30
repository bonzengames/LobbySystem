package de.wichtigesyt.inventoryes.listeners;

import de.wichtigesyt.Main;
import de.wichtigesyt.inventoryes.GadgetManager;
import de.wichtigesyt.inventoryes.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if (player.getItemInHand() == null) {

            event.setCancelled(true);

        } else if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bTeleporter")) {

                event.setCancelled(true);

                InventoryManager.compassInv(player);

            }
            if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Profil")) {

                event.setCancelled(true);

                InventoryManager.profilInv(player);

            }
            if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eGadgets")) {

                event.setCancelled(true);

                GadgetManager.gadgetInv(player);

            }
            if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cSpieler Verstecker")) {

                event.setCancelled(true);

                InventoryManager.hide_toolinv(player);

            }
            /*if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Lobby Selector")) {

                event.setCancelled(true);

                InventoryManager.lobbyselectorInv(player);

            }*/

        }

    }

}
