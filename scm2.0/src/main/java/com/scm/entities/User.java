package com.scm.entities;

//import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations.Providers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	@Id
	private String userId;
	@Column(name = "user_name", nullable = false)
    private String name;
	@Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(columnDefinition = "TEXT")
    private String about;
    @Column(columnDefinition = "TEXT")
    private String profilePic;
    private String phoneNumber;
    //information
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;
    
    //SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB
    private Providers provider = Providers.SELF;
    private String providerUserId;
    
}
