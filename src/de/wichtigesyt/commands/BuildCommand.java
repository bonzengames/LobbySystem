package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import de.wichtigesyt.inventoryes.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("jepcraft.lobby.build")) {

                if (args.length == 0) {

                    if (Main.getInstance().getBuilders().contains(player)) {

                        Main.getInstance().getBuilders().remove(player);

                        InventoryManager.giveJoinInv(player);

                        player.sendMessage(Main.getInstance().prefix + "§cDu bist jetzt nicht mehr im Baumodus");

                        InventoryManager.giveJoinInv(player);

                        player.setGameMode(GameMode.SURVIVAL);

                    } else {

                        Main.getInstance().getBuilders().add(player);

                        player.setGameMode(GameMode.CREATIVE);

                        player.sendMessage(Main.getInstance().prefix + "§aDu bist jetzt im Baumodus");

                        player.getInventory().clear();

                    }

                } else if (args.length == 1) {

                    if (player.hasPermission("jepcraft.lobby.build.other")) {

                        Player target = Bukkit.getPlayer(args[0]);

                        if (target == null) {

                            player.sendMessage(Main.getInstance().prefix + "§cDer Spieler ist offline");

                        } else {

                            if (Main.getInstance().getBuilders().contains(target)) {

                                Main.getInstance().getBuilders().remove(target);

                                InventoryManager.giveJoinInv(target);

                                target.sendMessage(Main.getInstance().prefix + "§cDu bist jetzt nicht mehr im Baumodus");

                                player.sendMessage(Main.getInstance().prefix + "§cDu hast §a" + target.getName() + "§c den Baumodus geklaut");

                                InventoryManager.giveJoinInv(target);

                                target.setGameMode(GameMode.SURVIVAL);

                            } else {

                                Main.getInstance().getBuilders().add(target);

                                target.sendMessage(Main.getInstance().prefix + "§aDu bist jetzt im Baumodus");

                                target.setGameMode(GameMode.CREATIVE);

                                player.sendMessage(Main.getInstance().prefix + "§aDu hast §c" + target.getName() + "§a in den Baumodus gesetzt");

                                target.getInventory().clear();

                            }

                        }

                    } else {


                        player.sendMessage(Main.getInstance().noPerms);

                    }

                } else {

                    player.sendMessage(Main.getInstance().prefix + "§cBenutze /build <Spieler>");

                }

            } else {

                player.sendMessage(Main.getInstance().noPerms);

            }

        } else {

            sender.sendMessage(Main.getInstance().noPlayer);

        }

        return false;
    }
}
