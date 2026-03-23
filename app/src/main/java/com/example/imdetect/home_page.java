package com.example.imdetect;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.imdetect.ml.Plantmo;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class home_page extends AppCompatActivity {

    private String plantName;

    Button camera, gallery,picture,moredetails; // Corrected button initialization
    TextView result, confidence;
    ImageView imageView;
    int imageSize = 256;
    private boolean plantResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home_pag);
        result = findViewById(R.id.result);
        confidence = findViewById(R.id.confidence);


        imageView = findViewById(R.id.imageView);
        // Corrected button initialization
        camera = findViewById(R.id.button); // Corrected button initialization
        gallery = findViewById(R.id.button2); // Corrected button initialization
        moredetails = findViewById(R.id.button_more_details);





        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 3);
                } else {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 300);
                }
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 10);
            }
        });

        moredetails.setOnClickListener(v -> {
            if (plantName != null && !plantName.isEmpty()) {
                // If plantName is set, proceed to the details activity
                Intent intent = new Intent(home_page.this, PlantDetailsActivity.class);
                intent.putExtra("plantName", plantName); // Pass the plant name to PlantDetailsActivity
                startActivity(intent);
            } else {
                // Show a toast message indicating that the output is missing
                Toast.makeText(home_page.this, "Please classify a plant first to view more details.", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void classifyImage(Bitmap image){


        try {


            Plantmo model = Plantmo.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 256, 256, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
            int pixel = 0;
            //iterate over each pixel and extract R, G, and B values. Add those values individually to the byte buffer.
            for(int i = 0; i < imageSize; i ++){
                for(int j = 0; j < imageSize; j++){
                    int val = intValues[pixel++]; // RGB
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 1));
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 1));
                    byteBuffer.putFloat((val & 0xFF) * (1.f / 1));
                }
            }

            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            Plantmo.Outputs outputs = model.process(inputFeature0);
            int maxPos = getMaxPos(outputs);
            String[] classes = {"Alpinia Galanga (Rasna)",
                    "Amaranthus Viridis (Arive-Dantu)",
                    "Artocarpus Heterophyllus (Jackfruit)",
                    "Azadirachta Indica (Neem)",
                    "Basella Alba (Basale)",
                    "Brassica Juncea (Indian Mustard)",
                    "Carissa Carandas (Karanda)",
                    "Citrus Limon (Lemon)",
                    "Ficus Auriculata (Roxburgh fig)",
                    "Ficus Religiosa (Peepal Tree)",
                    "Hibiscus Rosa-sinensis",
                    "Jasminum (Jasmine)",
                    "Mangifera Indica (Mango)",
                    "Mentha (Mint)",
                    "Moringa Oleifera (Drumstick)",
                    "Muntingia Calabura (Jamaica Cherry-Gasagase)",
                    "Murraya Koenigii (Curry)",
                    "Nerium Oleander (Oleander)",
                    "Nyctanthes Arbor-tristis (Parijata)",
                    "Ocimum Tenuiflorum (Tulsi)",
                    "Piper Betle (Betel)",
                    "Plectranthus Amboinicus (Mexican Mint)",
                    "Pongamia Pinnata (Indian Beech)",
                    "Psidium Guajava (Guava)",
                    "Punica Granatum (Pomegranate)",
                    "Santalum Album (Sandalwood)",
                    "Syzygium Cumini (Jamun)",
                    "Syzygium Jambos (Rose Apple)",
                    "Tabernaemontana Divaricata (Crape Jasmine)",
                    "Trigonella Foenum-graecum (Fenugreek)",
            };
            result.setText(classes[maxPos]);
            plantName = classes[maxPos];




            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
            float confidenceValue = outputFeature0.getFloatArray()[maxPos];
            confidence.setText("Confidence: " + confidenceValue*100);

            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {

        }
    }



    private static int getMaxPos(Plantmo.Outputs outputs) {
        TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

        float[] confidences = outputFeature0.getFloatArray();
        // find the index of the class with the biggest confidence.
        int maxPos = 0;
        float maxConfidence = 0;
        for (int i = 0; i < confidences.length; i++) {
            if (confidences[i] > maxConfidence) {
                maxConfidence = confidences[i];
                maxPos = i;
            }
        }
        return maxPos;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 3){
                Bitmap image = (Bitmap) data.getExtras().get("data");
                int dimension = Math.min(image.getWidth(), image.getHeight());
                image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);
            }else{
                Uri dat = data.getData();
                Bitmap image = null;
                try {
                    image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), dat);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}

