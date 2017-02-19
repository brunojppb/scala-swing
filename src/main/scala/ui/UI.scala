package ui
import scala.swing._

/**
  * Created by bruno on 19/02/17.
  */
class UI extends MainFrame {

  title = "GUI Program 1"
  contents = new BoxPanel(Orientation.Vertical) {
    contents += new Label("Hey I am a label!")
    contents += Swing.VStrut(10)
    contents += Swing.Glue
    contents += Button("print some!") { println("THanks!") }
    contents += Swing.VStrut(5)
    contents += Button("Close") { sys.exit(0) }
    border = Swing.EmptyBorder(10, 10, 10, 10)
  }

}
