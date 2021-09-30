package de.wichtigesyt.inventoryes.listeners;


import de.wichtigesyt.Main;
import de.wichtigesyt.inventoryes.GadgetManager;
import de.wichtigesyt.inventoryes.InventoryManager;
import de.wichtigesyt.inventoryes.ItemManager;
import de.wichtigesyt.inventoryes.SkullManager;
import de.wichtigesyt.manager.MySQLManager;
import de.wichtigesyt.shop.ShopManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static de.wichtigesyt.Main.dailyLoginReward;

public class ClickListener implements Listener {

    private String noCoins = Main.getInstance().prefix + "§cDu hast nicht genügend coins";

    public static MySQLManager mySQLManager = new MySQLManager(Main.mySQL, "geld");

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

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSkyBlock")) {

                        ItemManager.clickGunGame(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4In Entwicklung")) {

                        ItemManager.clickCommingSoon(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dEvent")) {

                        ItemManager.clickEvent(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBedWars")) {

                        ItemManager.clickBedWars(player);

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

                } else if (event.getInventory().getName().equalsIgnoreCase("§cSpieler Verstecker")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAlle anzeigen")) {

                        ItemManager.clickAll_Hider(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5YTer/Team anzeigen")) {

                        ItemManager.clickYT_Hider(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cKeinen anzeigen")) {

                        ItemManager.clickNothing_Hider(player);

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§6Profil")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFreunde")) {

                        player.performCommand("/friend list");

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRang Shop")) {

                        player.closeInventory();

                        ShopManager.clickVillager(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Tägliche Belohnung")) {

                        player.closeInventory();

                        if (!dailyLoginReward.getAllowBelohnung(player)) {
                            long current = System.currentTimeMillis();
                            long release = dailyLoginReward.getTime(player);
                            long millis = release - current;
                            player.sendMessage(Main.getInstance().prefix + "§cDu kannst deine tägliche Belohnung in " + dailyLoginReward.getRemainingTime(millis) + " wieder abholen");
                        } else {

                            player.sendMessage(Main.getInstance().prefix + "§aDu hast deine tägliche Belohung erhalten");
                            dailyLoginReward.setBelohnung(player);

                        }

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§cRang Shop")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Premium Rang")) {

                        ShopManager.clickPremium(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Ultra Rang")) {

                        ShopManager.clickUltra(player);

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§6Premium Rang")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§61 Monat Premium")) {

                        ShopManager.onePremium(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§63 Monat Premium")) {

                        ShopManager.dreiPremium(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§66 Monat Premium")) {

                        ShopManager.sechsPremium(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Lifetime Premium")) {

                        ShopManager.livetimePremium(player);

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§3Ultra Rang")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§31 Monat Ultra")) {

                        ShopManager.oneUltra(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("363 Monat Ultra")) {

                        ShopManager.dreiUltra(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§36 Monat Ultra")) {

                        ShopManager.sechsUltra(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Lifetime Ultra")) {

                        ShopManager.livetimeUltra(player);

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§61 Monat Premium")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {

                        player.closeInventory();

                        if (mySQLManager.getMoney(player, "geld") != "1000") {

                            mySQLManager.removeMoney(player, "geld", 1000);

                            Bukkit.dispatchCommand(player, "lp user " + player.getName() + " parent addtemp Premium 30D");

                            player.sendMessage(Main.instance.prefix + "Du hast nun den Premium rang für ein Monat");

                        } else {

                            player.sendMessage(noCoins);

                        }

                        player.closeInventory();

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {

                        player.closeInventory();

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§63 Monat Premium")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {

                        player.closeInventory();

                        if (mySQLManager.getMoney(player, "geld") != "2500") {

                            mySQLManager.removeMoney(player, "geld", 2500);

                            Bukkit.dispatchCommand(player, "lp user " + player.getName() + " parent addtemp Premium 60D");

                            player.sendMessage(Main.instance.prefix + "Du hast nun den Premium rang für drei Monat");

                        } else {

                            player.sendMessage(noCoins);

                        }

                        player.closeInventory();

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {

                        player.closeInventory();

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§66 Monat Premium")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {

                        player.closeInventory();

                        if (mySQLManager.getMoney(player, "geld") != "4500") {

                            mySQLManager.removeMoney(player, "geld", 4500);

                            Bukkit.dispatchCommand(player, "lp user " + player.getName() + " parent addtemp Premium 128D");

                            player.sendMessage(Main.instance.prefix + "Du hast nun den Premium rang für sechs Monat");

                        } else {

                            player.sendMessage(noCoins);

                        }

                        player.closeInventory();

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {

                        player.closeInventory();

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§6Lifetime Premium")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {

                        player.closeInventory();

                        if (mySQLManager.getMoney(player, "geld") != "10000") {

                            mySQLManager.removeMoney(player, "geld", 10000);

                            Bukkit.dispatchCommand(player, "lp user " + player.getName() + " parent set Premium");

                            player.sendMessage(Main.instance.prefix + "Du hast nun den Premium rang für immer");

                        } else {

                            player.sendMessage(noCoins);

                        }

                        player.closeInventory();

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {

                        player.closeInventory();

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§31Monat Ultra")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {

                        player.closeInventory();

                        if (mySQLManager.getMoney(player, "geld") != "2000") {

                            mySQLManager.removeMoney(player, "geld", 2000);

                            Bukkit.dispatchCommand(player, "lp user " + player.getName() + " parent addtemp Ultra 30D");

                            player.sendMessage(Main.instance.prefix + "Du hast nun den Ultra rang für ein Monat");

                        } else {

                            player.sendMessage(noCoins);

                        }

                        player.closeInventory();

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {

                        player.closeInventory();

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§33Monat Ultra")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {

                        player.closeInventory();

                        if (mySQLManager.getMoney(player, "geld") != "5500") {

                            mySQLManager.removeMoney(player, "geld", 5500);

                            Bukkit.dispatchCommand(player, "lp user " + player.getName() + " parent addtemp Ultra 60D");

                            player.sendMessage(Main.instance.prefix + "Du hast nun den Ultra rang für drei Monat");

                        } else {

                            player.sendMessage(noCoins);

                        }

                        player.closeInventory();

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {

                        player.closeInventory();

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§36Monat Ultra")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {

                        player.closeInventory();

                        if (mySQLManager.getMoney(player, "geld") != "10500") {

                            mySQLManager.removeMoney(player, "geld", 10500);

                            Bukkit.dispatchCommand(player, "lp user " + player.getName() + " parent addtemp Ultra 128D");

                            player.sendMessage(Main.instance.prefix + "Du hast nun den Ultra rang für sechs Monat");

                        } else {

                            player.sendMessage(noCoins);

                        }

                        player.closeInventory();

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {

                        player.closeInventory();

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§3Lifetime Ultra")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {

                        player.closeInventory();

                        if (mySQLManager.getMoney(player, "geld") != "20000") {

                            mySQLManager.removeMoney(player, "geld", 20000);

                            Bukkit.dispatchCommand(player, "lp user " + player.getName() + " parent set Ultra");

                            player.sendMessage(Main.instance.prefix + "Du hast nun den Ultra rang für ein immer");

                        } else {

                            player.sendMessage(noCoins);

                        }

                        player.closeInventory();

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {

                        player.closeInventory();

                    }

                }

            }

        }

        return false;
    }


}
