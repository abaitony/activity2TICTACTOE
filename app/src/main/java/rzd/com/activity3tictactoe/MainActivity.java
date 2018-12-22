package rzd.com.activity3tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLLayoutPlayer;
    Button mButton1,
            mButtonColorRedP1, mButtonColorYellowP1, mButtonColorBlueP1,
            mButtonColorRedP2, mButtonColorYellowP2, mButtonColorBlueP2,
            mBtnSettings;
    TextView mTxtViewResult;
    RadioButton mRBtnOp1, mRBtnXp1, mRBtnZp1,
                mRBtnOp2, mRBtnXp2, mRBtnZp2, radioButton;
    RadioGroup mRadioGroupP1, mRadioGroupP2;
    int mIndexClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLLayoutPlayer = findViewById(R.id.LLayoutPlayer);
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


    }

    public void mButton1(View v){
    int selectedID = mRadioGroupP1.getCheckedRadioButtonId();
    radioButton = (RadioButton)findViewById(selectedID);
    String value = radioButton.getText().toString();
    //int result  = Integer.parseInt(value);
    mButton1.setText(value);

    }
    public void mButton2(View v){

    }
    public void mButton3(View v){

    }
    public void mButton4(View v){

    }
    public void mButton5(View v){

    }
    public void mButton6(View v){

    }
    public void mButton7(View v){

    }
    public void mButton8(View v){

    }
    public void mButton9(View v){

    }
    public void mRBtnOP1(View v){
        mRBtnOp2.setEnabled(false);
        mRBtnXp2.setEnabled(true);
        mRBtnZp2.setEnabled(true);
    }
    public void mRBtnXP1(View v){
        mRBtnXp2.setEnabled(false);
        mRBtnOp2.setEnabled(true);
        mRBtnZp2.setEnabled(true);
    }
    public void mRBtnZP1(View v){
        mRBtnZp2.setEnabled(false);
        mRBtnOp2.setEnabled(true);
        mRBtnXp2.setEnabled(true);
    }
    public void mRBtnOP2(View v){
        mRBtnOp1.setEnabled(false);
        mRBtnXp1.setEnabled(true);
        mRBtnZp1.setEnabled(true);
    }

    public void mRBtnXP2(View v){
        mRBtnXp1.setEnabled(false);
        mRBtnOp1.setEnabled(true);
        mRBtnZp1.setEnabled(true);
    }

    public void mRBtnZP2(View v){
        mRBtnZp1.setEnabled(false);
        mRBtnOp1.setEnabled(true);
        mRBtnXp1.setEnabled(true);
    }



    public void mBtnSettings(View v){
        if (mLLayoutPlayer.getVisibility() == View.VISIBLE) {
            mLLayoutPlayer.setVisibility(LinearLayout.GONE);
            mBtnSettings.setText("Show Settings");

        }
        else{
            mLLayoutPlayer.setVisibility(LinearLayout.VISIBLE);
            mBtnSettings.setText("Hide Settings");
        }

    }
    public void setSymbolP1(){
        if(mRBtnOp1.isChecked() == true){
            mRBtnOp2.setEnabled(false);
        }

    }
    public void setSymBolP2(){

    }

}
