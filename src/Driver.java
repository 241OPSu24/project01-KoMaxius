import java.util.Scanner;

/**
 * Class: 44-241 Computer Programming II
 * Author: Kobe Hendrix
 * Description: Takes user input for votes for two candidates in three precincts; additionally will recount
 * votes if the user chooses to re-enter the votes values
 * Due: 07/21/2024
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any other student and will not share this code with anyone under 
 * any circumstances.
 */

/**
 * @author komah
 */

public class Driver
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in); // Declares and Instantiates a keyboard input scanner for user input
        int[] precinctVotesSmith = new int[3]; // Array for Smith votes by precinct
        int[] precinctVotesPewterschmidt = new int[3]; // Array for Pewterschmidt votes by precinct
        int totalVotesSmith, totalVotesPewterschmidt; // Holds the candidates' vote totals
        int recountVariable; // Holds the user selection for recounting
        
        // Program Introduction
        System.out.println("Enter your votes for each candidate by precinct");
        
        System.out.println(); // Prints newline
        
        // Retrieves initial precinct voting data
        for (int i = 0; i < 3; i++)
        {
            System.out.println("Precinct " + (i + 1) + " votes:"); // Precinct votes label
            System.out.print("Mr. Smith votes: "); // Asks user for this precinct's votes for Mr. Smith
            precinctVotesSmith[i] = userInput.nextInt(); // Assigns user entered integer to the array index
            System.out.print("Carter Pewterschmidt votes: "); // Asks user for this precinct's votes for Carter Pewterschmidt
            precinctVotesPewterschmidt[i] = userInput.nextInt(); // Assigns user entered integer to the array index
            System.out.println(); // Prints newline
        }
        
        // Calculates vote totals
        totalVotesSmith = findTotalVotes(precinctVotesSmith);
        totalVotesPewterschmidt = findTotalVotes(precinctVotesPewterschmidt);
        
        // Displays Initial Election Results
        System.out.println("The votes for each candidate are:"); // Prints votes total introduction
        System.out.println("Mr. Smith: " + totalVotesSmith); // Prints Mr. Smith's total votes
        System.out.println("Carter Pewterschmidt: " + totalVotesPewterschmidt); // Prints Carter Pewterschmidt's total votes
        System.out.println(); // Prints newline
        displayWinner(totalVotesSmith, totalVotesPewterschmidt); // Displays the winner
        
        System.out.println(); // Prints newline
        
        // Asks if there were vote recounts
        System.out.print("Do you have any recounts? 1 for Yes, 2 for No: ");
        recountVariable = userInput.nextInt(); // Stores user selection for recounting
        
        System.out.println(); // prints newline
        
        // The vote recount program
        while (recountVariable == 1)
        {
            int candidate; // Variable for candidate selection
            int precinct; // Variable for precinct selection
            int votes; // Variable for votes re-entry
            
            // Asks user for which candidate's votes are being recounted
            System.out.println("Select the appropriate candidate number below.");
            System.out.println("1. Mr. Smith");
            System.out.println("2. Carter Pewterschmidt");
            System.out.print("Candidate number: ");
            candidate = userInput.nextInt(); // Stores user input for candidate selection
            
            System.out.println(); // Prints newline
            
            // Asks user for which precinct's votes are being recounted
            System.out.println("Please select a precinct to change");
            System.out.println("1. Precinct 1");
            System.out.println("2. Precinct 2");
            System.out.println("3. Precinct 3");
            System.out.print("Precinct number: ");
            precinct = userInput.nextInt() - 1; // Stores user input for precinct selection
            
            System.out.println(); // Prints newline
            
            // Asks user for the recounted votes
            System.out.print("Please enter the number of votes: ");
            votes = userInput.nextInt(); // Stores user input for votes recount
            
            // Updates votes to the candidates' precinct votes arrays
            if (candidate == 1) // If Mr. Smith was selected
            {
                precinctVotesSmith[precinct] = votes; // Updates Mr. Smiths's votes in the selected precinct
            }
            else if (candidate == 2) // If Carter Pewterschmidt was selected
            {
                precinctVotesPewterschmidt[precinct] = votes; // Updates Carter Pewterschmidt's votes in the selected precinct
            }
            
            System.out.println(); // Prints newline
            
            // Asks if the user has more vote recounts
            System.out.print("Do you have any recounts? 1 for Yes, 2 for No: ");
            recountVariable = userInput.nextInt(); // Stores user selection for recounting
            
            System.out.println(); // Prints newline
            
            // Displays the election results when the user is done with recounts
            if (recountVariable == 2)
            {
                // Calculates vote totals
                totalVotesSmith = findTotalVotes(precinctVotesSmith);
                totalVotesPewterschmidt = findTotalVotes(precinctVotesPewterschmidt);
                
                // Displays Election Results after the recounts
                System.out.println("The votes for each candidate are:"); // Prints votes total introduction
                System.out.println("Mr. Smith: " + totalVotesSmith); // Prints Mr. Smith's total votes
                System.out.println("Carter Pewterschmidt: " + totalVotesPewterschmidt); // Prints Carter Pewterschmidt's total votes
                System.out.println(); // Prints newline
                displayWinner(totalVotesSmith, totalVotesPewterschmidt); // Displays the winner
            }
        }
    }
    
    /**
     * @param votes - an array that stores the values from the precincts vote array entered
     * @return sum - the total of the votes of each precinct
     * Description: Calculates and returns the total votes of a candidate from the three precincts
     */
    public static int findTotalVotes(int[] votes)
        {
            int sum = 0; // variable to hold the total votes
            
            for (int i = 0; i < 3; i++) // iterates through the array
            {
                sum += votes[i]; // adds the votes from each precinct
            }
            return sum; // returns the total votes
        }
    
    /**
     * @param firstCandidate - stores the first candidate's votes (Mr. Smith)
     * @param secondCandidate - stores the second candidate's votes (Carter Pewterschmidt)
     * Description: Displays the election results: who won or if it is a tie
     */
    public static void displayWinner(int firstCandidate, int secondCandidate)
    {        
        if (firstCandidate > secondCandidate) // If Mr. Smith had more votes
        {
            System.out.println("Mr. Smith with " + firstCandidate + " votes is the winner"); // Prints Mr. Smith has won
        }
        else if (firstCandidate < secondCandidate) // If Carter Pewterschmidt had more votes
        {
            System.out.println("Carter Pewterschmidt with " + secondCandidate + " votes is the winner"); // Prints Carter Pewterschmidt has won
        }
        else // If neither had more votes
        {
            System.out.println("It is a tie!"); // Prints that the election has resulted in a tie
        }
    }
}
