package com.habitissimo.vespapp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    private final int TAKE_CAPTURE_REQUEST = 0;
    private final int PICK_IMAGE_REQUEST = 1;

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabs();
        initCamBtn();
        initSelFotosBtn();
    }

    private void initSelFotosBtn() {
        Button btn = (Button) findViewById(R.id.btn_selFotos);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, PICK_IMAGE_REQUEST);
            }
        });
    }

    private void initCamBtn() {
        Button btn = (Button) findViewById(R.id.btn_cam);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, TAKE_CAPTURE_REQUEST);
            }
        });

        img = (ImageView) findViewById(R.id.img);
    }

    /**
     * Inicializar pestañas
     */
    private void initTabs() {
        TabHost tabs = (TabHost) findViewById(R.id.tabs_main);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("GuiaTab");
        spec.setContent(R.id.layout_guia_tab);
        spec.setIndicator("Guía");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("MainTab");
        spec.setContent(R.id.layout_main_tab);
        spec.setIndicator("Haz una foto");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("CapTab");
        spec.setContent(R.id.layout_capturas_tab);
        spec.setIndicator("Capturas");
        tabs.addTab(spec);

        tabs.setCurrentTab(1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Bitmap bp = null;

            switch (requestCode) {
                case TAKE_CAPTURE_REQUEST:
                    bp = (Bitmap) data.getExtras().get("data");
                    img.setImageBitmap(bp);
                    break;
                case PICK_IMAGE_REQUEST:
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    bp = BitmapFactory.decodeFile(picturePath);
                    break;
            }

            img.setImageBitmap(bp);
        }

    }
}
