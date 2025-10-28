package fr.epita.patients.datamodel;

import java.time.LocalDate;
import java.util.Date;

public class Patient {

    public String getGender() {
        return gender;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthLocation() {
        return birthLocation;
    }

    private String gender;
    private String birthYear;
    private String birthMonth;
    private String birthLocation;

    //pat_num_HC;pat_lastname;pat_firstname;pat_address;pat_tel;pat_insurance_id;pat_sub_date
    private String patNumHC;
    private String lastName;
    private String firstName;
    private String address;
    private String tel;
    private Integer insuranceId;
    private Date subDate;

    public Patient(String patNumHC, String lastName, String firstName, String address, String tel, Integer insuranceId, Date subDate) {
        this.patNumHC = patNumHC;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.tel = tel;
        this.insuranceId = insuranceId;
        this.subDate = subDate;
        if (patNumHC == null || patNumHC.equals("")) {
            return;
        }
        this.gender = patNumHC.substring(0, 1);
        this.birthYear = patNumHC.substring(2, 4);
        this.birthMonth = patNumHC.substring(5, 7);
        this.birthLocation = patNumHC.substring(8, 10);
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

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }
}
