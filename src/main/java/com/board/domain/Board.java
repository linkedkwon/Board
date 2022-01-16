package com.board.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "BOARD")
@NoArgsConstructor
public class Board {

    @Id @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private String writer;

    @Column
    private String category;

    @Column
    private String date;

    @Column
    private String content;

    @Column
    private String discussion;

}
