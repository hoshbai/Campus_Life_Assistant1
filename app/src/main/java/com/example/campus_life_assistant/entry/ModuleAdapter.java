package com.example.campus_life_assistant.entry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campus_life_assistant.R;

import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder> {

    private Context context;
    private List<Module> moduleList;

    public ModuleAdapter(Context context, List<Module> moduleList) {
        this.context = context;
        this.moduleList = moduleList;
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_module, parent, false);
        return new ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        Module module = moduleList.get(position);
        holder.moduleName.setText(module.getName());
        holder.moduleIcon.setImageResource(module.getIconResId());

        // 设置点击事件
        holder.itemView.setOnClickListener(v -> {
            // 处理点击事件，例如跳转到相应页面
        });
    }

    @Override
    public int getItemCount() {
        return moduleList.size();
    }

    static class ModuleViewHolder extends RecyclerView.ViewHolder {
        ImageView moduleIcon;
        TextView moduleName;

        public ModuleViewHolder(@NonNull View itemView) {
            super(itemView);
            moduleIcon = itemView.findViewById(R.id.module_icon);
            moduleName = itemView.findViewById(R.id.module_name);
        }
    }
}