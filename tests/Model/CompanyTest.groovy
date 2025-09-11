package Model

import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

class CompanyTest {

    @Test
    void testCompanyConstructorAndGetters() {
        def company = new Company(
                "Tech Minas",
                "contato@tech.com",
                "01.234.567/0001-01",
                "Brasil",
                "MG",
                "30110-000",
                "Consultoria em dados",
                ["Python", "ETL"]
        )

        assertEquals("Tech Minas", company.getName())
        assertEquals("contato@tech.com", company.getEmail())
        assertEquals("01.234.567/0001-01", company.cnpj)
        assertEquals("Brasil", company.country)
    }

    @Test
    void testToStringIncludesCnpjAndCountry() {
        def company = new Company("Arroz", "arroz@email.com",
                "22.333.444/0001-22", "Brasil", "SP", "01000-000", "Alimentos", ["SQL"])

        def str = company.toString()
        assertTrue(str.contains("CNPJ: 22.333.444/0001-22"))
        assertTrue(str.contains("País: Brasil"))
    }
}
