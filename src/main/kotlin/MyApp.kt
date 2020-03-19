
import app.Styles
import di.appModule
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
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

        stage.onCloseRequest = EventHandler { event ->
            alert(
                    Alert.AlertType.CONFIRMATION,
                    "You may have unsaved changes",
                    "Confirm closing",
                    ButtonType.YES, ButtonType.CANCEL,
                    owner = stage.owner
            ) {
                when (result) {
                    ButtonType.YES -> {
                    }
                    ButtonType.CANCEL -> {
                        event.consume()
                    }
                }
            }
        }

        super.start(stage)
    }
}