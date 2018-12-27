package rzd.com.activity3tictactoe;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    LinearLayout mLLayoutPlayer;
    Button mButton1, mButton2, mButton3, mButton4, mButton5,
            mButton6, mButton7, mButton8, mButton9, mButtonReset,
            mButtonColorRedP1, mButtonColorYellowP1, mButtonColorBlueP1,
            mButtonColorRedP2, mButtonColorYellowP2, mButtonColorBlueP2,
            mBtnSettings;
    TextView mTxtViewResult;
    EditText mEditTxtP1, mEditTxtP2;
    int mPlayerTurn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTxtP1 = findViewById(R.id.editTxtP1);
        mEditTxtP2 = findViewById(R.id.editTxtP2);
        mLLayoutPlayer = findViewById(R.id.LLayoutPlayer);
        mBtnSettings = findViewById(R.id.btnSettings);
        mButton1 = findViewById(R.id.btn1);
        mButton2 = findViewById(R.id.btn2);
        mButton3 = findViewById(R.id.btn3);
        mButton4 = findViewById(R.id.btn4);
        mButton5 = findViewById(R.id.btn5);
        mButton6 = findViewById(R.id.btn6);
        mButton7 = findViewById(R.id.btn7);
        mButton8 = findViewById(R.id.btn8);
        mButton9 = findViewById(R.id.btn9);
        mButtonReset = findViewById(R.id.btnReset);
        mButtonColorRedP1 = findViewById(R.id.btnColor1P1);
        mButtonColorRedP2 = findViewById(R.id.btnColor1P2);
        mButtonColorYellowP1 = findViewById(R.id.btnColor2P1);
        mButtonColorYellowP2 = findViewById(R.id.btnColor2P2);
        mButtonColorBlueP1 = findViewById(R.id.btnColor3P1);
        mButtonColorBlueP2 = findViewById(R.id.btnColor3P2);
        mTxtViewResult = findViewById(R.id.txtViewResult);

    }
    //onclick of 3x3
    public void mButton1(View v) {
        startBtn1();
    }

    public void mButton2(View v) {
        startBtn2();
    }

    public void mButton3(View v) {
        startBtn3();
    }

    public void mButton4(View v) {
        startBtn4();
    }

    public void mButton5(View v) {
        startBtn5();
    }

    public void mButton6(View v) {
        startBtn6();
    }

    public void mButton7(View v) {
        startBtn7();
    }

    public void mButton8(View v) {
        startBtn8();
    }

    public void mButton9(View v) {
        startBtn9();
    }

    //    onclick Button Color
    public void mBtnColor1P1(View v) {
        mButtonColorRedP1.setText("SELECTED");
        mButtonColorRedP2.setText("");
        mButtonColorBlueP1.setText("");
        mButtonColorYellowP1.setText("");
        mButtonColorRedP2.setClickable(false);
        mButtonColorBlueP2.setClickable(true);
        mButtonColorYellowP2.setClickable(true);
    }

    public void mBtnColor1P2(View v) {
        mButtonColorRedP2.setText("SELECTED");
        mButtonColorRedP1.setText("");
        mButtonColorBlueP2.setText("");
        mButtonColorYellowP2.setText("");
        mButtonColorRedP1.setClickable(false);
        mButtonColorBlueP1.setClickable(true);
        mButtonColorYellowP1.setClickable(true);
    }

    public void mBtnColor2P1(View v) {
        mButtonColorYellowP1.setText("SELECTED");
        mButtonColorYellowP2.setText("");
        mButtonColorRedP1.setText("");
        mButtonColorBlueP1.setText("");
        mButtonColorYellowP2.setClickable(false);
        mButtonColorBlueP2.setClickable(true);
        mButtonColorRedP2.setClickable(true);
    }

    public void mBtnColor2P2(View v) {
        mButtonColorYellowP2.setText("SELECTED");
        mButtonColorYellowP1.setText("");
        mButtonColorBlueP2.setText("");
        mButtonColorRedP2.setText("");
        mButtonColorYellowP1.setClickable(false);
        mButtonColorBlueP1.setClickable(true);
        mButtonColorRedP1.setClickable(true);
    }

    public void mBtnColor3P1(View v) {
        mButtonColorBlueP1.setText("SELECTED");
        mButtonColorBlueP2.setText("");
        mButtonColorRedP1.setText("");
        mButtonColorYellowP1.setText("");
        mButtonColorBlueP2.setClickable(false);
        mButtonColorRedP2.setClickable(true);
        mButtonColorYellowP2.setClickable(true);
    }

    public void mBtnColor3P2(View v) {
        mButtonColorBlueP2.setText("SELECTED");
        mButtonColorBlueP1.setText("");
        mButtonColorRedP2.setText("");
        mButtonColorYellowP2.setText("");
        mButtonColorBlueP1.setClickable(false);
        mButtonColorRedP1.setClickable(true);
        mButtonColorYellowP1.setClickable(true);
    }

    //show // hide settings
    public void mBtnSettings(View v) {
        if (mLLayoutPlayer.getVisibility() == View.VISIBLE) {
            mLLayoutPlayer.setVisibility(LinearLayout.GONE);
            mBtnSettings.setText("Show Settings");

        } else {
            mLLayoutPlayer.setVisibility(LinearLayout.VISIBLE);
            mBtnSettings.setText("Hide Settings");
        }

    }

    //reset game
    public void btnReset(View v) {
        setViewAndChildrenEnabled(mLLayoutPlayer, true);
        resetTicTacToeBtn();
        mTxtViewResult.setText("Result");
        mPlayerTurn = 0;
    }

    //inputting of symbols and background color
    public void startBtn1() {

        if(checkEmpty() == true){
            alertDialogEmpty();
        }
        else if (compareSymbol() == true) {
            alertDialogSymbol();
        } else if (checkColor() == true) {
            alertDialogColor();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            mPlayerTurn = (mPlayerTurn + 1) % 2;

            if (mPlayerTurn == 1) {
                mButton1.setText(mEditTxtP1.getText());
                mButton1.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.YELLOW);


            } else {
                mButton1.setText(mEditTxtP2.getText());
                mButton1.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.YELLOW);

            }
            checkWinnerBtn1();
        }
    }
    public void startBtn2() {
        if(checkEmpty() == true){
            alertDialogEmpty();
        }
        else if (compareSymbol() == true) {
            alertDialogSymbol();
        } else if (checkColor() == true) {
            alertDialogColor();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                mButton2.setText(mEditTxtP1.getText());
                mButton2.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.YELLOW);
            } else {
                mButton2.setText(mEditTxtP2.getText());
                mButton2.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.YELLOW);
            }
            checkWinnerBtn2();
        }
    }
    public void startBtn3() {
        if(checkEmpty() == true){
            alertDialogEmpty();
        }
        else if (compareSymbol() == true) {
            alertDialogSymbol();
        } else if (checkColor() == true) {
            alertDialogColor();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                mButton3.setText(mEditTxtP1.getText());
                mButton3.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.YELLOW);
            } else {
                mButton3.setText(mEditTxtP2.getText());
                mButton3.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.YELLOW);
            }
            checkWinnerBtn3();
        }
    }
    public void startBtn4() {
        if(checkEmpty() == true){
            alertDialogEmpty();
        }
        else if (compareSymbol() == true) {
            alertDialogSymbol();
        } else if (checkColor() == true) {
            alertDialogColor();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                mButton4.setText(mEditTxtP1.getText());
                mButton4.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.YELLOW);
            } else {
                mButton4.setText(mEditTxtP2.getText());
                mButton4.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.YELLOW);
            }
            checkWinnerBtn4();
        }
    }
    public void startBtn5() {
        if(checkEmpty() == true){
            alertDialogEmpty();
        }
        else if (compareSymbol() == true) {
            alertDialogSymbol();
        } else if (checkColor() == true) {
            alertDialogColor();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                mButton5.setText(mEditTxtP1.getText());
                mButton5.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.YELLOW);
            } else {
                mButton5.setText(mEditTxtP2.getText());
                mButton5.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.YELLOW);
            }
            checkWinnerBtn5();
        }
    }
    public void startBtn6() {
        if(checkEmpty() == true){
            alertDialogEmpty();
        }
        else if (compareSymbol() == true) {
            alertDialogSymbol();
        } else if (checkColor() == true) {
            alertDialogColor();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                mButton6.setText(mEditTxtP1.getText());
                mButton6.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.YELLOW);
            } else {
                mButton6.setText(mEditTxtP2.getText());
                mButton6.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.YELLOW);
            }
            checkWinnerBtn6();
        }
    }
    public void startBtn7() {
        if(checkEmpty() == true){
            alertDialogEmpty();
        }
        else if (compareSymbol() == true) {
            alertDialogSymbol();
        } else if (checkColor() == true) {
            alertDialogColor();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                mButton7.setText(mEditTxtP1.getText());
                mButton7.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.YELLOW);
            } else {
                mButton7.setText(mEditTxtP2.getText());
                mButton7.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.YELLOW);
            }
            checkWinnerBtn7();
        }
    }
    public void startBtn8() {
        if(checkEmpty() == true){
            alertDialogEmpty();
        }
        else if (compareSymbol() == true) {
            alertDialogSymbol();
        } else if (checkColor() == true) {
            alertDialogColor();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                mButton8.setText(mEditTxtP1.getText());
                mButton8.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.YELLOW);
            } else {
                mButton8.setText(mEditTxtP2.getText());
                mButton8.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.YELLOW);
            }
            checkWinnerBtn8();
        }
    }
    public void startBtn9() {
        if(checkEmpty() == true){
            alertDialogEmpty();
        }
        else if (compareSymbol() == true) {
            alertDialogSymbol();
        } else if (checkColor() == true) {
            alertDialogColor();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                mButton9.setText(mEditTxtP1.getText());
                mButton9.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.YELLOW);
            } else {
                mButton9.setText(mEditTxtP2.getText());
                mButton9.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.YELLOW);
            }
            checkWinnerBtn9();
        }
    }

    //enabled disabled layout view for radiobutton and color
    private static void setViewAndChildrenEnabled(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewAndChildrenEnabled(child, enabled);
            }
        }

    }

    public void resetTicTacToeBtn() {
        mButton1.setText("");
        mButton1.setBackgroundResource(R.color.defaultColor);
        mButton2.setText("");
        mButton2.setBackgroundResource(R.color.defaultColor);
        mButton3.setText("");
        mButton3.setBackgroundResource(R.color.defaultColor);
        mButton4.setText("");
        mButton4.setBackgroundResource(R.color.defaultColor);
        mButton5.setText("");
        mButton5.setBackgroundResource(R.color.defaultColor);
        mButton6.setText("");
        mButton6.setBackgroundResource(R.color.defaultColor);
        mButton7.setText("");
        mButton7.setBackgroundResource(R.color.defaultColor);
        mButton8.setText("");
        mButton8.setBackgroundResource(R.color.defaultColor);
        mButton9.setText("");
        mButton9.setBackgroundResource(R.color.defaultColor);
        mButton1.setEnabled(true);
        mButton2.setEnabled(true);
        mButton3.setEnabled(true);
        mButton4.setEnabled(true);
        mButton5.setEnabled(true);
        mButton6.setEnabled(true);
        mButton7.setEnabled(true);
        mButton8.setEnabled(true);
        mButton9.setEnabled(true);


    }

    public void disabledBtnTTT() {
        mButton1.setEnabled(false);
        mButton2.setEnabled(false);
        mButton3.setEnabled(false);
        mButton4.setEnabled(false);
        mButton5.setEnabled(false);
        mButton6.setEnabled(false);
        mButton7.setEnabled(false);
        mButton8.setEnabled(false);
        mButton9.setEnabled(false);
    }

    public void checkWinnerBtn1() {
        if ((mButton1.getText().equals(mButton2.getText())) && (mButton1.getText().equals(mButton3.getText()))
                || (mButton1.getText().equals(mButton5.getText()) && (mButton1.getText().equals(mButton9.getText())))
                || (mButton1.getText().equals(mButton4.getText()) && (mButton1.getText().equals(mButton7.getText())))) {
            if (mPlayerTurn == 1) {
                mTxtViewResult.setText("Result: Player 1 Wins");
                disabledBtnTTT();
            } else
                mTxtViewResult.setText("Result: Player 2 Wins");
            disabledBtnTTT();
        }
        else if(!mButton2.getText().equals("") && !mButton3.getText().equals("") && !mButton4.getText().equals("") &&
                !mButton5.getText().equals("") && !mButton6.getText().equals("") && !mButton7.getText().equals("") &&
                !mButton8.getText().equals("") && !mButton9.getText().equals("")){
            mTxtViewResult.setText("Result: DRAW");
        }
    }
    public void checkWinnerBtn2() {
        if ((mButton2.getText().equals(mButton3.getText())) && (mButton2.getText().equals(mButton1.getText()))
                || (mButton2.getText().equals(mButton5.getText()) && (mButton2.getText().equals(mButton8.getText())))) {
            if (mPlayerTurn == 1) {
                mTxtViewResult.setText("Result: Player 1 Wins");
                disabledBtnTTT();
            } else
                mTxtViewResult.setText("Result: Player 2 Wins");
            disabledBtnTTT();
        }
        else if(!mButton1.getText().equals("") && !mButton3.getText().equals("") && !mButton4.getText().equals("") &&
                !mButton5.getText().equals("") && !mButton6.getText().equals("") && !mButton7.getText().equals("") &&
                !mButton8.getText().equals("") && !mButton9.getText().equals("")){
            mTxtViewResult.setText("Result: DRAW");
        }
    }
    public void checkWinnerBtn3() {
        if ((mButton3.getText().equals(mButton2.getText())) && (mButton3.getText().equals(mButton1.getText()))
                || (mButton3.getText().equals(mButton6.getText()) && (mButton3.getText().equals(mButton9.getText())))
                || (mButton3.getText().equals(mButton5.getText()) && (mButton3.getText().equals(mButton7.getText())))) {
            if (mPlayerTurn == 1) {
                mTxtViewResult.setText("Result: Player 1 Wins");
                disabledBtnTTT();
            } else
                mTxtViewResult.setText("Result: Player 2 Wins");
            disabledBtnTTT();
        }
        else if(!mButton2.getText().equals("") && !mButton1.getText().equals("") && !mButton4.getText().equals("") &&
                !mButton5.getText().equals("") && !mButton6.getText().equals("") && !mButton7.getText().equals("") &&
                !mButton8.getText().equals("") && !mButton9.getText().equals("")){
            mTxtViewResult.setText("Result: DRAW");
        }
    }
    public void checkWinnerBtn4() {
        if ((mButton4.getText().equals(mButton5.getText())) && (mButton4.getText().equals(mButton6.getText()))
                || (mButton4.getText().equals(mButton1.getText()) && (mButton4.getText().equals(mButton7.getText())))) {
            if (mPlayerTurn == 1) {
                mTxtViewResult.setText("Result: Player 1 Wins");
                disabledBtnTTT();
            } else
                mTxtViewResult.setText("Result: Player 2 Wins");
            disabledBtnTTT();
        }
        else if(!mButton2.getText().equals("") && !mButton3.getText().equals("") && !mButton1.getText().equals("") &&
                !mButton5.getText().equals("") && !mButton6.getText().equals("") && !mButton7.getText().equals("") &&
                !mButton8.getText().equals("") && !mButton9.getText().equals("")){
            mTxtViewResult.setText("Result: DRAW");
        }
    }
    public void checkWinnerBtn5() {
        if ((mButton5.getText().equals(mButton4.getText())) && (mButton5.getText().equals(mButton6.getText()))
                || (mButton5.getText().equals(mButton2.getText())) && (mButton5.getText().equals(mButton8.getText()))
                || (mButton5.getText().equals(mButton1.getText())) && (mButton5.getText().equals(mButton9.getText()))
                || (mButton5.getText().equals(mButton3.getText())) && (mButton5.getText().equals(mButton7.getText()))) {
            if (mPlayerTurn == 1) {
                mTxtViewResult.setText("Result: Player 1 Wins");
                disabledBtnTTT();
            } else
                mTxtViewResult.setText("Result: Player 2 Wins");
            disabledBtnTTT();
        }
        else if(!mButton2.getText().equals("") && !mButton3.getText().equals("") && !mButton4.getText().equals("") &&
                !mButton1.getText().equals("") && !mButton6.getText().equals("") && !mButton7.getText().equals("") &&
                !mButton8.getText().equals("") && !mButton9.getText().equals("")){
            mTxtViewResult.setText("Result: DRAW");
        }
    }
    public void checkWinnerBtn6() {
        if ((mButton6.getText().equals(mButton5.getText())) && (mButton6.getText().equals(mButton4.getText()))
                || (mButton6.getText().equals(mButton3.getText()) && (mButton6.getText().equals(mButton9.getText())))) {
            if (mPlayerTurn == 1) {
                mTxtViewResult.setText("Result: Player 1 Wins");
                disabledBtnTTT();
            } else
                mTxtViewResult.setText("Result: Player 2 Wins");
            disabledBtnTTT();
        }
        else if(!mButton2.getText().equals("") && !mButton3.getText().equals("") && !mButton4.getText().equals("") &&
                !mButton5.getText().equals("") && !mButton1.getText().equals("") && !mButton7.getText().equals("") &&
                !mButton8.getText().equals("") && !mButton9.getText().equals("")){
            mTxtViewResult.setText("Result: DRAW");
        }
    }
    public void checkWinnerBtn7() {
        if ((mButton7.getText().equals(mButton4.getText())) && (mButton7.getText().equals(mButton1.getText()))
                || (mButton7.getText().equals(mButton8.getText()) && (mButton7.getText().equals(mButton9.getText())))
                || (mButton7.getText().equals(mButton5.getText()) && (mButton7.getText().equals(mButton3.getText())))) {
            if (mPlayerTurn == 1) {
                mTxtViewResult.setText("Result: Player 1 Wins");
                disabledBtnTTT();
            } else
                mTxtViewResult.setText("Result: Player 2 Wins");
            disabledBtnTTT();
        }
        else if(!mButton2.getText().equals("") && !mButton3.getText().equals("") && !mButton4.getText().equals("") &&
                !mButton5.getText().equals("") && !mButton6.getText().equals("") && !mButton1.getText().equals("") &&
                !mButton8.getText().equals("") && !mButton9.getText().equals("")){
            mTxtViewResult.setText("Result: DRAW");
        }
    }
    public void checkWinnerBtn8() {
        if ((mButton8.getText().equals(mButton7.getText())) && (mButton8.getText().equals(mButton9.getText()))
                || (mButton8.getText().equals(mButton5.getText()) && (mButton8.getText().equals(mButton2.getText())))) {
            if (mPlayerTurn == 1) {
                mTxtViewResult.setText("Result: Player 1 Wins");
                disabledBtnTTT();
            } else
                mTxtViewResult.setText("Result: Player 2 Wins");
            disabledBtnTTT();
        }
        else if(!mButton2.getText().equals("") && !mButton3.getText().equals("") && !mButton4.getText().equals("") &&
                !mButton5.getText().equals("") && !mButton6.getText().equals("") && !mButton7.getText().equals("") &&
                !mButton1.getText().equals("") && !mButton9.getText().equals("")){
            mTxtViewResult.setText("Result: DRAW");
        }
    }
    public void checkWinnerBtn9() {
        if ((mButton9.getText().equals(mButton8.getText())) && (mButton9.getText().equals(mButton7.getText()))
                || (mButton9.getText().equals(mButton6.getText()) && (mButton9.getText().equals(mButton3.getText())))
                || (mButton9.getText().equals(mButton5.getText()) && (mButton9.getText().equals(mButton1.getText())))) {
            if (mPlayerTurn == 1) {
                mTxtViewResult.setText("Result: Player 1 Wins");
                disabledBtnTTT();
            } else
                mTxtViewResult.setText("Result: Player 2 Wins");
            disabledBtnTTT();
        }
        else if(!mButton2.getText().equals("") && !mButton3.getText().equals("") && !mButton4.getText().equals("") &&
                !mButton5.getText().equals("") && !mButton6.getText().equals("") && !mButton7.getText().equals("") &&
                !mButton8.getText().equals("") && !mButton1.getText().equals("")){
            mTxtViewResult.setText("Result: DRAW");
        }
    }

    public boolean compareSymbol() {
        if (mEditTxtP1.getText().toString().equals(mEditTxtP2.getText().toString()) ||
                mEditTxtP2.getText().toString().equals(mEditTxtP1.getText().toString())){
                return true;
        }
                return false;
    }
    public boolean checkColor(){
        if( (mButtonColorRedP1.getText() == "" && mButtonColorBlueP1.getText() == "" && mButtonColorYellowP1.getText() == "")
                || (mButtonColorYellowP2.getText() == "" && mButtonColorRedP2.getText() == "" && mButtonColorBlueP2.getText() == ""))
        {
            return true;
        }
        return false;
    }
    public boolean checkEmpty(){
        if(mEditTxtP2.getText().toString().equals("") || mEditTxtP1.getText().toString().equals("")){
            return true;}
        return false;
    }
    public void alertDialogSymbol(){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Symbols cant be the same.");
        alertDialog.setTitle("Error");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
    public void alertDialogColor(){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Please select a color.");
        alertDialog.setTitle("Error");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
    public void alertDialogEmpty(){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Please enter symbols.");
        alertDialog.setTitle("Error");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

}

