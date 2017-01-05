package jojo.com.jivi;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private MyPagerAdapter myPagerAdapter;

    private ViewPager mViewPager;
    private final int SPEECH_RECOGNITION_CODE = 1;
    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView txtOutput;
    private ImageButton btnMicrophone;
    TextToSpeech t1;
    public Button btnAlphabet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(myPagerAdapter);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

                txtOutput = (TextView) findViewById(R.id.txt_output);
                btnMicrophone = (ImageButton) findViewById(R.id.btn_mic);

                btnMicrophone.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startSpeechToText();
                    }
                });
        }

            private void startSpeechToText() {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        "Speak something...");
                try {
                    startActivityForResult(intent, SPEECH_RECOGNITION_CODE);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),
                            "Sorry! Speech recognition is not supported in this device.",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);

                switch (requestCode) {
                    case SPEECH_RECOGNITION_CODE: {
                        if (resultCode == RESULT_OK && null != data) {

                            ArrayList<String> result = data
                                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                            String text = result.get(0);
                            txtOutput.setText(text);
                            System.out.println(text);
                            Log.d(TAG, text);
                            Log.d(TAG, result.toString());
                            if (text.equals("previous")) {
                                text = "back";
                            } else if
                                    (text.equals("forward")) {
                                text = "next";
                            }

                            switch (text) {

                                case "step 1": {
                                    String toSpeak = null;
                                    toSpeak = "Displaying step 1";
                                    Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                    if (mViewPager.getCurrentItem() < mViewPager.getAdapter().getCount()) {
                                        String lastDigit = text.substring(text.length() - 1);
                                        int stepnumber = Integer.parseInt(lastDigit);
                                        mViewPager.setCurrentItem(stepnumber - 1);
                                    }
                                }
                                break;
                                case "step 2": {
                                    String toSpeak = "Displaying step 2";
                                    Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                    if (mViewPager.getCurrentItem() < mViewPager.getAdapter().getCount()) {
                                        String lastDigit = text.substring(text.length() - 1);
                                        int stepnumber = Integer.parseInt(lastDigit);
                                        mViewPager.setCurrentItem(stepnumber - 1);
                                    }
                                }
                                break;
                                case "step 3": {
                                    String toSpeak = "Displaying step 3";

                                    Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                    if (mViewPager.getCurrentItem() < mViewPager.getAdapter().getCount()) {
                                        String lastDigit = text.substring(text.length() - 1);
                                        int stepnumber = Integer.parseInt(lastDigit);
                                        mViewPager.setCurrentItem(stepnumber - 1);
                                    }
                                }
                                break;
                                case "next": {
                                    String toSpeak = "Displaying next";
                                    Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                    if (mViewPager.getCurrentItem() < mViewPager.getAdapter().getCount()) {
                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
                                    }
                                }
                                break;
                                case "back": {
                                    String toSpeak = "Displaying previous";
                                    Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                    if (mViewPager.getCurrentItem() < mViewPager.getAdapter().getCount()) {
                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
                                    }
                                }
                                break;

                            }


                        }
                        break;
                    }

                }
            }

    public void onAlphabetClick(View view){
        Intent intent = new Intent (MainActivity.this,alphabetActivity.class);
        startActivity(intent);
    }

    @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.action_settings) {
                    return true;
                }

                return super.onOptionsItemSelected(item);
            }
        }