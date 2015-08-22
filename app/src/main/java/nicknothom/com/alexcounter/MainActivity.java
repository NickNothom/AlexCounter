package nicknothom.com.alexcounter;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int number;

    //Grab the textView out of the layout, call it "numberDisplay"
    TextView numberDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the number to zero, so our view will show it properly when it is created on the next line
        number = 0;

        setContentView(R.layout.activity_material);

        //Define what "numberDisplay" is, now that it exists in the view
        numberDisplay = (TextView) findViewById(R.id.numberDisplay);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

     public void up (View v) {
         Vibrator vib = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);

         vib.vibrate(10);

         //Add one to the number
         number++;

         //Define a string version of the number, so we can toss it in the textView
         String numberString = Integer.toString(number);

         //Set the text of the textview to our newly created String, which reflects the value of the integer "number"
         numberDisplay.setText(numberString);

    }

    public void reset (View v) {
        Vibrator vib = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);

        vib.vibrate(40);

        //Set the number to zero
        number = 0;

        //Define a string version of the number, so we can toss it in the textView
        String numberString = Integer.toString(number);

        //Set the text of the textview to our newly created String, which reflects the value of the integer "number"
        numberDisplay.setText(numberString);

    }

    public void down (View v) {
        Vibrator vib = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);

        vib.vibrate(10);

        number--;

        String numberString = Integer.toString(number);

        numberDisplay.setText(numberString);
    }

}
