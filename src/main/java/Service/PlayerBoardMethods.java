package Service;

import java.util.List;

import Interface.CoinFlipBoard;
import Interface.LargePlayerBoard;
import Interface.NormalPlayerBoard;
import Model.PlayerBoard;

public class PlayerBoardMethods {

    PlayerBoard playerBoard;

    public PlayerBoard getPlayerBoard() {
        return playerBoard;
    }

    public PlayerBoard getPlayerBoardFromChoice(String choice) {
        Integer chosenBoard = 0;
        try {
            chosenBoard = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            chosenBoard = 0;
        }
        switch(chosenBoard) {
            case 3:
                playerBoard = new CoinFlipBoard().getPlayerBoard();
                break;
            case 2:
                playerBoard = new LargePlayerBoard().getPlayerBoard();
                break;
            case 1:
            default:
                playerBoard = new NormalPlayerBoard().getPlayerBoard();
                break;
        }

        return this.getPlayerBoard();
    }

    public String getPlayerBoardDisplayString(PlayerBoard playerBoard) {
        String playerBoardDisplayString =
        "\nCall "+playerBoard.getNumbersPickedToDisplay().size() + " out of "+ playerBoard.getAmountOfNumbersSelected() +
        "\nCurrent Number:"+playerBoard.getCurrentDisplayNumber().toString()+
        "\nHistoric Numbers: \n";
//        +playerBoard.getNumbersPickedToDisplay().toString();
        List<Integer> numbersToDisplay = playerBoard.getNumbersPickedToDisplay();
        int entryInNumbersToDisplay = 0;
        for (Integer numberPickedToDisplay : numbersToDisplay) {
            entryInNumbersToDisplay++;
            if(entryInNumbersToDisplay%playerBoard.getDisplayRowSize()==1 && entryInNumbersToDisplay > playerBoard.getDisplayRowSize()) {
                playerBoardDisplayString += "\n";
            }
            else if(numberPickedToDisplay != numbersToDisplay.get(0)) {
                playerBoardDisplayString += ", ";
            }
            playerBoardDisplayString += numberPickedToDisplay.toString();
        }
        return playerBoardDisplayString;

    }

    public Integer selectNumberToDisplay(PlayerBoard playerBoard) {
        Integer displayNumber = playerBoard.addAndRemoveNumberFromRespectiveArrays(playerBoard.getNumbersPicked(), playerBoard.getNumbersPickedToDisplay());
        playerBoard.setCurrentDisplayNumber(displayNumber);
        return displayNumber;
    }
}
