package view

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Button
import javafx.scene.control.TextField
import tornadofx.*

class TextInputDialog(
        title: String,
        onTextSubmitted: ((String) -> Unit)
) : View("$title file") {
    private var textField by singleAssign<TextField>()
    private var submitButton by singleAssign<Button>()

    private val inputText = SimpleStringProperty()
    private val filenameRegex = Regex("^[\\w,\\s-]+\\.[A-Za-z]+\$")

    override val root = Form()

    init {
        with(root) {
            fieldset {
                field("File name") {
                    textfield(inputText) {
                        textField = this
                    }
                }
            }
            button(title) {
                submitButton = this
                enableWhen(inputText.matches(filenameRegex))
                action {
                    onTextSubmitted(textField.text)
                    close()
                }
            }
        }
    }
}
