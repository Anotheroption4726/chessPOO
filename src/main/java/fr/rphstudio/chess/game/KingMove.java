/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import static fr.rphstudio.chess.interf.IChess.BOARD_HEIGHT;
import static fr.rphstudio.chess.interf.IChess.BOARD_WIDTH;
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
        ArrayList<ChessPosition> moveList = new ArrayList<ChessPosition>();
        
        // Retrieve my piece color
        myColor = gameBoard.getBoardPieceColor(p);
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x, p.y - 1);
        
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x, p.y + 1);
        
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x + 1, p.y);
        
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 1, p.y);
        
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 1, p.y - 1);
        
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 1, p.y + 1);
        
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x + 1, p.y - 1);
        
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x + 1, p.y + 1);
        
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        return moveList;
    }
    
    //If tmpPos is not out of bounds or on ally position, add it to the moveList
    private void AddMoveList (ChessPosition tmpPos, Board gameBoard, ChessColor myColor, ArrayList<ChessPosition> moveList)
    {
        if(tmpPos.x >= 0 && tmpPos.x < BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < BOARD_HEIGHT)
        {
            if(gameBoard.getBoardPieceColor(tmpPos) != myColor)
            {
                moveList.add(tmpPos);
            }
        }
    }
    
}
