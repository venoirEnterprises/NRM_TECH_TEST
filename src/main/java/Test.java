import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Model.PlayerBoard;
import Service.PlayerBoardMethods;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        Boolean playerUsingBoard = false;
        Boolean activeSession = true;
        Boolean showUpdate = false;
        PlayerBoardMethods playerBoardMethods = new PlayerBoardMethods();
        PlayerBoard playerBoard = new PlayerBoard();

        String inputFromConsole = "";

        while(activeSession) {
//            System.out.println("[You can always restart with command 'restart' or exit with 'exit']");

            if(!playerUsingBoard) {

                System.out.println("\nWelcome! Please pick a board." +
                        "\n[1]: 36 choices from a total of 49 possible" +
                        "\n[2]: 49 choices from a total of 90 possible" +
                        "\n[3]: A coin flip of 1 choice from 2 possible");

                inputFromConsole = waitForInput();

                playerBoard = playerBoardMethods.getPlayerBoardFromChoice(inputFromConsole);
                playerUsingBoard = !playerUsingBoard;
                showUpdate = !showUpdate;
            } else if(showUpdate) {

                TimeUnit.SECONDS.sleep(2);
                System.out.println(playerBoardMethods.getPlayerBoardDisplayString(playerBoard));

                playerBoardMethods.selectNumberToDisplay(playerBoard);
                if(playerBoard.getNumbersPickedToDisplay().size() == playerBoard.getAmountOfNumbersSelected()) {
                    System.out.println(playerBoardMethods.getPlayerBoardDisplayString(playerBoard));
                    playerUsingBoard = !playerUsingBoard; //restart board
                    System.out.println("COMPLETED");
                }
            }
//            inputFromConsole = waitForInput();
//
//            if(inputFromConsole.equals("exit")) {
//                activeSession = false; // exit console
//                playerUsingBoard = false;
//            }
//            else if(inputFromConsole.equals("restart")) {
//                playerUsingBoard = !playerUsingBoard; //restart board
//            }


        }
    }
    private static String waitForInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}