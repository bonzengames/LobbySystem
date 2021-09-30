package de.wichtigesyt.commands.money;

import de.wichtigesyt.Main;
import de.wichtigesyt.manager.MySQLManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyAdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("bonzenagames.lobby.money-admin")) {

                MySQLManager mySQLManager = new MySQLManager(Main.mySQL, "geld");

                if (args.length == 2) {

                    int money = Integer.parseInt(args[1]);

                    if (args[0].equalsIgnoreCase("set")) {

                        mySQLManager.setMoney(player,"geld", String.valueOf(money));

                        player.sendMessage(Main.instance.prefix + "Du hast dein eigenes Geld auf " + money + " gesetzt");
                        player.sendMessage(Main.instance.prefix + "Dein aktuelles Geld beträgt nach der änderung " + mySQLManager.getMoney(player, "geld"));

                    } else if (args[0].equalsIgnoreCase("add")) {

                        mySQLManager.addMoney(player,"geld", money);

                        player.sendMessage(Main.instance.prefix + "Du hast zu deinem Geld " + money + " hinzugefügt");
                        player.sendMessage(Main.instance.prefix + "Dein aktuelles Geld beträgt nach der änderung " + mySQLManager.getMoney(player, "geld"));

                    } else if (args[0].equalsIgnoreCase("remove")) {

                        mySQLManager.removeMoney(player,"geld", money);

                        player.sendMessage(Main.instance.prefix + "Du hast von deinem Geld " + money + " weggenommen");
                        player.sendMessage(Main.instance.prefix + "Dein aktuelles Geld beträgt nach der änderung " + mySQLManager.getMoney(player, "geld"));

                    } else {

                        player.sendMessage(Main.instance.prefix + "Benutze §b/money-admin <set/add/remove> <geld> <Spieler>");

                    }

                } else if (args.length == 3) {

                    int money = Integer.parseInt(args[1]);

                    Player target = Bukkit.getPlayer(args[2]);

                    if (args[0].equalsIgnoreCase("set")) {

                        mySQLManager.setMoney(target,"geld", String.valueOf(money));

                        player.sendMessage(Main.instance.prefix + "Du hast das Geld von " + target.getName() + " auf " + money + " gesetzt");
                        target.sendMessage(Main.instance.prefix + "Dein Geld wurde von " + player.getName() + " auf " + money + " gesetzt");
                        player.sendMessage(Main.instance.prefix + "Das Geld von " + target.getName() + " beträgt nach der änderung " + mySQLManager.getMoney(target, "geld"));
                        target.sendMessage(Main.instance.prefix + "Dein aktuelles Geld beträgt nach der änderung " + mySQLManager.getMoney(target, "geld"));

                    } else if (args[0].equalsIgnoreCase("add")) {

                        mySQLManager.addMoney(player,"geld", money);

                        player.sendMessage(Main.instance.prefix + "Du hast zu dem Geld von " + target.getName() + " - " + money + " hinzugefügt");
                        target.sendMessage(Main.instance.prefix + "Zu deinem Geld wurden von " + target.getName() + " - " + money + " hinzugefügt");
                        player.sendMessage(Main.instance.prefix + "Das Geld von " + target.getName() + " beträgt nach der änderung " + mySQLManager.getMoney(target, "geld"));
                        target.sendMessage(Main.instance.prefix + "Dein aktuelles Geld beträgt nach der änderung " + mySQLManager.getMoney(target, "geld"));

                    } else if (args[0].equalsIgnoreCase("remove")) {

                        mySQLManager.removeMoney(player,"geld", money);

                        player.sendMessage(Main.instance.prefix + "Du hast von dem Geld von " + target.getName() + " - " + money + " entfernt");
                        target.sendMessage(Main.instance.prefix + "Von deinem Geld wurde " + money + "entfert von " + player.getName());
                        player.sendMessage(Main.instance.prefix + "Das Geld von " + target.getName() + " beträgt nach der änderung " + mySQLManager.getMoney(target, "geld"));
                        target.sendMessage(Main.instance.prefix + "Dein aktuelles Geld beträgt nach der änderung " + mySQLManager.getMoney(target, "geld"));

                    } else {

                        player.sendMessage(Main.instance.prefix + "Benutze §b/money-admin <set/add/remove> <geld> <Spieler>");

                    }

                } else {

                    player.sendMessage(Main.instance.prefix + "Benutze §b/money-admin <set/add/remove> <geld> <Spieler>");

                }

            } else {

                player.sendMessage(Main.instance.noPerms);

            }

        } else {

            sender.sendMessage(Main.instance.noPlayer);

        }

        return false;
    }
}
