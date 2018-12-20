package com.unothodox.entertainment.a3dchess;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class PieceLayout extends ArrayAdapter<ChessBoard.piece> {
    PieceLayout(Context context, ArrayList<ChessBoard.piece> e) {
        super(context, R.layout.layout_piece, e);
    }

    static class ViewHolder {
        View BG;
        ImageView piece;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        Resources res = getContext().getResources();
        ChessBoard.piece e = getItem(position);

        if (convertView == null)    {
            LayoutInflater inf = LayoutInflater.from(getContext());
            convertView = inf.inflate(R.layout.layout_piece, parent, false);

            holder = new ViewHolder();
            holder.BG = convertView.findViewById(R.id.BG);
            holder.piece = convertView.findViewById(R.id.piece);
        }else
            holder = (ViewHolder) convertView.getTag();

        assert e != null;
        if(e.BG == 1)
            holder.BG.setBackgroundColor(res.getColor(R.color.bgPossible));

        /*if (e.piece == 1)
            holder.piece.setImageResource(R.drawable.piece_dark_1);*/




        return convertView;
    }
}