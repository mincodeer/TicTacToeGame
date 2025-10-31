package tictactoeGame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author minja
 */
import javax.swing.*;

public class SwingTicTacToeGame implements Game 
{
    private final Board board = new Board();
    private Player player1;
    private Player player2;
    private Player current;
    private final GameWindow view = new GameWindow();

    // AI (uses O)
    private final MoveStrategy ai = new RandomStrategy();

    public SwingTicTacToeGame() 
    {
        String p1 = JOptionPane.showInputDialog(null, "Enter Player 1 name (X):", "Player 1", JOptionPane.PLAIN_MESSAGE);
        if (p1 == null || p1.isBlank()) p1 = "Player1";
        String p2 = JOptionPane.showInputDialog(null, "Enter Player 2 name (O):", "Player 2", JOptionPane.PLAIN_MESSAGE);
        if (p2 == null || p2.isBlank()) p2 = "Player2";

        player1 = new Player(p1, 'X');
        player2 = new Player(p2, 'O');
        current  = player1;

        wireEvents();
        refreshView();
    }

    @Override
    public void play() 
    {
        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }

    private void wireEvents() 
    {
        for (int r = 0; r < 3; r++) 
        {
            for (int c = 0; c < 3; c++) 
            {
                final int rr = r, cc = c;
                view.buttons[r][c].addActionListener(e -> onHumanClick(rr, cc));
            }
        }
        view.resetBtn.addActionListener(e -> 
        {
            board.reset();
            current = player1;
            refreshView();
        });
        view.vsAICheck.addActionListener(e -> refreshView());
    }

    private void onHumanClick(int r, int c) 
    {
        if (!board.makeMove(r, c, current.getSymbol())) 
        {
            java.awt.Toolkit.getDefaultToolkit().beep();
            return;
        }
        if (afterMoveCheckAndMaybeEnd()) return;

        current = (current == player1) ? player2 : player1;
        refreshView();

        maybeAIMove();
    }

    private boolean afterMoveCheckAndMaybeEnd() 
    {
        if (board.checkWin(current.getSymbol())) 
        {
            refreshView();
            JOptionPane.showMessageDialog(view, current.getName() + " (" + current.getSymbol() + ") wins!");
            current.addScore();
            FileHandler.saveScore(current);
            askReplayOrClose();
            return true;
        }
        if (board.isFull()) 
        {
            refreshView();
            JOptionPane.showMessageDialog(view, "It's a draw!");
            askReplayOrClose();
            return true;
        }
        return false;
    }

    private void maybeAIMove() 
    {
        if (!view.vsAICheck.isSelected()) return;
        if (current != player2) return;
        if (board.isFull()) return;

        SwingUtilities.invokeLater(() -> 
        {
            int[] mv = ai.nextMove(board, current.getSymbol());
            if (mv != null) 
            {
                board.makeMove(mv[0], mv[1], current.getSymbol());
                if (afterMoveCheckAndMaybeEnd()) return;

                current = player1;
                refreshView();
            }
        });
    }

    private void askReplayOrClose() 
    {
        int opt = JOptionPane.showConfirmDialog(view, "Play again?", "Next Round", JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_OPTION) 
        {
            board.reset();
            current = player1;
            refreshView();
        } else 
        {
            FileHandler.printScores();
            view.dispose();
        }
    }

    private void refreshView() 
    {
        for (int r = 0; r < 3; r++) 
        {
            for (int c = 0; c < 3; c++) 
            {
                char ch = board.get(r, c);
                view.buttons[r][c].setText(ch == ' ' ? "" : String.valueOf(ch));
                view.buttons[r][c].setEnabled(ch == ' ');
            }
        }
        String mode = view.vsAICheck.isSelected() ? "Human vs AI" : "Human vs Human";
        view.status.setText(mode + " — Player " + current.getName() + " (" + current.getSymbol() + ") turn");
    }
}