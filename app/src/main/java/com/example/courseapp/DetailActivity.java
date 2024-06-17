package com.example.courseapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Retrieve the course item passed from MainActivity.
        CourseItem courseItem = (CourseItem) getIntent().getSerializableExtra("courseItem");

        // Find and link our UI elements.
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView subtitleTextView = findViewById(R.id.subtitleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        ImageView imageView = findViewById(R.id.imageView);
        Button backButton = findViewById(R.id.backButton);

        // Set the title, subtitle, and description for the course.
        titleTextView.setText(courseItem.getTitle());
        subtitleTextView.setText(courseItem.getSubtitle());
        descriptionTextView.setText(courseItem.getDescription());

        // Load and resize the image using Picasso.
        Picasso.get().load(courseItem.getImageUrl())
                .resize(400, 400)
                .centerCrop()
                .into(imageView);

        // Set a click listener on the back button to return to the main activity.
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a toast message when returning to MainActivity.
                Toast.makeText(DetailActivity.this, "Returning to Main Activity", Toast.LENGTH_SHORT).show();
                finish(); // End this activity and go back.
            }
        });
    }
}
