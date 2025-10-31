package tictactoeGame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author minja
 */

import java.sql.*;
import java.util.*;

public class ResultDAO 
{

    public static void insert(String playerX, String playerO, String winner) 
    {
        String sql = "INSERT INTO RESULTS (PLAYER_X, PLAYER_O, WINNER) VALUES (?,?,?)";
        try (Connection c = DatabaseManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) 
        {
            ps.setString(1, playerX);
            ps.setString(2, playerO);
            ps.setString(3, winner);
            ps.executeUpdate();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static List<String[]> getRecent(int limit) 
    {
        List<String[]> out = new ArrayList<>();
        String sql = """
            SELECT PLAYER_X, PLAYER_O, WINNER, PLAYED_AT
            FROM RESULTS
            ORDER BY PLAYED_AT DESC
            FETCH FIRST ? ROWS ONLY
        """;
        try (Connection c = DatabaseManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) 
        {
            ps.setInt(1, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                out.add(new String[]
                {
                    rs.getString("PLAYER_X"),
                    rs.getString("PLAYER_O"),
                    rs.getString("WINNER"),
                    String.valueOf(rs.getTimestamp("PLAYED_AT"))
                });
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return out;
    }
}

