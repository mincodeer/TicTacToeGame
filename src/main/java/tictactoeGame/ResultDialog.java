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
import java.util.List;

public class ResultDialog {
    public static void showRecent(JFrame parent) {
        List<String[]> rows = ResultDAO.getRecent(10);
        String[] cols = {"Player X", "Player O", "Winner", "Played At"};
        JTable table = new JTable(rows.toArray(new String[0][]), cols);
        table.setEnabled(false);
        JScrollPane sc = new JScrollPane(table);
        JOptionPane.showMessageDialog(parent, sc, "Recent Results", JOptionPane.PLAIN_MESSAGE);
    }
}
