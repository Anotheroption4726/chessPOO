/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;

/**
 *
 * @author charneauadrien
 */
public class KnightMove implements IMove
{

    @Override
    public ArrayList<ChessPosition> getPossibleMoves(ChessPosition p, Board gameBoard)
    {
        ChessPosition tmpPos;
        ChessColor myColor;
        ArrayList<ChessPosition> moveList = new ArrayList<ChessPosition>();
        
        // Retrieve my piece color
        myColor = gameBoard.getBoardPieceColor(p);

        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 1,p.y - 2);
        // Check tmp pos is in the board
        if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
        {
            if(gameBoard.getBoardPieceColor(tmpPos) != myColor)
            {
                moveList.add(tmpPos);
            }
        }

        // Create temp pos
        tmpPos = new ChessPosition(p.x + 1,p.y + 2);
        // Check tmp pos is in the board
        if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
        {
            if(gameBoard.getBoardPieceColor(tmpPos) != myColor)
            {
                moveList.add(tmpPos);
            }
        }

        
        return moveList;
    }   
}
