/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessType;

/**
 *
 * @author charneauadrien
 */
public class Board
{
    private Piece[][] table = new Piece[8][8];
    
    public Board ()
    {
         for (int i = 0; i < IChess.BOARD_WIDTH; i++)
         {
             for (int j = 0; j < IChess.BOARD_POS_Y_BLACK_PAWNS; j++)
             {
                this.table[i][j] = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_PAWN);
             }
         }
    } 
}
