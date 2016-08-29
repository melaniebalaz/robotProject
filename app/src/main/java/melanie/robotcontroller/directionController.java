package melanie.robotcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class directionController extends AppCompatActivity {


    protected String serverIPAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction_controller);

        Intent intent = getIntent();
        this.serverIPAdress = intent.getStringExtra(MainActivity.EXTRA_SERVERIP);
    }

    public void forwardMove(View view) {

        String direction;
        direction = "forward";
        createNewServerRequest(direction);
    }

    public void backwardMove(View view) {



    }

    private void createNewServerRequest(final String direction){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URLConnection connection = new URL("http://" + serverIPAdress +":8000/?" + direction).openConnection();
                    InputStream response = connection.getInputStream();
                }
                catch (Exception e) {
                    Log.e("MYAPP", "exception", e);
                }
            }
        });

        thread.start();
    }
}
