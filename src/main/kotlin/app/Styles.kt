package app

import tornadofx.Stylesheet
import tornadofx.cssclass
import tornadofx.pt
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val enterText by cssclass()
        val outputText by cssclass()
    }

    init {
        textArea and enterText {
            maxWidth = 800.px
            maxHeight = 500.px
            prefWidth = 800.px
            prefHeight = 500.px
            fontSize = 10.pt
            fontFamily = "Lucida Console"
        }
        textArea and outputText {
            maxWidth = 800.px
            maxHeight = 200.px
            prefWidth = 800.px
            prefHeight = 200.px
            fontSize = 10.pt
            fontFamily = "Lucida Console"
        }
    }
}