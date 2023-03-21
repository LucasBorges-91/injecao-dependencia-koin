package br.com.portal.injecaocomcoin.repository

import br.com.portal.injecaocomcoin.model.User

interface UserRepository {

	suspend fun getAllUsers(): List<User>

}