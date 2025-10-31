/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tictactoeGame;

/**
 *
 * @author minja
 */

public interface MoveStrategy 
{
    int[] nextMove(Board board, char mySymbol);
}