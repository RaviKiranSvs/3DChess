package com.unothodox.entertainment.a3dchess;

import java.util.ArrayList;

class ChessBoard {
    
    static class piece {
        int piece, BG;

        piece() {
        }

        piece(int piece, int BG) {
            this.piece = piece;
            this.BG = BG;
        }
    }

    private piece[][] config = new piece[8][8];

    /* pieceAt
    key -   symbol
    ---------------
    0   -   absent
    1   -   present
     */

    /* BGat
    key -   symbol              -   color
    -------------------------------------------
    0   -   nothing             -   transparent
    1   -   possible movement   -   blue
     */

    ChessBoard() {
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                config[i][j] = new piece();
                if (i == 0 && j == 0)
                    config[i][j].piece = 1;
                else
                    config[i][j].piece = 0;
                config[i][j].BG = 0;
            }
        }
    }

    ArrayList<piece> getBoard() {
        ArrayList<piece> e = new ArrayList<>();
        for (int j = 0; j<8; j++) {
            for (int i=0; i<8; i++) {
                e.add(new piece(config[i][j].piece, config[i][j].BG));
            }
        }
        return e;
    }

    piece getPiece(int i, int j)    {
        return new piece(config[i][j].piece, config[i][j].BG);
    }

    /*
    j   i-> 0   1   2   3   4   5   6   7
    |
    0       1   0   0   0   0   0   0   0
    1       0   0   0   0   0   0   0   0
    2
    3
    4
    5
    6
    7
     */

    void getPossibleMovements(int i, int j)  {
        noPossibleMovements();
        if (config[i][j].piece== 1) {
            // 1 = present
            if (i == 0 && j == 0) {
                //  top left corner
                config[1][0].BG = 1;
                config[1][1].BG = 1;
                config[0][1].BG = 1;
            } else if (i == 7 && j == 0) {
                //  top right corner
                config[6][0].BG = 1;
                config[6][1].BG = 1;
                config[7][1].BG = 1;
            } else if (i == 0 && j == 7) {
                //  bottom left corner
                config[0][6].BG = 1;
                config[1][6].BG = 1;
                config[1][7].BG = 1;
            } else if (i == 7 && j == 7) {
                //  bottom right corner
                config[7][6].BG = 1;
                config[6][6].BG = 1;
                config[6][7].BG = 1;
            } else if (j == 0) {
                //  rest of the top row
                config[i-1][0].BG = 1;
                config[i-1][1].BG = 1;
                config[i]  [1].BG = 1;
                config[i+1][1].BG = 1;
                config[i+1][0].BG = 1;
            } else if (i == 0) {
                //  rest of the left row
                config[0][j-1].BG = 1;
                config[1][j-1].BG = 1;
                config[1]  [j].BG = 1;
                config[1][j+1].BG = 1;
                config[0][j+1].BG = 1;
            } else if (i == 7) {
                //  rest of the right row
                config[7][j-1].BG = 1;
                config[6][j-1].BG = 1;
                config[6]  [j].BG = 1;
                config[6][j+1].BG = 1;
                config[7][j+1].BG = 1;
            } else if (j == 7) {
                //  rest of the bottom row
                config[i-1][7].BG = 1;
                config[i-1][6].BG = 1;
                config[i]  [6].BG = 1;
                config[i+1][6].BG = 1;
                config[i+1][7].BG = 1;
            } else {
                //  rest of the board
                config[i-1][j-1].BG = 1;
                config[i]  [j-1].BG = 1;
                config[i+1][j-1].BG = 1;
                config[i+1]  [j].BG = 1;
                config[i-1]  [j].BG = 1;
                config[i-1][j+1].BG = 1;
                config[i]  [j+1].BG = 1;
                config[i+1][j+1].BG = 1;
            }
        }/*else if (config[i][j].setBGat() == ) {
            if (i == 0 && j == 0) {
                //  top left corner
            } else if (i == 7 && j == 0) {
                //  top right corner
            } else if (i == 0 && j == 7) {
                //  bottom left corner
            } else if (i == 7 && j == 7) {
                //  bottom right corner
            } else if (i > 0 && i < 7 && j == 0) {
                //  rest of the top row
            } else if (i == 0 && j > 0 && j < 7) {
                //  rest of the left row
            } else if (i == 7 && j > 0 && j < 7) {
                //  rest of the right row
            } else if (i > 0 && i < 7 && j == 7) {
                //  rest of the bottom row
            } else {
                //  rest of the board
            }
        }*/
    }

    private void noPossibleMovements()   {
        for (int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                config[i][j].BG = 0;
            }
        }
    }

    void move(int i, int j)  {
        if (config[i][j].BG == 1)    {
            config[i][j].piece = 1;
            noPossibleMovements();
        }
    }
}