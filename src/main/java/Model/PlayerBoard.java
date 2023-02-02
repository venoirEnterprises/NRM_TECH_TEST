package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerBoard {
    List<Integer> numbersPicked = new ArrayList<>();

    List<Integer> numbersPickedToDisplay = new ArrayList<>();

    private int maxPossibleNumber;
    int amountOfNumbersSelected;
    int displayRowSize = 0;
    int numberOfDisplayRows = 0;
    Integer currentDisplayNumber = 0;

    public PlayerBoard() {
    }


    public PlayerBoard(int maxPossibleNumber, int amountOfNumbersSelected) {

        this.maxPossibleNumber = maxPossibleNumber;
        this.amountOfNumbersSelected = amountOfNumbersSelected > this.maxPossibleNumber ? this.maxPossibleNumber: amountOfNumbersSelected;
        //Dynamically create the number of display rows based on amount they will see
        int[] possibleDisplayRows = {9,8,7,6,5,4,3,2,1};

        for(int possibleDisplayRow: possibleDisplayRows) {
            if(this.amountOfNumbersSelected % possibleDisplayRow==0 && this.displayRowSize ==0 && this.numberOfDisplayRows == 0) {
                this.displayRowSize = possibleDisplayRow;
                this.numberOfDisplayRows = this.amountOfNumbersSelected / possibleDisplayRow;
            }
        }

        List<Integer> possibleNumberChoices = new ArrayList<>();

        for(int i=0;i<this.maxPossibleNumber;i++)
        {
            possibleNumberChoices.add(i);
        }

        for (int i = 0; i < this.amountOfNumbersSelected; i++) {
            addAndRemoveNumberFromRespectiveArrays(possibleNumberChoices, numbersPicked);
        }
    }

    public Integer addAndRemoveNumberFromRespectiveArrays(List<Integer> listToRemoveFrom, List<Integer> listToAddTo) {
        int rnd = new Random().nextInt(listToRemoveFrom.size());
        int numberToAdd = listToRemoveFrom.get(rnd);
        listToAddTo.add(0,numberToAdd);
        listToRemoveFrom.remove(listToRemoveFrom.get(rnd));
        return Integer.valueOf(numberToAdd);
    }

    public List<Integer> getNumbersPicked() {
        return this.numbersPicked;
    }

    public int getMaxPossibleNumber() {
        return this.maxPossibleNumber;
    }

    public int getAmountOfNumbersSelected() {
        return this.amountOfNumbersSelected;
    }

    public int getDisplayRowSize() {
        return this.displayRowSize;
    }

    public int getNumberOfDisplayRows() {
        return this.numberOfDisplayRows;
    }
    public void setNumbersPicked(List<Integer> numbersPicked) {
        this.numbersPicked = numbersPicked;
    }

    public Integer getCurrentDisplayNumber() {
        return this.currentDisplayNumber;
    }

    public void setCurrentDisplayNumber(int currentDisplayNumber) {
        this.currentDisplayNumber = currentDisplayNumber;
    }

    public List<Integer> getNumbersPickedToDisplay() {
        return this.numbersPickedToDisplay;
    }
}