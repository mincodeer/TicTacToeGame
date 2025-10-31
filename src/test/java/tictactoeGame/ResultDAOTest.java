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
import java.util.List;

public class ResultDAOTest {

    @Test
    public void testInsertAndRead() {
        DatabaseManager.ensureTable();

        ResultDAO.insert("TesterX", "TesterO", "TesterX");

        List<String[]> recent = ResultDAO.getRecent(5);
        assertFalse(recent.isEmpty(), "Results list should not be empty");

        boolean found = recent.stream().anyMatch(r ->
                r[0].equals("TesterX") && r[1].equals("TesterO") && r[2].equals("TesterX"));
        assertTrue(found, "Inserted record should be present");
    }
}

