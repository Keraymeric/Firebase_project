package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ImportActivity extends AppCompatActivity {

   private ProgressBar progressBar;
   int count =0;
   Timer timer;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_import);
      progressBar=findViewById(R.id.progressBar2);
      timer = new Timer();
      TimerTask t = new TimerTask() {
         @Override
         public void run() {
            count=count+4;
            progressBar.setProgress(count);
            if (count==100){
               timer.cancel();
               Intent intent = new Intent(ImportActivity.this,EquipeActivity.class);
               startActivity(intent);
            }
         }
      };
      timer.schedule(t,0,100);

   }
}
