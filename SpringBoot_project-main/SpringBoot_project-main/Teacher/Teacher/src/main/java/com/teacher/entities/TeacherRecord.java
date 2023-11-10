package com.teacher.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacherRecord")
public class TeacherRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;

    @Column(name = "name")
    private String teacherName;

    @Column(name = "contactNo")
    private String mobileNo;
}
