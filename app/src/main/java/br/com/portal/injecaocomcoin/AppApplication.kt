package br.com.portal.injecaocomcoin

import android.app.Application
import br.com.portal.injecaocomcoin.di.module.apiModule
import br.com.portal.injecaocomcoin.di.module.repositoryModule
import br.com.portal.injecaocomcoin.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppApplication : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			//caso precise de um context do android
//			androidContext(this@AppApplication)

			//caso precise de um debug
//			androidLogger( level = Level.DEBUG )
			modules(
				apiModule,
				repositoryModule,
				viewModelModule
			)
		}
	}
}