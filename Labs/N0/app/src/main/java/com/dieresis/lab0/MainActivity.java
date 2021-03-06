package com.dieresis.lab0;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView helloTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTv = (TextView) findViewById(R.id.textView);
        Button helloBtn = (Button) findViewById(R.id.button);

        helloBtn.setOnClickListener(onClickListener);
    }


    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            helloTv.setText(helloTv.getText()+"\nЗдравствуй ещё раз!");
        }
    };

}
