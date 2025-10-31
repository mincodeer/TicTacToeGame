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

public class DatabaseManager 
{
    private static final String URL = "jdbc:derby:TicTacToeDB;create=true";

    public static Connection getConnection() throws SQLException 
    {
        return DriverManager.getConnection(URL);
    }

    public static void ensureTable() 
    {
        try (Connection conn = getConnection(); Statement st = conn.createStatement()) 
        {
            st.executeUpdate("""
                CREATE TABLE RESULTS (
                  ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                  PLAYER_X VARCHAR(50),
                  PLAYER_O VARCHAR(50),
                  WINNER   VARCHAR(10),
                  PLAYED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
            """);
            System.out.println("[DB] RESULTS table created.");
        } catch (SQLException e) 
        {
            if (!"X0Y32".equals(e.getSQLState())) e.printStackTrace();
        }
    }
}
