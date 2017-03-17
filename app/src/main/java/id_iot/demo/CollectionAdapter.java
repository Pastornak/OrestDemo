package id_iot.demo;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filter;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.List;

public class CollectionAdapter extends BaseAdapter implements Filterable {
    private Context mContext;
    private ArrayList<Recipe> recipes;
    private ArrayList<Recipe> backupRecipes;
    ValueFilter valueFilter;

    public CollectionAdapter(Context c, ArrayList<Recipe> recipes) {
        mContext = c;
        this.recipes = recipes;
        this.backupRecipes = recipes;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(R.layout.collection_view_cell, null);

        ImageView recipePhoto = (ImageView) convertView.findViewById(R.id.collection_image);
        ImageView favoriteStar = (ImageView) convertView.findViewById(R.id.collection_favorite);
        TextView recipeName = (TextView) convertView.findViewById(R.id.collection_name);
        TextView recipeDetail = (TextView) convertView.findViewById(R.id.collection_detail);
        recipeName.setText(recipes.get(position).getRecipeName());
        recipeDetail.setText(recipes.get(position).getRecipeDetail());
        favoriteStar.setImageResource(recipes.get(position).getFavorite()? R.drawable.favorite_checked: R.drawable.favorite_unchecked_2);
        recipePhoto.setImageResource(recipes.get(position).getRecipePhoto());
        return convertView;
    }

    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                List<Recipe> filterList = new ArrayList<>();
                for (Recipe recipe: recipes) {
                    if ((recipe.getRecipeName().toUpperCase()).contains(constraint.toString().toUpperCase())) {
                        filterList.add(recipe);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = backupRecipes.size();
                results.values = backupRecipes;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            recipes = (ArrayList) results.values;
            notifyDataSetChanged();
        }

    }
}
