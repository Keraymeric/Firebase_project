package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ImportActivity extends AppCompatActivity {
   private Button buttonImportFini;
   private ProgressBar progressBar;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_import);

      buttonImportFini = findViewById(R.id.buttonImportfini);
      progressBar=findViewById(R.id.progressBar);


      buttonImportFini.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(ImportActivity.this,EquipeActivity.class);
            startActivity(intent);
         }
      });
   }
}
