package com.studentapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student {
    @Column(length = 30)
    private String name;
    @Id
    @GeneratedValue(generator = "student_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "student_gen",sequenceName = "student_sequence",initialValue = 2,allocationSize = 2)
    private Integer studentId;
    @Column(length = 30)
    private String department;

    @OneToOne(cascade = CascadeType.ALL)// when the parent ref is saved all the child reference will be saved automatically using cascade
    @JoinColumn(name = "address_id") // to give a different column name
    private Address address;

    public Student(String name, String department, Address address) {
        this.name = name;
        this.department = department;
        this.address = address;
    }
}
