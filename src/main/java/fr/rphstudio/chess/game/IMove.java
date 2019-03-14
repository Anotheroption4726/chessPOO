/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;

/**
 * Interface used for generating classes used for pieces movements on each
 * piece type.
 * @author ludovickotusik
 */
public interface IMove 
{
    /**
     * Interface used for each type of piece's movements
     * @param pos - The piece position
     * @param gameBoard - The board played on
     * @return a list of positions the piece can perform here
     */
    public ArrayList<ChessPosition> getPossibleMoves(ChessPosition pos, Board gameBoard);
}
