/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * NOTE: Parts of this class (e.g., play loop skeleton) were assisted by ChatGPT.
 * I implemented input validation, scoreboard parsing/sorting, and comments myself.
*/
package tictactoeGame;

/**
 *
 * @author minja
 */
public class Player {
    private String name;
    private char symbol;
    private int score;
    
    public Player(String name, char symbol)
    {
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }
    
    public String getName() { return name;}
    public char getSymbol() { return symbol;}
    public int getScore() { return score;}
    public void addScore() {score++;}
    
}
