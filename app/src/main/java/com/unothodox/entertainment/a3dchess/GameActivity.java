package com.unothodox.entertainment.a3dchess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

public class GameActivity extends AppCompatActivity {

    ChessBoard chessBoard;
    GridView board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        chessBoard = new ChessBoard();
        board = findViewById(R.id.board);

        setBoard();

        board.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (chessBoard.getPiece(i/8, i%8).piece == 1)   {
                    chessBoard.getPossibleMovements(i/8, i%8);
                    setBoard();
                }else if (chessBoard.getPiece(i/8, i%8).BG == 1)  {
                    chessBoard.move(i/8, i%8);
                    setBoard();
                }
            }
        });
    }

    private void setBoard() {
        ListAdapter  adapter = new PieceLayout(this, chessBoard.getBoard());
        board.setAdapter(adapter);
    }
}
