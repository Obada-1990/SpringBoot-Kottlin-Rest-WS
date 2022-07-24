package obada.com.restws.datasource.mock

import obada.com.restws.datasource.BankDataSource
import obada.com.restws.model.Bank
import org.springframework.stereotype.Repository


//Repository --> this class is responsible for storing data, retrieving data
@Repository //tells Springboot to initialize object at runtime
class MockBankDataSource: BankDataSource {

    val banks = mutableListOf(
        Bank("1234",3.14,17),
        Bank("1010",17.0,2),
        Bank("5678",2.0,100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBanks(accountNumber: String): Bank =
        banks.firstOrNull(){it.accountNumber == accountNumber}
            ?: throw NoSuchElementException("Could not find a bank with a such $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if(banks.any{it.accountNumber == bank.accountNumber}) {
            throw java.lang.IllegalArgumentException("Bank with accountNumber ${bank.accountNumber}already exist")
        }
            banks.add(bank)
        return bank
    }

    override fun patchBank(bank: Bank): Bank {
     val currentBank = banks.firstOrNull{it.accountNumber == bank.accountNumber}
         ?: throw NoSuchElementException("Could not find a bank with a such ${bank.accountNumber}")
         banks.remove(currentBank)
        banks.add(bank)
        return bank
    }

    override fun deleteBank(accountNumber: String) {
      val currentBank = banks.firstOrNull{it.accountNumber == accountNumber}
          ?: throw NoSuchElementException("Could not find a bank with accountNumber:  $accountNumber")
        banks.remove(currentBank)
    }

}