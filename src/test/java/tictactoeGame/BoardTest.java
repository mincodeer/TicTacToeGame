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

public class BoardTest {

    @Test
    public void testWinRow() {
        Board b = new Board();
        b.makeMove(0, 0, 'X');
        b.makeMove(0, 1, 'X');
        b.makeMove(0, 2, 'X');
        assertTrue(b.checkWin('X'), "Row win should be detected");
    }

    @Test
    public void testWinColumn() {
        Board b = new Board();
        b.makeMove(0, 0, 'O');
        b.makeMove(1, 0, 'O');
        b.makeMove(2, 0, 'O');
        assertTrue(b.checkWin('O'), "Column win should be detected");
    }

    @Test
    public void testDrawCondition() {
        Board b = new Board();
        char[] moves = {'X','O','X','O','O','X','X','X','O'};
        int k = 0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                b.makeMove(i,j,moves[k++]);
        assertTrue(b.isFull(), "Board should be full");
        assertFalse(b.checkWin('X'), "No one should win");
        assertFalse(b.checkWin('O'), "No one should win");
    }
}

