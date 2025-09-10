package Model

class Candidate extends Person {
    String cpf
    Integer age

    Candidate(String name, String email, String cpf, Integer age, String state, String cep, String description, List<String> skills) {
        super(name, email, state, cep, description, skills)
        this.cpf = cpf
        this.age = age
    }

    @Override
    String toString() {
        return super.toString() +
                "CPF: " + cpf + "\n" +
                "Idade: " + age + "\n"
    }
}