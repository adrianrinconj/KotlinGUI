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
            "sch" -> myPicture = ImageIO.read(File("src/sch_img.png"))
            "dfl" -> myPicture = ImageIO.read(File("src/dfl_img.png"))
            "ili" -> myPicture = ImageIO.read(File("src/ili_img.png"))
            "guts" -> myPicture = ImageIO.read(File("src/guts_img.png"))
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

    // Short Change Hero button
    val sch = JButton("Short Change Hero")
    // this closes the song that is playing then sets buttonClicked() to the name of the button
    // passes through changeImage, changes the image accordingly, then plays the song Short Change Hero
    sch.addActionListener {
        clip.close()
        buttonClicked("sch")
        changeImage()
        val audioInputStream = AudioSystem.getAudioInputStream(File("src/Short Change Hero.wav"))
        clip.open(audioInputStream)
        clip.start()
    }



    // What You Won't Do For Love button
    val dfl = JButton("What You Won't Do For Love")
    // this closes the song that is playing then sets buttonClicked() to the name of the button
    // passes through changeImage, changes the image accordingly, then plays the song What You Won't Do For Love
    dfl.addActionListener {
        clip.close()
        buttonClicked("dfl")
        changeImage()
        val audioInputStream = AudioSystem.getAudioInputStream(File("src/What You Won't Do for Love.wav"))
        clip.open(audioInputStream)
        clip.start()
    }

    // I Like It button
    val ili = JButton("I Like It")
    // this closes the song that is playing then sets buttonClicked() to the name of the button
    // passes through changeImage, changes the image accordingly, then plays the song I like It
    ili.addActionListener {
        clip.close()
        buttonClicked("ili")
        changeImage()
        val audioInputStream = AudioSystem.getAudioInputStream(File("src/I Like It.wav"))
        clip.open(audioInputStream)
        clip.start()
    }

    // Guts' Theme Song button
    val guts = JButton("Guts' Theme")
    // this closes the song that is playing then sets buttonClicked() to the name of the button
    // passes through changeImage, changes the image accordingly, then plays Guts' Theme Song
    guts.addActionListener {
        clip.close()
        buttonClicked("guts")
        changeImage()
        val audioInputStream = AudioSystem.getAudioInputStream(File("src/guts.wav"))
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
    panel.add(dfl)
    panel.add(sch)
    panel.add(ili)
    panel.add(guts)
    panel.add(stop)
    frame.preferredSize = Dimension(500, 500)
    frame.pack()
    frame.isVisible = true
}
