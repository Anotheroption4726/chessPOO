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
import java.util.List;

/**
 * Class used to generate Rook's movements
 * @author charneauadrien
 */
public class RookMove implements IMove
{

    /**
     * Method that return the moves a rook can perform at this position
     * @param p - the position to check moves
     * @param gameBoard - the board the piece operate
     * @return a list of positions the piece can perform here
     */
    @Override
    public ArrayList<ChessPosition> getPossibleMoves(ChessPosition p, Board gameBoard)
    {   
        ChessColor color = gameBoard.getBoardPieceColor(p);
        ArrayList<ChessPosition> moveList = new ArrayList<ChessPosition>();
        
        //droite
        for(int x=p.x + 1; x<IChess.BOARD_WIDTH; x++){
            if(gameBoard.getTable()[p.y][x] != null){
                if(gameBoard.getTable()[p.y][x].getChessColor() != color){
                    moveList.add(new ChessPosition(x,p.y)); 
                }
                break;
            }
            moveList.add(new ChessPosition(x,p.y)); 
        }
        
        //gauche
        for(int x=p.x - 1; x>=0; x--){
            if(gameBoard.getTable()[p.y][x] != null){
                if(gameBoard.getTable()[p.y][x].getChessColor() != color){
                    moveList.add(new ChessPosition(x,p.y)); 
                }
                break;
            }
            moveList.add(new ChessPosition(x,p.y)); 
        }
        
        //haut
        for(int y=p.y - 1; y>=0; y--){
            if(gameBoard.getTable()[y][p.x] != null){
                if(gameBoard.getTable()[y][p.x].getChessColor() != color){
                    moveList.add(new ChessPosition(p.x,y)); 
                }
                break;
            }
            moveList.add(new ChessPosition(p.x,y)); 
        }
        
        //bas
        for(int y=p.y + 1; y<IChess.BOARD_HEIGHT; y++){
            if(gameBoard.getTable()[y][p.x] != null){
                if(gameBoard.getTable()[y][p.x].getChessColor() != color){
                    moveList.add(new ChessPosition(p.x,y)); 
                }
                break;
            }
            moveList.add(new ChessPosition(p.x,y)); 
        }
        
        return moveList;
    }
}