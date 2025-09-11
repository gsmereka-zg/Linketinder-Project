package Repository

import Model.Candidate
import Model.Company
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

class RepositoryTest {

    @BeforeEach
    void setup() {
        Repository.candidates.clear()
        Repository.companies.clear()
    }

    @Test
    void testAddCandidate() {
        def candidate = new Candidate("Maria", "maria@email.com",
                "111.111.111-11", 28, "BA", "40000-000", "Dev frontend", ["JS"])

        Repository.addCandidate(candidate)

        assertEquals(1, Repository.getCandidates().size())
        assertEquals("Maria", Repository.getCandidates().first().name)
    }

    @Test
    void testAddCompany() {
        def company = new Company("Boliche", "boliche@email.com",
                "99.888.777/0001-99", "Brasil", "SP", "01000-000", "Entretenimento", ["Angular"])

        Repository.addCompany(company)

        assertEquals(1, Repository.getCompanies().size())
        assertEquals("Boliche", Repository.getCompanies().first().name)
    }

    @Test
    void testAddNullCandidateThrowsError() {
        assertThrows(IllegalArgumentException.class) {
            Repository.addCandidate(null)
        }
    }

    @Test
    void testAddNullCompanyThrowsError() {
        assertThrows(IllegalArgumentException.class) {
            Repository.addCompany(null)
        }
    }
}
