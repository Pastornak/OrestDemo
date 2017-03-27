package id_iot.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.recycler_view_category, container, false);
        getActivity().setTitle("Menu");

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_category);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final CategoryAdapter adapter = new CategoryAdapter(((MainActivity) getActivity()).getRecipesList());
        recyclerView.setAdapter(adapter);
        return view;
    }
}
