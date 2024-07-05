package org.psota.invoices.repository

import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions.assertThat
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.BeforeEach
import org.psota.invoices.TestUtils
import org.psota.invoices.entity.Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.Test

@DataJpaTest
@Transactional
class PersistenceTests {
    @Autowired
    var clientRepo: ClientRepo? = null

    @Autowired
    var companyRepo: CompanyRepo? = null

    @Autowired
    var invoiceRepo: InvoiceRepo? = null

    @Autowired
    var productRepo: ProductRepo? = null

    @BeforeEach
    @Transactional
    fun setup() {
        clientRepo!!.deleteAll()
        companyRepo!!.deleteAll()
        invoiceRepo!!.deleteAll()
        productRepo!!.deleteAll()
    }

    @Test
    fun test_persistClient() {
        val random = EasyRandom()
        val client = random.nextObject(Client::class.java)

        val saved = clientRepo!!.save(client)

        assertThat(client).usingRecursiveComparison().isEqualTo(saved)
    }

    @Test
    fun test_persistInvoice() {
        val company = TestUtils.buildCompany()
        val client = TestUtils.buildClient()
        val product = TestUtils.buildProduct()
        val invoice = TestUtils.buildInvoice(company, client, product)

        val savedProduct = productRepo!!.save(product)
        val savedClient = clientRepo!!.save(client)

        invoice.client = savedClient
        invoice.products = listOf(savedProduct)
        val savedInvoice = invoiceRepo!!.save(invoice)

        assertThat(savedInvoice).usingRecursiveComparison().isEqualTo(savedInvoice)
    }

    @Test
    fun test_persistCompany() {
        val company = TestUtils.buildCompany()

        val saved = companyRepo!!.save(company)

        assertThat(company).usingRecursiveComparison().isEqualTo(saved)
    }

    @Test
    fun test_persistProduct() {
        val product = TestUtils.buildProduct()

        val saved = productRepo!!.save(product)

        assertThat(product).usingRecursiveComparison().isEqualTo(saved)
    }
}
