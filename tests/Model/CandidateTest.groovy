package Model


import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

class CandidateTest {

    @Test
    void testCandidateConstructorAndGetters() {
        def candidate = new Candidate(
                "Ana Souza",
                "ana@email.com",
                "123.456.789-00",
                26,
                "SP",
                "01001-000",
                "Dev backend júnior",
                ["Java", "Spring"]
        )

        assertEquals("Ana Souza", candidate.getName())
        assertEquals("ana@email.com", candidate.getEmail())
        assertEquals("123.456.789-00", candidate.cpf)
        assertEquals(26, candidate.age)
        assertTrue(candidate.skills.contains("Java"))
    }

    @Test
    void testToStringIncludesCpfAndAge() {
        def candidate = new Candidate("João", "joao@email.com",
                "111.222.333-44", 30, "RJ", "20000-000", "Tester", ["Groovy"])

        def str = candidate.toString()
        assertTrue(str.contains("CPF: 111.222.333-44"))
        assertTrue(str.contains("Idade: 30"))
    }
}
