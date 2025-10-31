/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoeGame;

/**
 *
 * @author minja
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmartStrategyTest {

    @Test
    public void testWinningMove() {
        SmartStrategy ai = new SmartStrategy();
        Board b = new Board();
        b.makeMove(0,0,'X');
        b.makeMove(0,1,'X');
        b.makeMove(1,1,'O');

        int[] move = ai.nextMove(b, 'X');
        assertNotNull(move, "AI should find a move");
        assertEquals(0, move[0]);
        assertEquals(2, move[1]);
    }

    @Test
    public void testBlockOpponent() {
        SmartStrategy ai = new SmartStrategy();
        Board b = new Board();
        b.makeMove(1,0,'O');
        b.makeMove(1,1,'O');

        int[] move = ai.nextMove(b, 'X');
        assertNotNull(move);
        assertEquals(1, move[0]);
        assertEquals(2, move[1]);
    }
}

