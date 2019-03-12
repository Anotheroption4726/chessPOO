/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
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
                if(i == IChess.BOARD_POS_Y_BLACK_PIECES || i == IChess.BOARD_POS_Y_WHITE_PIECES){
                    switch(j){
                        case IChess.BOARD_POS_X_QUEENSIDE_ROOK:
                        case IChess.BOARD_POS_X_KINGSIDE_ROOK:
                            type = ChessType.TYP_ROOK;
                            break;

                        case IChess.BOARD_POS_X_QUEENSIDE_KNIGHT:
                        case IChess.BOARD_POS_X_KINGSIDE_KNIGHT:
                            type = ChessType.TYP_KNIGHT;
                            break;

                        case IChess.BOARD_POS_X_QUEENSIDE_BISHOP:
                        case IChess.BOARD_POS_X_KINGSIDE_BISHOP:
                            type = ChessType.TYP_BISHOP;
                            break;

                        case IChess.BOARD_POS_X_QUEEN:
                            type = ChessType.TYP_QUEEN;
                            break;

                        case IChess.BOARD_POS_X_KING:
                            type = ChessType.TYP_KING;
                    }
                }
                
                else if(i == IChess.BOARD_POS_Y_BLACK_PAWNS || i == IChess.BOARD_POS_Y_WHITE_PAWNS){
                    type = ChessType.TYP_PAWN;
                }
                
                else{
                    continue;
                }
                System.out.println(i+"-"+j);
                table[i][j] = new Piece(color, type);
            }
        }
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
        return this.table[p.y][p.x].getMoveAvailableFromPiece(p);
    }
}
