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
public class PawnMove implements IMove 
{
    private boolean firstMove = false;
    
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
        if(gameBoard.getTable()[p.y + direction][p.x] == null){
            moveList.add(new ChessPosition(p.x, p.y + direction));
        }
        
        //Premier déplacement
        //TODO mettre en place un first move plus propre
        /*
        if(this.firstMove == false){
            moveList.add(new ChessPosition(p.x, p.y + direction*2));
        }
        */
        
        if((color == ChessColor.CLR_WHITE && p.y == 6) || (color == ChessColor.CLR_BLACK && p.y == 1)){
            moveList.add(new ChessPosition(p.x, p.y + direction*2));
        }
        
        //Attaque diagonale gauche
        if(p.x - 1 >= 0){
            if(gameBoard.getTable()[p.y + direction][p.x-1] != null){
                ChessPosition pos = new ChessPosition(p.x-1,p.y + direction);
                if(gameBoard.getBoardPieceColor(pos) != color){
                    moveList.add(new ChessPosition(p.x-1, p.y + direction));
                }
            }
        }
        
        //Attaque diagonale droite
        if(p.x + 1 < IChess.BOARD_WIDTH){
            if(gameBoard.getTable()[p.y + direction][p.x+1] != null){
                ChessPosition pos = new ChessPosition(p.x+1,p.y + direction);
                if(gameBoard.getBoardPieceColor(pos) != color){
                    moveList.add(new ChessPosition(p.x+1, p.y + direction));
                }
            }
        }
        
        return moveList;
    }    
}
