Header: 
Akhil Sanka, Sanjana Koka, Mikaela Valenciano
05/22/2017
Scavenger Hunt
APCS Final Project, 5th period

Description:

This program lets you create and play scavenger hunts in Homestead through the use of maps with hints.
 To play a race, the user enters the name of the scavenger hunt they would like to play. After entering the scavenger hunt, the user will be shown a hint and an approximate location. In order to proceed, the user must enter the correct code (a number which will be at the location). The scavenger hunt will be completed after the user goes through all the hints and completes them. 
Users are able to create races that can have locations for each hint. After a user finishes a race, a popup window will appear and display the time it took to finish the race.

Instructions:

To make a Scavenger Hunt click the make game button with locations or without. If you are making a Scavenger Hunt without locations enter the name in the first text box and all hints and answers into their respective textboxes, then press the finish making race button to 
make the race. Hints must be strings and answers must be number from -231 to 231. Make sure that each hint has a corresponding answer.  If you are making a Scavenger Hunt with locations, enter the name of the race into the popup window that appears right after clicking the make race with locations button. Then add hints by clicking the spot on the image that contains the location you want the hint to be located at. Next, enter the hints and answers in their respective places in the popup window.

To play a race, click the play race button and enter the name of the race you want to play and press the button that says “Enter this Race”. If a popup window that says “Race Not Found” appears, enter a different race name. When the race starts, see the hint that shows up in the hint text box and the general location of the answer if there are locations in the race. Enter your number guess for the answer in the answer text box and click check 
answer. If the answer is correct a new hint and location will appear.

Features list:

Must-Have Features: 
Map of area where the answers to the hints are located with circles around the area corresponding to each answers
Files where race objects created by users can be stored and retrieved
Local race in CS classroom (default race: Shelby’s Classroom)
Allow users to make their own races
Timer that keeps track of how long each user takes to complete the race.
Want-to-have Features:
Picture hints 
High scores for each race in the database
Allow games to be paused, resumed, and restarted
Allow users to make races on Homestead’s campus or wherever they want using the Google Maps API
Multiple users can play from different computers through networking
Stretch Features:
Make an app that users can use to send answers from a phone.
Real time leaderboard
Allow users to send pictures as an answer and race coordinator can accept or deny the picture
Allow users to send pictures and determine if the picture resembles the correct picture
Produce a highlight reel of the photo submissions and play at the end of the race

Class list:
File I/O: Contains all the code required to read and write files.
GamePanel: JPanel that users use to choose what race they want to play
Hint: Contains the hint question and answer that
Main: Switches between the different JPanels
MakeGamePanel: Makes a game without locations
MapJPanel: Makes a game using locations on the Homestead Map
OptionPanel: Contains JButtons for all the panels on the home screen
PlayGamePanel: Panel where game is played
Race: Contains an ArrayList of hint strings or images and an ArrayList of answers whose indices correspond to their respective hints
TimerPanel: Timer that records the time taken to play a race.
InstructionPanel: JPanel that describes how to play the game with a short tutorial.
 
Responsibility list: 

Sanjana Koka: Was the core code contributor of our team. Developed the initial GUI and program framework, coded all of the working location functionality that is currently part of the final draft of the project. Fixed the bugs and refactored the non-functioning portions of the program to make them functional. The classes I refactored were HintLocation, Map, TabClasses, and User. Worked diligently to ensure that all parts of the project were working correctly and were of good quality. Classes Coded: Main, MakeGamePanel, MapJPanel, OptionPanel, PlayGamePanel, InstructionPanel, Location, Race, Hint, GamePanel.

Akhil Sanka: UML, TimerPanel, File I/O, Race, GamePanel, Hint, Main, OptionPanel, InstructionPanel (only the text field)
classes/functions not seen in project were deleted/changed: tabs made to use maps with race, another map panel specific to playgamepanel to record hints from the race, clicks from mouse on map recorded and saved in array when race created

Mikaela Valenciano: PowerPoint, UML, Hint, Race, TimerPanel
Classes not seen in project were deleted: HintLocation, Map, User



