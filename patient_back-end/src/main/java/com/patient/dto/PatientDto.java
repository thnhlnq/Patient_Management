//package com.patient.dto;
//
//import com.example.model.customer.CustomerType;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//
//public class CustomerDto {
//
//    private int id;
//
//    @NotBlank(message = "Name Must Be Capitalization !")
//    @Pattern(regexp = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$", message = "")
//    private String name;
//
//    @NotBlank(message = "Cannot Be Blank !")
//    private String dateOfBirth;
//
//    private int gender;
//
//    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Id Card Must Have 9 / 12 number !")
//    private String idCard;
//
//    @Pattern(regexp = "^(090|091|8490|8491)+(\\d{7})$", message = "Phone Must Be Incorrect Format !")
//    private String phone;
//
//    @NotBlank(message = "Email Must Be Incorrect Format !")
//    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "")
//    private String email;
//
//    @NotBlank(message = "Cannot Be Blank !")
//    private String address;
//    private CustomerType customerType;
//
//    public CustomerDto() {
//    }
//
//    public CustomerDto(int id, String name, String dateOfBirth, int gender, String idCard, String phone, String email, String address, CustomerType customerType) {
//        this.id = id;
//        this.name = name;
//        this.dateOfBirth = dateOfBirth;
//        this.gender = gender;
//        this.idCard = idCard;
//        this.phone = phone;
//        this.email = email;
//        this.address = address;
//        this.customerType = customerType;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public int getGender() {
//        return gender;
//    }
//
//    public void setGender(int gender) {
//        this.gender = gender;
//    }
//
//    public String getIdCard() {
//        return idCard;
//    }
//
//    public void setIdCard(String idCard) {
//        this.idCard = idCard;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public CustomerType getCustomerType() {
//        return customerType;
//    }
//
//    public void setCustomerType(CustomerType customerType) {
//        this.customerType = customerType;
//    }
//}
