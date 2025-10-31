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

/**
 * Hard AI (Minimax for 3x3 TicTacToe)
 * - Win (+10) / Lose (-10) / Draw(0)
 * - Add or subtract the remaining depth as a weight so that the AI wins faster or loses slower
 */
public class SmartStrategy implements MoveStrategy 
{

    @Override
    public int[] nextMove(Board board, char mySymbol) 
    {
        char[][] state = snapshot(board);
        char opp = (mySymbol == 'X') ? 'O' : 'X';

        int bestScore = Integer.MIN_VALUE;
        int[] best = null;

        for (int[] mv : emptyCells(state)) 
        {
            state[mv[0]][mv[1]] = mySymbol;
            int score = minimax(state, /*isMax=*/false, mySymbol, opp, 0);
            state[mv[0]][mv[1]] = ' ';
            if (score > bestScore) 
            {
                bestScore = score;
                best = mv;
            }
        }
        return best;
    }

    // minimax: if isMax=true, mySymbol turn, else opponent turn
    private int minimax(char[][] s, boolean isMax, char me, char opp, int depth) 
    {
        Character winner = winnerOf(s);
        if (winner != null) 
        {
            if (winner == me) return 10 - depth;
            if (winner == opp) return depth - 10;
        }
        if (isFull(s)) return 0;

        if (isMax) 
        {
            int best = Integer.MIN_VALUE;
            for (int[] mv : emptyCells(s)) 
            {
                s[mv[0]][mv[1]] = me;
                best = Math.max(best, minimax(s, false, me, opp, depth + 1));
                s[mv[0]][mv[1]] = ' ';
            }
            return best;
        } else 
        {
            int best = Integer.MAX_VALUE;
            for (int[] mv : emptyCells(s)) 
            {
                s[mv[0]][mv[1]] = opp;
                best = Math.min(best, minimax(s, true, me, opp, depth + 1));
                s[mv[0]][mv[1]] = ' ';
            }
            return best;
        }
    }

    private static char[][] snapshot(Board b) 
    {
        char[][] s = new char[3][3];
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                s[r][c] = b.get(r, c);
        return s;
    }

    private static List<int[]> emptyCells(char[][] s) 
    {
        List<int[]> out = new ArrayList<>();
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (s[r][c] == ' ') out.add(new int[]{r, c});
        return out;
    }

    private static boolean isFull(char[][] s) 
    {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (s[r][c] == ' ') return false;
        return true;
    }

    private static Character winnerOf(char[][] g) 
    {

        for (int i = 0; i < 3; i++) 
        {
            if (g[i][0] != ' ' && g[i][0] == g[i][1] && g[i][1] == g[i][2]) return g[i][0];
            if (g[0][i] != ' ' && g[0][i] == g[1][i] && g[1][i] == g[2][i]) return g[0][i];
        }

        if (g[0][0] != ' ' && g[0][0] == g[1][1] && g[1][1] == g[2][2]) return g[0][0];
        if (g[0][2] != ' ' && g[0][2] == g[1][1] && g[1][1] == g[2][0]) return g[0][2];
        return null;
    }
}
