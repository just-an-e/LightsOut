package edu.ccm.lightsout;

import java.util.Random;

public class LightsOutGame {
    public static final int GRID_SIZE = 3;

    private final boolean [][] mLightsGrid;

    public LightsOutGame(){
        mLightsGrid = new boolean[GRID_SIZE][GRID_SIZE];
    }

    public void newGame(){
        Random RandomNumGenerator = new Random();
        for(int row = 0; row < GRID_SIZE; row++){
            for (int col = 0; col < GRID_SIZE; col++){
                mLightsGrid[row][col] = RandomNumGenerator.nextBoolean();
            }
        }
    }

    public boolean isLightOn(int row, int col){
        return mLightsGrid[row][col];
    }

    public void selectLight(int row, int col){
        mLightsGrid[row][col] = !mLightsGrid[row][col];

        if(row > 0){//if not the first row
            mLightsGrid[row-1][col] = !mLightsGrid[row-1][col]; //flip cell above
        }
        if(row < GRID_SIZE - 1){ // if not the last row
            mLightsGrid[row+1][col] = !mLightsGrid[row+1][col]; //flip cell below
        }
        if(col > 0){//not the first column
            mLightsGrid[row][col-1] = !mLightsGrid[row][col-1];//flip cell to the left
        }
        if(col < GRID_SIZE - 1){//not the last column
            mLightsGrid[row][col+1] = !mLightsGrid[row][col+1];//clip cell to the right
        }
    }
    public boolean isGameOver(){
        for (int row = 0; row < GRID_SIZE; row++)
            for(int  col =0; col < GRID_SIZE; col++)
                if(mLightsGrid[row][col]){
                    return false;
                }
        return true;
    }
}
