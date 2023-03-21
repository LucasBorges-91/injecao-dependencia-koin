package br.com.portal.injecaocomcoin.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.portal.injecaocomcoin.repository.UserRepository
import br.com.portal.injecaocomcoin.viewmodel.UserViewModel
import java.lang.IllegalArgumentException

class UserViewModelFactory constructor( private val repository: UserRepository ) :
	ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return if ( modelClass.isAssignableFrom( UserViewModel::class.java ) ) {
			UserViewModel( this.repository ) as T
		} else {
			throw IllegalArgumentException("ViewModel not found")
		}
	}


}