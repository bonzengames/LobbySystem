package de.wichtigesyt.commands.money;

import de.wichtigesyt.Main;
import de.wichtigesyt.manager.MySQLManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            MySQLManager mySQLManager = new MySQLManager(Main.mySQL, "geld");

            Player player = (Player) sender;

            if (args.length == 2) {

                Player target = Bukkit.getPlayer(args[0]);

                if (target == null) {

                    player.sendMessage(Main.instance.prefix + "Der Spieler ist offline");

                } else if (target == player) {

                    player.sendMessage(Main.instance.prefix + "Du kannst dir selber kein Geld geben");

                } else if (target.getAddress() == player.getAddress()) {

                    player.sendMessage(Main.instance.prefix + "Du kannst deinem Zweit account kein Geld geben");

                } else {

                    int money = Integer.parseInt(args[1]);

                    mySQLManager.payMoney(player, target, money);

                    player.sendMessage(Main.instance.prefix + "Du hast " + target.getName() + " einen betrag von " + money + " bezahlt");
                    target.sendMessage(Main.instance.prefix + "Dir wurde von " + player.getName() + " ein betrag von " + money + " bezahlt");

                }

            } else {

                player.sendMessage(Main.instance.prefix + "Benutze §b/pay <Spieler> <Geld>");

            }

        } else {

            sender.sendMessage(Main.instance.noPlayer);

        }

        return false;
    }
}