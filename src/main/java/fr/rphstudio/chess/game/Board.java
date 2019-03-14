/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessKingState;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import fr.rphstudio.chess.interf.IChess.ChessType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author charneauadrien
 */
public class Board
{
    private Piece[][] table = new Piece[8][8];
    private ArrayList<ChessType> piecesPerduesBlanc = new ArrayList<ChessType>();
    private ArrayList<ChessType> piecesPerduesNoir = new ArrayList<ChessType>();
    private ArrayList<Turn> history = new ArrayList<Turn>();
    
    public Board()
    {
        for (int i = 0; i < IChess.BOARD_HEIGHT; i++)
        {
            for (int j = 0; j < IChess.BOARD_WIDTH; j++)
            {
                ChessColor color = null;
                switch(i){
                    case IChess.BOARD_POS_Y_BLACK_PIECES:
                    case IChess.BOARD_POS_Y_BLACK_PAWNS:
                        color = ChessColor.CLR_BLACK;
                        break;
                    
                    case IChess.BOARD_POS_Y_WHITE_PIECES:
                    case IChess.BOARD_POS_Y_WHITE_PAWNS:
                        color = ChessColor.CLR_WHITE;
                        break;
                    default:
                        continue;
                }
                
                ChessType type = null;
                IMove move = null;
                if(i == IChess.BOARD_POS_Y_BLACK_PIECES || i == IChess.BOARD_POS_Y_WHITE_PIECES){
                    switch(j){
                        case IChess.BOARD_POS_X_QUEENSIDE_ROOK:
                        case IChess.BOARD_POS_X_KINGSIDE_ROOK:
                            type = ChessType.TYP_ROOK;
                            move = new RookMove();
                            break;

                        case IChess.BOARD_POS_X_QUEENSIDE_KNIGHT:
                        case IChess.BOARD_POS_X_KINGSIDE_KNIGHT:
                            type = ChessType.TYP_KNIGHT;
                            move = new KnightMove();
                            break;

                        case IChess.BOARD_POS_X_QUEENSIDE_BISHOP:
                        case IChess.BOARD_POS_X_KINGSIDE_BISHOP:
                            type = ChessType.TYP_BISHOP;
                            // move = new KnightMove();
                            move = new BishopMove();
                            break;

                        case IChess.BOARD_POS_X_QUEEN:
                            type = ChessType.TYP_QUEEN;
                            move = new KnightMove();
                            // move = new QueenMove();
                            break;

                        case IChess.BOARD_POS_X_KING:
                            type = ChessType.TYP_KING;
                            // move = new KnightMove();
                            move = new KingMove();
                    }
                }
                
                else if(i == IChess.BOARD_POS_Y_BLACK_PAWNS || i == IChess.BOARD_POS_Y_WHITE_PAWNS){
                    type = ChessType.TYP_PAWN;
                    move = new PawnMove();
                }
                
                else{
                    continue;
                }
                System.out.println(i+"-"+j);
                table[i][j] = new Piece(color, type, move);
            }
        }
    }
    
    public Piece[][] getTable ()
    {
        return table;
    }
    
    public ChessColor getBoardPieceColor(ChessPosition p){
        if(this.table[p.y][p.x] == null){
            return null;
        }
        else{
            return this.table[p.y][p.x].getChessColor();
        }
    }
    
    public ChessType getBoardPieceType(ChessPosition p){
        if(this.table[p.y][p.x] == null){
            return null;
        }
        else{
            return this.table[p.y][p.x].getChessType();
        }
    }
    
    public List<ChessPosition> getMoveAvailableFromBoard(ChessPosition p)
    {   
        if(this.table[p.y][p.x] != null ){
            return this.table[p.y][p.x].getMoveAvailableFromPiece(p, this);
        }
        return new ArrayList<ChessPosition>();
    }
    
    public void moveBoardPiece(ChessPosition p0, ChessPosition p1){
        Piece attacked=null;
        
        //Enregistre la pièce mangé si une attaque est effectué
        if(this.table[p1.y][p1.x] != null){
            attacked = this.table[p1.y][p1.x];
            if(this.table[p1.y][p1.x].getChessColor() == IChess.ChessColor.CLR_BLACK){
                this.piecesPerduesNoir.add(this.table[p1.y][p1.x].getChessType());
            }
            else if(this.table[p1.y][p1.x].getChessColor() == IChess.ChessColor.CLR_WHITE){
                this.piecesPerduesBlanc.add(this.table[p1.y][p1.x].getChessType());
            }
        }
        
        //Enregistre dans l'historique le coup porté
        history.add(new Turn(p0,this.table[p0.y][p0.x],p1,attacked));
        
        this.table[p1.y][p1.x] = this.table[p0.y][p0.x];
        this.table[p0.y][p0.x] = null;
    }
    
    public List<ChessType> getBoardPiecesPerdues(ChessColor clr){
        if(clr == IChess.ChessColor.CLR_BLACK){
            return this.piecesPerduesNoir;
        }
        else{
            return this.piecesPerduesBlanc;
        }
    }
    
    public void switchPawnToQueen(ChessPosition p, ChessColor color)
    {
        // CHANGE MOVE ARGUMENT !!!!!!
        this.table[p.y][p.x] = new Piece(color, ChessType.TYP_QUEEN, new KnightMove());
    }
    
    private ChessPosition getKingPosition(ChessColor clr){
        for(int i=0; i< IChess.BOARD_HEIGHT ; i++){
            for(int j=0; j< IChess.BOARD_WIDTH ; j++){
                ChessPosition pos = new ChessPosition(j,i);
                if(this.getBoardPieceType(pos) == ChessType.TYP_KING && this.getBoardPieceColor(pos) == clr){
                    return pos;
                }
            }
        }
        
        return new ChessPosition();
    }
    
    public ChessKingState getBoardKingState(ChessColor clr){
        ChessPosition kingPos = this.getKingPosition(clr);
        
        for(int i=0; i< IChess.BOARD_HEIGHT ; i++){
            for(int j=0; j< IChess.BOARD_WIDTH ; j++){
                ChessPosition pos = new ChessPosition(j,i);
                List<ChessPosition> cp_list = this.getMoveAvailableFromBoard(pos);
                
                for(int k=0; k<cp_list.size(); k++){
                    if(kingPos.equals(cp_list.get(k))){
                        return ChessKingState.KING_THREATEN;
                    }
                }
            }
        }
        
        return ChessKingState.KING_SAFE;
    }
    
    public boolean undoBoardLastMove() {
        if(history.size() > 0){
            Piece played = history.get(history.size()-1).getPlayed();
            Piece attacked = history.get(history.size()-1).getAttacked();
            ChessPosition start = history.get(history.size()-1).getStart();
            ChessPosition end = history.get(history.size()-1).getEnd();
            
            this.table[start.y][start.x] = played;
            
            if(attacked == null){
                this.table[end.y][end.x] = null;
            }
            else{
                this.table[end.y][end.x] = attacked;
                
                if(attacked.getChessColor() == ChessColor.CLR_BLACK){
                    this.piecesPerduesNoir.remove(this.piecesPerduesNoir.size()-1);
                }
                else{
                    this.piecesPerduesBlanc.remove(this.piecesPerduesBlanc.size()-1);
                }
            }
            
            history.remove(history.size()-1);
            
            return true;
        }
        else{
            return false;
        }
    }
}
