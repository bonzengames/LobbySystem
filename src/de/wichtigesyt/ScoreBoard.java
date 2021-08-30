package de.wichtigesyt;

import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ScoreBoard {

    private static int sec = 30;
    public static int Task;

    public static void setLobbyScore(Player p){
        Scoreboard sb = new Scoreboard();
        ScoreboardObjective obj = sb.registerObjective("Lobby", IScoreboardCriteria.b);
        obj.setDisplayName("§2JepCraft.de");
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj,0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1,obj);

        ScoreboardScore a1 = new ScoreboardScore(sb,obj,"§6");
        ScoreboardScore a2 = new ScoreboardScore(sb,obj,"§7Dein Rang:");
        ScoreboardScore a3 = new ScoreboardScore(sb,obj,"§6"+getRang(p));
        ScoreboardScore a4 = new ScoreboardScore(sb,obj,"§5");
        ScoreboardScore a5 = new ScoreboardScore(sb,obj,"§7Spieleranzahl:");
        ScoreboardScore a6 = new ScoreboardScore(sb,obj,"§6"+ Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers());
        ScoreboardScore a7 = new ScoreboardScore(sb,obj,"§4");

        a1.setScore(7);
        a2.setScore(6);
        a3.setScore(5);
        a4.setScore(4);
        a5.setScore(3);
        a6.setScore(2);
        a7.setScore(1);

        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(a1);
        PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
        PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(a3);
        PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(a4);
        PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(a5);
        PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(a6);
        PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(a7);

        sendPacket(p, removePacket);
        sendPacket(p, createPacket);
        sendPacket(p, display);

        sendPacket(p, pa1);
        sendPacket(p, pa2);
        sendPacket(p, pa3);
        sendPacket(p, pa4);
        sendPacket(p, pa5);
        sendPacket(p, pa6);
        sendPacket(p, pa7);

    }

    private static void sendPacket(Player p, Packet packet){
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }

    public static String getRang(Player p) {

        String rang = null;
        if (p.getName().equalsIgnoreCase("WichtigesYT") || p.getName().equalsIgnoreCase("Joshi_7")) {
            rang = "§4Leitung";
            return rang;
        } else if (p.hasPermission("group.admin")) {
            rang = "§4Admin";
            return rang;
        } else if (p.hasPermission("group.srdeveloper")) {
            rang = "§bSrDeveloper";
            return rang;
        } else if (p.hasPermission("group.developer")) {
            rang = "§bDeveloper";
            return rang;
        } else if (p.hasPermission("group.event")) {
            rang = "§9Event-Manager";
            return rang;
        } else if (p.hasPermission("group.moderator")) {
            rang = "§cModerator";
            return rang;
        } else if (p.hasPermission("group.supporter")) {
            rang = "§eSupporter";
            return rang;
        } else if (p.hasPermission("group.helfer")) {
            rang = "§dHelfer";
            return rang;
        } else if (p.hasPermission("group.srbuilder")) {
            rang = "§aSrBuilder";
            return rang;
        } else if (p.hasPermission("group.builder")) {
            rang = "§aBuilder";
            return rang;
        } else if (p.hasPermission("group.testbuilder")) {
            rang = "§aTestBuilder";
            return rang;
        } else if (p.hasPermission("group.freund")) {
            rang = "§2Freund";
            return rang;
        } else if (p.hasPermission("group.youtuber")) {
            rang = "§5YouTuber";
            return rang;
        } else if (p.hasPermission("group.ultra")) {
            rang = "§3Ultra";
            return rang;
        } else if (p.hasPermission("group.premium")) {
            rang = "§6Premium";
            return rang;
        } else {
            rang = "§7Spieler";
            return rang;
        }

    }

    public static void startupdate(){

        Task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                if (sec == 0){

                    for (Player all : Bukkit.getOnlinePlayers()){

                        ScoreBoard.setLobbyScore(all);

                    }

                    Bukkit.getScheduler().cancelTask(Task);

                    startupdate();

                }

                sec--;

            }
        }, 0L, 20L);

    }

}
