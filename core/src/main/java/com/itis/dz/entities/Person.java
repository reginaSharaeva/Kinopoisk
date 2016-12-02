package com.itis.dz.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String secondName;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
    private List<Comment> comments;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
    private List<Raiting> raitings;

    @ManyToMany
    @JoinTable(name="person_roles",
            joinColumns = @JoinColumn(name="person_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="id")
    )
    private List<Role> roles;

    @ManyToMany
    @JoinTable(name="person_awards",
            joinColumns = @JoinColumn(name="person_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="award_id", referencedColumnName="id")
    )
    private List<Award> awards;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "persons")
    private List<Movie> movies;



    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public Person() {
    }

    public Person(String lastName, String firstName, String secondName, List<Role> roles, List<Award> awards, Country country) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.roles = roles;
        this.awards = awards;
        this.country=country;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Role> getRoles() {return roles;}

    public void setRoles(List<Role> roles) {this.roles = roles;}

    public List<Award> getAwards() {return awards;}

    public void setAwards(List<Award> awards) {this.awards = awards;}
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public List<Raiting> getRaitings() {
        return raitings;
    }

    public void setRaitings(List<Raiting> raitings) {
        this.raitings = raitings;
    }
}

