/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessPosition;

/**
 * Class used for recording turns.
 * It contains :
 * - The start piece position
 * - The end piece position
 * - The piece played
 * - The piece (if any) attacked
 */
public class Turn {
    private ChessPosition start;
    private Piece played;
    private ChessPosition end;
    private Piece attacked;
    private long turnTime;
    
    /**
     * Constructor that need the turn based informations to work
     * @param start - start piece position
     * @param played - The moving/attacking piece
     * @param end - end piece position
     * @param attacked  - The piece (if any) that is attacked
     */
    public Turn(ChessPosition start, Piece played, ChessPosition end, Piece attacked, long turnTime){
        this.start = start;
        this.played = played;
        this.end = end;
        this.attacked = attacked;
        this.turnTime = turnTime;
    }
    
    /**
     * This method is an accessor for the piece start position
     * @return the start position
     */
    public ChessPosition getStart(){
        return this.start;
    }
    
    /**
     * This method is an accessor for the piece that move/attack
     * @return the moving piece
     */
    public Piece getPlayed(){
        return this.played;
    }
    
    /**
     * This method is an accessor for the piece end position
     * @return the end position
     */
    public ChessPosition getEnd(){
        return this.end;
    }
    
    /**
     * This method is an accessor for the piece that being attacked
     * @return the attacked piece
     */
    public Piece getAttacked(){
        return this.attacked;
    }

    /**
     * This method is an accessor for the time require to finish this turn
     * @return the time in millisecond
     */
    public long getTurnTime(){
        return this.turnTime;
    }
}
