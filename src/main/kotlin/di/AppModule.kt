package di

import app.MainViewController
import org.koin.dsl.module
import service.FileService

val appModule = module {
    single { MainViewController(get()) }
    single { FileService() }
}