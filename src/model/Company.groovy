package model

class Company extends Person {
    String cnpj
    String country

    Company(String name, String email, String cnpj, String country, String state, String cep, String description, List<String> skills) {
        super(name, email, state, cep, description, skills)
        this.cnpj = cnpj
        this.country = country
    }

    @Override
    String toString() {
        return super.toString() +
                "CNPJ: " + cnpj + "\n" +
                "País: " + country + "\n"
    }
}