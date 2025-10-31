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
    public final JComboBox<String> aiLevelBox = new JComboBox<>(new String[]{"Easy", "Hard"});

    public GameWindow()
    {
        super("TicTacToe (Swing)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        
        JMenuBar menuBar = new JMenuBar();
        JMenu recordsMenu = new JMenu("Records");
        JMenuItem showRecentItem = new JMenuItem("Show Recent 10");
        recordsMenu.add(showRecentItem);
        menuBar.add(recordsMenu);
        setJMenuBar(menuBar);
        
        showRecentItem.addActionListener(e -> ResultDialog.showRecent(this));

        JPanel top = new JPanel(new BorderLayout(8, 8));

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        left.add(vsAICheck);
        left.add(new JLabel("AI:"));
        left.add(aiLevelBox);

        top.add(left, BorderLayout.WEST);
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

        setSize(420, 480);
        setLocationRelativeTo(null);
    }
}
