package com.itis.dz.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name="movie_genres",
            joinColumns = @JoinColumn(name="MOVIE_ID", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="GENRE_ID", referencedColumnName="id")
    )
    private List <Genre> genres;


    @ManyToMany
    @JoinTable(name = "movie_persons",
            joinColumns = @JoinColumn(name = "MOVIE_ID", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName="id"))
    private List<Person> persons;



    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "movie")
    private List<Raiting> raitings;

    private int totalraiting;

    private long mencount;


    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "movie")
    private List<Comment> comments;

    @Column
    private int time;

    @Column
    private int year;

    @Column
    private int age;

    @Column
    private String img;
    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;


    public Movie() {
    }

    public long getMencount() {
        return mencount;
    }

    public void setMencount(long mencount) {
        this.mencount = mencount;
    }

    public int getTotalraiting() {
        return totalraiting;
    }

    public void setTotalraiting(int totalraiting) {
        this.totalraiting = totalraiting;
    }

    public Movie(String name, List<Genre> genres, List<Person> persons, int totalraiting, long mencount, int time, int year, int age, String img, String description, Country country) {
        this.name = name;
        this.genres = genres;
        this.persons = persons;
        this.totalraiting = totalraiting;
        this.mencount = mencount;
        this.time = time;
        this.year = year;
        this.age = age;
        this.img = img;
        this.description = description;
        this.country = country;
    }

    public Movie(String name, List<Genre> genres, List<Person> persons, List<Raiting> raitings, int totalraiting, long mencount, List<Comment> comments, int time, int year, int age, String img, String description, Country country) {
        this.name = name;
        this.genres = genres;
        this.persons = persons;
        this.raitings = raitings;
        this.totalraiting = totalraiting;
        this.mencount = mencount;
        this.comments = comments;
        this.time = time;
        this.year = year;
        this.age = age;
        this.img = img;
        this.description = description;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public List<Genre> getGenres() {return genres;}

    public void setGenres(List<Genre> genres) {this.genres = genres;}

    public double getTime() {return time;}

    public void setTime(int time) {this.time = time;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public Country getCountry() {return country;}
    public void setCountry(Country country) {this.country = country;}
    public List<Raiting> getRaitings() {
        return raitings;
    }

    public void setRaitings(List<Raiting> raitings) {
        this.raitings = raitings;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public void  setImg(String i){
        this.img=i;
    }
    public String getImg(){
        return img;
    }
}
