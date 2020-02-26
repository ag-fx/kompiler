package app

import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val enterText by cssclass()

        val newFile by cssclass()
        val openFile by cssclass()
        val saveFile by cssclass()
        val undo by cssclass()
        val redo by cssclass()
        val copy by cssclass()
        val cut by cssclass()
        val paste by cssclass()
    }

    init {
        textArea and enterText {
            maxWidth = 800.px
            maxHeight = 600.px
            prefWidth = 800.px
            prefHeight = 600.px
            fontSize = 14.px
        }
        newFile and button {
            startMargin = 4.px
        }
        openFile and button {
            startMargin = 4.px
        }
        saveFile and button {
            startMargin = 4.px
            endMargin = 4.px
        }
        undo and button {
            startMargin = 4.px
        }
        redo and button {
            startMargin = 4.px
        }
        copy and button {
            startMargin = 4.px
        }
        cut and button {
            startMargin = 4.px
        }
        paste and button {
            startMargin = 4.px
        }
    }
}