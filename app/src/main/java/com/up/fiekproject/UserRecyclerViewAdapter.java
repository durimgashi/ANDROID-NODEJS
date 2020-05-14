package com.up.fiekproject;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.up.fiekproject.Model.Car;
import com.up.fiekproject.Model.User;

import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {

    Context context;
    private List<User> userList;

    public UserRecyclerViewAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = userList.get(position);
        String fullNameStr = user.getFirstName() + " " + user.getLastName();

        holder.userId.setText(String.valueOf(user.getUserId()));
        holder.fullName.setText(fullNameStr);
        holder.email.setText(user.getEmail());
        holder.username.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView userId;
        public TextView fullName;
        public TextView email;
        public TextView username;
        public CardView userCardView;
        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    User user = userList.get(position);
                    Integer userId = user.getUserId();

                    Intent intent = new Intent(context, RentsActivity.class);
                    intent.putExtra("userId", userId);

                    context.startActivity(intent);

                    Toast.makeText(ctx, "UserID" + position, Toast.LENGTH_SHORT).show();
                }
            });

            context = ctx;
            userId = itemView.findViewById(R.id.userId);
            fullName = itemView.findViewById(R.id.fullName);
            email = itemView.findViewById(R.id.email);
            username = itemView.findViewById(R.id.username);
            userCardView = itemView.findViewById(R.id.userCardView);

        }
    }
}
