package org.homework.servlets.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String text;

    @Column(name="img_url")
    private String imgUrl;

}
