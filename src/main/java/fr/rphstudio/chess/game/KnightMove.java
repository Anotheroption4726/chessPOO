/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author charneauadrien
 */
public class KnightMove implements IMove
{

    @Override
    public ArrayList<ChessPosition> getPossibleMoves(ChessPosition p, Board gameBoard)
    {
        ArrayList<ChessPosition> moveList = new ArrayList<ChessPosition>();
        
        if (gameBoard.getTable()[p.y - 1][p.x] != null)
        {
            moveList.add(new ChessPosition(p.x, p.y - 1));
        }
        
        return moveList;
    }   
}
