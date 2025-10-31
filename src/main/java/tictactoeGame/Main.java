/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * NOTE: Parts of this class (e.g., play loop skeleton) were assisted by ChatGPT.
 * I implemented input validation, scoreboard parsing/sorting, and comments myself.
*/
package tictactoeGame;

import javax.swing.SwingUtilities;

/**
 *
 * @author minja
 */
public class Main {
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            Game game = new SwingTicTacToeGame();
            game.play();
        });
    }
}
