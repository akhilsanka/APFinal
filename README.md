# APFinalHeader: 
Akhil Sanka, Sanjana Koka, Mikaela Valenciano
05/22/2017
Scavenger Hunt
APCS Final Project, 5th period


Description:
This program lets you create and play scavenger hunts in your local area through the use of maps with hints. To play, the user enters a code for the scavenger hunt they would like to be a part of. If none are chosen, a default one located in HHS can be played. After entering the scavenger hunt, the user will be shown a hint and an approximate location. In order to proceed, the user must enter the correct code (which will be at the location). The scavenger hunt will be completed after the user goes through all the hints and completes them. 
To create a scavenger hunt, the user clicks, “Create.” They will then be prompted to choose areas within the map of Homestead and give corresponding hints for each location. The program will shuffle these hints and give them to each user to play. To finish creating it, the user will make a code for the scavenger hunt.


Instructions:
        To play a scavenger hunt, run the program and click “Play”. Enter a code to enter a specific game or enter “0” to play the default one, which will start the timer. The winner will be the person to finish the fastest. After starting, the program will show the first hint and the corresponding location in Homestead for it. To go to the next hint, the user should type the code located at the various places in Homestead. Type the code exactly as seen or the program will not accept it. After going through all the locations, the program will end and give the user their time. 
        To create a scavenger hunt, run the program and click, “Create”. To choose locations of each hint, click on a starting point and drag the mouse. Release after circling the entire area you would like to choose. After doing so, enter the hint for the location and do the same for the answer, which should be a number from -231 to 231. Click finish when you are done. To add another hint, click “Add” and do the same. Otherwise, click finish. After finishing, enter a unique code of only numbers from -231 to 231. Click enter after you finish and you will be taken back to the home page.


Features list:
Split into 3 categories: Must-have, Want-to-have, and Stretch Features
Thoroughly describe 5 of each
Must-Have Features: 
* Map of area where the answers to the hints are located with circles around the area corresponding to each answers
* Database where race objects created by users can be stored and retrieved
* Multiple users can play from different computers through networking
* Local race in CS classroom
* Allow users to make their own races
Want-to-have Features:
* Picture hints 
* Timer that keeps track of how long each user takes to complete the race.
* High scores for each race in the database
* Allow games to be paused, resumed, and restarted
* Allow users to make races on Homestead’s campus or wherever they want using the Google Maps API
Stretch Features:
* Make an app that users can use to send answers from a phone.
* Real time leaderboard
* Allow users to send pictures as an answer and race coordinator can accept or deny the picture
* Allow users to send pictures and determine if the picture resembles the correct picture
* Produce a highlight reel of the photo submissions and play at the end of the race


Class list: Lists the classes within the program and describes what each one represents
User: Receives shuffled arrayList of hints and answers where the indices correspond to each other. Keeps track of the number of hints the user has completed and determines when the user has finished. 
Map: Contains an ArrayList of Locations
Race: Contains an ArrayList of hint strings or images and an ArrayList of answers whose indices correspond to their respective hints. Contains an array of User objects which are currently playing the game.
Location: contains picture of the area where all the answers are located and coordinates for each location. 
Main: includes main method and instantiates classes based on race retrieved from database
Instructions (static page) : JPanel that describes how to play the game with a short tutorial. 
Responsibility list: Lists the group members and describes how each member contributed to the completion of the final program
Akhil: User, Map,
Sanjana: Location, Main
Mikaela: Race, Instructions
