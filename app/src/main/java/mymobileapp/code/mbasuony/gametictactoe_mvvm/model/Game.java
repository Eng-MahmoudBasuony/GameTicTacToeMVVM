package mymobileapp.code.mbasuony.gametictactoe_mvvm.model;

import android.arch.lifecycle.MutableLiveData;

import java.util.IllegalFormatCodePointException;

import mymobileapp.code.mbasuony.gametictactoe_mvvm.utilitys.StringUtility;

public class Game
{

    private static final String TAG=Game.class.getName();
    private static final int BOARD_SIZE=3; //for 3*3 Matrix


    public Player player1;
    public Player player2;
    public Player currentPlayer=player1;

    public Cell[][] cell;

    public MutableLiveData<Player> winner = new MutableLiveData<>();

    public Game(String playerOne, String playerTwo)
    {

        cell=new Cell[BOARD_SIZE][BOARD_SIZE];

      player1=new Player(playerOne,"X");
      player2=new Player(playerTwo,"O");

      currentPlayer=player1;

    }

    //The game ended in three cases
       //1-  "3cell identical Horizontal"
       //2-  "3cell identical Vertical"
       //3-  "3cell identical Diagonal"


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
