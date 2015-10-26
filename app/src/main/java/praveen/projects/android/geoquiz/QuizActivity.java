package praveen.projects.android.geoquiz;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button bTrueButton;
    private Button bNextButton;
    private Button bPrevButton;
    private Button bFalseButton;
    private TextView tQuestion_View;
    private int mCurrentIndex;
    private Question cQues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        if (savedInstanceState != null)
            mCurrentIndex = savedInstanceState.getInt("QNO");
        else
            mCurrentIndex = 0;
        bTrueButton = (Button) findViewById(R.id.true_button);
        bFalseButton = (Button) findViewById(R.id.false_button);
        bNextButton = (Button) findViewById(R.id.next_button);
        bPrevButton = (Button) findViewById(R.id.prev_button);
        tQuestion_View = (TextView) findViewById(R.id.question_text_box);
        updateQuestion(0);
        bTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        bFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        bNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion(1);

            }
        });

        bPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion(-1);
            }
        });

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("QNO", mCurrentIndex);
    }

    private void updateQuestion(int increment) {
        Log.d("MYTAG", "in update question");
        mCurrentIndex += increment + QuestionBank.qBank.size();
        mCurrentIndex = mCurrentIndex % QuestionBank.qBank.size();
        tQuestion_View.setText(QuestionBank.qBank.get(mCurrentIndex).getqId());
    }

    private void checkAnswer(boolean selected) {
        if (QuestionBank.qBank.get(mCurrentIndex).getQans() == selected)
            Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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
}
