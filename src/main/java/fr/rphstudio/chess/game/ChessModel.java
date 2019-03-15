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
 * Class ChessModel basec on the interface
 * Please refer to the interface for the javadoc
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
        return currentBoard.getBoardPlayerDuration(color, isPlaying);
        /*
        if(color == ChessColor.CLR_BLACK){
            if(isPlaying){
                return System.currentTimeMillis() - this.currentTime + this.blackTime;
            }
            else{
                return this.blackTime;
            }
            
        }
        else{
            if(isPlaying){
                return System.currentTimeMillis() - this.currentTime + this.whiteTime;
            }
            else{
                return this.whiteTime;
            }
        }
        */
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
        //On vérifie que les mouvements occasionnés n'occasionnent pas un échec chez soi
        List<ChessPosition> availableMoves = new ArrayList<ChessPosition>();
        List<ChessPosition> moves = currentBoard.getMoveAvailableFromBoard(p);
        
        ChessColor color = currentBoard.getBoardPieceColor(p);
        for(int i=0; i<moves.size(); i++){
            Board dummy = new Board(currentBoard.getTable());
            dummy.moveBoardPiece(p, moves.get(i));
            if(dummy.getBoardKingState(color) == ChessKingState.KING_SAFE){
                availableMoves.add(moves.get(i));
            }
        }
            
        return availableMoves;
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1)
    {
        //Gestion du temps
        currentBoard.moveBoardPiece(p0, p1);
        
        if (currentBoard.getBoardPieceType(p1) == ChessType.TYP_PAWN)
        {
            if (p1.y == 0 && currentBoard.getBoardPieceColor(p1) == ChessColor.CLR_WHITE)
            {
                currentBoard.switchPawnToQueen(p1, ChessColor.CLR_WHITE);
            }
            
            if (p1.y == IChess.BOARD_HEIGHT - 1 && currentBoard.getBoardPieceColor(p1) == ChessColor.CLR_BLACK)
            {
                currentBoard.switchPawnToQueen(p1, ChessColor.CLR_BLACK);
            }   
        }
    }

    @Override
    public ChessKingState getKingState(ChessColor clr) {
        return currentBoard.getBoardKingState(clr);
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return currentBoard.getBoardPiecesPerdues(color);
    }

    @Override
    public boolean undoLastMove() {
        return currentBoard.undoBoardLastMove();
    }
}
