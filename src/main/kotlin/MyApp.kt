
import app.Styles
import di.appModule
import javafx.stage.Stage
import org.koin.core.context.startKoin
import tornadofx.App
import tornadofx.alert
import view.MainView

class MyApp : App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        startKoin {
            modules(appModule)
        }
        super.start(stage)
    }
}