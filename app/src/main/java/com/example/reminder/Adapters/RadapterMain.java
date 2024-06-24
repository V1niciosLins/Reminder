package com.example.reminder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.reminder.Fundamentals.Statics;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminder.Fundamentals.Reminder;
import com.example.reminder.R;

import java.util.ArrayList;

public class RadapterMain extends RecyclerView.Adapter<RadapterMain.vh> {
    private ArrayList<Reminder> reminderArrayList;
    private Context context;

    public RadapterMain(ArrayList<Reminder> reminderArrayList, Context context) {
        this.reminderArrayList = reminderArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RadapterMain.vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.reminder_list_item, null, false);
        return new vh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RadapterMain.vh holder, int position) {
        holder.reminderTitle.setText(reminderArrayList.get(position).getTitle());
        if (reminderArrayList.get(position).getPendence()){
            holder.reminderPendence
                    .setText("Concluído | desde "+reminderArrayList.get(position).getDateCreated());
        }else{
            holder.reminderPendence
                    .setText("Pendente | desde " + reminderArrayList.get(position).getDateCreated());
        }
        holder.trash.setOnClickListener(click->{
            reminderArrayList.remove(position);
            notifyDataSetChanged();
        });
        switch (reminderArrayList.get(position).getReminderType()){
            case 0: holder.importancia.setImageResource(R.drawable.icons8_alert_96r); break;
            case 1: holder.importancia.setImageResource(R.drawable.icons8_alert_96y); break;
            case 2: holder.importancia.setImageResource(R.drawable.icons8_alert_96g); break;
        }
    }

    @Override
    public int getItemCount() {
        return reminderArrayList.size();
    }
    public class vh extends RecyclerView.ViewHolder{
        TextView reminderTitle, reminderPendence;
        ImageView trash;
        ImageView importancia;
        public vh(@NonNull View itemView) {
            super(itemView);
            reminderTitle = itemView.findViewById(R.id.reminderTitle);
            reminderPendence = itemView.findViewById(R.id.pendence);
            trash = itemView.findViewById(R.id.trash);
            importancia = itemView.findViewById(R.id.image);
        }
    }
}
