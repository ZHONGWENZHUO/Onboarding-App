package com.example.onboardingapplication.Activities.Both;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onboardingapplication.Adapters.Topics.LunchAdapter;
import com.example.onboardingapplication.R;

import java.util.Objects;

public class LunchActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String lunchNameList[], lunchLocList[], lunchDescList[];
    int images[] = {R.drawable.ic_lunch,
                    R.drawable.ic_lunch,
                    R.drawable.ic_lunch,
                    R.drawable.ic_lunch,
                    R.drawable.ic_lunch,
                    R.drawable.ic_lunch};
    Button homeBtn;
    TextView topicTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //FULL SCREEN + BACKGROUND COLOR
        Objects.requireNonNull(getSupportActionBar()).hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.topic5Backgroundcolor));



        //SET home Button + topic title
        homeBtn = findViewById(R.id.detailsHomebtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        topicTitle = findViewById(R.id.detailsTopicTitle);
        topicTitle.setText(R.string.topic_lunch_title);


        //Set up recycler view
        recyclerView = findViewById(R.id.recyclerView_Details);

        lunchNameList = getResources().getStringArray(R.array.lunch_name_list);
        lunchLocList = getResources().getStringArray(R.array.lunch_loc_list);
        lunchDescList = getResources().getStringArray(R.array.lunch_desc_list);

        LunchAdapter lunchAdapter = new LunchAdapter(this,lunchNameList,lunchLocList,lunchDescList,images);
        recyclerView.setAdapter(lunchAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
