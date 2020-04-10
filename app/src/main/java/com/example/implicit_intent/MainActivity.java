package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText web,loc,share;
    Button open_web,open_loc,open_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web=findViewById(R.id.web);
        loc=findViewById(R.id.loc);
        share=findViewById(R.id.share);
        open_web=findViewById(R.id.open_web);
        open_loc=findViewById(R.id.open_loc);
        open_share=findViewById(R.id.open_share);
    }

    public void openwebsite(View view) {
        String url = web.getText().toString();
        Uri webpage=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("Implicit intents","can't handle this");
        }

    }

    public void openlocation(View view) {
        String lo = loc.getText().toString();
        Uri addressuri=Uri.parse("geo:0,0?q" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressuri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void sharetext(View view) {
        String txt = share.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder.from(this).setType(mimeType).setChooserTitle(R.string.start).setText(txt).startChooser();

    }
}
