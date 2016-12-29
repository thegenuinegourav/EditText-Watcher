package thegenuinegourav.textwatcherexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mobileEditText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initializing views */
        mobileEditText = (EditText) findViewById(R.id.mobile);
        textView = (TextView) findViewById(R.id.mobileHint);
        textView.setVisibility(View.GONE);

        /* Set Text Watcher listener */
        mobileEditText.addTextChangedListener(mobileWatcher);
    }

    private final TextWatcher mobileWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            textView.setTextColor(Color.RED);
            if (s.length() == 0) {
                textView.setText("This is required field");
            }
            else if(s.length() == 10)
            {
                textView.setText("Perfect");
                textView.setTextColor(Color.GREEN);
            }else if(s.length() > 10){
                textView.setText("Mobile should be less than 10 digit");
            }
            else
            {
                textView.setText("Mobile should be 10 digit");
            }
        }
    };
}
