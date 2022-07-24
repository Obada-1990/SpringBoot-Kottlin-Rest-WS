package obada.com.restws.service

import obada.com.restws.datasource.BankDataSource
import obada.com.restws.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()

    fun getBank(accountNumber: String):Bank = dataSource.retrieveBanks(accountNumber)

    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

    fun updateBank(bank: Bank): Bank = dataSource.patchBank(bank)

    fun deleteBank(accountNumber: String) = dataSource.deleteBank(accountNumber)


}


