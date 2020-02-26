package utils.ext

import javafx.scene.control.TextArea

fun TextArea.deleteSelectedText() {
    if (anchor < caretPosition)
        deleteText(anchor, caretPosition)
    else
        deleteText(caretPosition, anchor)
}