package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player)sender;

            if (player.hasPermission("jepcraft.lobby.fly")) {

                if (args.length == 0) {

                    if (Main.getInstance().getFlyers().contains(player)) {

                        Main.getInstance().getFlyers().remove(player);

                        player.sendMessage(Main.getInstance().prefix + "§cDu kannst nun nicht mehr fliegen");

                        player.setAllowFlight(false);

                    } else {

                        Main.getInstance().getFlyers().add(player);

                        player.sendMessage(Main.getInstance().prefix + "§aDu kannst nun fliegen");

                        player.setAllowFlight(true);

                    }

                } else if (args.length == 1) {

                    if (player.hasPermission("jepcraft.lobby.fly.other")) {

                        Player target = Bukkit.getPlayer(args[0]);

                        if (target == null) {

                            player.sendMessage(Main.getInstance().prefix + "§cDer Spieler ist offline");

                        }

                        if (Main.getInstance().getFlyers().contains(target)) {

                            Main.getInstance().getFlyers().remove(target);

                            target.sendMessage(Main.getInstance().prefix + "§cDu kannst nun nicht mehr fliegen");

                            player.sendMessage(Main.getInstance().prefix + "§cDu hast §a" + target.getName() + "§c den Flugmodus geklaut");

                            target.setAllowFlight(false);

                        } else {

                            Main.getInstance().getFlyers().add(target);

                            target.sendMessage(Main.getInstance().prefix + "§aDu kannst nun Fliegen");

                            player.sendMessage(Main.getInstance().prefix + "§aDu hast §c" + target.getName() + "§a hast du in den Flugmodus gesetzt");

                            target.setAllowFlight(true);

                        }

                    } else {

                        player.sendMessage(Main.getInstance().noPerms);

                    }

                } else {

                    player.sendMessage(Main.getInstance().prefix + "§cBenutze /fly");

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
