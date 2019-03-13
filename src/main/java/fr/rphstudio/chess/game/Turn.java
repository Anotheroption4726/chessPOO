/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessPosition;

/**
 *
 * @author kotusikludovic
 */
public class Turn {
    private ChessPosition start;
    private Piece played;
    private ChessPosition end;
    private Piece attacked;
    
    public Turn(ChessPosition start, Piece played, ChessPosition end, Piece attacked){
        this.start = start;
        this.played = played;
        this.end = end;
        this.attacked = attacked;
    }
    
    public ChessPosition getStart(){
        return this.start;
    }
    
    public Piece getPlayed(){
        return this.played;
    }
    
    public ChessPosition getEnd(){
        return this.end;
    }
    
    public Piece getAttacked(){
        return this.attacked;
    }
}
