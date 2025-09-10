package Repository

import Model.Candidate
import Model.Company

class Repository {
    static List<Candidate> candidates = []
    static List<Company> companies = []

    static void setup() {
        if (!candidates.isEmpty() || !companies.isEmpty()) return

        candidates.addAll([
                new Candidate('Ana Souza', 'ana.souza@email.com', '123.456.789-00', 26, 'SP', '01001-000', 'Dev backend júnior', ['Java', 'Spring Framework', 'SQL']),
                new Candidate('Bruno Lima', 'bruno.lima@email.com', '987.654.321-11', 31, 'RJ', '20040-020', 'Fullstack curioso', ['JavaScript', 'Angular', 'Node.js']),
                new Candidate('Carla Mendes', 'carla.mendes@email.com', '222.333.444-55', 29, 'MG', '30140-110', 'Data enthusiast', ['Python', 'Pandas', 'ETL']),
                new Candidate('Diego Alves', 'diego.alves@email.com', '111.222.333-44', 35, 'PR', '80010-000', 'Mobile dev', ['Kotlin', 'Android', 'REST']),
                new Candidate('Elisa Freitas', 'elisa.freitas@email.com', '555.666.777-88', 24, 'RS', '90010-001', 'QA e automação', ['Selenium', 'Groovy', 'Spock'])
        ])

        companies.addAll([
                new Company('Arroz-Gostoso', 'contato@arrozgostoso.com', '12.345.678/0001-99', 'Brasil', 'SP', '04567-000', 'Alimentos premium', ['Java', 'Spring Framework', 'SQL']),
                new Company('Império do Boliche', 'hr@imperioboliche.com', '98.765.432/0001-55', 'Brasil', 'RJ', '22010-010', 'Entretenimento e lazer', ['Angular', 'Node.js']),
                new Company('Tech Minas', 'gente@techminas.com', '01.234.567/0001-01', 'Brasil', 'MG', '30110-000', 'Consultoria em dados', ['Python', 'ETL', 'Data Viz']),
                new Company('Paraná Mobile', 'talentos@prmobile.com', '23.456.789/0001-22', 'Brasil', 'PR', '80020-002', 'Soluções mobile', ['Kotlin', 'REST']),
                new Company('Gaúcha Quality', 'recrutamento@gauchaquality.com', '67.890.123/0001-33', 'Brasil', 'RS', '90020-003', 'Qualidade de software', ['Groovy', 'Spock', 'Selenium'])
        ])
    }

    static void addCompany(Company newCompany) {
        if (newCompany == null) {
            throw new IllegalArgumentException("Company cannot be null")
        }
        companies.add(newCompany)
    }

    static List<Company> getCompanies() {
        return companies
    }

    static void addCandidate(Candidate newCandidate) {
        if (newCandidate == null) {
            throw new IllegalArgumentException("Candidate cannot be null")
        }
        candidates.add(newCandidate)
    }

    static List<Candidate> getCandidates() {
        return candidates
    }
}