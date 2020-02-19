# Slot Machine Program

Author: Cody West
Last Updated: 12/10/2019

# Description:

Functional Slot Machine Program utilizing multiple methods, classes, and packages. 
Uses the scanner package to scan input from the terminal, and random package to generate random numbers.
The Slot Machine functions as a 2-Demensional Array setup as Reels[3][3], and can hold any value from 1-7.
A jackpot is defined as Sevens across the row.
Jackpot is increased by the number of credits spent each pull.
The goal is to get 3 of the same numbers in a row.

1 Credit:
	
	  | X | X | X |
	->|---|---|---|
	  | X | X | X |

	(Single Payline)

2 Credits:
	
	->|---|---|---|
	->|---|---|---|
	  | X | X | X |
	
	(Two Paylines)

3 Credits:
	
	->|---|---|---|
	->|---|---|---|
	->|---|---|---|
	
	(Three Paylines)

Payouts are calculated using the following formulas:
	
1 Credit:
	Non-jackpot:
		Winnings = 10*X (Where X is the number in the payline)
	Jackpot:
		Winnings = jackpot/10

2 Credit:
	Non-jackpot:
		Winnings = 20*X (Where X is the number in the payline)
	Jackpot:
		Winnings = jackpot/4

3 Credit:
	Non-jackpot:
		Winnings = 30*X (Where X is the number in the payline)
	Jackpot:
		Winnings = jackpot
		Jackpot value resets to 3000

# Compilation Instructions:

	To compile from source files:   Export the Slots package as an executable JAR.
					Main method is located in the main class.

	Executable Jar can be run directly using:
		java -jar finalproject.jar


