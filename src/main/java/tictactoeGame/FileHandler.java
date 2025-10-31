/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * NOTE: Parts of this class (e.g., play loop skeleton) were assisted by ChatGPT.
 * I implemented input validation, scoreboard parsing/sorting, and comments myself.
*/
package tictactoeGame;

import java.io.*;
import java.util.*;

/**
 *
 * @author minja
 */
public class FileHandler {
    private static final String FILE_NAME = "scores.txt";
    
    public static void saveScore(Player player)
    {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
                BufferedWriter bw = new BufferedWriter(fw))
        {
            bw.write(player.getName() + "," + player.getScore());
            bw.newLine();
        }
        catch (IOException e)
        {
            System.out.println("[Error] Cannot save score.");
        }
    }
    
    public static void printScores()
    {
        System.out.println("=== Score Board");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("[Info] No scores yet.");
        }
    }
    
}
