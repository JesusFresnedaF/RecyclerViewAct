/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.recyclerview2;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/***
 * The adapter class for the RecyclerView, contains the sports data.
 */
class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {

    // Member variables.
    private ArrayList<Sport> mSportsData;
    private Context mContext;

    private int orientation;

    /**
     * Constructor that passes in the sports data and the context.
     *
     * @param sportsData ArrayList containing the sports data.
     * @param context    Context of the application.
     */
    SportsAdapter(Context context, ArrayList<Sport> sportsData) {
        this.mSportsData = sportsData;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     *
     * @param parent   The ViewGroup into which the new View will be added
     *                 after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @Override
    public ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder   The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get current sport.
        Sport currentSport = mSportsData.get(position);
        // Populate the textviews with data.
        holder.bindTo(currentSport);
    }

    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mSportsData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;

        private ImageView sportImage;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);
            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            sportImage = itemView.findViewById(R.id.sportsImage);
        }

        void bindTo(Sport currentSport) {
            // Populate the textviews with data.
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            findImage(currentSport);
        }

        public void findImage(Sport currentSport) {
            switch (currentSport.getImage()) {
                case "Baseball":
                    sportImage.setImageResource(R.mipmap.baseball_foreground);
                    break;
                case "Badminton":
                    sportImage.setImageResource(R.mipmap.badminton_foreground);
                    break;
                case "Basketball":
                    sportImage.setImageResource(R.mipmap.basketball_foreground);
                    break;
                case "Bowling":
                    sportImage.setImageResource(R.mipmap.bowling_foreground);
                    break;
                case "Cycling":
                    sportImage.setImageResource(R.mipmap.cycling_foreground);
                    break;
                case "Golf":
                    sportImage.setImageResource(R.mipmap.golf_foreground);
                    break;
                case "Running":
                    sportImage.setImageResource(R.mipmap.running_foreground);
                    break;
                case "Soccer":
                    sportImage.setImageResource(R.mipmap.soccer_foreground);
                    break;
                case "Swimming":
                    sportImage.setImageResource(R.mipmap.swimming_foreground);
                    break;
                case "Table Tennis":
                    sportImage.setImageResource(R.mipmap.tabletennis_foreground);
                    break;
                case "Tennis":
                    sportImage.setImageResource(R.mipmap.tennis_foreground);
                    break;
            }
        }
    }
}
