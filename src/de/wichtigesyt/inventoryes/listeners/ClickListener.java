package de.wichtigesyt.inventoryes.listeners;


import de.wichtigesyt.Main;
import de.wichtigesyt.inventoryes.InventoryManager;
import de.wichtigesyt.inventoryes.ItemManager;
import de.wichtigesyt.inventoryes.PartikleManager;
import de.wichtigesyt.inventoryes.SkullManager;
import de.wichtigesyt.shop.DailyLoginReward;
import de.wichtigesyt.shop.ShopManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.concurrent.TimeUnit;

import static de.wichtigesyt.Main.dailyLoginReward;

public class ClickListener implements Listener {

    private String noCoins = Main.getInstance().prefix + "§cDu hast nicht genügend coins";

    @EventHandler
    public boolean onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (!Main.getInstance().getBuilders().contains(player)) {

            if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getCurrentItem().getItemMeta().getDisplayName() != null) {

                event.setCancelled(true);

                if (event.getInventory().getName().equalsIgnoreCase("§bTeleporter")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Nether")) {

                        ItemManager.clickCityBuild(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSpawn")) {

                        ItemManager.clickSpawn(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fCityBuild")) {

                        ItemManager.clickCores(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFarmwelt")) {

                        ItemManager.clickSkyBlock(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Survival")) {

                        ItemManager.clickGunGame(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4In Entwicklung")) {

                        ItemManager.clickCommingSoon(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dEvent")) {

                        ItemManager.clickEvent(player);

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§6Profil")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFreunde")) {

                        player.performCommand("/friend list");

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRang Shop")) {

                        player.closeInventory();

                        ShopManager.clickVillager(player);

                    }
                } else if (event.getInventory().getName().equalsIgnoreCase("§eGadgets")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dSpielzeuge")) {

                        ItemManager.clickSpielzeug(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Köpfe")) {

                        ItemManager.clickKoepf(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPartikel")) {

                        ItemManager.clickPartikel(player);

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§dSpielzeuge")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGrappling Hook")) {

                        ItemManager.clickFish(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cLösche dein Gadget")) {

                        ItemManager.clickGadgetDelete(player);

                    }


                } else if (event.getInventory().getName().equalsIgnoreCase("§3Köpfe")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.getInstance().kopfOneDisplayname)) {

                        SkullManager.clickWichtigesYT(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.getInstance().kopfTwoDisplayname)) {

                        SkullManager.clickjoshi(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.getInstance().kopfThreeDisplayname)) {

                        SkullManager.clickGremgom(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.getInstance().kopfFourDisplayname)) {

                        SkullManager.clickEnte(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.getInstance().kopfFiveDisplayname)) {

                        SkullManager.clickrobert(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.getInstance().kopfSixDisplayname)) {

                        SkullManager.clickjulian(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cLösche dein Kopf")) {

                        player.closeInventory();

                        player.getInventory().setHelmet(null);

                        InventoryManager.giveJoinInv(player);

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§bPartikel")) {


                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Wasser Partikel")) {

                        PartikleManager.clickWasser(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cTNT Partikel")) {

                        PartikleManager.clickTnt(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Lava Partikel")) {

                        PartikleManager.clickLava(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cLösche deine Partikel")) {

                        PartikleManager.removePartikel(player);

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§cSpieler Verstecker")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAlle anzeigen")) {

                        ItemManager.clickAll_Hider(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5YTer/Team anzeigen")) {

                        ItemManager.clickYT_Hider(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cKeinen anzeigen")) {

                        ItemManager.clickNothing_Hider(player);

                    }

                }

            }

        }

        return false;
    }


}
