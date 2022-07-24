package obada.com.restws.service

import io.mockk.mockk
import obada.com.restws.datasource.BankDataSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest{
    private val dataSource: BankDataSource = mockk(relaxed = true)
    private val bankService = BankService(dataSource)
    @Test
    fun`should call its data source to retrieve banks`(){
    //given

    //when
    val banks = bankService.getBanks()
    //then

    }
}