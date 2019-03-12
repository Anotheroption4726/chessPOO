/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;

/**
 *
 * @author kotusikludovic
 */
public class BishopMove implements IMove {

    @Override
    public ArrayList<ChessPosition> getPossibleMoves(IChess.ChessPosition pos, Board gameBoard) {
        ArrayList<ChessPosition> cp_list =  new ArrayList<ChessPosition>();
        cp_list.add(new ChessPosition(pos.x,pos.y-3));
        return cp_list;
    }
    
}
