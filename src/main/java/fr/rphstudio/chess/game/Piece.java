/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessType;

/**
 *
 * @author charneauadrien
 */
public class Piece
{
    private ChessColor color;
    private ChessType type;
    
    public Piece(ChessColor pickedColor, ChessType pickedType)
    {
        this.color = pickedColor;
        this.type = pickedType;
    }
    
    public ChessColor getChessColor ()
    {
        return this.color;
    }
    
    public ChessType getChessType ()
    {
        return this.type;
    }
}
