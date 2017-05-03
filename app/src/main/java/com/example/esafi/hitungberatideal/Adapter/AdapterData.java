package com.example.esafi.hitungberatideal.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.esafi.hitungberatideal.Model.DataBeratModel;
import com.example.esafi.hitungberatideal.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import java.util.ArrayList;
/**
 * Created by esafi on 03/05/2017.
 */

public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolder> {

    private final OnItemClickListener listener;
    private ArrayList<DataBeratModel> data;

    public AdapterData(ArrayList<DataBeratModel> data, OnItemClickListener listener) {
        this.listener = listener;
        this.data = data;
    }

    @Override
    public AdapterData.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterData.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.tvId.setText(String.valueOf(data.get(position).getId()));
        holder.nama.setText(data.get(position).getNama());
        holder.jenisKelamin.setText(data.get(position).getJenisKelamin());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, nama, jenisKelamin, berat, tinggi, ideal, bmi, kesimpulan;


        public ViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            nama = (TextView) itemView.findViewById(R.id.tvNama1);
            jenisKelamin = (TextView) itemView.findViewById(R.id.tvJenisKelamin);
            tinggi = (TextView) itemView.findViewById(R.id.tvTinggi);
            berat = (TextView) itemView.findViewById(R.id.tvBerat);
            ideal = (TextView) itemView.findViewById(R.id.tvIdeal);
            bmi = (TextView) itemView.findViewById(R.id.tvBmi);
            kesimpulan = (TextView) itemView.findViewById(R.id.tvKesimpulan);
        }


        public void click(final DataBeratModel dataBeratModel, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(dataBeratModel);
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onClick(DataBeratModel item);
    }
}
