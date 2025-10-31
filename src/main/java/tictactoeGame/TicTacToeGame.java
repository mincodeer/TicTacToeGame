/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/*
 * NOTE: Parts of this class (e.g., play loop skeleton) were assisted by ChatGPT.
 * I implemented input validation, scoreboard parsing/sorting, and comments myself.
*/
package tictactoeGame;

import java.util.Scanner;

/**
 *
 * @author minja
 */
public class TicTacToeGame implements Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Scanner sc = new Scanner(System.in);
    
    public TicTacToeGame()
    {
        System.out.print("Enter Player 1 name: ");
        String p1 = sc.nextLine();
        System.out.print("Enter Player 2 name: ");
        String p2 = sc.nextLine();
        player1 = new Player(p1, 'X');
        player2 = new Player (p2, 'O');
        board = new Board();
    }
    
    @Override
    public void play()
    {
        boolean running = true;
        while(running)
        {
            board.reset();
            Player current = player1;
            boolean gameOver = false;
            
            while (!gameOver)
            {
                board.printBoard();
                System.out.println(current.getName() + " (" + current.getSymbol() + ") turn.");
                System.out.print("Enter row (0-2): ");
                int row = sc.nextInt();
                System.out.print("Enter col (0-2): ");
                int col = sc.nextInt();
                
                if (!board.makeMove(row, col, current.getSymbol()))
                {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }
                
                if (board.checkWin(current.getSymbol()))
                {
                    board.printBoard();
                    System.out.println(current.getName() + " wins!");
                    current.addScore();
                    FileHandler.saveScore(current);
                    gameOver = true;
                }
                else if (board.isFull())
                {
                    board.printBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                }
                else
                {
                    current = (current == player1) ? player2 : player1;
                }
            }
            
            System.out.print("Play again? (y/n): ");
            String ans = sc.next();
            if (!ans.equalsIgnoreCase("y"))
            {
                running = false;
                FileHandler.printScores();
            }
        }
    }
}
