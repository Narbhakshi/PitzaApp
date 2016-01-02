package adil.shahrukh.pitzaapp;


import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastaFragment extends ListFragment {


    public PastaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.pastaNameArray));
        setListAdapter(adapter);
        return super.onCreateView(inflater,container,savedInstanceState);
    }


}
