package adil.shahrukh.pitzaapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MainActivity extends Activity {

    private String[] titles;
    private ListView drawerList;
    private DrawerLayout drawerLayout;
    private android.support.v7.app.ActionBarDrawerToggle drawerToggle;




    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Code to run when an item in the navigation drawer gets clicked
            selectItem(position);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titles= getResources().getStringArray(R.array.titles);
        drawerList = (ListView)findViewById(R.id.drawer);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, titles);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        getActionBar().setHomeButtonEnabled(true);



        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerToggle = new android.support.v7.app.ActionBarDrawerToggle(
                this,drawerLayout,
                R.string.open_drawer,R.string.Close_drawer){
            @Override
            public void onDrawerClosed(View view){
                super.onDrawerClosed(view);
            }

            @Override
            public void onDrawerOpened(View view){
                super.onDrawerOpened(view);
            }

        };
        drawerLayout.setDrawerListener(drawerToggle);
        if (savedInstanceState == null) {
            selectItem(0);
        }

    }

    private void selectItem (int position){
        Fragment fragment;
        switch (position){
            case 1:
                fragment = new PizzaFragment();
                break;
            case 2:
                fragment = new PastaFragment();
                break;
            case 3:
                fragment = new StoresFragment();
                break;
            default:
                fragment = new TopFragment();
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        setActionBarTitle(position);
        drawerLayout.closeDrawer(drawerList);

    }



    private void setActionBarTitle(int position) {
        String title;
        if(position == 0){
            title = getResources().getString(R.string.app_name);
        }
        else{
            title = titles[position];
        }

        getActionBar().setTitle(title);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }



}