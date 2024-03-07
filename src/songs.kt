// Adrian Rincon Jimenez
// KotlinGUI
// Creates a GUI from kotlin and then allows the user to play music and switches
// album covers depending on the song that is being played currently.

import java.awt.Dimension
import java.awt.EventQueue

import java.io.File
import javax.sound.sampled.AudioSystem
import javax.imageio.ImageIO
import javax.swing.*

// starts function
fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}

// this creates the GUI
fun createAndShowGUI() {

    val clip = AudioSystem.getClip()

    var clicked : String = ""

    // this sets the title
    val frame = JFrame("Song Player")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    // adds the JPanel
    val panel = JPanel()
    frame.add(panel)

    // placeholder for image
    var myPicture = ImageIO.read(File("src/playlist.png"))

    // placeholder for JLabel
    var picLabel : JLabel? = null


    fun changeImage(){

        // this checks to see if picLabel is null and if not,
        // then it removes the label
        picLabel?.let {
            panel.remove(it)
            panel.revalidate()
            panel.repaint()
        }

        // when statement that displays image based on the value of 'clicked'
        when (clicked) {
            "king" -> myPicture = ImageIO.read(File("src/king.png"))
            "nuj" -> myPicture = ImageIO.read(File("src/brothel_love.png"))
            "joey" -> myPicture = ImageIO.read(File("src/joey.png"))
            "jin" -> myPicture = ImageIO.read(File("src/jinsang.png"))
        }

        // this adds the specific image to picLabel, then displays it on the panel
        picLabel = JLabel(ImageIcon(myPicture))
        panel.add(picLabel)
        panel.revalidate()
        panel.repaint()
    }

    // function that passes a string as a parameter, and is then used within changeImage()
    // in order to determine which image to output to the GUI
    fun buttonClicked(button : String){
        clicked = button
        print(clicked)
    }

    // King button
    val king = JButton("Ring A Bell")
    // this closes the song that is playing then sets buttonClicked() to the name of the button
    // passes through changeImage, changes the image accordingly, then plays the song Ring A Bell
    king.addActionListener {
        clip.close()
        buttonClicked("king")
        changeImage()
        val audioInputStream = AudioSystem.getAudioInputStream(File("src/Tekken 2 (OST) - Ring A Bell - Thème de King.wav"))
        clip.open(audioInputStream)
        clip.start()
    }



    // Jinsang button
    val jin = JButton("Feelings")
    // this closes the song that is playing then sets buttonClicked() to the name of the button
    // passes through changeImage, changes the image accordingly, then plays the song Feelings
    jin.addActionListener {
        clip.close()
        buttonClicked("jin")
        changeImage()
        val audioInputStream = AudioSystem.getAudioInputStream(File("src/jinsang - feelings..wav"))
        clip.open(audioInputStream)
        clip.start()
    }

    // Love is only a Feeling button
    val joey = JButton("Love Is Only A Feeling")
    // this closes the song that is playing then sets buttonClicked() to the name of the button
    // passes through changeImage, changes the image accordingly, then plays the song Love is only a feeling
    joey.addActionListener {
        clip.close()
        buttonClicked("joey")
        changeImage()
        val audioInputStream = AudioSystem.getAudioInputStream(File("src/Joey Bada\$\$ - “Love Is Only A Feeling“ (Official Audio).wav"))
        clip.open(audioInputStream)
        clip.start()
    }

    // Brothel Love button
    val nuj = JButton("Brothel Love")
    // this closes the song that is playing then sets buttonClicked() to the name of the button
    // passes through changeImage, changes the image accordingly, then plays Brothel Love
    nuj.addActionListener {
        clip.close()
        buttonClicked("nuj")
        changeImage()
        val audioInputStream = AudioSystem.getAudioInputStream(File("src/Nujabes - Brothel Love.wav"))
        clip.open(audioInputStream)
        clip.start()
    }

    // this button stops music at any time
    val stop = JButton("Stop Music")
    stop.addActionListener{
        clip.close()
        clip.stop()
    }

    // this block of code adds all the buttons and sets the frame. It then packs the frame and makes it visible
    panel.add(jin)
    panel.add(king)
    panel.add(joey)
    panel.add(nuj)
    panel.add(stop)
    frame.preferredSize = Dimension(500, 500)
    frame.pack()
    frame.isVisible = true
}
