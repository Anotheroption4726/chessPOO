/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import static fr.rphstudio.chess.interf.IChess.BOARD_HEIGHT;
import static fr.rphstudio.chess.interf.IChess.BOARD_WIDTH;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;

/**
 * Class used to generate Knight's movements
 * @author charneauadrien
 */
public class KnightMove implements IMove
{

    /**
     * Method that return the moves a knight can perform at this position
     * @param p - the position to check moves
     * @param gameBoard - the board the piece operate
     * @return a list of positions the piece can perform here
     */
    @Override
    public ArrayList<ChessPosition> getPossibleMoves(ChessPosition p, Board gameBoard)
    {
        ChessPosition tmpPos;
        ChessColor myColor;
        ArrayList<ChessPosition> moveList = new ArrayList<ChessPosition>();
        
        // Retrieve my piece color
        myColor = gameBoard.getBoardPieceColor(p);

        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 1, p.y - 2);
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        

        // Create temp pos
        tmpPos = new ChessPosition(p.x + 1, p.y + 2);
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 1, p.y + 2);
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x + 1, p.y - 2);
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 2, p.y - 1);
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        

        // Create temp pos
        tmpPos = new ChessPosition(p.x + 2, p.y + 1);
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x - 2, p.y + 1);
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        // Create temp pos
        tmpPos = new ChessPosition(p.x + 2, p.y - 1);
        // Check tmp pos is in the board
        AddMoveList(tmpPos, gameBoard, myColor, moveList);
        
        
        return moveList;
    }
    
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
