package br.com.portal.injecaocomcoin.repository

import br.com.portal.injecaocomcoin.api.UserApi
import br.com.portal.injecaocomcoin.model.User

class UserRepositoryImpl(
	private val userApi: UserApi
) : UserRepository {

	override suspend fun getAllUsers(): List<User> = userApi.getAllUsers()
}