package view

import app.MainViewController
import app.Styles
import javafx.application.Platform
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCombination
import javafx.stage.FileChooser
import javafx.stage.Window
import org.koin.core.KoinComponent
import tornadofx.*
import utils.ext.deleteSelectedText
import java.io.File


class MainView : View(), KoinComponent {
    private val mainViewController: MainViewController by getKoin().inject()
    private var textArea by singleAssign<TextArea>()
    private val viewTitle = SimpleStringProperty("Kompiler")

    init {
        titleProperty.unbind()
        titleProperty.bind(viewTitle)
    }

    override val root = vbox {
        setPrefSize(800.0, 600.0)
        alignment = Pos.CENTER

        menubar {
            menu(name = "File") {
                item(name = "Create new", keyCombination = "Ctrl+N") {
                    shortcut(KeyCombination.keyCombination("Ctrl+N")) {
                        createFile()
                    }
                    action { createFile() }
                }
                item(name = "Open file", keyCombination = "Ctrl+O") {
                    shortcut(KeyCombination.keyCombination("Ctrl+O")) {
                        openFile()
                    }
                    action { openFile() }
                }
                item(name = "Save file", keyCombination = "Ctrl+S") {
                    shortcut(KeyCombination.keyCombination("Ctrl+S")) {
                        saveChanges()
                    }
                    action { saveChanges() }
                }
                item(name = "Save file as", keyCombination = "Ctrl+Shift+S") {
                    shortcut(KeyCombination.keyCombination("Ctrl+S")) {
                        saveAsFile()
                    }
                    action { saveAsFile() }
                }
                item(name = "Exit") {
                    action {
                        confirmation(
                                header = "Exit",
                                content = "All unsaved changes will be lost"
                        ) {
                            when (result) {
                                ButtonType.OK -> Platform.exit()
                            }
                        }
                    }
                }
            }
            menu(name = "Edit") {
                item(name = "Undo", keyCombination = "Ctrl+Z") {
                    tooltip("Undo last action")
                    action { textArea.undo() }
                }
                item(name = "Redo", keyCombination = "Ctrl+Shift+Z") {
                    tooltip("Redo previous action")
                    action { textArea.redo() }
                }
                item(name = "Cut", keyCombination = "Ctrl+X") {
                    tooltip("Cut selected text to clipboard")
                    action { textArea.cut() }
                }
                item(name = "Copy", keyCombination = "Ctrl+C") {
                    tooltip("Copy text to clipboard")
                    action { textArea.copy() }
                }
                item(name = "Paste", keyCombination = "Ctrl+V") {
                    tooltip("Paste text from clipboard")
                    action { textArea.paste() }
                }
                item(name = "Remove", keyCombination = "Ctrl+D") {
                    shortcut(KeyCombination.keyCombination("Ctrl+D")) {
                        textArea.deleteSelectedText()
                    }
                    tooltip("Remove selected text")
                    action {
                        textArea.deleteSelectedText()
                    }
                }
                item(name = "Select all", keyCombination = "Ctrl+A") {
                    tooltip("Select all the text")
                    action { textArea.selectAll() }
                }
            }
            menu(name = "Text") {
                item(name = "Problem") {
                    tooltip(text = "Problem")
                    action {
                        alert(Alert.AlertType.INFORMATION, "Problem")
                    }
                }
                item(name = "Grammar") {
                    tooltip(text = "Grammar")
                    action {
                        alert(Alert.AlertType.INFORMATION, "Grammar")
                    }
                }
                item(name = "Grammar classification") {
                    tooltip(text = "Grammar classification")
                    action {
                        alert(Alert.AlertType.INFORMATION, "Grammar classification")
                    }
                }
                item(name = "Analysis method") {
                    tooltip(text = "Analysis method")
                    action {
                        alert(Alert.AlertType.INFORMATION, "Analysis method")
                    }
                }
                item(name = "Diagnostic") {
                    tooltip(text = "Diagnostic")
                    action {
                        alert(Alert.AlertType.INFORMATION, "Diagnostic")
                    }
                }
                item(name = "Example") {
                    tooltip(text = "Example")
                    action {
                        alert(Alert.AlertType.INFORMATION, "Example")
                    }
                }
                item(name = "Literature sources") {
                    tooltip(text = "Literature sources")
                    action {
                        alert(Alert.AlertType.INFORMATION, "Literature sources")
                    }
                }
                item(name = "Code sources") {
                    tooltip(text = "Code sources")
                    action {
                        alert(Alert.AlertType.INFORMATION, "Code sources")
                    }
                }
            }
            menu(name = "Run") {
                tooltip(text = "Run")
                shortcut(KeyCombination.keyCombination("Ctrl+F5")) {
                    alert(type = Alert.AlertType.INFORMATION, header = "Info", content = "Run shortcut")
                }
                action {
                    alert(type = Alert.AlertType.INFORMATION, header = "Info", content = "Run shortcut")
                }
            }
            menu(name = "Help") {
                item(name = "Help") {
                    action {
                        alert(Alert.AlertType.INFORMATION, "Help")
                    }
                }
                item(name = "About") {
                    action {
                        alert(Alert.AlertType.INFORMATION, "About")
                    }
                }
            }
        }
        hbox {
            spacing = 2.0

            button("", ImageView(Image("app/new.png"))) {
                tooltip("New file")
                action {
                    createFile()
                    textArea.requestFocus()
                }
            }
            button("", ImageView(Image("app/open.png"))) {
                tooltip("Open file")
                action {
                    openFile()
                    textArea.requestFocus()
                }
            }
            button("", ImageView(Image("app/save.png"))) {
                tooltip("Save file")
                action {
                    saveChanges()
                    textArea.requestFocus()
                }
            }
            button("", ImageView(Image("app/undo.png"))) {
                tooltip("Undo")
                action {
                    textArea.undo()
                    textArea.requestFocus()
                }
            }
            button("", ImageView(Image("app/redo.png"))) {
                tooltip("Redo")
                action {
                    textArea.redo()
                    textArea.requestFocus()
                }
            }
            button("", ImageView(Image("app/copy.png"))) {
                tooltip("Copy")
                action {
                    textArea.copy()
                    textArea.requestFocus()
                }
            }
            button("", ImageView(Image("app/cut.png"))) {
                tooltip("Cut")
                action {
                    textArea.cut()
                    textArea.requestFocus()
                }
            }
            button("", ImageView(Image("app/paste.png"))) {
                tooltip("Paste")
                action {
                    textArea.paste()
                    textArea.requestFocus()
                }
            }
        }
        textarea {
            textArea = this
            requestFocus()
            addClass(Styles.enterText)
        }
    }

    override fun onDock() {
        super.onDock()

        currentStage?.isResizable = false
    }

    private fun createFile() {
        TextInputDialog("Create") {
            if (it.isNotEmpty()) {
                val file = File(it).apply { createNewFile() }
                mainViewController.currentFile = file
                textArea.text = file.readText()
                viewTitle.set("Kompiler " + file.absolutePath)
            }
        }.openModal()
    }

    private fun openFile() {
        textArea.text = try {
            FileChooser().run {
                initialDirectory = File(".")
                showOpenDialog(currentWindow)
            }.also {
                mainViewController.currentFile = it
                viewTitle.set("Kompiler " + it.absolutePath)
            }?.readText()
        } catch (t: Throwable) {
            textArea.text
        }
    }

    private fun saveChanges() {
        val file = mainViewController.currentFile
        if (file != null) {
            file.writeText(textArea.text)
        } else
            showErrorAlert("No current file", currentWindow)
    }

    private fun saveAsFile() {
        TextInputDialog("Save as") {
            val file = File(it)
            file.writeText(textArea.text)
            viewTitle.set("Kompiler " + file.absolutePath)
        }.openModal()
    }

    private fun showErrorAlert(message: String?, dialogOwner: Window? = null) = alert(
            type = Alert.AlertType.ERROR,
            header = "An error occurred",
            content = message,
            owner = dialogOwner
    )
}