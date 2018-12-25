package rzd.com.activity3tictactoe;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    LinearLayout mLLayoutPlayer, mLLayout1, mLLayout2, mLLayout3, mLLayout4;
    Button mButton1, mButton2, mButton3, mButton4, mButton5,
            mButton6, mButton7, mButton8, mButton9, mButtonReset,
            mButtonColorRedP1, mButtonColorYellowP1, mButtonColorBlueP1,
            mButtonColorRedP2, mButtonColorYellowP2, mButtonColorBlueP2,
            mBtnSettings;
    TextView mTxtViewResult;
    RadioButton mRBtnOp1, mRBtnXp1, mRBtnZp1,
            mRBtnOp2, mRBtnXp2, mRBtnZp2, radioButton, radioButton1;
    RadioGroup mRadioGroupP1, mRadioGroupP2;
    int mPlayerTurn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLLayoutPlayer = findViewById(R.id.LLayoutPlayer);
        mLLayout1 = findViewById(R.id.LLayoutBP1);
        mLLayout2 = findViewById(R.id.LLayoutRbP1);
        mLLayout3 = findViewById(R.id.LLayoutBP2);
        mLLayout4 = findViewById(R.id.LLayoutRbP2);
        mBtnSettings = findViewById(R.id.btnSettings);
        mRBtnOp1 = findViewById(R.id.rbOplay1);
        mRBtnOp2 = findViewById(R.id.rbOplay2);
        mRBtnXp1 = findViewById(R.id.rbXplay1);
        mRBtnXp2 = findViewById(R.id.rbXplay2);
        mRBtnZp1 = findViewById(R.id.rbZplay1);
        mRBtnZp2 = findViewById(R.id.rbZplay2);
        mRadioGroupP1 = findViewById(R.id.RGroupP1);
        mRadioGroupP2 = findViewById(R.id.RGroupP2);
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
        checkWinner();
    }

    public void mButton2(View v) {
        startBtn2();
        checkWinner();
    }

    public void mButton3(View v) {
        startBtn3();
        checkWinner();
    }

    public void mButton4(View v) {
        startBtn4();
        checkWinner();
    }

    public void mButton5(View v) {
        startBtn5();
        checkWinner();
    }

    public void mButton6(View v) {
        startBtn6();
        checkWinner();
    }

    public void mButton7(View v) {
        startBtn7();
        checkWinner();
    }

    public void mButton8(View v) {
        startBtn8();
        checkWinner();
    }

    public void mButton9(View v) {
        startBtn9();
        checkWinner();
    }


    //    onclick RadioButton
    public void mRBtnOP1(View v) {
        mRBtnOp2.setEnabled(false);
        mRBtnXp2.setEnabled(true);
        mRBtnZp2.setEnabled(true);
    }

    public void mRBtnXP1(View v) {
        mRBtnXp2.setEnabled(false);
        mRBtnOp2.setEnabled(true);
        mRBtnZp2.setEnabled(true);
    }

    public void mRBtnZP1(View v) {
        mRBtnZp2.setEnabled(false);
        mRBtnOp2.setEnabled(true);
        mRBtnXp2.setEnabled(true);
    }

    public void mRBtnOP2(View v) {
        mRBtnOp1.setEnabled(false);
        mRBtnXp1.setEnabled(true);
        mRBtnZp1.setEnabled(true);
    }

    public void mRBtnXP2(View v) {
        mRBtnXp1.setEnabled(false);
        mRBtnOp1.setEnabled(true);
        mRBtnZp1.setEnabled(true);
    }

    public void mRBtnZP2(View v) {
        mRBtnZp1.setEnabled(false);
        mRBtnOp1.setEnabled(true);
        mRBtnXp1.setEnabled(true);
    }


    //    onclick Button
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
        resetenablePSide();
        resetTicTacToeBtn();
        resetTxt();
        mTxtViewResult.setText("Result");
        mPlayerTurn = 0;
    }

    //inputting of symbols and background color
    public void startBtn1() {

        if (mRadioGroupP1.getCheckedRadioButtonId() == -1 || mRadioGroupP2.getCheckedRadioButtonId() == -1
                || (mButtonColorRedP1.getText() == "" && mButtonColorBlueP1.getText() == "" && mButtonColorYellowP1.getText() == "")
                || (mButtonColorYellowP2.getText() == "" && mButtonColorRedP2.getText() == "" && mButtonColorBlueP2.getText() == "")) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please select a color and a symbol first before starting the game.");
            alertDialog.setTitle("Error");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
            mTxtViewResult.setText("Result");
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            int selectedID1 = mRadioGroupP1.getCheckedRadioButtonId();
            int selectedID2 = mRadioGroupP2.getCheckedRadioButtonId();
            radioButton = findViewById(selectedID1);
            radioButton1 = findViewById(selectedID2);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                String value = radioButton.getText().toString();
                mButton1.setText(value);
                mButton1.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.YELLOW);


            } else {
                String value1 = radioButton1.getText().toString();
                mButton1.setText(value1);
                mButton1.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton1.setBackgroundColor(Color.YELLOW);

            }
        }
    }

    public void startBtn2() {
        if (mRadioGroupP1.getCheckedRadioButtonId() == -1 || mRadioGroupP2.getCheckedRadioButtonId() == -1
                || (mButtonColorRedP1.getText() == "" && mButtonColorBlueP1.getText() == "" && mButtonColorYellowP1.getText() == "")
                || (mButtonColorYellowP2.getText() == "" && mButtonColorRedP2.getText() == "" && mButtonColorBlueP2.getText() == "")) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please select a color and a symbol first before starting the game.");
            alertDialog.setTitle("Error");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            int selectedID1 = mRadioGroupP1.getCheckedRadioButtonId();
            int selectedID2 = mRadioGroupP2.getCheckedRadioButtonId();
            radioButton = findViewById(selectedID1);
            radioButton1 = findViewById(selectedID2);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                String value = radioButton.getText().toString();
                mButton2.setText(value);
                mButton2.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.YELLOW);
            } else {
                String value1 = radioButton1.getText().toString();
                mButton2.setText(value1);
                mButton2.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton2.setBackgroundColor(Color.YELLOW);
            }
        }
    }

    public void startBtn3() {
        if (mRadioGroupP1.getCheckedRadioButtonId() == -1 || mRadioGroupP2.getCheckedRadioButtonId() == -1
                || (mButtonColorRedP1.getText() == "" && mButtonColorBlueP1.getText() == "" && mButtonColorYellowP1.getText() == "")
                || (mButtonColorYellowP2.getText() == "" && mButtonColorRedP2.getText() == "" && mButtonColorBlueP2.getText() == "")) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please select a color and a symbol first before starting the game.");
            alertDialog.setTitle("Error");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            int selectedID1 = mRadioGroupP1.getCheckedRadioButtonId();
            int selectedID2 = mRadioGroupP2.getCheckedRadioButtonId();
            radioButton = findViewById(selectedID1);
            radioButton1 = findViewById(selectedID2);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                String value = radioButton.getText().toString();
                mButton3.setText(value);
                mButton3.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.YELLOW);
            } else {
                String value1 = radioButton1.getText().toString();
                mButton3.setText(value1);
                mButton3.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton3.setBackgroundColor(Color.YELLOW);
            }
        }
    }

    public void startBtn4() {
        if (mRadioGroupP1.getCheckedRadioButtonId() == -1 || mRadioGroupP2.getCheckedRadioButtonId() == -1
                || (mButtonColorRedP1.getText() == "" && mButtonColorBlueP1.getText() == "" && mButtonColorYellowP1.getText() == "")
                || (mButtonColorYellowP2.getText() == "" && mButtonColorRedP2.getText() == "" && mButtonColorBlueP2.getText() == "")) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please select a color and a symbol first before starting the game.");
            alertDialog.setTitle("Error");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            int selectedID1 = mRadioGroupP1.getCheckedRadioButtonId();
            int selectedID2 = mRadioGroupP2.getCheckedRadioButtonId();
            radioButton = findViewById(selectedID1);
            radioButton1 = findViewById(selectedID2);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                String value = radioButton.getText().toString();
                mButton4.setText(value);
                mButton4.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.YELLOW);
            } else {
                String value1 = radioButton1.getText().toString();
                mButton4.setText(value1);
                mButton4.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton4.setBackgroundColor(Color.YELLOW);
            }
        }
    }

    public void startBtn5() {
        if (mRadioGroupP1.getCheckedRadioButtonId() == -1 || mRadioGroupP2.getCheckedRadioButtonId() == -1
                || (mButtonColorRedP1.getText() == "" && mButtonColorBlueP1.getText() == "" && mButtonColorYellowP1.getText() == "")
                || (mButtonColorYellowP2.getText() == "" && mButtonColorRedP2.getText() == "" && mButtonColorBlueP2.getText() == "")) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please select a color and a symbol first before starting the game.");
            alertDialog.setTitle("Error");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            int selectedID1 = mRadioGroupP1.getCheckedRadioButtonId();
            int selectedID2 = mRadioGroupP2.getCheckedRadioButtonId();
            radioButton = findViewById(selectedID1);
            radioButton1 = findViewById(selectedID2);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                String value = radioButton.getText().toString();
                mButton5.setText(value);
                mButton5.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.YELLOW);
            } else {
                String value1 = radioButton1.getText().toString();
                mButton5.setText(value1);
                mButton5.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton5.setBackgroundColor(Color.YELLOW);
            }
        }
    }

    public void startBtn6() {
        if (mRadioGroupP1.getCheckedRadioButtonId() == -1 || mRadioGroupP2.getCheckedRadioButtonId() == -1
                || (mButtonColorRedP1.getText() == "" && mButtonColorBlueP1.getText() == "" && mButtonColorYellowP1.getText() == "")
                || (mButtonColorYellowP2.getText() == "" && mButtonColorRedP2.getText() == "" && mButtonColorBlueP2.getText() == "")) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please select a color and a symbol first before starting the game.");
            alertDialog.setTitle("Error");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            int selectedID1 = mRadioGroupP1.getCheckedRadioButtonId();
            int selectedID2 = mRadioGroupP2.getCheckedRadioButtonId();
            radioButton = findViewById(selectedID1);
            radioButton1 = findViewById(selectedID2);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                String value = radioButton.getText().toString();
                mButton6.setText(value);
                mButton6.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.YELLOW);
            } else {
                String value1 = radioButton1.getText().toString();
                mButton6.setText(value1);
                mButton6.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton6.setBackgroundColor(Color.YELLOW);
            }
        }
    }

    public void startBtn7() {
        if (mRadioGroupP1.getCheckedRadioButtonId() == -1 || mRadioGroupP2.getCheckedRadioButtonId() == -1
                || (mButtonColorRedP1.getText() == "" && mButtonColorBlueP1.getText() == "" && mButtonColorYellowP1.getText() == "")
                || (mButtonColorYellowP2.getText() == "" && mButtonColorRedP2.getText() == "" && mButtonColorBlueP2.getText() == "")) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please select a color and a symbol first before starting the game.");
            alertDialog.setTitle("Error");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            int selectedID1 = mRadioGroupP1.getCheckedRadioButtonId();
            int selectedID2 = mRadioGroupP2.getCheckedRadioButtonId();
            radioButton = findViewById(selectedID1);
            radioButton1 = findViewById(selectedID2);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                String value = radioButton.getText().toString();
                mButton7.setText(value);
                mButton7.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.YELLOW);
            } else {
                String value1 = radioButton1.getText().toString();
                mButton7.setText(value1);
                mButton7.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton7.setBackgroundColor(Color.YELLOW);
            }
        }
    }

    public void startBtn8() {
        if (mRadioGroupP1.getCheckedRadioButtonId() == -1 || mRadioGroupP2.getCheckedRadioButtonId() == -1
                || (mButtonColorRedP1.getText() == "" && mButtonColorBlueP1.getText() == "" && mButtonColorYellowP1.getText() == "")
                || (mButtonColorYellowP2.getText() == "" && mButtonColorRedP2.getText() == "" && mButtonColorBlueP2.getText() == "")) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please select a color and a symbol first before starting the game.");
            alertDialog.setTitle("Error");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            int selectedID1 = mRadioGroupP1.getCheckedRadioButtonId();
            int selectedID2 = mRadioGroupP2.getCheckedRadioButtonId();
            radioButton = findViewById(selectedID1);
            radioButton1 = findViewById(selectedID2);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                String value = radioButton.getText().toString();
                mButton8.setText(value);
                mButton8.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.YELLOW);
            } else {
                String value1 = radioButton1.getText().toString();
                mButton8.setText(value1);
                mButton8.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton8.setBackgroundColor(Color.YELLOW);
            }
        }
    }

    public void startBtn9() {
        if (mRadioGroupP1.getCheckedRadioButtonId() == -1 || mRadioGroupP2.getCheckedRadioButtonId() == -1
                || (mButtonColorRedP1.getText() == "" && mButtonColorBlueP1.getText() == "" && mButtonColorYellowP1.getText() == "")
                || (mButtonColorYellowP2.getText() == "" && mButtonColorRedP2.getText() == "" && mButtonColorBlueP2.getText() == "")) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please select a color and a symbol first before starting the game.");
            alertDialog.setTitle("Error");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        } else {
            setViewAndChildrenEnabled(mLLayoutPlayer, false);
            int selectedID1 = mRadioGroupP1.getCheckedRadioButtonId();
            int selectedID2 = mRadioGroupP2.getCheckedRadioButtonId();
            radioButton = findViewById(selectedID1);
            radioButton1 = findViewById(selectedID2);
            mPlayerTurn = (mPlayerTurn + 1) % 2;
            if (mPlayerTurn == 1) {
                String value = radioButton.getText().toString();
                mButton9.setText(value);
                mButton9.setEnabled(false);
                if (mButtonColorRedP1.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP1.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP1.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.YELLOW);
            } else {
                String value1 = radioButton1.getText().toString();
                mButton9.setText(value1);
                mButton9.setEnabled(false);
                if (mButtonColorRedP2.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.RED);
                else if (mButtonColorBlueP2.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.BLUE);
                else if (mButtonColorYellowP2.getText().equals("SELECTED"))
                    mButton9.setBackgroundColor(Color.YELLOW);
            }
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


    }

    public void resetenablePSide() {
        mRadioGroupP1.clearCheck();
        mRadioGroupP2.clearCheck();
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

    public void resetTxt() {
        mButtonColorRedP1.setText("");
        mButtonColorRedP2.setText("");
        mButtonColorYellowP1.setText("");
        mButtonColorYellowP2.setText("");
        mButtonColorBlueP1.setText("");
        mButtonColorBlueP2.setText("");
    }

    public void checkWinner() {
        if((mButton3.getText().equals("") && mButton2.getText().equals("") && mButton1.getText().equals(""))
            || (mButton3.getText().equals("") && mButton6.getText().equals("") && mButton9.getText().equals(""))
            || (mButton7.getText().equals("") && mButton8.getText().equals("") && mButton9.getText().equals(""))
            || (mButton1.getText().equals("") && mButton4.getText().equals("") && mButton7.getText().equals(""))
            || (mButton4.getText().equals("") && mButton5.getText().equals("") && mButton6.getText().equals(""))
            || (mButton2.getText().equals("") && mButton5.getText().equals("") && mButton8.getText().equals(""))
            || (mButton1.getText().equals("") && mButton5.getText().equals("") && mButton9.getText().equals(""))
            || (mButton3.getText().equals("") && mButton5.getText().equals("") && mButton7.getText().equals("")))
                {
                    mTxtViewResult.setText("Result");
                }
        else if((mButton1.getText().toString().equals(mButton2.getText().toString()) &&
                 mButton1.getText().toString().equals(mButton3.getText().toString()) &&
                 mButton2.getText().toString().equals(mButton3.getText().toString()))
                     ||
                 (mButton1.getText().toString().equals(mButton4.getText().toString()) &&
                 mButton1.getText().toString().equals(mButton7.getText().toString()) &&
                 mButton4.getText().toString().equals(mButton7.getText().toString()))
                     ||
                 (mButton1.getText().toString().equals(mButton5.getText().toString()) &&
                 mButton1.getText().toString().equals(mButton9.getText().toString()) &&
                 mButton5.getText().toString().equals(mButton9.getText().toString()))
                     ||
                 (mButton3.getText().toString().equals(mButton6.getText().toString()) &&
                 mButton3.getText().toString().equals(mButton9.getText().toString()) &&
                 mButton6.getText().toString().equals(mButton9.getText().toString()))
                     ||
                 (mButton7.getText().toString().equals(mButton8.getText().toString()) &&
                 mButton7.getText().toString().equals(mButton9.getText().toString()) &&
                 mButton8.getText().toString().equals(mButton9.getText().toString()))
                     ||
                 (mButton3.getText().toString().equals(mButton5.getText().toString()) &&
                 mButton3.getText().toString().equals(mButton7.getText().toString()) &&
                 mButton5.getText().toString().equals(mButton7.getText().toString()))
                     ||
                 (mButton4.getText().toString().equals(mButton5.getText().toString()) &&
                 mButton4.getText().toString().equals(mButton6.getText().toString()) &&
                 mButton5.getText().toString().equals(mButton6.getText().toString()))
                     ||
                 (mButton2.getText().toString().equals(mButton5.getText().toString()) &&
                 mButton2.getText().toString().equals(mButton8.getText().toString()) &&
                 mButton5.getText().toString().equals(mButton8.getText().toString()))
                )
                    {
                        if (mPlayerTurn == 1) {
                            mTxtViewResult.setText("Result: Player 1 Wins");
                            //disabledBtnTTT();
                        }
                        else
                            mTxtViewResult.setText("Result: Player 2 Wins");
                            //disabledBtnTTT();
                    }
        }
        public void disabledBtnTTT(){
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

}

