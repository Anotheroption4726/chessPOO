/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessType;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.List;

/**
 *
 * @author charneauadrien
 */
public class Piece
{
    private ChessColor color;
    private ChessType type;
    private IMove pieceMove;
    
    public Piece(ChessColor pickedColor, ChessType pickedType, IMove pickedMove)
    {
        this.color = pickedColor;
        this.type = pickedType;
        this.pieceMove = pickedMove;
    }
    
    public ChessColor getChessColor()
    {
        return this.color;
    }
    
    public ChessType getChessType()
    {
        return this.type;
    }
    
    public List<ChessPosition> getMoveAvailableFromPiece(ChessPosition p, Board gameBoard)
    {    
        return pieceMove.getPossibleMoves(p, gameBoard);
    }
}
