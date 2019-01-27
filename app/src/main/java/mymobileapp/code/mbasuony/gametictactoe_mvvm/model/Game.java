package mymobileapp.code.mbasuony.gametictactoe_mvvm.model;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import mymobileapp.code.mbasuony.gametictactoe_mvvm.utilitys.StringUtility;

public class Game
{

    private static final String TAG=Game.class.getName();
    private static final int BOARD_SIZE=3; //for 3*3 Matrix


    public Player player1;
    public Player player2;
    public Player currentPlayer=player1;

    public Cell[][] cells;

    public MutableLiveData<Player> winner = new MutableLiveData<>();

    public Game(String playerOne, String playerTwo)
    {

        cells =new Cell[BOARD_SIZE][BOARD_SIZE];

      player1=new Player(playerOne,"X");
      player2=new Player(playerTwo,"O");

      currentPlayer=player1;

    }

    //The game ended in 4 cases
       //1-  "3cell identical Horizontal"
       //2-  "3cell identical Vertical"
       //3-  "3cell identical Diagonal"
       //4-   "is Board Full"

    public boolean threeSameHorizontalCells()
    {
        try
        {
            for (int i=0;i<BOARD_SIZE;i++)
            {
                if (areEquele(cells[i][0], cells[i][1], cells[i][2]))
                    return true;

            }

         return false;

        }catch (NullPointerException e)
        {
            Log.e(TAG, "threeSameHorizontalCells: "+e.getMessage() );
            return false;
        }


    }

    public boolean threeSameVerticalCells()
    {
        try
        {
            for (int i=0;i<BOARD_SIZE;i++)
            {

                if (areEquele(cells[0][i], cells[1][i], cells[2][i]))
                     return true;

            }

            return false;

        }catch (NullPointerException e)
        {
            Log.e(TAG, "threeSameVerticalCells: "+e.getMessage() );
            return false;
        }

    }

    public  boolean threeSameDiagonalCells()
    {
        try
        {
            for (int i=0;i<BOARD_SIZE;i++)
            {
                if ( areEquele(cells[0][0], cells[1][1], cells[2][2]) ||
                     areEquele(cells[0][2], cells[1][1], cells[2][0]))
                    return true;
            }

            return false;
        }
        catch (NullPointerException e)
        {
            Log.e(TAG, "threeSameDiagonalCells: "+e.getMessage() );
            return false;
        }

    }

   public  boolean isBoardFull()
   {
       for (Cell[]row: cells)
       {
             for (Cell cell: row)
             {
                 if (cell==null||cell.isEmpty())
                     return false;
             }
       }

       return  true;
   }







    private boolean areEquele(Cell... cells)
    {
        //check for 3 cases
           //case 1- "object cells is empty
           //case 2- "Check in value for  all cells "
           //case 3- "check do "value" for First cells object == "value" for 2 cells Object"

          //case 1
        if (cells==null||cells.length==0)
               return false;

        //case 2
        for (Cell cell:cells)
        {
            if (cell==null|| StringUtility.isNullOrEmpty(cell.player.value))
                return false;
        }


        //case 3
        Cell comparisonBase = cells[0];

        for (int i=1;i<cells.length;i++)
        {
            if (comparisonBase.player.value.equals(cells[i].player.value));

        }






        return true;
    }



}
