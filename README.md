# KotlinGUI Application Documentation

## Description
This application allows users to play audio files and display corresponding images using Java Swing.
It provides buttons to select different songs and displays the album covers of each song.

## Source File
The source file is named `songs.kt`.

## How to Use
Run the source file in your selected IDE, then press the buttons for the songs you would like to hear.
Buttons are labeled by the song name, and upon pressing said button, the song will start to play, and the song's
album image will be displayed as well.

## Usage
The application can be run to play audio files and display images. Users can click on buttons representing different
songs to play them and see the corresponding images.

## Main Function
The `main()` function is the entry point of the application. It invokes the `createAndShowGUI()` function to initialize
 and display the GUI.

## createAndShowGUI() Function
This function creates the main frame and panel for the GUI. It initializes buttons for different songs and adds action
listeners to handle button clicks. The `changeImage()` function is called to display the corresponding image when a
button is clicked.

## changeImage() Function
This function changes the displayed image based on the button clicked. It removes the previous image (if any) from the
panel and adds the new image corresponding to the selected song.

## buttonClicked() Function
This function is called when a button representing a song is clicked. It sets the `clicked` variable to the name of
the clicked button.

## Stop Music Button
The "Stop Music" button allows users to stop the playback of the currently playing audio file.

## Notes
- Song and image files are expected to be located in the `src` directory.
- Song and image file urls should not be changed within source file.
