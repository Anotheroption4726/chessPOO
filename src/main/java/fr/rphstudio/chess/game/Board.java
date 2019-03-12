/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessType;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
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
                switch(i){
                ChessColor color = null;
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
                            type = ChessType.TYP_ROOK;
                        case IChess.BOARD_POS_X_KINGSIDE_ROOK:
                            break;

    }
        return this.table[p.y][p.x].getMoveAvailableFromPiece(p);
    {    
    public List<ChessPosition> getMoveAvailableFromBoard(ChessPosition p)
    
    }
        }
            return this.table[p.y][p.x].getChessType();
        else{
        }
            return null;
        if(this.table[p.y][p.x] == null){
    public ChessType getBoardPieceType(ChessPosition p){
    
    }
        }
            return this.table[p.y][p.x].getChessColor();
        else{
        }
            return null;
        if(this.table[p.y][p.x] == null){
    public ChessColor getBoardPieceColor(ChessPosition p){
    
    }
        }
            }
                table[i][j] = new Piece(color, type);
                System.out.println(i+"-"+j);
                }
                    continue;
                else{
                
                }
                    type = ChessType.TYP_PAWN;
                else if(i == IChess.BOARD_POS_Y_BLACK_PAWNS || i == IChess.BOARD_POS_Y_WHITE_PAWNS){
                
                }
                    }
                            type = ChessType.TYP_KING;
                        case IChess.BOARD_POS_X_KING:

                            break;
                            type = ChessType.TYP_QUEEN;
                        case IChess.BOARD_POS_X_QUEEN:

                            break;
                            type = ChessType.TYP_BISHOP;
                        case IChess.BOARD_POS_X_KINGSIDE_BISHOP:
                        case IChess.BOARD_POS_X_QUEENSIDE_BISHOP:

                            break;
                            type = ChessType.TYP_KNIGHT;
                        case IChess.BOARD_POS_X_KINGSIDE_KNIGHT:
                        case IChess.BOARD_POS_X_QUEENSIDE_KNIGHT:
}
