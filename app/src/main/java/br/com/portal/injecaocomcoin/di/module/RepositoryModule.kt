package br.com.portal.injecaocomcoin.di.module

import br.com.portal.injecaocomcoin.repository.UserRepository
import br.com.portal.injecaocomcoin.repository.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
	//preferencia por singleton

//	factory {
//		UserRepositoryImpl(
//			userApi = get()
//		)
//	}

	single<UserRepository> {
		UserRepositoryImpl(
			userApi = get()
		)
	}
}