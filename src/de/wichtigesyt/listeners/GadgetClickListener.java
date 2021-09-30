package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import de.wichtigesyt.inventoryes.GadgetManager;
import de.wichtigesyt.inventoryes.ItemManager;
import de.wichtigesyt.manager.MySQL;
import de.wichtigesyt.manager.MySQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GadgetClickListener implements Listener {

    private static MySQLManager moneyManager = new MySQLManager(Main.mySQL, "geld");

    private static MySQLManager mySQLManager = new MySQLManager(Main.mySQL, "gagets");

    @EventHandler
    public void onCLick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (!Main.getInstance().getBuilders().contains(player)) {

            if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getCurrentItem().getItemMeta().getDisplayName() != null) {

                event.setCancelled(true);

                 if (event.getInventory().getName().equalsIgnoreCase("§eGadgets")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dSpielzeuge")) {

                        GadgetManager.gadget_gadgetInv(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Köpfe")) {

                        GadgetManager.gadget_kopfInv(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPartikel")) {

                        GadgetManager.gadget_partikelInv(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Schuhe")) {

                        GadgetManager.gadget_schuheInv(player);

                    }

                } else if (event.getInventory().getName().equalsIgnoreCase("§dSpielzeuge")) {

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGrappling Hook §7➤ §cDeaktiviert")) {

                        GadgetManager.giveGrapplingItem(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGrappling Hook §7➤ §aAktiviert")) {

                        GadgetManager.removeGrapplingItem(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bElytra Gadget §7➤ §cNicht gekauft")) {

                        player.closeInventory();

                        int money = Integer.parseInt(moneyManager.getMoney(player, "geld"));

                        if (money >= 5000) {

                            moneyManager.removeMoney(player, "geld", 5000);

                            player.sendMessage(Main.instance.prefix + "Du hast das Elytra Gadget für 5000 gekauft!");

                            mySQLManager.setGadget(player, "gadget_elytra", "true");

                        } else {

                            player.sendMessage(Main.instance.prefix + "Du hast nicht genügend Geld für das Elytra Gadget");

                        }

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bElytra Gadget §7➤ §cDeaktiviert")) {

                        GadgetManager.giveElytraGadget(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bElytra Gadget §7➤ §aAktiviert")) {

                        GadgetManager.removeElytraGadget(player);

                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cLösche dein Gadget")) {

                        GadgetManager.clickGadgetDelete(player);

                    }


                } else if (event.getInventory().getName().equalsIgnoreCase("§bPartikel")) {

                     if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cTNT Partikel §7➤ §cNicht gekauft")) {

                         player.closeInventory();

                         int money = Integer.parseInt(moneyManager.getMoney(player, "geld"));

                         if (money >= 1000) {

                             moneyManager.removeMoney(player, "geld", 1000);

                             player.sendMessage(Main.instance.prefix + "Du hast die Tnt Partikel für 1000 gekauft!");

                             mySQLManager.setGadget(player, "partikel_tnt", "true");

                         } else {

                             player.sendMessage(Main.instance.prefix + "Du hast nicht genügend Geld");

                         }

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cTNT Partikel §7➤ §cDeaktiviert")) {

                         GadgetManager.clickTnt(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cTNT Partikel §7➤ §aAktiviert")) {

                         GadgetManager.removePartikel(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Herz Partikel §7➤ §cNicht gekauft")) {

                         player.closeInventory();

                         int money = Integer.parseInt(moneyManager.getMoney(player, "geld"));

                         if (money >= 1000) {

                             moneyManager.removeMoney(player, "geld", 1000);

                             player.sendMessage(Main.instance.prefix + "Du hast die Herz Partikel für 1000 gekauft!");

                             mySQLManager.setGadget(player, "partikel_herz", "true");

                         } else {

                             player.sendMessage(Main.instance.prefix + "Du hast nicht genügend Geld");

                         }

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Herz Partikel §7➤ §cDeaktiviert")) {

                         GadgetManager.clickHerz(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Herz Partikel §7➤ §aAktiviert")) {

                         GadgetManager.removePartikel(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Lava Partikel §7➤ §cNicht gekauft")) {

                         player.closeInventory();

                         int money = Integer.parseInt(moneyManager.getMoney(player, "geld"));

                         if (money >= 1000) {

                             moneyManager.removeMoney(player, "geld", 1000);

                             player.sendMessage(Main.instance.prefix + "Du hast die Lava Partikel für 1000 gekauft!");

                             mySQLManager.setGadget(player, "partikel_lava", "true");

                         } else {

                             player.sendMessage(Main.instance.prefix + "Du hast nicht genügend Geld");

                         }

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Lava Partikel §7➤ §cDeaktiviert")) {

                         GadgetManager.clickLava(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Lava Partikel §7➤ §aAktiviert")) {

                         GadgetManager.removePartikel(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Wasser Partikel §7➤ §cNicht gekauft")) {

                         player.closeInventory();

                         int money = Integer.parseInt(moneyManager.getMoney(player, "geld"));

                         if (money >= 1000) {

                             moneyManager.removeMoney(player, "geld", 1000);

                             player.sendMessage(Main.instance.prefix + "Du hast die Wasser Partikel für 1000 gekauft!");

                             mySQLManager.setGadget(player, "partikel_water", "true");

                         } else {

                             player.sendMessage(Main.instance.prefix + "Du hast nicht genügend Geld");

                         }

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Wasser Partikel §7➤ §cDeaktiviert")) {

                         GadgetManager.clickWasser(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Wasser Partikel §7➤ §aAktiviert")) {

                         GadgetManager.removePartikel(player);

                     }

                } else if (event.getInventory().getName().equalsIgnoreCase("§bSchuhe")) {

                     if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Standard Schuhe §7➤ §cDeaktiviert")) {

                         GadgetManager.clickStandartdSchuhe(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Standard Schuhe §7➤ §aAktiviert")) {

                         GadgetManager.clickRemoveSchuhe(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Premium Schuhe §7➤ §cNicht gekauft")) {

                         player.closeInventory();

                         int money = Integer.parseInt(moneyManager.getMoney(player, "geld"));

                         if (money >= 1000) {

                             moneyManager.removeMoney(player, "geld", 1000);

                             player.sendMessage(Main.instance.prefix + "Du hast die Premium Schuhe für 1000 gekauft!");

                             mySQLManager.setGadget(player, "schuhe_premium", "true");

                         } else {

                             player.sendMessage(Main.instance.prefix + "Du hast nicht genügend Geld");

                         }

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Premium Schuhe §7➤ §cDeaktiviert")) {

                         GadgetManager.clickPremiumSchuhe(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Premium Schuhe §7➤ §aAktiviert")) {

                         GadgetManager.clickRemoveSchuhe(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Ultra Schuhe §7➤ §cNicht gekauft")) {

                         player.closeInventory();

                         int money = Integer.parseInt(moneyManager.getMoney(player, "geld"));

                         if (money >= 1000) {

                             moneyManager.removeMoney(player, "geld", 1000);

                             player.sendMessage(Main.instance.prefix + "Du hast die Ultra Schuhe für 1000 gekauft!");

                             mySQLManager.setGadget(player, "schuhe_ultra", "true");

                         } else {

                             player.sendMessage(Main.instance.prefix + "Du hast nicht genügend Geld");

                         }

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Ultra Schuhe §7➤ §cDeaktiviert")) {

                         GadgetManager.clickUltraSchuhe(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Ultra Schuhe §7➤ §aAktiviert")) {

                         GadgetManager.clickRemoveSchuhe(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cTeam Schuhe §7➤ §cNicht gekauft")) {

                         player.closeInventory();

                         int money = Integer.parseInt(moneyManager.getMoney(player, "geld"));

                         if (player.hasPermission("bonzengames.team")) {

                             if (money >= 1000) {

                                 moneyManager.removeMoney(player, "geld", 1000);

                                 player.sendMessage(Main.instance.prefix + "Du hast die Team Schuhe für 1000 gekauft!");

                                 mySQLManager.setGadget(player, "schuhe_team", "true");

                             } else {

                                 player.sendMessage(Main.instance.prefix + "Du hast nicht genügend Geld");

                             }

                         } else {

                             player.sendMessage(Main.instance.prefix + "Du bist nicht im Team");

                         }

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cTeam Schuhe §7➤ §cDeaktiviert")) {

                         GadgetManager.clickTeamSchuhe(player);

                     } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cTeam Schuhe §7➤ §aAktiviert")) {

                         GadgetManager.clickRemoveSchuhe(player);

                     }

                 }

            }

        }

    }

}
