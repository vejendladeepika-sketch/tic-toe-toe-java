import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };

    static void displayBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | "
                    + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player
                    && board[i][1] == player
                    && board[i][2] == player) {
                return true;
            }

            if (board[0][i] == player
                    && board[1][i] == player
                    && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player
                && board[1][1] == player
                && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player
                && board[1][1] == player
                && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char player = 'X';
        int moves = 0;

        while (moves < 9) {
            displayBoard();
            System.out.print("Player " + player
                    + ", choose a position (1-9): ");

            int position;

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 9.");
                sc.next();
                continue;
            }

            position = sc.nextInt();

            if (position < 1 || position > 9) {
                System.out.println("Invalid position. Try again.");
                continue;
            }

            int row = (position - 1) / 3;
            int col = (position - 1) % 3;

            if (board[row][col] == 'X'
                    || board[row][col] == 'O') {
                System.out.println("That position is occupied. Try again.");
                continue;
            }

            board[row][col] = player;
            moves++;

            if (checkWin(player)) {
                displayBoard();
                System.out.println("Player " + player + " wins!");
                sc.close();
                return;
            }

            player = (player == 'X') ? 'O' : 'X';
        }

        displayBoard();
        System.out.println("It's a draw!");
        sc.close();
    }
}