package com.example.courseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CourseItem> courseItems;

    public ItemAdapter(Context context, ArrayList<CourseItem> courseItems) {
        this.context = context;
        this.courseItems = courseItems;
    }

    @Override
    public int getCount() {
        return courseItems.size(); // Return the number of course items.
    }

    @Override
    public Object getItem(int position) {
        return courseItems.get(position); // Get the course item at a specific position.
    }

    @Override
    public long getItemId(int position) {
        return position; // Return the position as the ID.
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false); // Inflate the layout for each item.
            viewHolder = new ViewHolder();
            viewHolder.titleTextView = convertView.findViewById(R.id.titleTextView);
            viewHolder.subtitleTextView = convertView.findViewById(R.id.subtitleTextView);
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder); // Save the ViewHolder for future reuse.
        } else {
            viewHolder = (ViewHolder) convertView.getTag(); // Reuse the ViewHolder to save resources.
        }

        CourseItem currentItem = (CourseItem) getItem(position);
        viewHolder.titleTextView.setText(currentItem.getTitle()); // Set the course title.
        viewHolder.subtitleTextView.setText(currentItem.getSubtitle()); // Set the course subtitle.

        if (currentItem.getImageUrl() != null && !currentItem.getImageUrl().isEmpty()) {
            Picasso.get().load(currentItem.getImageUrl())
                    .resize(200, 200) // Resize the image to fit nicely.
                    .centerCrop() // Crop the image to fill the ImageView.
                    .into(viewHolder.imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            // Hooray! The image loaded successfully.
                        }

                        @Override
                        public void onError(Exception e) {
                            // Oops! Something went wrong.
                            viewHolder.imageView.setImageResource(R.drawable.placeholder_image); // Set a default image if there's an error.
                        }
                    });
        } else {
            viewHolder.imageView.setImageResource(R.drawable.placeholder_image); // Use a default image if the URL is empty.
        }

        return convertView; // Return the completed view to display.
    }

    private static class ViewHolder {
        TextView titleTextView; // Holds the title TextView.
        TextView subtitleTextView; // Holds the subtitle TextView.
        ImageView imageView; // Holds the ImageView for the course image.
    }
}
