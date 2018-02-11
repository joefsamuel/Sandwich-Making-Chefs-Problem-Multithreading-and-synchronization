------------------------------
	JOE SAMUEL
------------------------------


Files in this project:
src:
Agent.java: Creates the agent that randomly selects two ingredients to put on the table.
Chef.java: Creates the chef that is responsible for adding it's own different ingredient as the third and make a sandwich and eat it.
Kitchen.java: Creates a kitchen that holds the table for the ingredients to be shared on and starts the threads for Chefs and agent.
Documentation:
Readme.txt
UML Class Diagram.png: The UML class diagram for the program.
Agent Collaboration Diagram
Chef Collaboration Diagram
Kitchen Collaboration Diagram
UCM
Javadoc

To run:
To run the program, invoking the main function in Kitchen.java class will run the remainder of the classes in multithreaded fashion.
Using Eclipse, load the project -> Right click on project title -> Select 'Run as' -> Select 'Java Application'.
Output will be shown on the console. 

Editing ingredients:
To edit the ingredients, simply toggle over to the main() function in class Kitchen.java and modify the values for each Thread definition of chef and agent t your choice replacing bread, jam and peanut butter.

Known Issues:
1. Random is not true random but pseudo-random and the switch case + randomizer combination was chosen for easy debugging and readability. 