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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


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

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        mButtonColorYellowP1.setOnClickListener(this);
        mButtonColorYellowP2.setOnClickListener(this);
        mButtonColorRedP1.setOnClickListener(this);
        mButtonColorRedP2.setOnClickListener(this);
        mButtonColorBlueP1.setOnClickListener(this);
        mButtonColorBlueP2.setOnClickListener(this);
        mButtonReset.setOnClickListener(this);
        mBtnSettings.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn1: startBtn(mButton1); break;
            case R.id.btn2: startBtn(mButton2); break;
            case R.id.btn3: startBtn(mButton3); break;
            case R.id.btn4: startBtn(mButton4); break;
            case R.id.btn5: startBtn(mButton5); break;
            case R.id.btn6: startBtn(mButton6); break;
            case R.id.btn7: startBtn(mButton7); break;
            case R.id.btn8: startBtn(mButton8); break;
            case R.id.btn9: startBtn(mButton9); break;
            case R.id.btnColor1P1: mBtnColor(mButtonColorRedP1,mButtonColorRedP2,mButtonColorBlueP1,mButtonColorYellowP1,mButtonColorBlueP2,mButtonColorYellowP2); break;
            case R.id.btnColor1P2: mBtnColor(mButtonColorRedP2,mButtonColorRedP1,mButtonColorBlueP2,mButtonColorYellowP2,mButtonColorBlueP1,mButtonColorYellowP1); break;
            case R.id.btnColor2P1: mBtnColor(mButtonColorYellowP1,mButtonColorYellowP2,mButtonColorRedP1,mButtonColorBlueP1,mButtonColorBlueP2,mButtonColorRedP2); break;
            case R.id.btnColor2P2: mBtnColor(mButtonColorYellowP2,mButtonColorYellowP1,mButtonColorBlueP2,mButtonColorRedP2,mButtonColorBlueP1,mButtonColorRedP1); break;
            case R.id.btnColor3P1: mBtnColor(mButtonColorBlueP1,mButtonColorBlueP2,mButtonColorRedP1,mButtonColorYellowP1,mButtonColorRedP2,mButtonColorYellowP2); break;
            case R.id.btnColor3P2: mBtnColor(mButtonColorBlueP2,mButtonColorBlueP1,mButtonColorRedP2,mButtonColorYellowP2,mButtonColorRedP1,mButtonColorYellowP1); break;
            case R.id.btnSettings: mBtnSettings(); break;
            case R.id.btnReset: btnReset(); break;


        }
        }

        //start game
    public void startBtn(Button mbtn) {

        if (checkEmpty() == true) {
            alertDialogEmpty();
        } else if (compareSymbol() == true) {
            alertDialogSymbol();
        } else if (checkColor() == true) {
            alertDialogColor();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            checkPlayerTurn();

            if (mPlayerTurn == 1) {
                mbtn.setText(mEditTxtP1.getText());
                mbtn.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mbtn.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mbtn.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mbtn.setBackgroundColor(Color.YELLOW);


            } else {
                mbtn.setText(mEditTxtP2.getText());
                mbtn.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mbtn.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mbtn.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mbtn.setBackgroundColor(Color.YELLOW);

            }
            if(mbtn == mButton1)
                checkWinnerBtn1379(mButton1,mButton2,mButton3,mButton5,mButton9,mButton4,mButton7);
            else if(mbtn == mButton3)
                checkWinnerBtn1379(mButton3,mButton2,mButton1,mButton5,mButton7,mButton6,mButton9);
            else if(mbtn == mButton7)
                checkWinnerBtn1379(mButton7,mButton4,mButton1,mButton8,mButton9,mButton5,mButton3);
            else if(mbtn == mButton9)
                checkWinnerBtn1379(mButton9,mButton8,mButton7,mButton6,mButton3,mButton5,mButton1);
            else if(mbtn == mButton2)
                checkWinnerBtn2468(mButton2,mButton1,mButton3,mButton5,mButton8);
            else if(mbtn == mButton4)
                checkWinnerBtn2468(mButton4,mButton1,mButton7,mButton5,mButton6);
            else if(mbtn == mButton6)
                checkWinnerBtn2468(mButton6,mButton4,mButton5,mButton3,mButton9);
            else if(mbtn == mButton8)
                checkWinnerBtn2468(mButton8,mButton7,mButton9,mButton5,mButton2);
            else if(mbtn == mButton5)
                checkWinnerBtn5();

        }
    }

    //check winner
    public void checkWinnerBtn2468(Button mbtn1, Button mbtn2, Button mbtn3, Button mbtn4, Button mbtn5) {
        if ((mbtn1.getText().equals(mbtn2.getText())) && (mbtn1.getText().equals(mbtn3.getText()))
                || (mbtn1.getText().equals(mbtn4.getText()) && (mbtn1.getText().equals(mbtn5.getText())))) {
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
    public void checkWinnerBtn1379(Button mbtn1, Button mbtn2, Button mbtn3, Button mbtn4, Button mbtn5, Button mbtn6, Button mbtn7) {
        if ((mbtn1.getText().equals(mbtn2.getText())) && (mbtn1.getText().equals(mbtn3.getText()))
                || (mbtn1.getText().equals(mbtn4.getText()) && (mbtn1.getText().equals(mbtn5.getText())))
                || (mbtn1.getText().equals(mbtn6.getText()) && (mbtn1.getText().equals(mbtn7.getText())))) {
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
       //set color
    public void mBtnColor(Button mBtn1, Button mBtn2, Button mBtn3, Button mBtn4, Button mBtn5, Button mBtn6) {
           mBtn1.setText("SELECTED");
           mBtn2.setText("");
           mBtn3.setText("");
           mBtn4.setText("");
           mBtn2.setClickable(false);
           mBtn5.setClickable(true);
           mBtn6.setClickable(true);
       }
    //show // hide settings
    public void mBtnSettings() {
        if (mLLayoutPlayer.getVisibility() == View.VISIBLE) {
            mLLayoutPlayer.setVisibility(LinearLayout.GONE);
            mBtnSettings.setText("Show Settings");

        } else {
            mLLayoutPlayer.setVisibility(LinearLayout.VISIBLE);
            mBtnSettings.setText("Hide Settings");
        }

    }
    //reset game
    public void btnReset() {
        setViewAndChildrenEnabled(mLLayoutPlayer, true);
        resetTicTacToeBtn();
        mTxtViewResult.setText("Result");
        mPlayerTurn = 0;
    }

    //check player turn
    public void checkPlayerTurn(){
        mPlayerTurn = (mPlayerTurn + 1) % 2;
    }

    //enabled disabled layout view for edittext and color
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

