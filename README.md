# Artificial-Life
This project is a class assignment for CSC207 Grinnell
*********************
AUTHOR: Giang Khuat and Kabir Jain
*********************

***********************************
DESCRIPTION
***********************************
We use our artificial life simulation to study the dynamics of cooperation between bacteria of the same species
This project contains the following:
A Population Class that contains the specifics of constructing a population of bacteria of different types, with 
given counts of each subtype. This class also contians the update method, which we use to update (increment energy, check for
cooperation, check for reproduction) each organism in our population.
An Organism superclass that has subclasses Cooperator, Defector, PartialCooperator. These are the different types of bacteria. 

Through this project, we can simulate the environment of these bacteria for a given number of iterations(updates), and then, 
at the end, return the number of each type of organism that is still surviving in the popoulation. This allows us to get an idea
of which types of these organisms are better suited for survival under different conditions. These conditions can be the number of 
updates, or even the specific abilities of each subclass of Organism. 

REFERENCES:
https://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2019S/02/assignments/assignment04.html
Professor Samuel Rebelsky
Classmate Ryuuta Kure
CSC Tutor Timothy


