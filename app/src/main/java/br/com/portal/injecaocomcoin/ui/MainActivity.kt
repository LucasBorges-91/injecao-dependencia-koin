package br.com.portal.injecaocomcoin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.portal.injecaocomcoin.api.UserApi
import br.com.portal.injecaocomcoin.databinding.ActivityMainBinding
import br.com.portal.injecaocomcoin.repository.UserRepositoryImpl
import br.com.portal.injecaocomcoin.viewmodel.UserViewModel
import br.com.portal.injecaocomcoin.viewmodel.factory.UserViewModelFactory

class MainActivity : AppCompatActivity() {

	private val binding by lazy {
		ActivityMainBinding.inflate( layoutInflater )
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		val userApi = UserApi.getInstance()

		val userRepository = UserRepositoryImpl(userApi)

		val userViewModel = ViewModelProvider(
			this,
			UserViewModelFactory( userRepository )
		)[UserViewModel::class.java]

		binding.btnCallNetWork.setOnClickListener {
			userViewModel.getAllUsers()
		}
	}
}