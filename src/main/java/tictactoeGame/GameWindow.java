/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoeGame;

/**
 *
 * @author minja
 */

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame 
{
    public final JButton[][] buttons = new JButton[3][3];
    public final JLabel status = new JLabel("Player X turn");
    public final JButton resetBtn = new JButton("Reset");
    public final JCheckBox vsAICheck = new JCheckBox("vs AI (Player O)");

    public GameWindow() 
    {
        super("TicTacToe (Swing)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        JPanel top = new JPanel(new BorderLayout());
        top.add(vsAICheck, BorderLayout.WEST);
        top.add(status, BorderLayout.CENTER);
        top.add(resetBtn, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3, 3, 6, 6));
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 48);
        for (int r = 0; r < 3; r++) 
        {
            for (int c = 0; c < 3; c++) 
            {
                JButton b = new JButton("");
                b.setFont(f);
                buttons[r][c] = b;
                center.add(b);
            }
        }
        add(center, BorderLayout.CENTER);

        setSize(380, 440);
        setLocationRelativeTo(null);
    }
}
