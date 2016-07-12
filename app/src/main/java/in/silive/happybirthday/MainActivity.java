package in.silive.happybirthday;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity  {
    ListView navigation;
    DrawerLayout drawer_layout;
    String[] names={"Abishek","Akash","Akash Sir","Akriti","Aman","Avinash","Divyanshu","Mom n Dad"};
    Integer [] images={R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon};
    ActionBar mActionBar;
    ActionBarDrawerToggle mDrawerToggle;
    //int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer_layout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigation=(ListView)findViewById(R.id.navigation);
        mActionBar = getSupportActionBar();
        setUpDrawer();
        display(7);
        setTitle("Happy Birthday");
         }
    public void setUpDrawer(){
        //setting up drawer
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this,drawer_layout,R.string.drawer_open,R.string.drawer_close){ };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        drawer_layout.setDrawerListener(mDrawerToggle);
        navigation.setAdapter(new ListAdapter(MainActivity.this, names, images));

    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }




    public void display(int position) {
        Log.d("Msg","Item Clicked called");
        Fragment fragment = new Mom_Dad();
        Log.d("Msg","Item fragment created");
        switch (position){
            case 0: fragment= new Abishek();
                Log.d("Msg","Item transisted");
                break;
            case 1: fragment= new Akash();
                Log.d("Msg","Item transisted");
                break;
            case 2: fragment= new Akash_Sir();
                break;
            case 3: fragment= new Akriti();
                break;
            case 4: fragment= new Aman();
                break;
            case 5: fragment= new Avinash();
                break;
            case 6: fragment= new Divyanshu();
                break;
            case 7: fragment= new Mom_Dad();
                break;

                    }
        //getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frame, fragment).commit();
        Log.d("Msg","Item ot of switch");
           setTitle(names[position]);
            final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).replace(R.id.frame, fragment).commit();
            drawer_layout.closeDrawers();


    }
}
