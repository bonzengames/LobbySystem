package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class PluginsCommand implements CommandExecutor {

    public static ArrayList<String> plugins = new ArrayList<>();
    public static ArrayList<String> enabledPlugin = new ArrayList<>();
    public static ArrayList<String> disabledPlugin = new ArrayList<>();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("jepcraft.plugins")) {

                enabledPlugin.clear();
                disabledPlugin.clear();
                plugins.clear();

                for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {

                    plugins.add(plugin.getName());

                    if (Bukkit.getPluginManager().isPluginEnabled(plugin)) {

                        enabledPlugin.add(plugin.getName());

                    } else {

                        disabledPlugin.add(plugin.getName());

                    }

                }

                if (args.length == 0){

                    player.sendMessage(Main.getInstance().prefix + "Benutze: §c/pp <unload/list/load/reload/info> <Plugin/all>");

                } else if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("list")) {

                        player.sendMessage(Main.getInstance().prefix + "Plugins aktiv: §a" + enabledPlugin.size());
                        player.sendMessage(Main.getInstance().prefix + "Plugins deaktiviert: §c" + disabledPlugin.size());
                        player.sendMessage("§1");

                        if (!(disabledPlugin.size() != 0)) {

                            player.sendMessage(Main.getInstance().prefix + "Plugins: §a" + enabledPlugin.toString() + " §7/§c keine deaktivierten Plugins!");

                        } else {

                            player.sendMessage(Main.getInstance().prefix + "Plugins: §a" + enabledPlugin.toString() + " §7/§c " + disabledPlugin.toString());

                        }

                    } else if (args[0].equalsIgnoreCase("load")) {

                        player.sendMessage(Main.getInstance().prefix + "Benutze: §c/pp load <Plugin,all>");

                    } else if (args[0].equalsIgnoreCase("unload")) {

                        player.sendMessage(Main.getInstance().prefix + "Benutze: §c/pp unload <Plugin,all>");

                    } else if (args[0].equalsIgnoreCase("reload")) {

                        player.sendMessage(Main.getInstance().prefix + "Benutze: §c/pp reload <Plugin,all>");

                    } else if (args[0].equalsIgnoreCase("info")){

                        player.sendMessage(Main.getInstance().prefix + "Benutze: §c/pp info <Plugin>");

                    }  else {

                        player.sendMessage(Main.getInstance().prefix + "Benutze: §c/pp <unload/list/load/reload/info> <Plugin/all>");

                    }

                } else if (args.length == 2){

                    if (args[0].equalsIgnoreCase("load")) {

                        if (plugins.contains(args[1])) {

                            Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(args[1]));
                            player.sendMessage(Main.getInstance().prefix + "Das Plugin §c" + args[1] + " §7wurde §ageladen");

                        }  else if (args[1].equalsIgnoreCase("all")){

                            for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {

                                Bukkit.getPluginManager().enablePlugin(plugin);

                            }

                            player.sendMessage(Main.getInstance().prefix + "Es wurden alle Plugins §ageladen");

                        } else {

                            player.sendMessage(Main.getInstance().prefix + "§cDas Plugin konnte nicht gefunden werden!");

                        }

                    } else if (args[0].equalsIgnoreCase("unload")) {

                        if (plugins.contains(args[1])) {

                            Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin(args[1]));

                            player.sendMessage(Main.getInstance().prefix + "Das Plugin " + args[1] + " wurde §cdeaktiviert§7!");


                        }  else if (args[1].equalsIgnoreCase("all")){

                            for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {

                                if (!plugin.getName().equalsIgnoreCase("ServerSachen")) {

                                    Bukkit.getPluginManager().disablePlugin(plugin);

                                }

                            }

                            player.sendMessage(Main.getInstance().prefix + "Es wurden alle Plugins §cdeaktiviert§7!");

                        } else {

                            player.sendMessage(Main.getInstance().prefix + "§cDas Plugin konnte nicht gefunden werden!");

                        }

                    } else if (args[0].equalsIgnoreCase("reload")) {

                        if (plugins.contains(args[1])) {

                            Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin(args[1]));

                            Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(args[1]));

                            player.sendMessage(Main.getInstance().prefix + "Das Plugin §c" + args[1] + " §7wurde §aneugeladen");

                        }  else if (args[1].equalsIgnoreCase("all")){

                            for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {

                                Bukkit.getPluginManager().disablePlugin(plugin);

                                Bukkit.getPluginManager().enablePlugin(plugin);

                            }

                            player.sendMessage(Main.getInstance().prefix + "Es wurden alle Plugins §aneugeladen");

                        } else {

                            player.sendMessage(Main.getInstance().prefix + "§cDas Plugin konnte nicht gefunden werden!");

                        }

                    } else if (args[0].equalsIgnoreCase("info")) {

                        if (plugins.contains(args[1])) {

                            player.sendMessage(Main.getInstance().prefix + "Name: " + Bukkit.getPluginManager().getPlugin(args[1]).getName());
                            player.sendMessage(Main.getInstance().prefix + "Version: " + Bukkit.getPluginManager().getPlugin(args[1]).getDescription().getVersion());
                            player.sendMessage(Main.getInstance().prefix + "Author: " + Bukkit.getPluginManager().getPlugin(args[1]).getDescription().getAuthors());
                            player.sendMessage(Main.getInstance().prefix + "Beschreibung: " + Bukkit.getPluginManager().getPlugin(args[1]).getDescription().getDescription());
                            player.sendMessage(Main.getInstance().prefix + "Main Class: " + Bukkit.getPluginManager().getPlugin(args[1]).getDescription().getMain());

                        } else {

                            player.sendMessage(Main.getInstance().prefix + "§cDas Plugin konnte nicht gefunden werden!");

                        }


                    } else {

                        player.sendMessage(Main.getInstance().prefix + "Benutze: §c/pp <unload/list/load/reload/info> <Plugin/all>");

                    }

                } else {

                    player.sendMessage(Main.getInstance().prefix + "Benutze: §c/pp <unload/list/load/reload/info> <Plugin/all>");

                }

            } else {

                player.sendMessage(Main.getInstance().prefix + "Benutze: §c/pp <unload/list/load/reload/info> <Plugin/all>");

            }


        } else {

            sender.sendMessage(Main.getInstance().prefix + "Benutze: §c/pp <unload/list/load/reload/info> <Plugin/all>");

        }

        return false;
    }
}
