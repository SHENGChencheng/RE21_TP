package com.example.re21_tp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(findViewById(R.id.imageView));
        setSupportActionBar(findViewById(R.id.toolbar));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, 1, Menu.NONE, "Supprimer");
        menu.add(Menu.NONE, 2, Menu.NONE, "Retour");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);

        switch (item.getItemId()) {
            case 1: {
                AlertDialog alertDialog = new
                        AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Titre");
                alertDialog.setMessage("Message ?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Oui",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int
                                    which) {
                                findViewById(R.id.imageView).setVisibility(View.INVISIBLE);

                                Toast.makeText(getApplicationContext(), "Text",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Non",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int
                                    which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();


                break;
            }
            case 2: {
                return true;
            }
            default:break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        int itemId = item.getItemId();
        if (itemId == R.id.reset) {
            imageView.setVisibility(View.VISIBLE);
            imageView.clearColorFilter();
        } else if (itemId == R.id.bleu) {
            imageView.setColorFilter(Color.BLUE,
                    PorterDuff.Mode.MULTIPLY);
        } else if (itemId == R.id.rouge) {
            imageView.setColorFilter(Color.RED,
                    PorterDuff.Mode.MULTIPLY);
        } else if (itemId == R.id.vert) {
            imageView.setColorFilter(Color.GREEN,
                    PorterDuff.Mode.MULTIPLY);
        }
        return true;
    }
}