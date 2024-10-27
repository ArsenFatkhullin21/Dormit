package ru.fatkhullin.spring.arsenProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле ФИО не должно быть пустым")
    @Size(min = 2, max = 60, message = "Поле ФИО дожно иметь длинну 2-60 символов")
    @Column(name = "fio")
    private String fio;

    @NotEmpty(message = "Полу Факультут не должно быть пустым")
    @Column(name = "faculty")
    private String faculty;

    @NotEmpty(message = "Поле группа не должно быть пустым")
    @Column(name = "groupp")
    private String groupp;

    @NotEmpty(message = "Поле форма обучения не должно быть пустым")
    @Column(name = "payment")
    private String payment;

//    @Enumerated(EnumType.STRING)
//    private Payment payment;

    @NotEmpty(message = "Поле Б/К/М не должно быть пустым")
    @Column(name = "education")
    private String education;
//    @Enumerated(EnumType.STRING)
//    private Education education;

    @NotEmpty(message = "Поле страна не должно быть пустым")
    @Column(name = "country")
    private String country;

    @NotEmpty(message = "Поле номер телефона не должно быть пустым")
    @Column(name = "phonenumber")
    private String phoneNumber;


    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @NotEmpty(message = "Поле адрес не должно быть пустым")
    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomid", referencedColumnName = "id")
    private Room room;

    public Person() {
    }

    public Person(int id, String fio, String faculty,
                  String groupp, String payment, String education,
                  String country, String phoneNumber, Date dateOfBirth,
                  String address) {
        this.id = id;
        this.fio = fio;
        this.faculty = faculty;
        this.groupp = groupp;
        this.payment = payment;
        this.education = education;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroupp() {
        return groupp;
    }

    public void setGroupp(String groupp) {
        this.groupp = groupp;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


}
