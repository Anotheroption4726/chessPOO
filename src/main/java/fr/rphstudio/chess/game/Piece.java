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
 * Class that is a piece of the game board
 * Contain his type, color and the moves doable
 * @author charneauadrien
 */
public class Piece
{
    private ChessColor color;
    private ChessType type;
    private IMove pieceMove;
    
    /**
     * Constructor that require the type, color and picked to move
     * @param pickedColor - The piece color
     * @param pickedType - The piece type
     * @param pickedMove - The piece movement
     */
    public Piece(ChessColor pickedColor, ChessType pickedType, IMove pickedMove)
    {
        this.color = pickedColor;
        this.type = pickedType;
        this.pieceMove = pickedMove;
    }
    
    /**
     * /**
     * This method is an accessor to the piece color
     * @return the piece color
     */
    public ChessColor getChessColor()
    {
        return this.color;
    }
    
    /**
     * /**
     * This method is an accessor to the piece type
     * @return the piece type
     */
    public ChessType getChessType()
    {
        return this.type;
    }
    
    /**
     * This method return a list of positions that his piece is allowed to do
     * Don't care about making's player king chess
     * @param p - the piece position
     * @param gameBoard - The board used
     * @return The list of position that piece can be placed on
     */
    public List<ChessPosition> getMoveAvailableFromPiece(ChessPosition p, Board gameBoard)
    {    
        return pieceMove.getPossibleMoves(p, gameBoard);
    }
}
