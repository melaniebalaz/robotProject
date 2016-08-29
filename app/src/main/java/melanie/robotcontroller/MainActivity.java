package melanie.robotcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_SERVERIP = "com.example.robotController.EXTRA_SERVERIP";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void processIP(View view) {
        Intent intent = new Intent(this, directionController.class);

        EditText editText = (EditText) findViewById(R.id.enterServerIP);
        String serverIP = editText.getText().toString();
        intent.putExtra(EXTRA_SERVERIP, serverIP);

        startActivity(intent);
    }
}
