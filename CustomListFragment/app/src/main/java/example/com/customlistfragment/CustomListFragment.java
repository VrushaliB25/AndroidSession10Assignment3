package example.com.customlistfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * Created by HPWorld on 6/4/2017.
 */

public class CustomListFragment extends ListFragment {

    // Array of strings-names
    String social[] = {"Facebook", "Youtube", "Instagram", "Whatsapp", "Twitter", "Blogger"};


    // Array of strings- Description
    String desc[] = {"Facebook Description", "Youtube Description", "Instagram Description", "Whatsapp Description", "Twitter Description", "Blogger Description"};

    // Array of integers pointing to images stored in drawable folder
    int[] images = new int[]{R.drawable.facebook, R.drawable.youtube, R.drawable.instagram, R.drawable.whatsapp,
            R.drawable.twitter, R.drawable.blogger};


    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
   SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //MAP
        HashMap<String, String> map = new HashMap<String, String>();
        //FILL
        for (int i = 0; i < social.length; i++) {
            map = new HashMap<String, String>();
            map.put("social", social[i]);
            map.put("image", Integer.toString(images[i]));
            map.put("description", desc[i]);

            data.add(map);
        }
        //KEYS IN MAP
        String[] from = {"social", "description", "image"};

        //IDs of View
        int[] to = {R.id.name, R.id.desc, R.id.imageView1};

        //ADAPTER

        adapter = new SimpleAdapter(getActivity(), data, R.layout.mylist,from,to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);


    }

    @Override
    public void onStart() {
        super.onStart();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View view, int position, long id) {
                Toast.makeText(getActivity(), data.get(position).get("social"), Toast.LENGTH_LONG).show();
            }
        });


    }
}

