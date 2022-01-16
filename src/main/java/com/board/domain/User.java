package com.board.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PASSWORD")
    private String password;

    public User(String userId){
        this. userId = userId;
    }

    @Builder
    public User(String studentId, String userId, String password){
        this.studentId = studentId;
        this.userId =  userId;
        this.password = password;
    }

}