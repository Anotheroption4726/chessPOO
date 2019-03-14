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
public class QueenMove implements IMove
{

    @Override
    public ArrayList<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition p, Board gameBoard) {
        IChess.ChessColor color = gameBoard.getBoardPieceColor(p);
        ArrayList<IChess.ChessPosition> moveList = new ArrayList<IChess.ChessPosition>();
        
        //droite
        for(int x=p.x + 1; x<IChess.BOARD_WIDTH; x++){
            if(gameBoard.getTable()[p.y][x] != null){
                if(gameBoard.getTable()[p.y][x].getChessColor() != color){
                    moveList.add(new IChess.ChessPosition(x,p.y)); 
                }
                break;
            }
            moveList.add(new IChess.ChessPosition(x,p.y)); 
        }
        
        //gauche
        for(int x=p.x - 1; x>=0; x--){
            if(gameBoard.getTable()[p.y][x] != null){
                if(gameBoard.getTable()[p.y][x].getChessColor() != color){
                    moveList.add(new IChess.ChessPosition(x,p.y)); 
                }
                break;
            }
            moveList.add(new IChess.ChessPosition(x,p.y)); 
        }
        
        //haut
        for(int y=p.y - 1; y>=0; y--){
            if(gameBoard.getTable()[y][p.x] != null){
                if(gameBoard.getTable()[y][p.x].getChessColor() != color){
                    moveList.add(new IChess.ChessPosition(p.x,y)); 
                }
                break;
            }
            moveList.add(new IChess.ChessPosition(p.x,y)); 
        }
        
        //bas
        for(int y=p.y + 1; y<IChess.BOARD_HEIGHT; y++){
            if(gameBoard.getTable()[y][p.x] != null){
                if(gameBoard.getTable()[y][p.x].getChessColor() != color){
                    moveList.add(new IChess.ChessPosition(p.x,y)); 
                }
                break;
            }
            moveList.add(new IChess.ChessPosition(p.x,y)); 
        }
        
        return moveList;
    }
}
