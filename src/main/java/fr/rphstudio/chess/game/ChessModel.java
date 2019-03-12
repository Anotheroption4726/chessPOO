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
    public void reinit()
    {
        System.out.println("reinit");
        currentBoard = new Board();
    }
    
    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying)
    {
        return 0;
    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        if(p.x<0 || p.x >= IChess.BOARD_WIDTH || p.y<0 || p.y >= IChess.BOARD_HEIGHT ){
            throw new OutOfBoardException();
        }
        
        ChessType typ = currentBoard.getBoardPieceType(p);
        if(typ == null){
            throw new EmptyCellException();
        }
        else{
            return typ;
        }
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        if(p.x<0 || p.x >= IChess.BOARD_WIDTH || p.y<0 || p.y >= IChess.BOARD_HEIGHT ){
            throw new OutOfBoardException();
        }
        
        ChessColor col = currentBoard.getBoardPieceColor(p);
        if(col == null){
            throw new EmptyCellException();
        }
        else{
            return col;
        }
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        int nbrPieces = 0;
        for(int i=0; i< IChess.BOARD_HEIGHT; i++){
            for(int j=0; j< IChess.BOARD_WIDTH; j++){
                ChessPosition cp = new ChessPosition(i,j);
                if(currentBoard.getBoardPieceType(cp) != null && currentBoard.getBoardPieceColor(cp) == color){
                    nbrPieces++;
                }
            }
        }
        
        return nbrPieces;
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p)
    {
        return currentBoard.getMoveAvailableFromBoard(p);
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
