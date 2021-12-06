# SpringMVCFilmCRUD

## Overview
This application is the first we have worked on as a full stack spring boot project. From the spring boot dashboard you will need to launch the project and it is hosted on localhost:8082. Once you have started the project you will be greeted with the Films R Us! logo and then 3 options to do on the site. 

The first option is to search with id, which once the user types in an id of a film, they will be displayed with either the film matching the id they requested, or a screen to notify them that a film with that id does not exist. While viewing the film the user can choose to delete the film or update certain fields of the film. At this point of our learning the delete function will only delete a film if the film in the database does not include any foreign keys. If the film does contain foreign keys in the database the user will be taken to a page informing them that the delete failed and given an option to go back to the home page. If the delete was successful, the user is taken to a page informing them of the deletion. The update function will also take the user to the error page if the user fails to put all the required information into the update film fields.

The second option on the Films R Us! page is to search for a film with a keyword. When the user types in a word of their choice the site will search the database for any films including the users keyword. All films meeting the search criteria will be shown as well as the same update and delete options as described prior. After each film the user may also choose to go back to the home page so that they do not have to scroll to the very bottom of the page to return home.

The third and final option on our site is the ability to add a film to the database. After filling out all the fields listed in the create movie section, the user is taken to a page showing them the film they have created. At this point they are again given the option to update the film they just created, delete the film, or return back to the home page.

## Tech Used
SpringMVC, Eclipse, SQL, mySQL workbench, Java, html

## Lessons Learned
Communication is key to avoid merge conflicts. Muscle memory in the proper processes is important. Getting used to skipping steps (like git pull) can lead to accidental merge conflict mistakes. Get used to doing it the right way every time. Linking controllers, DAO, and jsps was a huge challenge in making the app work. Seeing how the changes you make to one file affects the other files and becoming used to adjusting all related files on the fly to create a desired result was very difficult at first but became more intuitive with repetition. Using the web dev tools and learning to read error messages was paramount in completing this project. Multiple times when things looked like they should be working we traced our errors and fixed issues that we had overlooked.

## Project Owners

Rick Kaucher, CJ Harris