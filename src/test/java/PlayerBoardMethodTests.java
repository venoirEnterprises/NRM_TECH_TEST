import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Model.PlayerBoard;
import Service.PlayerBoardMethods;

public class PlayerBoardMethodTests {

    PlayerBoardMethods playerNumberMethods;

    @Before
    public void setup() {
        playerNumberMethods = new PlayerBoardMethods();
    }

    @Test
    public void test1Option2From2Numbers() {
        PlayerBoard testPlayerBoard = new PlayerBoard(2, 1);
        assertEquals(testPlayerBoard.getDisplayRowSize(), 1);
        assertEquals(testPlayerBoard.getNumberOfDisplayRows(), 1);
        assertEquals(testPlayerBoard.getNumbersPicked().size(), 1);
        confirmAllValuesAreUnique(testPlayerBoard);
        addValuesToDisplayNumbersAndConfirm(testPlayerBoard);
    }

    @Test
    public void test36OptionsFrom49Numbers() {
        PlayerBoard testPlayerBoard = new PlayerBoard(49,36);
        assertEquals(testPlayerBoard.getDisplayRowSize(),9);
        assertEquals(testPlayerBoard.getNumberOfDisplayRows(), 4);
        assertEquals(testPlayerBoard.getNumbersPicked().size(),36);
        assertEquals(testPlayerBoard.getCurrentDisplayNumber(),new Integer(0));
        confirmAllValuesAreUnique(testPlayerBoard);
        addValuesToDisplayNumbersAndConfirm(testPlayerBoard);
    }

    @Test
    public void test49OptionsFrom90Numbers() {
        PlayerBoard testPlayerBoard = new PlayerBoard(90,49);
        assertEquals(testPlayerBoard.getDisplayRowSize(),7);
        assertEquals(testPlayerBoard.getNumberOfDisplayRows(), 7);
        assertEquals(testPlayerBoard.getNumbersPicked().size(),49);
        confirmAllValuesAreUnique(testPlayerBoard);
        addValuesToDisplayNumbersAndConfirm(testPlayerBoard);
    }

    @Test
    public void testBigPrimeOptionsFromManyNumbers() {
        PlayerBoard testPlayerBoard = new PlayerBoard(2000,397);
        assertEquals(testPlayerBoard.getDisplayRowSize(),1);
        assertEquals(testPlayerBoard.getNumberOfDisplayRows(), 397);
        assertEquals(testPlayerBoard.getNumbersPicked().size(),397);
        confirmAllValuesAreUnique(testPlayerBoard);
        addValuesToDisplayNumbersAndConfirm(testPlayerBoard);
    }

    @Test
    public void test36PreventTooManyPlayerBoards() {
        PlayerBoard testPlayerBoard = new PlayerBoard(36,1000);
        assertEquals(testPlayerBoard.getDisplayRowSize(),9);
        assertEquals(testPlayerBoard.getNumberOfDisplayRows(), 4);
        assertEquals(testPlayerBoard.getNumbersPicked().size(),36);
        confirmAllValuesAreUnique(testPlayerBoard);
        addValuesToDisplayNumbersAndConfirm(testPlayerBoard);
    }

    private void confirmAllValuesAreUnique(PlayerBoard testPlayerBoard) {
        List<Integer> numbersChecked = new ArrayList<>();
        testPlayerBoard.getNumbersPicked().forEach(numberChecked -> {
            assertFalse(numbersChecked.contains(numberChecked));
            numbersChecked.add(numberChecked);
            // no value is repeated
        });
    }

    private void addValuesToDisplayNumbersAndConfirm(PlayerBoard testPlayerBoard) {
        Integer numbersPickedToDisplay = testPlayerBoard.getNumbersPickedToDisplay().size();
        Integer numbersPicked = testPlayerBoard.getNumbersPicked().size();
        while(!numbersPickedToDisplay.equals(testPlayerBoard.getAmountOfNumbersSelected())) {
            numbersPicked -=1;
            numbersPickedToDisplay += 1;
            Integer selectRandomNumber1 = playerNumberMethods.selectNumberToDisplay(testPlayerBoard);
            assertEquals(Integer.valueOf(testPlayerBoard.getNumbersPicked().size()), numbersPicked);
            assertEquals(testPlayerBoard.getCurrentDisplayNumber(), selectRandomNumber1);
            assertEquals(Integer.valueOf(testPlayerBoard.getNumbersPickedToDisplay().size()), numbersPickedToDisplay);
        }
    }

}
