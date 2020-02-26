package utils

import javafx.event.EventHandler
import javafx.scene.control.TextArea
import javafx.scene.input.KeyEvent

class KeyEventDispatcher(
        private val textArea: TextArea
) : EventHandler<KeyEvent> {
    fun dispatch() {

    }

    override fun handle(event: KeyEvent) {
        if (event.isControlDown) print("ctrl+${event.code}")
        if (event.isShiftDown) print("shift+${event.code}")
    }
}