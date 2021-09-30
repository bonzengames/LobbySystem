package de.wichtigesyt.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLManager {
    private MySQL mySQL = null;
    private Connection conn = null;
    private String tablename;

    public MySQLManager(MySQL mySQL, String tablename) {

        this.mySQL = mySQL;
        conn = mySQL.getConnection();
        this.tablename = tablename;

    }

    public void setMoney(Player player, String name, String money) {

        mySQL.qeryUpdate("UPDATE " + tablename + " SET " + name + "='" + money + "', PlayerName='" + player.getName() + "' WHERE PlayerUUID='" + player.getUniqueId().toString() + "'");

    }

    public void addPlayer(Player player) {

        if(getMoney(player, "geld") == null) {

            mySQL.qeryUpdate("CREATE TABLE IF NOT EXISTS " + tablename + " (PlayerUUID varchar(200), PlayerName varchar(200), geld int)");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`,`PlayerName`, `geld`) VALUES ('" + player.getUniqueId() + "','" + player.getName() + "', '0')");

        }

        if (getPunkte(player, "PlayerUUID") == null) {

            mySQL.qeryUpdate("CREATE TABLE IF NOT EXISTS gagets (PlayerUUID varchar(200), GadgetName varchar(200), State varchar(200))");
            mySQL.qeryUpdate("INSERT INTO gagets (`PlayerUUID`,`GadgetName`, `State`) VALUES ('" + player.getUniqueId() + "','schuhe_standard', 'true')");
            mySQL.qeryUpdate("INSERT INTO gagets (`PlayerUUID`,`GadgetName`, `State`) VALUES ('" + player.getUniqueId() + "','schuhe_premium', 'false')");
            mySQL.qeryUpdate("INSERT INTO gagets (`PlayerUUID`,`GadgetName`, `State`) VALUES ('" + player.getUniqueId() + "','schuhe_ultra', 'false')");
            mySQL.qeryUpdate("INSERT INTO gagets (`PlayerUUID`,`GadgetName`, `State`) VALUES ('" + player.getUniqueId() + "','schuhe_team', 'false')");

            mySQL.qeryUpdate("INSERT INTO gagets (`PlayerUUID`,`GadgetName`, `State`) VALUES ('" + player.getUniqueId() + "','partikel_herz', 'false')");
            mySQL.qeryUpdate("INSERT INTO gagets (`PlayerUUID`,`GadgetName`, `State`) VALUES ('" + player.getUniqueId() + "','partikel_water', 'false')");
            mySQL.qeryUpdate("INSERT INTO gagets (`PlayerUUID`,`GadgetName`, `State`) VALUES ('" + player.getUniqueId() + "','partikel_lava', 'false')");
            mySQL.qeryUpdate("INSERT INTO gagets (`PlayerUUID`,`GadgetName`, `State`) VALUES ('" + player.getUniqueId() + "','partikel_tnt', 'false')");

            mySQL.qeryUpdate("INSERT INTO gagets (`PlayerUUID`,`GadgetName`, `State`) VALUES ('" + player.getUniqueId() + "','gadget_grappling', 'true')");
            mySQL.qeryUpdate("INSERT INTO gagets (`PlayerUUID`,`GadgetName`, `State`) VALUES ('" + player.getUniqueId() + "','gadget_elytra', 'false')");

        }

    }

    public String getMoney(Player player, String stat) {
        ResultSet rs = null;
        PreparedStatement st = null;
        String statvalue = null;
        try {
            st = conn.prepareStatement("SELECT * FROM " + tablename + " WHERE PlayerUUID=?");
            st.setString(1, player.getUniqueId().toString());
            rs = st.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                rs.first();
                statvalue = rs.getString("geld");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        } finally {
            mySQL.closeRessources(rs, st);
        }


        return statvalue;

    }

    public void payMoney(Player player, Player target, int money) {

        int akt_money_player = Integer.parseInt(getMoney(player, "geld"));
        int akt_money_target = Integer.parseInt(getMoney(target, "geld"));

        int end_money_player = akt_money_player - money;
        int end_money_target = akt_money_target + money;

        setMoney(player, "geld", String.valueOf(end_money_player));
        setMoney(target, "geld", String.valueOf(end_money_target));

    }

    public void addMoney(Player player, String geld, int money) {

        int akt_money = Integer.parseInt(getMoney(player, "geld"));

        int end_money = akt_money + money;

        setMoney(player, geld, String.valueOf(end_money));

    }

    public void removeMoney(Player player, String geld, int money) {

        int akt_money = Integer.parseInt(getMoney(player, "geld"));

        int end_money = akt_money - money;

        setMoney(player, geld, String.valueOf(end_money));

    }

    public String getPunkte(Player player, String stat) {
        ResultSet rs = null;
        PreparedStatement st = null;
        String statvalue = null;
        try {
            st = conn.prepareStatement("SELECT * FROM gagets WHERE PlayerUUID=?");
            st.setString(1, player.getUniqueId().toString());
            rs = st.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                rs.first();
                statvalue = rs.getString(stat);
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        } finally {
            mySQL.closeRessources(rs, st);
        }

        return statvalue;

    }

    public String getGadget(Player player, String gadgetName) {
        ResultSet rs = null;
        PreparedStatement st = null;
        String statvalue = null;
        String uuid = String.valueOf(player.getUniqueId());
        try {
            st = conn.prepareStatement("SELECT * FROM gagets WHERE PlayerUUID=? AND GadgetName='" + gadgetName + "'");
            st.setString(1, uuid);
            rs = st.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                rs.first();
                statvalue = rs.getString("State");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        } finally {
            mySQL.closeRessources(rs, st);
        }

        return statvalue;
    }

    public void setGadget(Player player, String gadgetName, String state) {

        mySQL.qeryUpdate("UPDATE gagets SET State='" + state + "' WHERE PlayerUUID='" + player.getUniqueId().toString() + "' AND GadgetName='" + gadgetName + "'");

    }

}

