package com.example.campus_life_assistant.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.campus_life_assistant.R;
import com.example.campus_life_assistant.SuSheRepairProcessActivity;
import com.example.campus_life_assistant.entry.RepairRequest;

import java.util.List;

public class RepairAdapter extends RecyclerView.Adapter<RepairAdapter.ViewHolder> {
    private List<RepairRequest> requests;
    private Context context;

    public RepairAdapter(List<RepairRequest> requests, Context context) {
        this.requests = requests;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 使用自定义布局文件 item_repair_request.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repair_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RepairRequest request = requests.get(position);
        holder.tvDescription.setText(request.getDescription());
        holder.tvTimeStatus.setText(String.format("%s | %s", request.getTime(), request.getStatus()));

        // 设置点击事件
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, SuSheRepairProcessActivity.class);
            intent.putExtra("repairRequest", request); // 使用 Serializable 传递对象
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return requests.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDescription;
        public TextView tvTimeStatus;

        public ViewHolder(View view) {
            super(view);
            tvDescription = view.findViewById(R.id.tvDescription);
            tvTimeStatus = view.findViewById(R.id.tvTimeStatus);
        }
    }
}