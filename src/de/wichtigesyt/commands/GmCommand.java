package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("jepcraft.lobby.gamemode")) {

                if (args.length == 0) {

                    player.sendMessage(Main.getInstance().prefix + "§cBenutze /gm <0/1/2/3> <Spieler>");

                } else if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("0")) {

                        player.sendMessage(Main.getInstance().prefix + "§aDu hast dich in den GameMode 0 gesetzt");

                        player.setGameMode(GameMode.SURVIVAL);

                    } else if (args[0].equalsIgnoreCase("1")) {

                        player.sendMessage(Main.getInstance().prefix + "§aDu hast dich in den GameMode 1 gesetzt");

                        player.setGameMode(GameMode.CREATIVE);

                    } else if (args[0].equalsIgnoreCase("2")) {

                        player.sendMessage(Main.getInstance().prefix + "§aDu hast dich in den GameMode 2 gesetzt");

                        player.setGameMode(GameMode.ADVENTURE);

                    } else if (args[0].equalsIgnoreCase("3")) {

                        player.sendMessage(Main.getInstance().prefix + "§aDu hast dich in den GameMode 3 gesetzt");

                        player.setGameMode(GameMode.SPECTATOR);

                    }

                } else if (args.length == 2) {

                    if (player.hasPermission("jepcraft.lobby.gm.other")) {

                        Player target = Bukkit.getPlayer(args[1]);

                        if (target == null) {

                            player.sendMessage(Main.getInstance().prefix + "§cDer Spieler ist offline");

                        } else if (args[0].equalsIgnoreCase("0")) {

                            player.sendMessage(Main.getInstance().prefix + "§aDu hast §c" + target.getName() + "§a in den GameMode 0 gesetzt");

                            target.sendMessage(Main.getInstance().prefix + "§aDu wurdest in den GameMode 0 gesetzt");

                            target.setGameMode(GameMode.SURVIVAL);

                        } else if (args[0].equalsIgnoreCase("1")) {

                            player.sendMessage(Main.getInstance().prefix + "§aDu hast §c" + target.getName() + "§a in den GameMode 1 gesetzt");

                            target.sendMessage(Main.getInstance().prefix + "§aDu wurdest in den GameMode 1 gesetzt");

                            target.setGameMode(GameMode.CREATIVE);

                        } else if (args[0].equalsIgnoreCase("2")) {

                            player.sendMessage(Main.getInstance().prefix + "§aDu hast §c" + target.getName() + "§a in den GameMode 2 gesetzt");

                            target.sendMessage(Main.getInstance().prefix + "§aDu wurdest in den GameMode 2 gesetzt");

                            target.setGameMode(GameMode.ADVENTURE);

                        } else if (args[0].equalsIgnoreCase("3")) {

                            player.sendMessage(Main.getInstance().prefix + "§aDu hast §c" + target.getName() + "§a in den GameMode 3 gesetzt");

                            target.sendMessage(Main.getInstance().prefix + "§aDu wurdest in den GameMode 3 gesetzt");

                            target.setGameMode(GameMode.SPECTATOR);

                        }

                    }else {

                        player.sendMessage(Main.getInstance().noPerms);

                    }

                } else {

                    player.sendMessage(Main.getInstance().prefix + "§cBenutze /gm <0/1/2/3> <Spieler>");

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
