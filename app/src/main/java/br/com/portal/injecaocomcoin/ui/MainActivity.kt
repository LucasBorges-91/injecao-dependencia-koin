package br.com.portal.injecaocomcoin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.portal.injecaocomcoin.api.UserApi
import br.com.portal.injecaocomcoin.databinding.ActivityMainBinding
import br.com.portal.injecaocomcoin.repository.UserRepositoryImpl
import br.com.portal.injecaocomcoin.viewmodel.UserViewModel
import br.com.portal.injecaocomcoin.viewmodel.factory.UserViewModelFactory
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

	private val binding by lazy {
		ActivityMainBinding.inflate( layoutInflater )
	}

	private val userRepository : UserRepositoryImpl by inject()

	//inject vs get - inject só no momento que for utilizar, get no momento da criacao.
//	val userApi = get<UserApi>()
	private val userApi by inject<UserApi>()

	private val userViewModel by viewModel<UserViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

//		val userViewModel = ViewModelProvider(
//			this,
//			UserViewModelFactory( userRepository )
//		)[UserViewModel::class.java]

		binding.btnCallNetWork.setOnClickListener {
			userViewModel.getAllUsers()
		}
	}
}