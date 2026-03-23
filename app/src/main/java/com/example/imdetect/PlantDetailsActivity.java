package com.example.imdetect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlantDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_details);

        ImageView plantImage = findViewById(R.id.imageViewPlant);
        TextView plantName1 = findViewById(R.id.textViewPlantName);
        TextView plantFamily = findViewById(R.id.textViewPlantFamily);
        TextView plantNativeRegion = findViewById(R.id.textViewPlantNativeRegion);
        TextView plantDescription = findViewById(R.id.textViewPlantDescription);
        TextView plantTreatments = findViewById(R.id.textViewPlantTreatments);

        // Get the plant name passed from the previous activity
        Intent intent = getIntent();
        String plantName = intent.getStringExtra("plantName");



        // Show specific details based on the classified plant
        if ("Ocimum Tenuiflorum (Tulsi)".equals(plantName)) {
            plantImage.setImageResource(R.drawable.tulsi_image);
            plantName1.setText("Ocimum Tenuiflorum (Tulsi)");
            plantFamily.setText("Family: Lamiaceae");
            plantNativeRegion.setText("Native Region: Indian Subcontinent\n");
            plantDescription.setText("A sacred plant in Hinduism, Tulsi has numerous health benefits such as boosting immunity, reducing stress, and improving respiratory function.\n");
            plantTreatments.setText("Treatments:\n- Fevers\n- Respiratory issues\n- Skin diseases\n- Asthma\n- Digestive disorders");
        } else if ("Azadirachta Indica (Neem)".equals(plantName)) {
            plantImage.setImageResource(R.drawable.neem_image);
            plantName1.setText("Azadirachta Indica (Neem)");
            plantFamily.setText("Family: Meliaceae");
            plantNativeRegion.setText("Native Region: Indian Subcontinent\n");
            plantDescription.setText("A tall tree with spreading branches, known for its medicinal properties including antibacterial and anti-inflammatory benefits.\n");
            plantTreatments.setText("Treatments:\n- Skin ailments\n- Wounds\n- Coughs\n- Asthma\n- Eye diseases\n- Worms");
        } else if ("Citrus Limon (Lemon)".equals(plantName)) {
            plantImage.setImageResource(R.drawable.lemon_image);
            plantName1.setText("Citrus Limon (Lemon)");
            plantFamily.setText("Family: Rutaceae");
            plantNativeRegion.setText("Native Region: Asia\n");
            plantDescription.setText("Lemon is widely used for its high vitamin C content, helping boost immunity, improve digestion, and detoxify the body.\n");
            plantTreatments.setText("Treatments:\n- Colds\n- Coughs\n- Sore throat\n- Detoxification\n- Skin care");
        } else if ("Mangifera Indica (Mango)".equals(plantName)) {
            plantImage.setImageResource(R.drawable.mango_image);
            plantName1.setText("Mangifera Indica (Mango)");
            plantFamily.setText("Family: Anacardiaceae");
            plantNativeRegion.setText("Native Region: South Asia\n");
            plantDescription.setText("Mango is known for its delicious fruit and high nutritional value, providing essential nutrients and antioxidants for overall health.\n");
            plantTreatments.setText("Treatments:\n- Digestive health\n- Skin care\n- Immunity boost\n- Eye health");
        } else {
            plantImage.setImageResource(R.drawable.image); // Set a default image if no match is found
            plantName1.setText("Unknown Plant");
            plantDescription.setText("Details not available for this plant.");
        }
    }
}

