package com.example.bottomnavigationtrials;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomnav);
        bottomNavigationView.setItemIconTintList(null);

        getSupportFragmentManager().beginTransaction().replace(R.id.homepagebottomnavcontainer,new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Fragment fragment = null;
                        if(menuItem.getItemId()==R.id.explore){
                            fragment=new ExploreFragment();
                        }else if(menuItem.getItemId()==R.id.account){
                            fragment=new AccountFragment();
                        }else if(menuItem.getItemId()==R.id.home){
                            fragment=new HomeFragment();
//                            menuItem.setIcon(R.drawable.cart_selected);
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.homepagebottomnavcontainer,fragment).commit();
                        return true;
                    }
                }
        );
    }



}