package ui
import scala.swing._

/**
  * Created by bruno on 19/02/17.
  */
class UI extends MainFrame {

  title = "GUI Program"

  def restrictHeight(s: Component): Unit = {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }

  val nameField = new TextField(columns = 32)
  val likeScala = new CheckBox("I like Scala")
  likeScala.selected = true
  val status1 = new RadioButton("Radio 1")
  val status2 = new RadioButton("Radio 2")
  val status3 = new RadioButton("Radio 3")
  status3.selected = true
  val statusGroup = new ButtonGroup(status1, status2, status3)
  val gender = new ComboBox(List("Other", "Male", "Female"))
  val commentField = new TextArea {
    rows = 8
    lineWrap = true
    wordWrap = true
  }
  val pressMe = new ToggleButton("Press me")
  pressMe.selected = true

  restrictHeight(nameField)
  restrictHeight(gender)

  contents = new BoxPanel(Orientation.Vertical) {
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("My Name")
      contents += Swing.HStrut(5)
      contents += nameField
    }

    contents += Swing.VStrut(5)
    contents += likeScala
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += status1
      contents += Swing.HStrut(10)
      contents += status2
      contents += Swing.HStrut(10)
      contents += status3
    }
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Gender")
      contents += Swing.HStrut(20)
      contents += gender
    }
    contents += Swing.VStrut(5)
    contents += new Label("Comments")
    contents += Swing.VStrut(3)
    contents += new ScrollPane(commentField)
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += pressMe
      contents += Swing.HGlue
      contents += Button("Close") { reportAndClose() }
    }
    for (e <- contents) {
      e.xLayoutAlignment = 0.0
    }
    border = Swing.EmptyBorder(10,10,10,10)
  }

  def reportAndClose(): Unit = {
    println("Your name: " + nameField.text)
    println("Like Scala?: " + likeScala.selected)
    println("Status1: " + status1.selected)
    println("Status2: " + status2.selected)
    println("Status3: " + status3.selected)
    println("Gender: " + gender.selection.item + " - Index: " + gender.selection.index)
    println("Comments: " + commentField.text)
    println("Press Me is pressed: " + pressMe.selected)
    sys.exit(0)
  }


}
