/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoeGame;

/**
 *
 * @author minja
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStrategy implements MoveStrategy 
{
    private final Random rnd = new Random();

    @Override
    public int[] nextMove(Board board, char mySymbol) 
    {
        List<int[]> empty = new ArrayList<>();
        for (int r = 0; r < 3; r++) 
        {
            for (int c = 0; c < 3; c++) 
            {
                if (board.get(r, c) == ' ') 
                {
                    empty.add(new int[]{r, c});
                }
            }
        }
        if (empty.isEmpty()) return null;
        return empty.get(rnd.nextInt(empty.size()));
    }
}
