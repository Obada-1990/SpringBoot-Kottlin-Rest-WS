package obada.com.restws.datasource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest{
    private val mocDataSource = MockBankDataSource()
    @Test
    fun`should provide a collection of banks`(){
    //given

    //when
     val banks = mocDataSource.retrieveBanks()
    //then
        assertThat(banks).allMatch(){it.accountNumber.isNotBlank()}
        assertThat(banks).allMatch{it.trust != 0.0}
        assertThat(banks).allMatch{it.transactionFee != 0}

    }
}