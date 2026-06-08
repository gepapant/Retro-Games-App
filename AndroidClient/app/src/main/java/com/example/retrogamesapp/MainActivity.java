package com.example.retrogamesapp;

public class MainActivity {
  
  searchBtn.setOnClickListener(v -> {

    Intent intent = new Intent(MainActivity.this, ResultsActivity.class);

    intent.putExtra("title", titleInput.getText().toString());
    intent.putExtra("dateFrom", dateFromInput.getText().toString());
    intent.putExtra("dateTo", dateToInput.getText().toString());

    startActivity(intent);
});

 Button addButton = findViewById(R.id.btnAddGame);

 addButton.setOnClickListener(v -> {

    Intent intent = new Intent(MainActivity.this, AddGameActivity.class);

    startActivity(intent);
}); 

}
