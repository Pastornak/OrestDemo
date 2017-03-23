package id_iot.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ChosenRecipeFragment extends Fragment {

    private Recipe chosenRecipe;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chosen_recipe_fragment, container, false);

        chosenRecipe = ((MainActivity) getActivity()).getChosenRecipe();
        getActivity().setTitle(chosenRecipe.getRecipeName());

        ImageView chosenRecipeImage = (ImageView) view.findViewById(R.id.chosen_recipe_image);
        TextView chosenRecipeDetail = (TextView) view.findViewById(R.id.chosen_recipe_detail);
        TextView chosenRecipeHTC = (TextView) view.findViewById(R.id.how_to_cook);

        chosenRecipeImage.setImageResource(chosenRecipe.getRecipePhoto());
        chosenRecipeDetail.setText(chosenRecipe.getRecipeDetail());
        chosenRecipeHTC.setText(chosenRecipe.getRecipeHowToCook());

        return view;
    }
}
