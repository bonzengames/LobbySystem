package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import de.wichtigesyt.manager.ScoreBoard;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScoreboardCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("jepcraft.cores.scoreboard")) {

                if (args.length == 0) {

                    player.sendMessage(Main.getInstance().prefix + "§cBenutze /scoreboard reload");

                } else if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("reload")) {

                        for (Player all : Bukkit.getOnlinePlayers()) {

                            ScoreBoard.setLobbyScore(all);

                        }

                        player.sendMessage(Main.getInstance().prefix + "§aDas Scoreboard wurde reloadet");

                    } else {

                        player.sendMessage(Main.getInstance().prefix + "§cBenutze /scoreboard reload");

                    }

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
