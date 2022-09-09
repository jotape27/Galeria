package ferreira.juan.galeria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   List<String> photos = new ArrayList<>();

   MainAdapter mainAdapter;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      File dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
      File[] files = dir.listFiles();
      for(int i = 0; i < files.length; i++) {
         photos.add(files[i].getAbsolutePath());
      }

      mainAdapter = new MainAdapter(MainActivity.this, photos);

      RecyclerView rvGallery = findViewById(R.id.rvGallery);
      rvGallery.setAdapter(mainAdapter);

      float w = getResources().getDimension(R.dimen.itemWidth);
      int numberOfColumns = Utils.calculateNoOfColumns(MainActivity.this, w);
      GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, numberOfColumns);
      rvGallery.setLayoutManager(gridLayoutManager);


      Toolbar toolbar = findViewById(R.id.tbMain);
      setSupportActionBar(toolbar);

      ActionBar actionBar = getSupportActionBar();
      actionBar.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      super.onCreateOptionsMenu(menu);
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.main_activity_tb, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
         case R.id.opCamera:
            dispatchTakePictureIntent();
            return true;
         default:
            return super.onOptionsItemSelected(item);
      }
   }

   private void dispatchTakePictureIntent() {
   }

   public void startPhotoActivity(String s) {
   }



}