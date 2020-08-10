package tictactoe;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static int Xcord, Ycord;

    public static void main(String[] args) {
        getInput();
        drawTable(board);
        getCoordinates();
        drawTable(board);
    }

    static void getInput(){ // gets matrix input from user as String
        System.out.println("Enter cells: ");
        String cells = scanner.next();
        fillTable(board, cells);
    }

    static void getCoordinates(){ // gets coordinates and checks whether it satisfies specific conditions
        System.out.println("Enter coordinates: ");
        while(true){

            while(!(scanner.hasNextInt()) ){
                System.out.println("You should enter numbers!");
            }

            Xcord = scanner.nextInt();
            Ycord = scanner.nextInt();

            if(Xcord > 3 || Xcord < 1 || Ycord > 3 || Ycord < 1){
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                ninetyRight(board);
                if(isEmpty(board, Xcord, Ycord)){
                    fillValue(board, 'X', Xcord, Ycord);
                    ninetyLeft(board);
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
                ninetyLeft(board);
            }
        }
    }

    static void drawTable(char[][] arr){    // draws matrix as a table
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static char[][] fillTable(char[][] arr, String input){ // fills the whole matrix by the String put by user
        int counter = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = input.charAt(counter);
                counter++;
            }
        }
        return arr;
    }

    static char[][] fillValue(char[][] arr, char value, int X, int Y){ // fills matrix with a specific value
        arr[X-1][Y-1] = value;
        return arr;
    }

    static char[][] ninetyRight(char[][] arr){ // rotates matrix to 90 degree right
        char[][] carr = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                carr[i][j] = arr[i][j];
            }
        }

        int k = 2;
        for(int i = 0; i < 3; i++){
            arr[0][i] = carr[k][0];
            arr[1][i] = carr[k][1];
            arr[2][i] = carr[k][2];
            k--;
        }
        return arr;
    }

    static char[][] ninetyLeft(char[][] arr){ // rotates matrix to 90 degree left
        for(int i = 0; i < 3; i++){
            ninetyRight(arr);
        }
        return arr;
    }

    static boolean isEmpty(char[][] arr, int X, int Y){  // checks whether the chosen coordinates are empty
        return (arr[X-1][Y-1] == ' ' || arr[X-1][Y-1] == '_');
    }
}