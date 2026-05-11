package com.mahrach.loubna.vehiclerental.entities;

import com.mahrach.loubna.vehiclerental.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utilisateurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "motdepasse")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String motdepasse;
    
    @Column(unique = true)
    private String email;
    
    private String nom;
    private String prenom;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    private Boolean enabled = true;
}
