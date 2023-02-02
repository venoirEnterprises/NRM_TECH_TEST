package Interface;

import Model.PlayerBoard;

public class NormalPlayerBoard implements IPlayerBoard {

    private PlayerBoard playerBoard = new PlayerBoard(36, 49);
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
