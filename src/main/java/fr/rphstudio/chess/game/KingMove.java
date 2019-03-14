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
public class KingMove implements IMove
{
    @Override
    public ArrayList<IChess.ChessPosition> getPossibleMoves(ChessPosition p, Board gameBoard)
    {
        ChessPosition tmpPos;
        ChessColor myColor;
        ArrayList<IChess.ChessPosition> moveList = new ArrayList<IChess.ChessPosition>();
        
        // Retrieve my piece color
        myColor = gameBoard.getBoardPieceColor(p);
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x, p.y - 1);
        
        // Check tmp pos is in the board
        if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
        {
            if(gameBoard.getBoardPieceColor(tmpPos) != myColor)
            {
                moveList.add(tmpPos);
            }
        }
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x, p.y + 1);
        
        // Check tmp pos is in the board
        if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
        {
            if(gameBoard.getBoardPieceColor(tmpPos) != myColor)
            {
                moveList.add(tmpPos);
            }
        }
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x + 1, p.y);
        
        // Check tmp pos is in the board
        if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
        {
            if(gameBoard.getBoardPieceColor(tmpPos) != myColor)
            {
                moveList.add(tmpPos);
            }
        }
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 1, p.y);
        
        // Check tmp pos is in the board
        if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
        {
            if(gameBoard.getBoardPieceColor(tmpPos) != myColor)
            {
                moveList.add(tmpPos);
            }
        }
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 1, p.y - 1);
        
        // Check tmp pos is in the board
        if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
        {
            if(gameBoard.getBoardPieceColor(tmpPos) != myColor)
            {
                moveList.add(tmpPos);
            }
        }
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 1, p.y + 1);
        
        // Check tmp pos is in the board
        if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
        {
            if(gameBoard.getBoardPieceColor(tmpPos) != myColor)
            {
                moveList.add(tmpPos);
            }
        }
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x + 1, p.y - 1);
        
        // Check tmp pos is in the board
        if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
        {
            if(gameBoard.getBoardPieceColor(tmpPos) != myColor)
            {
                moveList.add(tmpPos);
            }
        }
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x + 1, p.y + 1);
        
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
