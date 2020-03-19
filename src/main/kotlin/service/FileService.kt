package service

import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser
import javafx.stage.Window
import java.io.File
import java.io.IOException

class FileService {
    private val listeners: MutableList<FileServiceEventListener> = mutableListOf()

    var currentFile: File? = null

    fun createFile(filename: String, ownerWindow: Window? = null): File? {
        val dir: File? = DirectoryChooser().run {
            initialDirectory = File(".")
            showDialog(ownerWindow)
        }
        currentFile = dir?.let {
            File(dir.absolutePath + File.separator + filename).apply {
                createNewFile()
            }
        }

        listeners.forEach { it.consumeEvent(FileServiceEvent.FileChanged(currentFile)) }

        return currentFile
    }

    fun openFile(ownerWindow: Window? = null): File? {
        val file: File? = FileChooser().run {
            initialDirectory = File(".")
            showOpenDialog(ownerWindow)
        }
        currentFile = file
                ?.apply {
                    if (!canRead()) throw IOException("Cannot read file")
                }
                ?: throw IOException("File is null")

        listeners.forEach { it.consumeEvent(FileServiceEvent.FileChanged(currentFile)) }

        return currentFile
    }

    fun saveToFile(data: String, onFileNameMissed: () -> Unit) {
        currentFile
                ?.apply {
                    if (canWrite())
                        writeText(data)
                    else
                        throw IOException("Cannot write to file")
                }
                ?: onFileNameMissed()
    }

    fun saveFileAs(filename: String, data: String, ownerWindow: Window? = null): File? {
        currentFile = createFile(filename, ownerWindow)?.apply {
            if (canWrite()) {
                writeText(data)
            } else {
                throw IOException("Cannot write to file")
            }
        }

        listeners.forEach { it.consumeEvent(FileServiceEvent.FileChanged(currentFile)) }

        return currentFile
    }

    fun addFileServiceEventListener(listener: FileServiceEventListener) {
        listeners.add(listener)
    }

    fun removeFileServiceEventListener(listener: FileServiceEventListener) {
        listeners.remove(listener)
    }

    interface FileServiceEventListener {
        fun consumeEvent(event: FileServiceEvent)
    }

    sealed class FileServiceEvent {
        class FileChanged(val file: File?) : FileServiceEvent()
    }
}