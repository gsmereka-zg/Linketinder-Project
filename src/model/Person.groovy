package model

abstract class Person implements IPerson {
    String name
    String email
    String state
    String cep
    String description
    List<String> skills = []

    Person(String name, String email, String state, String cep, String description, List<String> skills) {
        this.name = name
        this.email = email
        this.state = state
        this.cep = cep
        this.description = description
        if (skills) this.skills.addAll(skills)
    }

    @Override
    String toString() {
        String comp
        if (skills != null && !skills.isEmpty()) {
            comp = String.join(", ", skills)
        } else {
            comp = "—"
        }

        return "Nome: " + name + "\n" +
                "E-mail: " + email + "\n" +
                "Estado: " + state + "\n" +
                "CEP: " + cep + "\n" +
                "Descrição: " + description + "\n" +
                "Competências: " + comp + "\n"
    }
}