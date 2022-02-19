package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        MenuItem m1 = m.add("Item 1");
        m1.setCheckable(true);

        m.add("Item 2");
        m.add(0, 1, Menu.NONE, "Id Item 1");
        m.add(0, 2, Menu.NONE, "Id Item 2");
        SubMenu sm = m.addSubMenu(0, 3, Menu.NONE, "SubMenu");

        sm.add(0, 4, 0, "Subitem 1");
        sm.add(0, 5, 0, "Subitem 2");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem m) {
        switch (m.getItemId()) {
            case 1:
                startActivity(new Intent(getApplicationContext(), XMLmenu.class));
                return true;
            default:
                Toast.makeText(getApplicationContext(), m.getItemId() + " " + m.getItemId(), Toast.LENGTH_SHORT).show();
                return true;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.TV_1) {
            menu.add(0, 1, Menu.NONE, "Item 1");
            menu.add(0, 2, Menu.NONE, "Item 3");

        } else {
            menu.add(0, 3, Menu.NONE, "Item 3");
            menu.add(0, 4, Menu.NONE, "Item 4");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem i) {

        switch (i.getItemId()) {
            case 3:
                startActivity(new Intent(getApplicationContext(), XMLmenu.class));
                return true;
            default:
                Toast.makeText(getApplicationContext(), i.getItemId() + " " + i.getItemId(), Toast.LENGTH_SHORT).show();
                return true;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerForContextMenu(findViewById(R.id.TV_1));
        registerForContextMenu(findViewById(R.id.TV_2));
    }


    public void openActionMode(View v){
        startActionMode(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(0,2,Menu.NONE, "Item 1");
                menu.add(0,3,Menu.NONE, "Item 3");
                menu.add(0,4,Menu.NONE, "Item 5");
                menu.add(0,5,Menu.NONE, "Item 7");
                menu.add(0,6,Menu.NONE, "Item 9");
                menu.add(0,7,Menu.NONE, "Item 11");

                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                Toast.makeText(getApplicationContext(), item.getItemId() + " " + item.getItemId(), Toast.LENGTH_SHORT).show();

                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

    }


}