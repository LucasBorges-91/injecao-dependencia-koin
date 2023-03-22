package br.com.portal.injecaocomcoin.di.module

import br.com.portal.injecaocomcoin.api.UserApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
	single { providerUserApi() }
}

fun providerUserApi() : UserApi {
	return Retrofit.Builder()
		.baseUrl( "https://api.github.com/" )
		.addConverterFactory( GsonConverterFactory.create() )
		.build().create( UserApi::class.java )
}
