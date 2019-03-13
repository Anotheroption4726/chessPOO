/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import java.util.ArrayList;

/**
 *
 * @author charneauadrien
 */
public class KingMove implements IMove
{

    @Override
    public ArrayList<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition pos, Board gameBoard) {
        
        ArrayList<IChess.ChessPosition> moveList = new ArrayList<IChess.ChessPosition>();
        
        return moveList;
    }
    
}
