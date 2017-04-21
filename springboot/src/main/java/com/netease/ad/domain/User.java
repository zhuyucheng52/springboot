package com.netease.ad.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by bjzhuyucheng on 2017/4/20.
 */
@Data
@NoArgsConstructor
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 5899104787290940522L;
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;
}
