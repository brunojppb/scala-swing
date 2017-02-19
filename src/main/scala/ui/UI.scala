package ui
import scala.swing._

/**
  * Created by bruno on 19/02/17.
  */
class UI extends MainFrame {

  title = "GUI Program 1"

  val label = new Label("My first UI")

  contents = new BoxPanel(Orientation.Vertical) {
    contents += label
    contents += Swing.VStrut(10)
    contents += Swing.Glue
    contents += Button("Press me!") { pressMeAction() }
    contents += Swing.VStrut(5)
    contents += Button("Change Text") { changeTextAction() }
    contents += Swing.VStrut(5)
    contents += Button("Close") { closeMe() }
    border = Swing.EmptyBorder(10, 10, 10, 10)
  }

  def pressMeAction(): Unit = {
    Dialog.showMessage(contents.head, "Thanks!", title = "You pressed me!")
  }

  def changeTextAction(): Unit = {
    val r = Dialog.showInput(contents.head, "Enter New Text:", initial = label.text)
    r match {
      case Some(text) => label.text = text
      case None =>
    }
  }

  def closeMe(): Unit = {
    sys.exit(0)
  }

}
