package praveen.projects.android.geoquiz;

import java.util.ArrayList;

/**
 * Created by Praveen on 10/25/2015.
 */
public class QuestionBank {
    public static ArrayList<Question> qBank = new ArrayList<Question>();

    static {
        qBank.add(new Question(false, R.string.q_name));
        qBank.add(new Question(true, R.string.q_age));
        qBank.add(new Question(false, R.string.q_height));
        qBank.add(new Question(true, R.string.q_weight));
        qBank.add(new Question(false, R.string.q_birth));
    }
}
