package org.healthcare.enrollment.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "enrolle_dependent_registration")
public class Dependent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "dep_id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Enrolle enrolle;

    public Dependent() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Enrolle getEnrolle() {
        return enrolle;
    }

    public void setEnrolle(Enrolle enrolle) {
        this.enrolle = enrolle;
    }
}
