package com.rpm.web.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.rpm.web.social.Comment;
import com.rpm.web.social.Social;
import com.rpm.web.social.Thumb;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component @Lazy @Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userSeq")
@JsonIdentityReference(alwaysAsId = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERSEQ") @NotNull private Long userSeq;
    @Column(name = "USERID") @NotNull private String userid;
    @Column(name = "PASSWD") @NotNull private String passwd;
    @Column(name = "NAME") @NotNull private String name;
    @Column(name = "EMAIL") @NotNull private String email;
    @Column(name = "GENDER")  private String gender;
    @Column(name = "BIRTHMONTH")  private String birthMonth;
    @Column(name = "REGION")  private String region;

    @OneToMany(mappedBy = "userSeq", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Social> socials = new ArrayList<>();

    @OneToMany(mappedBy = "userSeq", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "userSeq", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Thumb> thumbs = new ArrayList<>();


   /* @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "USERSEQ")
    private List<Social> socials = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "USERSEQ")
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "USERSEQ")
    private List<Thumb> thumbs = new ArrayList<>();
*/
    @Builder
    private User(String userid, String passwd, String name, String email,
                 String gender, String birthMonth, String region) {
        Assert.hasText(userid, "userid must not be empty");
        Assert.hasText(passwd, "passwd must not be empty");
        Assert.hasText(name, "name must not be empty");
        Assert.hasText(email, "email must not be empty");
        Assert.hasText(gender);
        Assert.hasText(birthMonth);
        Assert.hasText(region);
        this.userid = userid;
        this.passwd = passwd;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birthMonth = birthMonth;
        this.region = region;
    }

}
