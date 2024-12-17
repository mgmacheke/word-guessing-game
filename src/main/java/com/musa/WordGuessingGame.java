package com.musa;

import java.util.HashSet;
import java.util.Scanner;

public class WordGuessingGame {
    public static void main(String[] args) {
        String secretWord = "JAVA";
        HashSet<Character> guessedLetters = new HashSet<>();
        int maxAttempts = 8;
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to the Word Guessing Game");
        while (attempts < maxAttempts) {
            System.out.println("Please enter a letter that you wish to guess: ");
            char guess = scanner.next().toUpperCase().charAt(0);

            if (!guessedLetters.add(guess)) {
                System.out.println("You already guessed the letter " + guess);
                continue;
            }

            if (guessedLetters.contains(Character.toString(guess))) {
                System.out.println("Your guess are correct");
            }else {
                System.out.println("Your guess is not correct");
                attempts++;
            }

            for(char letter : secretWord.toCharArray()) {
                if (guessedLetters.contains(letter)) {
                    System.out.print( letter + " ");
                }else {
                    System.out.print("_ ");
                }
            }
            System.out.println();

            boolean allGuessed = true;
            for (char letter : secretWord.toCharArray()) {
                if (!guessedLetters.contains(letter)) {
                    allGuessed = false;
                    break;
                }
            }

            if (allGuessed) {
                System.out.println("Congratulations! You guessed the letter " + guess);
                break;
            }
        }
        if (attempts == maxAttempts) {
            System.out.println("Game Over");
        }
        scanner.close();
    }
}
