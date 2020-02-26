package di

import app.MainViewController
import org.koin.dsl.module

val appModule = module {
    single { MainViewController() }
}