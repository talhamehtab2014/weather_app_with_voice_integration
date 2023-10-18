package com.example.applicationweather;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.applicationweather.api_service.ApiCall;
import com.example.applicationweather.api_service.CreateService;
import com.example.applicationweather.interfaces.OnApiTest;
import com.example.applicationweather.model.DModelWeather;
import com.example.applicationweather.utils.Constant;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final Integer RecordAudioRequestCode = 1;
    ProgressDialog progressDialog;
    //region Variable Declaration
    private LinearLayout llBtnVoiceRecognition, llMainContainer;
    private TextView txvLocation, txvHighTemperature, txvLowTemperature;
    private SpeechRecognizer speechRecognizer;
    private Intent speechRecognizerIntent;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bindViews();
    }


    //To Initialize the Variables or any other stuff when activity start
    private void init() {
        checkMicroPhonePermission();
        progressDialog = new ProgressDialog(this);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

    }

    //To Bind the views with the variables
    private void bindViews() {
        txvLocation = findViewById(R.id.act_main_txv_location_name);
        txvHighTemperature = findViewById(R.id.act_main_txv_high_temp);
        txvLowTemperature = findViewById(R.id.act_main_txv_low_temp);
        llBtnVoiceRecognition = findViewById(R.id.act_main_ll_btn_voice_recognition);
        llMainContainer = findViewById(R.id.act_main_ll_main_container);

        //Setting the Events
        llBtnVoiceRecognition.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                speechRecognizer.stopListening();
            }
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                speechRecognizer.startListening(speechRecognizerIntent);
            }
            return true;
        });

        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                //Only City names will work
                if (data != null) {
                    String cityName = data.get(0);
                    requestWeatherData(cityName);
                }
            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });


    }

    private void requestWeatherData(String cityName) {

        showLoadingIndicator();

        ApiCall.callApi(CreateService.getNodeService().requestGetWeatherInformation(cityName, "json", 'c'), new OnApiTest() {
            @Override
            public void onSuccess(Response response) {
                hideLoadingIndicator();
                if (response.isSuccessful()) {

                    DModelWeather obj = (DModelWeather) response.body();

                    txvLocation.setText(new StringBuilder().append(obj.getLocation().getCity()).append(", ").append(obj.getLocation().getCountry()));
                    txvHighTemperature.setText(new StringBuilder().append("High: ").append(obj.getForecasts().get(0).getHigh()).append(" °"));
                    txvLowTemperature.setText(new StringBuilder().append("Low: ").append(obj.getForecasts().get(0).getLow()).append(" °"));
                } else {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFail(String msg) {
                hideLoadingIndicator();
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        }, Constant.RESPONSE_TYPE_DATA, getApplicationContext());

    }

    private void checkMicroPhonePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
            // Permission is already granted, you can proceed with using the microphone.
        } else {
            // Permission is not granted, request it.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, RecordAudioRequestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RecordAudioRequestCode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showLoadingIndicator() {

        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false); // Prevent dismissing with a touch outside the dialog
        progressDialog.show();
    }

    private void hideLoadingIndicator() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}