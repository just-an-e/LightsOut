package edu.ccm.lightsout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LightsOutGame mGame;
    private GridLayout mLightGrid;
    private int mLightOnColor;
    private int mLightOffColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLightGrid = findViewById((R.id.light_grid));

        mLightOnColor = ContextCompat.getColor(this, R.color.yellow);
        mLightOffColor = ContextCompat.getColor(this, R.color.black);

        mGame = new LightsOutGame();
        startGame();
    }
    private void startGame(){
        mGame.newGame();
        setButtonColors();
    }

    public void onLightButtonClick(View view){
        //find the button's row and col
        int buttonIndex = mLightGrid.indexOfChild(view);
        int row = buttonIndex / LightsOutGame.GRID_SIZE;//int division, throws away the fractional part, doesnt round
        int col = buttonIndex % LightsOutGame.GRID_SIZE;//get the remainder

        mGame.selectLight(row, col);

        setButtonColors();

        if(mGame.isGameOver()){
            Toast.makeText(this, R.string.congrats, Toast.LENGTH_SHORT).show();
        }
    }

    private void setButtonColors(){
        //set all buttons background color
        for(int row = 0; row < LightsOutGame.GRID_SIZE; row++) {
            for (int col = 0; col < LightsOutGame.GRID_SIZE; col++){
                int buttonIndex = row * LightsOutGame.GRID_SIZE + col;

                Button gridButton = (Button) mLightGrid.getChildAt(buttonIndex);

                if(mGame.isLightOn(row, col)){
                    gridButton.setBackgroundColor(mLightOnColor);
                }
                else {
                    gridButton.setBackgroundColor(mLightOnColor);
                }
            }
        }
    }
    public void onNewGameClick(View view){
        startGame();
    }
}