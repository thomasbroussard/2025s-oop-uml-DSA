package fr.epita.patients.datamodel;

public class Patient {

    //pat_num_HC;pat_lastname;pat_firstname;pat_address;pat_tel;pat_insurance_id;pat_sub_date
    private String patNumHC;
    private String lastName;
    private String firstName;
    private String address;
    private String tel;
    private Integer insuranceId;
    private String subDate;

    public Patient(String patNumHC, String lastName, String firstName, String address, String tel, Integer insuranceId, String subDate) {
        this.patNumHC = patNumHC;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.tel = tel;
        this.insuranceId = insuranceId;
        this.subDate = subDate;
    }

    public String getPatNumHC() {
        return patNumHC;
    }

    public void setPatNumHC(String patNumHC) {
        this.patNumHC = patNumHC;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getSubDate() {
        return subDate;
    }

    public void setSubDate(String subDate) {
        this.subDate = subDate;
    }
}
