package com.example.courseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CourseItem> courseItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Let's create our list of course items.
        courseItems = new ArrayList<>();
        courseItems.add(new CourseItem("Introduction to Programming", "Learn the basics of coding", "This course covers the fundamentals of programming, including syntax, logic, and problem-solving techniques. Ideal for beginners looking to start their journey in the world of coding.", "https://www.w3schools.com/w3images/lights.jpg"));
        courseItems.add(new CourseItem("Web Development Essentials", "Build your first website", "In this course, you'll learn how to create stunning websites using HTML, CSS, and JavaScript. Perfect for those who want to understand the building blocks of the web.", "https://www.w3schools.com/w3images/nature.jpg"));
        courseItems.add(new CourseItem("Data Science for Beginners", "Uncover the power of data", "Explore the basics of data science, including data analysis, visualization, and machine learning. This course is designed for those who want to dive into the data-driven world.", "https://www.w3schools.com/w3images/mountains.jpg"));

        // Find the ListView in our layout.
        ListView listView = findViewById(R.id.listView);

        // Set up our custom adapter for the ListView.
        ItemAdapter adapter = new ItemAdapter(this, courseItems);
        listView.setAdapter(adapter);

        // Set a click listener to handle item clicks in the ListView.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the clicked item from the list.
                CourseItem selectedItem = (CourseItem) parent.getItemAtPosition(position);

                // Create an explicit intent to navigate to DetailActivity.
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("courseItem", selectedItem);

                // Start DetailActivity using the explicit intent.
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Show a Snackbar message when returning to the MainActivity.
        View view = findViewById(android.R.id.content);
        Snackbar.make(view, "Returned to Main Activity", Snackbar.LENGTH_SHORT).show();
    }
}
