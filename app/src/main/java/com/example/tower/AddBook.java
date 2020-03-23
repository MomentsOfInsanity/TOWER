package com.example.tower;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBook extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.profile);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        return true;
                }

                return false;
            }
        });
    }

    public void onClickSubmit(View view) {
        EditText titleET = (EditText) findViewById(R.id.title_text);
        EditText authorET = (EditText) findViewById(R.id.author_text);
        EditText priceET = (EditText) findViewById(R.id.price_text);

        String title = titleET.getText().toString();
        String author = authorET.getText().toString();
        Double price = Double.parseDouble(priceET.getText().toString());

        Intent intent = new Intent(this, ProfileLogin.class);

        intent.putExtra("BOOK_TITLE", title);
        intent.putExtra("BOOK_AUTHOR", author);
        intent.putExtra("BOOK_PRICE", price);


        Toast.makeText(this, "Added " + title, Toast.LENGTH_SHORT).show();
        setResult(2, intent);
        finish();
    }
}
