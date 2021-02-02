package me.jipps.demospringdi;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {

    @Id @GeneratedValue
    private Integer id;
    private String text;

}
