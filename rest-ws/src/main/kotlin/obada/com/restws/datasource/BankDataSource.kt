package obada.com.restws.datasource

import obada.com.restws.model.Bank


interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
    fun retrieveBanks(accountNumber: String): Bank
    fun createBank(bank: Bank): Bank
    fun patchBank(bank: Bank): Bank
    fun deleteBank(accountNumber: String)
}