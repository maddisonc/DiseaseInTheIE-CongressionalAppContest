package com.example.covidtrackerv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>
{
    private List<Image> imageList;
    private ViewPager2 viewPager2;

    public ImageAdapter(List<Image> imageList, ViewPager2 viewPager2)
    {
        this.imageList = imageList;
        this.viewPager2 = viewPager2;
    } // end ImageAdapter constructor

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_container, parent, false);
        return new ImageViewHolder(view);
    } // end initialization of ViewHolder

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(imageList.get(position).getImage());

        // if current image is third from last, calls runnable that adds the previous
        // images to end of list again, creating infinite slide effect
        if (position == imageList.size() - 2)
        {
            viewPager2.post(runnable);
        }
    } // calls infinite scroll if end of list

    @Override
    public int getItemCount() {
        return imageList.size();
    } // returns size of image list

    public class ImageViewHolder extends RecyclerView.ViewHolder
    {
        RoundedImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
        }
    } // end imageViewHolder

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            imageList.addAll(imageList);
            notifyDataSetChanged();
        }
    }; // end runnable that adds all previous images to end of list for infinite scroll

} // end ImageAdapter class (contains conditional to allow for infinite slide)
