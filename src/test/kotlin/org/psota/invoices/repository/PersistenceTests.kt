package org.psota.invoices.repository

import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions.*
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.BeforeEach
import org.psota.invoices.entity.*
import org.psota.invoices.entity.Unit
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.*
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
        val address = buildAddress()
        val bankInfo = buildBankInfo()
        val company = buildCompany(address, bankInfo)
        val client = buildClient(address)
        val product = buildProduct()
        val invoice = buildInvoice(company, client, product)

        val savedProduct = productRepo!!.save(product)
        val savedClient = clientRepo!!.save(client);

        invoice.client = savedClient
        invoice.products = listOf(savedProduct)
        val savedInvoice = invoiceRepo!!.save(invoice)

        assertThat(savedInvoice).usingRecursiveComparison().isEqualTo(savedInvoice)
    }

    @Test
    fun test_persistCompany() {
        val address = buildAddress()
        val bankInfo = buildBankInfo()
        val company = buildCompany(address, bankInfo)

        val saved = companyRepo!!.save(company)

        assertThat(company).usingRecursiveComparison().isEqualTo(saved)
    }

    @Test
    fun test_persistProduct() {
        val product = buildProduct()

        val saved = productRepo!!.save(product)

        assertThat(product).usingRecursiveComparison().isEqualTo(saved)
    }

    fun buildInvoice(company: Company,
                     client: Client,
                     product: Product): Invoice {
        return Invoice(
                invoiceNo = "20240601",
                company = company,
                client = client,
                issuedOn = null,
                dueOn = null,
                products = listOf(product),
                quantity = null
        )
    }

    fun buildClient(address: Address): Client {
        return Client(
                address = address,
                regNo = "regNo",
                taxNo = "taxNo",
                vatNo = "vatNo"
        )
    }

    fun buildAddress(): Address {
        return Address(
                streetNo = "streetNo",
                street = "street",
                city = "city",
                zipCode = "zipCode"
        )
    }

    fun buildCompany(address: Address, bankInfo: BankInfo): Company {
        return Company(
                name = "My Company",
                address = address,
                regNo = "regNo",
                taxNo = "taxNo",
                vatNo = "vatNo",
                bankInfo = bankInfo,
        )
    }

    fun buildBankInfo(): BankInfo {
        return BankInfo(
                accountNo = "accountNo",
                iban = "iban",
                bankName = "bankName",
                swiftCode = "swiftCode",
                ""
        )
    }

    fun buildProduct(): Product {
        return Product(
                name = "name",
                description = "",
                unit = Unit.MD,
                unitPrice = 1.00
        )
    }
}
