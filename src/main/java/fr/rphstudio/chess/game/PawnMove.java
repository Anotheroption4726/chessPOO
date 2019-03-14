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
 * Class used to generate Pawn's movements
 * @author ludovicKotusik
 */
public class PawnMove implements IMove 
{
    private boolean firstMove = false;
    
    /**
     * Method that return the moves a pawn can perform at this position
     * @param p - the position to check moves
     * @param gameBoard - the board the piece operate
     * @return a list of positions the piece can perform here
     */
    @Override
    public ArrayList<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition p, Board gameBoard) {
        IChess.ChessColor color = gameBoard.getBoardPieceColor(p);
        ArrayList<IChess.ChessPosition> moveList = new ArrayList<IChess.ChessPosition>();
        
        //La direction verticale change en fonction de la couleur de la pièce
        int direction = 1;
        if(color == IChess.ChessColor.CLR_WHITE){
            direction = -1;
        }
        
        //Déplacement avant
        try{
            if(gameBoard.getTable()[p.y + direction][p.x] == null){
                moveList.add(new ChessPosition(p.x, p.y + direction));
            }
        }
        catch(Exception e){

        }
        
        
        //Premier déplacement
        //TODO mettre en place un first move plus propre
        /*
        if(this.firstMove == false){
            moveList.add(new ChessPosition(p.x, p.y + direction*2));
        }
        */
        
        if((color == ChessColor.CLR_WHITE && p.y == 6) || (color == ChessColor.CLR_BLACK && p.y == 1)){
            if(gameBoard.getTable()[p.y + direction][p.x] == null && gameBoard.getTable()[p.y + direction*2][p.x] == null){
                moveList.add(new ChessPosition(p.x, p.y + direction*2));
            }
        }
        
        //Attaque diagonale gauche
        try{
            if(p.x - 1 >= 0){
                if(gameBoard.getTable()[p.y + direction][p.x-1] != null){
                    ChessPosition pos = new ChessPosition(p.x-1,p.y + direction);
                    if(gameBoard.getBoardPieceColor(pos) != color){
                        moveList.add(new ChessPosition(p.x-1, p.y + direction));
                    }
                }
            }
        }
        catch(Exception e){

        }
        
        //Attaque diagonale droite
        try{
            if(p.x + 1 <= IChess.BOARD_WIDTH-1){
                if(gameBoard.getTable()[p.y + direction][p.x+1] != null){
                    ChessPosition pos = new ChessPosition(p.x+1,p.y + direction);
                    if(gameBoard.getBoardPieceColor(pos) != color){
                        moveList.add(new ChessPosition(p.x+1, p.y + direction));
                    }
                }
            }
        }
        catch(Exception e){

        }
        
        return moveList;
    }    
}
