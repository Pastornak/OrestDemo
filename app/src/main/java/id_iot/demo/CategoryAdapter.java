package id_iot.demo;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<Recipe> recipes;

    public CategoryAdapter(ArrayList<Recipe> recipes){
        this.recipes = recipes;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView itemImage;
        public TextView itemName;
        private CardView cardView;

        public ViewHolder (View view){
            super(view);
            itemImage = (ImageView) itemView.findViewById(R.id.category_image);
            itemName = (TextView) itemView.findViewById(R.id.category_name);
            cardView = (CardView) itemView.findViewById(R.id.cardview_category);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_category, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i){
        viewHolder.itemName.setText(recipes.get(i).getRecipeName());
        viewHolder.itemImage.setImageResource(recipes.get(i).getRecipePhoto());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), recipes.get(viewHolder.getAdapterPosition()).getRecipeName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return recipes.size();
    }
}
