package model;

public class Employee {

    private Integer idEmployee;
    private String name;
    private String email;
    private String phone;
    private String departement;
    private String poste;

    // Constructeur corrigé
    public Employee(Integer idEmployee, String name, String email, String phone, String departement, String poste) {
        this.idEmployee = idEmployee; // Correction ici
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.departement = departement;
        this.poste = poste;
    }

    public Employee() {
    }

    public Employee(String name, String email, String phone, String departement, String poste) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.departement = departement;
        this.poste = poste;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public String toString() {
        return String.format("Employee{idEmployee=%d, name='%s', email='%s', phone='%s', department='%s', position='%s'}",
                idEmployee, name, email, phone, departement, poste);
    }
}
