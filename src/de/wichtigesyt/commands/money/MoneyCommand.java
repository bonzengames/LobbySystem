package de.wichtigesyt.commands.money;

import de.wichtigesyt.Main;
import de.wichtigesyt.manager.MySQLManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            MySQLManager mySQLManager = new MySQLManager(Main.mySQL, "geld");

            Player player = (Player) sender;

            if (args.length == 0) {

                player.sendMessage(Main.instance.prefix + " Dein Geld beträgt aktuell " + mySQLManager.getMoney(player, "geld"));

            } else if (args.length == 1) {

                if (player.hasPermission("bonzengames.lobby.money.other")) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        player.sendMessage(Main.instance.prefix + "Der Spieler ist offline");

                    } else {

                        player.sendMessage(Main.instance.prefix + " Das Geld von " + target.getName() + " beträgt aktuell " + mySQLManager.getMoney(target, "geld"));
                    }

                } else {

                    player.sendMessage(Main.instance.noPerms);

                }

            } else {

                player.sendMessage(Main.instance.prefix + " Benutze §b/money <Spieler>");

            }

        } else {

            sender.sendMessage(Main.instance.noPlayer);

        }

        return false;
    }
}