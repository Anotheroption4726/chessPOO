/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author charneauadrien
 */
public class ChessModel implements IChess
{
    private static ChessModel instance;
    private static Board currentBoard;
    
    private ChessModel()
    {
        
    }
    
    public static ChessModel getInstance()
    {
        if(ChessModel.instance == null)
        {
            ChessModel.instance = new ChessModel();
            currentBoard = new Board();
        }
        return ChessModel.instance;
    }
    
    @Override
    public void reinit() {
    }
    
    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying)
    {
        return 0;
    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        ChessType typ = currentBoard.getPieceType(p);
        if(typ == null){
            throw new EmptyCellException();
        }
        else{
            return typ;
        }
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        ChessColor col = currentBoard.getPieceColor(p);
        if(col == null){
            throw new EmptyCellException();
        }
        else{
            return col;
        }
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return 0;
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        return new ArrayList<ChessPosition>(); 
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return ChessKingState.KING_SAFE;
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return new ArrayList<ChessType>();
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }
}
