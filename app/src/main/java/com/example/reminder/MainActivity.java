package com.example.reminder;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.reminder.Adapters.RadapterMain;
import com.example.reminder.Fundamentals.Reminder;
import com.example.reminder.Fundamentals.Statics;
import com.example.reminder.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RadapterMain radapterMain = new RadapterMain(new ArrayList<Reminder>(
                Arrays.asList(
                        new Reminder("Comprar pão amanhã", false, "02/06/2024", Statics.TYPE_IMPORTANTE),
                        new Reminder("Comprar pão amanhã", false, "02/06/2024", Statics.TYPE_LEVE),
                        new Reminder("Comprar pão amanhã", false, "02/06/2024", Statics.TYPE_IMPORTANTE),
                        new Reminder("Comprar pão amanhã", false, "02/06/2024", Statics.TYPE_MODERADO)
                )
        ),this);
        binding.remindersRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.remindersRecycler.setAdapter(radapterMain);
    }
}