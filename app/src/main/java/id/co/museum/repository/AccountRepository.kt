package id.co.museum.repository

import id.co.museum.data.datasource.AccountDataSource
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val accountDataSource: AccountDataSource
) {

    suspend fun register(email: String, password: String) =
        accountDataSource.register(email, password)


}