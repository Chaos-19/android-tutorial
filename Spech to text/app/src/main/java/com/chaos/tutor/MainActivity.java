package com.chaos.tutor;

import android.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.speech.*;
import android.view.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.appcompat.app.*;
import androidx.appcompat.widget.*;
import androidx.core.app.*;
import androidx.core.content.*;
import com.google.android.material.floatingactionbutton.*;
import java.util.*;

import androidx.appcompat.widget.Toolbar;
import android.view.View.*;

public class MainActivity extends AppCompatActivity 
{
    private Toolbar toolbar;
	
  public static final Integer RECORD_AUDIO_RC = 1;
  private SpeechRecognizer speechRecognizer;
  private TextView editText;
  private FloatingActionButton micButton;

	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*toolbar = findViewById(R.id.mainToolbar);

        setSupportActionBar(toolbar);*/
		
	  if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
		checkPermission();
	  }

	  editText = findViewById(R.id.text);
	  micButton = findViewById(R.id.button);
	  speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

	  final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	  speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	  speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

	  speechRecognizer.setRecognitionListener(new RecognitionListener() {
		  @Override
		  public void onReadyForSpeech(Bundle bundle) {

		  }

		  @Override
		  public void onBeginningOfSpeech() {
			editText.setText("");
			editText.setHint("Listening...");
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
			micButton.setImageResource(R.drawable.ic_launcher);
			ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
			editText.setText(data.get(0));
		  }

		  @Override
		  public void onPartialResults(Bundle bundle) {

		  }

		  @Override
		  public void onEvent(int i, Bundle bundle) {

		  }
        });
	  micButton.setOnTouchListener(new OnTouchListener(){

		  @Override
		  public boolean onTouch(View p1, MotionEvent p2)
		  {
			if (p2.getAction() == MotionEvent.ACTION_UP) {
			  speechRecognizer.stopListening();
			}
			if (p2.getAction()== MotionEvent.ACTION_DOWN) {
			  micButton.setImageResource(R.drawable.ic_launcher);
			  speechRecognizer.startListening(speechRecognizerIntent);
			}
			return false;
		  }
		});

/*	  micButton.setOnTouchListener((view, motionEvent) {
		
	  });
*/

    }

    @Override
    protected void onDestroy() {
	  super.onDestroy();
	  speechRecognizer.destroy();
    }

    private void checkPermission() {
	  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_AUDIO_RC);
	  }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
	  super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	  if (requestCode == RECORD_AUDIO_RC && grantResults.length > 0) {
		if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
		  Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
	  }
		
        
       
        
    }
}
