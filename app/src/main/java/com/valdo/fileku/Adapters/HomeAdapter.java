package com.valdo.fileku.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertController;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.valdo.fileku.R;
import com.valdo.fileku.models.UploadModel;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
      List<UploadModel>uploadModel;
//    public ArrayList<String> namaFile = new ArrayList<String>();

    public HomeAdapter(List<UploadModel> uploadModel) {
        this.uploadModel = uploadModel;
    }

    @NonNull
    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //mengambil objek context dari parrent
        Context context = parent.getContext();
        //objek context digunakan untuk membuat object layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //object layoutInflater digunakan untuk membuat object view yang merupakan hasil inflate layout
        View getFile = layoutInflater.inflate(R.layout.item_home,parent,false);
        //digunakan untuk membuat object viewHolder
        MyViewHolder viewHolder = new MyViewHolder(getFile);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.MyViewHolder holder, int position) {
        UploadModel uploadBin = uploadModel.get(position);
        holder.listFile.setText(uploadBin.getNamaFile());


    }

    @Override
    public int getItemCount() {
        return (uploadModel != null) ? uploadModel.size() : 0 ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Button listFile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            listFile = itemView.findViewById(R.id.buttonItemHome);
        }
    }
}
