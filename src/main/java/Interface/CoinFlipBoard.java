package Interface;

import Model.PlayerBoard;

public class CoinFlipBoard implements IPlayerBoard {

    private PlayerBoard playerBoard = new PlayerBoard(2, 1);
    @Override
    public void getDisplayRows() {
        playerBoard.getDisplayRowSize();
    }

    @Override
    public void getNumberOfDisplayRows() {
        playerBoard.getNumberOfDisplayRows();
    }

    @Override
    public PlayerBoard getPlayerBoard() {
        return playerBoard;
    }
}
