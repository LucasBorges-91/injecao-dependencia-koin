package br.com.portal.injecaocomcoin.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.portal.injecaocomcoin.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
	private val userRepository: UserRepository
) : ViewModel() {

	fun getAllUsers() = viewModelScope.launch {
		val users = userRepository.getAllUsers()

		for ( user in users ) {
			Log.i( "Teste", user.login )
		}
	}

}