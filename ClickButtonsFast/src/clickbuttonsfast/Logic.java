/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickbuttonsfast;

import java.util.Random;

/**
 *
 * @author Bruger
 */
public class Logic 
{
    private int[][] grid = new int[4][3];
    
    
    
    public boolean checkForRightButton(int button)
    {
        int rightButton = 0;
        for (int i = 0; i < 3; i++) 
        {
            if(grid[3][i] == 1) 
            {
                rightButton = i;
            }
        }
        
        if (button == rightButton) 
        {
            return true;
        }
        return false;
    }
    
    public void moveRowsDown()
    {
        Random rando = new Random();
        int[][] newGrid = new int[4][3];
        
        for (int i = 1; i < 4; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                newGrid[i][j] = grid[i-1][j]; 
            }
        }
        
        int randomNumber = (rando.nextInt(3));
        newGrid[0][randomNumber] = 1;
        
        grid = newGrid;
    }
    
    public void gameOver()
    {
        
    }
    
    public void fillArray()
    {
        reset();
        Random rando = new Random();
        
        for (int i = 0; i < 4; i++) 
        {
            int randomNumber = (rando.nextInt(3));
            grid[i][randomNumber] = 1;
        }
    }
    
    public int[][] getArray()
    {
        return grid;
    }
    
    public void reset()
    {
        for (int i = 0; i < 4; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                grid[i][j] = 0;
            }
        }
    }
}
