package praveen.projects.android.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private boolean answer;
    private Button bShowAnswer;
    private TextView answer_text_box;
    public static Intent newIntent(Context packageContext, boolean answer){
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra("ANSWER", answer);
        return i;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Intent i = getIntent();
        answer = i.getBooleanExtra("ANSWER", false);
        bShowAnswer = (Button)findViewById(R.id.show_answer);
        answer_text_box = (TextView)findViewById(R.id.answer_text_box);

        bShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer_text_box.setText(String.valueOf(answer));
                setResult(RESULT_OK, new Intent().putExtra("ANSWER_SHOWN", true));
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
