package com.example.reimbursementcalculator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "organisation", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"}),
        @UniqueConstraint(columnNames = {"email"})
})
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties("registrationList")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String loginPassword;
    private String nip;
    private String address;
    private String city;
    private String postcode;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "organisation_roles",
    joinColumns = @JoinColumn(name = "organisation_Id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_Id", referencedColumnName = "id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "organisation", fetch = FetchType.EAGER)
    private List<RegistrationExpense> reservationList = new ArrayList<>();
    public Organisation(Long id, String name, String email, String loginPassword, String nip, String address, String city, String postcode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.loginPassword = loginPassword;
        this.nip = nip;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
    }

    public Organisation(String name, String nip, String address, String city, String postcode) {
        this.name = name;
        this.nip = nip;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
    }
}
