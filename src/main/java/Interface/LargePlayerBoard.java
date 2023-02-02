package Interface;

import Model.PlayerBoard;

public class LargePlayerBoard implements IPlayerBoard {

    private PlayerBoard playerBoard = new PlayerBoard(49, 90);
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
