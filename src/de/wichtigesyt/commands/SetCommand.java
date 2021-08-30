package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import de.wichtigesyt.shop.ShopManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("jepcraft.lobby.set")) {

                if (args.length == 0) {

                    player.sendMessage(Main.getInstance().prefix + "§cBenutze /set <Spawn/CityBuild/Farmwelt/Nether/Survival/set>");

                } else if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("spawn")) {

                        Main.getInstance().getConfig().set("Spawn.world", player.getWorld().getName());
                        Main.getInstance().getConfig().set("Spawn.X", player.getLocation().getX());
                        Main.getInstance().getConfig().set("Spawn.Y", player.getLocation().getY());
                        Main.getInstance().getConfig().set("Spawn.Z", player.getLocation().getZ());
                        Main.getInstance().getConfig().set("Spawn.Yaw", player.getLocation().getYaw());
                        Main.getInstance().getConfig().set("Spawn.Pitch", player.getLocation().getPitch());
                        Main.getInstance().saveConfig();

                        player.sendMessage(Main.getInstance().prefix + "§aDu hast den Spawn gesetzt");

                    } else if (args[0].equalsIgnoreCase("nether")) {

                        Main.getInstance().getConfig().set("CityBuild.world", player.getWorld().getName());
                        Main.getInstance().getConfig().set("CityBuild.X", player.getLocation().getX());
                        Main.getInstance().getConfig().set("CityBuild.Y", player.getLocation().getY());
                        Main.getInstance().getConfig().set("CityBuild.Z", player.getLocation().getZ());
                        Main.getInstance().getConfig().set("CityBuild.Yaw", player.getLocation().getYaw());
                        Main.getInstance().getConfig().set("CityBuild.Pitch", player.getLocation().getPitch());
                        Main.getInstance().saveConfig();

                        player.sendMessage(Main.getInstance().prefix + "§aDu hast den Spawn für Nether gesetzt");

                    } else if (args[0].equalsIgnoreCase("farmwelt")) {

                        Main.getInstance().getConfig().set("SkyBlock.world", player.getWorld().getName());
                        Main.getInstance().getConfig().set("SkyBlock.X", player.getLocation().getX());
                        Main.getInstance().getConfig().set("SkyBlock.Y", player.getLocation().getY());
                        Main.getInstance().getConfig().set("SkyBlock.Z", player.getLocation().getZ());
                        Main.getInstance().getConfig().set("SkyBlock.Yaw", player.getLocation().getYaw());
                        Main.getInstance().getConfig().set("SkyBlock.Pitch", player.getLocation().getPitch());
                        Main.getInstance().saveConfig();

                        player.sendMessage(Main.getInstance().prefix + "§aDu hast den Spawn für Farmwelt gesetzt");

                    } else if (args[0].equalsIgnoreCase("citybuild")) {

                        Main.getInstance().getConfig().set("Cores.world", player.getWorld().getName());
                        Main.getInstance().getConfig().set("Cores.X", player.getLocation().getX());
                        Main.getInstance().getConfig().set("Cores.Y", player.getLocation().getY());
                        Main.getInstance().getConfig().set("Cores.Z", player.getLocation().getZ());
                        Main.getInstance().getConfig().set("Cores.Yaw", player.getLocation().getYaw());
                        Main.getInstance().getConfig().set("Cores.Pitch", player.getLocation().getPitch());
                        Main.getInstance().saveConfig();

                        player.sendMessage(Main.getInstance().prefix + "§aDu hast den Spawn für CityBuild gesetzt");

                    } else if (args[0].equalsIgnoreCase("Survival")) {

                        Main.getInstance().getConfig().set("GunGame.world", player.getWorld().getName());
                        Main.getInstance().getConfig().set("GunGame.X", player.getLocation().getX());
                        Main.getInstance().getConfig().set("GunGame.Y", player.getLocation().getY());
                        Main.getInstance().getConfig().set("GunGame.Z", player.getLocation().getZ());
                        Main.getInstance().getConfig().set("GunGame.Yaw", player.getLocation().getYaw());
                        Main.getInstance().getConfig().set("GunGame.Pitch", player.getLocation().getPitch());
                        Main.getInstance().saveConfig();

                        player.sendMessage(Main.getInstance().prefix + "§aDu hast den Spawn für GunGame gesetzt");

                    } else if (args[0].equalsIgnoreCase("villager")) {

                        Main.getInstance().getConfig().set("Villager.world", player.getWorld().getName());
                        Main.getInstance().getConfig().set("Villager.X", player.getLocation().getX());
                        Main.getInstance().getConfig().set("Villager.Y", player.getLocation().getY());
                        Main.getInstance().getConfig().set("Villager.Z", player.getLocation().getZ());
                        Main.getInstance().saveConfig();

                        ShopManager.spawnVillager(player);

                    } else if (args[0].equalsIgnoreCase("event")) {

                        Main.getInstance().getConfig().set("Event.world", player.getWorld().getName());
                        Main.getInstance().getConfig().set("Event.X", player.getLocation().getX());
                        Main.getInstance().getConfig().set("Event.Y", player.getLocation().getY());
                        Main.getInstance().getConfig().set("Event.Z", player.getLocation().getZ());
                        Main.getInstance().getConfig().set("Event.Yaw", player.getLocation().getYaw());
                        Main.getInstance().getConfig().set("Event.Pitch", player.getLocation().getPitch());
                        Main.getInstance().saveConfig();

                        player.sendMessage(Main.getInstance().prefix + "§aDu hast den Spawn für Event gesetzt");

                    } else {

                        player.sendMessage(Main.getInstance().prefix + "§cBenutze /set <Spawn/CityBuild/SkyBlock/Cores/GunGame>");

                    }

                } else {

                    player.sendMessage(Main.getInstance().prefix + "§cBenutze /set <Spawn/CityBuild/SkyBlock/Cores/GunGame>");

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
