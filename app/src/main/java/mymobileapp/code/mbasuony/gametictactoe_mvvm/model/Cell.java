package mymobileapp.code.mbasuony.gametictactoe_mvvm.model;

import mymobileapp.code.mbasuony.gametictactoe_mvvm.utilitys.StringUtility;

//Has a single attribute, a player instance.
public class Cell
{

    public Player player;

    public Cell(Player player)
    {
        this.player=player;
    }


    public boolean isEmpty()
    {
        return player==null|| StringUtility.isNullOrEmpty(player.value);
    }



}
