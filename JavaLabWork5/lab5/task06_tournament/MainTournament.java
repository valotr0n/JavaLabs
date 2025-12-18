package lab5.task06_tournament;

import java.util.Scanner;

public class MainTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tournament tournament = new Tournament(6); 
        String winner = tournament.run(scanner);
        System.out.println("Победитель: " + winner);
    }
}