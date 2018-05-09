package example.com.familyagenda;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final String TAG = "MainDebug";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // Open Settings fragment
        if (id == R.id.action_settings)
        {
            setTitle("Settings");
            Settings settings = new Settings();

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, settings)
                    .commit();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_calendar)
        {
            setTitle("Calendar");
            Calendar calendar = new Calendar();

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, calendar)
                    .commit();

        }
        else if (id == R.id.nav_groceries)
        {
            setTitle("Groceries");
            Groceries groceries = new Groceries();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, groceries).commit();
        }
        else if (id == R.id.nav_todo)
        {
            setTitle("ToDo");
            ToDo todo = new ToDo();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, todo).commit();
        }
        else if (id == R.id.nav_chores)
        {
            setTitle("Chores");
            Chores chores = new Chores();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, chores).commit();
        }
        else if (id == R.id.nav_settings)
        {
            setTitle("Settings");
            Settings settings = new Settings();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, settings).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
