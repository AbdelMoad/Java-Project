package com.isep.utils;
import java.util.Scanner;
public class ConsoleParser extends InputParser{
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            // split input into an array of "tokens" separated by space character
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "rpj":
                    // handle the "rpj" command
                    break;
                default:
                    // handle invalid or unknown command
                    break;
            }
        }


}
