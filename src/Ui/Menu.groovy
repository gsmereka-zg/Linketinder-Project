package Ui

import model.Candidate
import model.Company
import Repository.Repository

class Menu {
    static boolean running = false

    static void startMenu(Repository repo) {
        Scanner scanner = new Scanner(System.in)

        running = true
        while (running) {
            println "\n===== MENU ====="
            println "1 - Adicionar Candidato"
            println "2 - Adicionar Empresa"
            println "3 - Listar Candidatos"
            println "4 - Listar Empresas"
            println "0 - Sair"
            print "Escolha uma opção: "

            String option = scanner.nextLine()

            switch (option) {
                case "1":
                    addCandidate(scanner, repo)
                    break
                case "2":
                    addCompany(scanner, repo)
                    break
                case "3":
                    listCandidates(repo)
                    break
                case "4":
                    listCompanies(repo)
                    break
                case "0":
                    println "Saindo..."
                    running = false
                    break
                default:
                    println "Opção inválida!"
            }
        }
    }

    static void addCandidate(Scanner scanner, Repository repo) {
        println "\n-- Novo Candidato --"
        print "Nome: "
        String name = scanner.nextLine()
        print "Email: "
        String email = scanner.nextLine()
        print "CPF: "
        String cpf = scanner.nextLine()
        print "Idade: "
        int age = scanner.nextLine().toInteger()
        print "Estado: "
        String state = scanner.nextLine()
        print "CEP: "
        String cep = scanner.nextLine()
        print "Resumo: "
        String description = scanner.nextLine()
        print "Habilidades (separadas por vírgula): "
        List<String> skills = scanner.nextLine()
                .split(",")
                .collect { it.trim() }

        repo.addCandidate(new Candidate(name, email, cpf, age, state, cep, description, skills))
        println "Candidato adicionado com sucesso!"
    }

    static void addCompany(Scanner scanner, Repository repo) {
        println "\n-- Nova Empresa --"
        print "Nome: "
        String name = scanner.nextLine()
        print "Email: "
        String email = scanner.nextLine()
        print "CNPJ: "
        String cnpj = scanner.nextLine()
        print "País: "
        String country = scanner.nextLine()
        print "Estado: "
        String state = scanner.nextLine()
        print "CEP: "
        String cep = scanner.nextLine()
        print "Descrição: "
        String description = scanner.nextLine()
        print "Tecnologias (separadas por vírgula): "
        List<String> skills = scanner.nextLine()
                .split(",")
                .collect { it.trim() }

        repo.addCompany(new Company(name, email, cnpj, country, state, cep, description, skills))
        println "Empresa adicionada com sucesso!"
    }

    static void listCandidates(Repository repo) {
        println "\n-- Lista de Candidatos --"
        List<Candidate> candidates = repo.getCandidates()
        for (Candidate candidate : candidates) {
            println "- ${candidate}"
        }
    }

    static void listCompanies(Repository repo) {
        println "\n-- Lista de Empresas --"
        List<Company> companies = repo.getCompanies()
        for (Company company : companies) {
            println "- ${company}"
        }
    }
}
