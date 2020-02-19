package slots;

import java.util.*;

public class Slot_Machine {
	public void slots() {
        boolean run = true;
        int jackpot = 3000;
        int coins = 200;
        int winnings = 0;
        int lastwin = 0;
        int coin_hold = 0;

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int[][] reels = new int[3][3];

        while (run) {
            this.clearScreen();
            //Bet determination for the user pull, if user selected respin this step is skipped
            System.out.println("\t\t\tSLOT MACHINE!\n\t\t\tJackpot: " + jackpot + "\n");
            System.out.println("\t\t\t|-----------|");
            System.out.println("\t\t\t| " + reels[0][0] + " | " + reels[0][1] + " | " + reels[0][2] + " |    o");
            System.out.println("\t\t\t|---|---|---|   /");
            System.out.println("\t\t\t| " + reels[1][0] + " | " + reels[1][1] + " | " + reels[1][2] + " |  /");
            System.out.println("\t\t\t|---|---|---|)/");
            System.out.println("\t\t\t| " + reels[2][0] + " | " + reels[2][1] + " | " + reels[2][2] + " |");
            System.out.println("\t\t\t|-----------|" + "\n");
            System.out.println("Enter your bet (1-3): ");
            int input = scan.nextInt();
            boolean valid = false;

            while (!valid) {
                if (input == 1) {
                    coins = coins - 1;
                    jackpot = jackpot + 1;
                    valid = true;
                } else if (input == 2) {
                    coins = coins - 2;
                    jackpot = jackpot + 2;
                    valid = true;
                } else if (input == 3) {
                    coins = coins - 3;
                    jackpot = jackpot + 3;
                    valid = true;
                } else {
                    System.out.println("Input not valid" + "\n");
                    this.clearScreen();
                    System.out.println("Enter your bet (1-3): ");
                    input = scan.nextInt();
                }
            }


            for (int i = 0; i < 3; i++) {  //spin reels
                for (int j = 0; j < 3; j++) {
                    reels[i][j] = rand.nextInt(7) + 1;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (reels[0][i] == reels[1][i] || reels[0][i] == reels[2][i] || reels[1][i] == reels[2][i]) { //check if values in column are the same
                    boolean same = true;
                    while (same) {   //respin if any values are the same
                        reels[0][i] = rand.nextInt(7) + 1;
                        reels[1][i] = rand.nextInt(7) + 1;
                        reels[2][i] = rand.nextInt(7) + 1;

                        if (reels[0][i] != reels[1][i] && reels[0][i] != reels[2][i] && reels[1][i] != reels[2][i]) {
                            same = false;
                        }
                    }
                }
            }

            coin_hold = coins;
            coins = this.win(reels, coins, jackpot, input);
            lastwin = coins - coin_hold;
            winnings = lastwin + winnings;
            jackpot = this.jackpotcheck(reels, jackpot);
            this.printreels(reels, coins, jackpot, input, lastwin, winnings);
            System.out.println("\n\n\n\t\tWould you like to play again?");
            System.out.println("\t\t1. New Spin" + " | " + "2. Quit");
            int user_continue = scan.nextInt();
            if (user_continue == 2) {
                this.clearScreen();
                scan.close();
                run = false;
                break;
            } else if (user_continue != 1 && user_continue != 2) {
                System.out.println("Invalid Input!");
            }
            

        }
    }


    private int jackpotcheck(int[][] reels, int jackpot) {
        if (reels[1][0] == reels[1][1] && reels[1][0] == reels[1][2] && reels[1][0] == 7) {
            jackpot = 3000; //reset jackpot to 3000 if the jackpot is won
            return jackpot;
        } else {
            return jackpot;
        }
    }

    private int win(int[][] reels, int coins, int jackpot, int input) {
        if (input == 1) {
            if (reels[1][0] == reels[1][1] && reels[1][0] == reels[1][2]) {
                if (reels[1][0] != 7) {
                    int value = reels[1][0];
                    coins = coins + 10 * value;
                    return coins;
                } else {
                    coins = coins + jackpot / 10;
                    return coins;
                }
            } else {
                return coins;
            }
        } else if (input == 2) {

            if (reels[0][0] == reels[0][1] && reels[0][0] == reels[0][2]) {
                if (reels[0][0] != 7) {
                    int value = reels[0][0];
                    coins = coins + 20 * value;
                    return coins;
                } else {
                    coins = coins + jackpot / 4;
                    return coins;
                }
            } else if (reels[1][0] == reels[1][1] && reels[1][0] == reels[1][2]) {
                if (reels[1][0] != 7) {
                    int value = reels[1][0];
                    coins = coins + 20 * value;
                    return coins;
                } else {
                    coins = coins + jackpot / 4;
                    return coins;
                }
            } else {
                return coins;
            }
        } else if (input == 3) {

            if (reels[0][0] == reels[0][1] && reels[0][0] == reels[0][2]) {
                if (reels[0][0] != 7) {
                    int value = reels[0][0];
                    coins = coins + 30 * value;
                    return coins;
                } else {
                    coins = coins + jackpot;
                    return coins;
                }
            } else if (reels[1][0] == reels[1][1] && reels[1][0] == reels[1][2]) {
                if (reels[1][0] != 7) {
                    int value = reels[1][0];
                    coins = coins + 30 * value;
                    return coins;
                } else {
                    coins = coins + jackpot / 4;
                    return coins;
                }
            } else if (reels[2][0] == reels[2][1] && reels[2][0] == reels[2][2]) {
                if (reels[2][0] != 7) {
                    int value = reels[2][0];
                    coins = coins + 30 * value;
                    return coins;
                } else {
                    coins = coins + jackpot / 4;
                    return coins;
                }
            } else {
                return coins;
            }
        } else {
            return coins;
        }
    }

    private void printreels(int[][] reels, int coins, int jackpot, int input, int lastwin, int winnings) {
        this.clearScreen();
        System.out.println("\t\t\tSLOT MACHINE!\n\t\t\tJackpot: " + jackpot + "\n");
        System.out.println("\t\t\t|-----------|");
        System.out.println("\t\t\t| " + reels[0][0] + " | " + reels[0][1] + " | " + reels[0][2] + " |");
        System.out.println("\t\t\t|---|---|---|");
        System.out.println("\t\t\t| " + reels[1][0] + " | " + reels[1][1] + " | " + reels[1][2] + " |");
        System.out.println("\t\t\t|---|---|---|)-------o");
        System.out.println("\t\t\t| " + reels[2][0] + " | " + reels[2][1] + " | " + reels[2][2] + " |");
        System.out.println("\t\t\t|-----------|" + "\n");
        System.out.println("\t\tCredits: " + coins + "\tLast Bet: " + input);
        System.out.println("\t\tLast Win: " + lastwin + "\tTotal Winnings: " + winnings);
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
