package Assignment_09_10_06_22;

import java.util.*;

class Player {
    private String name;
    private String choice;
    private int roundsWon;

    Player(String n) {
        name = n;
        roundsWon = 0;
    }

    public String getName() {
        return name;
    }

    public String getChoice() {
        return choice;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void setName(String n) {
        name = n.toLowerCase();
    }

    public void setChoice(String c) {
        choice = c.toLowerCase();
    }

    public void setRoundsWon(int rw) {
        roundsWon = rw;
    }

    public void incrementRoundsWon() {
        roundsWon++;
    }

    public String getUserInput(Scanner in, String msg) {
        System.out.print(msg);
        try {
            if(in.hasNextLine()) choice = in.nextLine();
        } catch(Exception e) {
            System.out.println(e);
        }
        return choice;
    }
}

class RockPaperScissors {

    static Player p1;
    static Player p2;
    static Player[] players = new Player[2];

    static Scanner in;
    static String msg1 = "enter choice: ";

    static int limit = 3;
    static boolean stop = false;

    private static boolean isWin(Player p1, Player p2) {
        if(p1.getChoice().equals("rock")) {
            if(p2.getChoice().equals("scissors")) return true;
            else if(p2.getChoice().equals("paper")) return false;

        } else if(p1.getChoice().equals("paper")) {
            if(p2.getChoice().equals("rock")) return true;
            else if(p2.getChoice().equals("scissors")) return false;

        } else if(p1.getChoice().equals("scissors")) {
            if(p2.getChoice().equals("paper")) return true;
            else if(p2.getChoice().equals("rock")) return false;
        }
        return false;
    }

    private static void run() {
        do {
            for(Player p: players) {
                System.out.print(p.getName() + "'s turn ");
                p.setChoice(p.getUserInput(in, msg1));
            }

            if(p1.getChoice().equals(p2.getChoice())) {
                System.out.println("Tie!");
                continue;
            }

            if(isWin(p1, p2)) {
                System.out.println("\n"+"+++++++++ "+(p1.getName() + " Beats " + p2.getName()).toUpperCase()+" ++++++++");
                p1.incrementRoundsWon();
            } else if(isWin(p2, p1)) {
                System.out.println("\n"+"+++++++++ "+(p2.getName() + " Beats " + p1.getName()).toUpperCase()+" ++++++++");
                p2.incrementRoundsWon();
            }

            System.out.println();

            if(p1.getRoundsWon() == limit) {
                System.out.println("********* "+"Final Result : "+p1.getName() + " wins!"+" *********");
                stop = true;
            } else if(p2.getRoundsWon() == limit){
                System.out.println("********* "+"Final Result : "+p2.getName() + " wins!"+" *********");
                stop = true;
            }
        } while(!stop);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Name : ");
        String player1 = sc.next();
        System.out.print("Enter Second Name : ");
        String player2 = sc.next();
        System.out.println();
        p1 = new Player(player1);
        p2 = new Player(player2);

        players[0] = p1;
        players[1] = p2;

        in = new Scanner(System.in);

        try {
            run();
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            in.close();
        }
    }
}