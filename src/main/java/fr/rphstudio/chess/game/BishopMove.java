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
public class BishopMove implements IMove
{
    @Override
    public ArrayList<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition p, Board gameBoard)
    {
        ChessColor color = gameBoard.getBoardPieceColor(p);
        ArrayList<ChessPosition> moveList = new ArrayList<ChessPosition>();
        
        
        // Setting vertical Increment
        int verticalCount = 1;
        
        for(int x = p.x + 1; x < BOARD_WIDTH; x++)
        {
            if (p.y - verticalCount >= 0)
            {
                if(gameBoard.getTable()[p.y - verticalCount][x] != null)
                {
                    if(gameBoard.getTable()[p.y - verticalCount][x].getChessColor() != color)
                    {
                        moveList.add(new ChessPosition(x, p.y - verticalCount));
                    }
                    break;
                }
                moveList.add(new ChessPosition(x, p.y - verticalCount));
                verticalCount++;
            }
            else
            {
                break;
            }
        }
        
        
        // Setting vertical Increment
        verticalCount = 1;
        
        for(int x = p.x + 1; x < BOARD_WIDTH; x++)
        {
            if (p.y + verticalCount < BOARD_HEIGHT)
            {
                if(gameBoard.getTable()[p.y + verticalCount][x] != null)
                {
                    if(gameBoard.getTable()[p.y + verticalCount][x].getChessColor() != color)
                    {
                        moveList.add(new ChessPosition(x, p.y + verticalCount));
                    }
                    break;
                }
                moveList.add(new ChessPosition(x, p.y + verticalCount));
                verticalCount++;
            }
            else
            {
                break;
            }
        }
        
        
        // Setting vertical Increment
        verticalCount = 1;
        
        for(int x = p.x - 1; x >= 0; x--)
        {
            if (p.y + verticalCount < BOARD_HEIGHT)
            {
                if(gameBoard.getTable()[p.y + verticalCount][x] != null)
                {
                    if(gameBoard.getTable()[p.y + verticalCount][x].getChessColor() != color)
                    {
                        moveList.add(new ChessPosition(x, p.y + verticalCount));
                    }
                    break;
                }
                moveList.add(new ChessPosition(x, p.y + verticalCount));
                verticalCount++;
            }
            else
            {
                break;
            }
        }
        
        
        // Setting vertical Increment
        verticalCount = 1;
        
        for(int x = p.x - 1; x >= 0; x--)
        {
            if (p.y - verticalCount >= 0)
            {
                if(gameBoard.getTable()[p.y - verticalCount][x] != null)
                {
                    if(gameBoard.getTable()[p.y - verticalCount][x].getChessColor() != color)
                    {
                        moveList.add(new ChessPosition(x, p.y - verticalCount));
                    }
                    break;
                }
                moveList.add(new ChessPosition(x, p.y - verticalCount));
                verticalCount++;
            }
            else
            {
                break;
            }
        }
        
        
        return moveList;
    }    
}
