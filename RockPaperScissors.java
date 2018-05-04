/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milagame;

import java.util.Random;

import java.util.Scanner;

public class MilaGame {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       /* This loop  will be asking user to continue,

* until the user enters "n"

*/
       
       
       System.out.println("\n Lets play Rock Paper Scissors game! \n");

while (true) {

//calling the methods

char user = userChoice();

char computer = computerChoice();

determineWinner(user, computer);

char ch = playAgain();



if (ch == 'y' || ch == 'Y')

continue;

else

break;

}

}

//This method will return the game to play again

private static char playAgain() {

// Getting the reply from the user 'Y' or 'y' or 'N' or 'n'

System.out.print("Do you want to Play again (Y/N) ?");

char ch = sc.next(".").charAt(0);

return ch;

}

//This method will determine the winner

private static void determineWinner(char user, char computer) {

String winner = "";



if (user == 'r' && computer == 's') {

winner = "Rock versus Scissors..You win!";

} else if (user == 's' && computer == 'r') {

winner = "Scissors versus Rock..You Lose!";

} else if (user == 'r' && computer == 'p') {

winner = "Rock versus Paper..You Lose!";

} else if (user == 'p' && computer == 'r') {

winner = "Paper versus Rock..You Win!";

} else if (user == 'p' && computer == 's') {

winner = "Paper versus Scissors..You lose!";

} else if (user == 's' && computer == 'p') {

winner = "Scissors versus Paper..You Win!";

} else {

if (user == 'r' && computer == 'r') {

winner = "Rock versus Rock...Tie!";

} else if (user == 'p' && computer == 'p') {

winner = "Paper versus Paper...Tie!";

} else if (user == 's' && computer == 's') {

winner = "Scissors versus Scissors...Tie!";

}

}

System.out.println(winner);

}

//This method will return computers choice

private static char computerChoice() {

char comp = 0;

// Creating a random class object

Random r = new Random();

int num = r.nextInt((3 - 1) + 1) + 1;

if (num == 1)

comp = 'r';

else if (num == 2)

comp = 'p';

else if (num == 3)

comp = 's';

return comp;

}

//This method will return the users choice

private static char userChoice() {

char user;

while (true) {

System.out.print("Enter Choice Rock 'r',Paper 'p', Scissors 's' :");

user = sc.next(".").charAt(0);

if (user != 'r' && user != 'p' && user != 's') {

System.out.println("** Invalid Input **");

continue;

} else

break;

}

return user;

}

} 
        
    /* Thank you! */    
        
        
        

