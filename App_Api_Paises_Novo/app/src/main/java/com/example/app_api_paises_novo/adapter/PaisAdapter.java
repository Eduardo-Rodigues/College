package com.example.app_api_paises_novo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_api_paises_novo.R;
import com.example.app_api_paises_novo.model.Pais_Model;
import java.util.ArrayList;

public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.ViewHolder> {

    private ArrayList<Pais_Model> listaPaises;
    private LayoutInflater inflater;

    public PaisAdapter(Context context, ArrayList<Pais_Model> listaPaises) {
        this.inflater = LayoutInflater.from(context);
        this.listaPaises = listaPaises;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pais_Model pais = listaPaises.get(position);

        holder.tvCodigo.setText(String.valueOf(pais.getCodigo()));
        holder.tvDescricao.setText(pais.getDescricao());
    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCodigo, tvDescricao;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.textViewCodigo);
            tvDescricao = itemView.findViewById(R.id.textViewDescricao);
        }
    }
}

