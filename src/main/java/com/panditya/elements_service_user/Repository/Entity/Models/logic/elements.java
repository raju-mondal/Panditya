package com.panditya.elements_service_user.Repository.Entity.Models.logic;

import java.sql.Timestamp;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="elements",schema="dev")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class elements implements element {
    
    /* 
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="elements_gen",sequenceName="elements_seq_gen",initialValue=1,allocationSize=1)
    private long id;
    */

    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_gen")
    @GenericGenerator(name = "custom_gen", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, value = "_seq"),
                    @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "101"),
                    @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1")})
    private long id;
    
    /*
    ! Future use case with UUID 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private String id;
    
    */
    @Column(nullable=true)    
    private long createdByUser;

    @Column(nullable=true)
    private long approvedByUser;

    @Column(nullable=true)
    private long searchCount;

    @Column(nullable=true,name="all_tags")
    @Enumerated(EnumType.STRING)
    private Set<PandityaTags> allTags;
    
    @NotNull
    @Column(nullable=false,length=200)
    private String name;

    @Column(nullable=true)
    private String image;

    @Column(nullable=true,length=512)
    private Set<String> paraname;

    @Column(nullable=true,length=4096)
    private Set<String> parabody;

    @Column(nullable=true)
    private boolean approved;

    @Column(nullable=true)
    private boolean deleted;
    
    @CreationTimestamp
    @Column(name = "created_on", columnDefinition = "TIMESTAMP",nullable=true)
    private Timestamp created_on;
    
    
    @Column(nullable=true)
    private Timestamp last_updated;

    public elements(){}

    public elements(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
            @NotNull String name, String image, Set<String> paraname, Set<String> parabody, boolean approved,
            boolean deleted, Timestamp created_on, Timestamp last_updated) {
        this.id = id;
        this.createdByUser = createdByUser;
        this.approvedByUser = approvedByUser;
        this.searchCount = searchCount;
        this.allTags = allTags;
        this.name = name;
        this.image = image;
        this.paraname = paraname;
        this.parabody = parabody;
        this.approved = approved;
        this.deleted = deleted;
        this.created_on = created_on;
        this.last_updated = last_updated;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public long getCreatedByUser() {
        return createdByUser;
    }


    public void setCreatedByUser(long createdByUser) {
        this.createdByUser = createdByUser;
    }


    public long getApprovedByUser() {
        return approvedByUser;
    }


    public void setApprovedByUser(long approvedByUser) {
        this.approvedByUser = approvedByUser;
    }


    public long getSearchCount() {
        return searchCount;
    }


    public void setSearchCount(long searchCount) {
        this.searchCount = searchCount;
    }


    public Set<PandityaTags> getAllTags() {
        return allTags;
    }


    public void setAllTags(Set<PandityaTags> allTags) {
        this.allTags = allTags;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public Set<String> getParaname() {
        return paraname;
    }


    public void setParaname(Set<String> paraname) {
        this.paraname = paraname;
    }


    public Set<String> getParabody() {
        return parabody;
    }


    public void setParabody(Set<String> parabody) {
        this.parabody = parabody;
    }


    public boolean isApproved() {
        return approved;
    }


    public void setApproved(boolean approved) {
        this.approved = approved;
    }


    public boolean isDeleted() {
        return deleted;
    }


    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    public Timestamp getCreated_on() {
        return created_on;
    }


    public void setCreated_on(Timestamp created_on) {
        this.created_on = created_on;
    }


    public Timestamp getLast_updated() {
        return last_updated;
    }


    public void setLast_updated(Timestamp last_updated) {
        this.last_updated = last_updated;
    }

    

}
