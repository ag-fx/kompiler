package app

import tornadofx.Stylesheet
import tornadofx.cssclass
import tornadofx.pt
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val enterText by cssclass()
    }

    init {
        textArea and enterText {
            maxWidth = 800.px
            maxHeight = 600.px
            prefWidth = 800.px
            prefHeight = 600.px
            fontSize = 10.pt
            fontFamily = "Lucida Console"
        }
    }
}