/**
 * Created by Praveen on 10/25/2015.
 */
package praveen.projects.android.geoquiz;
public class Question {
    private int qId;
    private boolean qans;

    public Question(boolean qans, int qId) {
        this.qans = qans;
        this.qId = qId;
    }

    public boolean getQans() {
        return qans;
    }

    public int getqId() {
        return qId;
    }
}
