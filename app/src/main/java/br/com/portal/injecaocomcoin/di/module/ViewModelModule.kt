package br.com.portal.injecaocomcoin.di.module

import br.com.portal.injecaocomcoin.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
	viewModel {
		UserViewModel(
			userRepository = get()
		)
	}
}