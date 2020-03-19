package app

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javafx.stage.Window
import service.FileService
import java.io.IOException

class MainViewController(
        private val fileService: FileService
) {
    private val errorSubject: BehaviorSubject<Throwable> = BehaviorSubject.create()
    val errorObservable: Observable<Throwable> = errorSubject

    val fileServiceEventsObservable: Observable<FileService.FileServiceEvent> = Observable.create {
        val eventListener = object : FileService.FileServiceEventListener {
            override fun consumeEvent(event: FileService.FileServiceEvent) {
                if (!it.isDisposed) {
                    it.onNext(event)
                }
            }
        }
        fileService.addFileServiceEventListener(eventListener)
    }

    fun createFile(filename: String, ownerWindow: Window? = null): String? {
        return try {
            fileService.createFile(filename, ownerWindow)?.readText()
        } catch (e: IOException) {
            errorSubject.onNext(e)
            null
        }
    }

    fun openFile(ownerWindow: Window? = null): String? {
        return try {
            fileService.openFile(ownerWindow)?.readText()
        } catch (e: IOException) {
            errorSubject.onNext(e)
            null
        }
    }

    fun saveFile(data: String, ownerWindow: Window? = null, onFileNameMissed: () -> Unit) {
        try {
            fileService.saveToFile(data, onFileNameMissed)
        } catch (e: IOException) {
            errorSubject.onNext(e)
        }
    }

    fun saveFileAs(filename: String, data: String, ownerWindow: Window? = null) {
        try {
            fileService.saveFileAs(filename, data, ownerWindow)
        } catch (e: IOException) {
            errorSubject.onNext(e)
        }
    }
}