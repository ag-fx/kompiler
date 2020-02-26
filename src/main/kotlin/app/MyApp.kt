package app

import di.appModule
import javafx.stage.Stage
import org.koin.core.context.startKoin
import tornadofx.*
import view.MainView

class MyApp : App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        startKoin {
            modules(appModule)
        }
        super.start(stage)
    }
}