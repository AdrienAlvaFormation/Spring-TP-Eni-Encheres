package fr.eni.springtpeniencheres.security;

import fr.eni.springtpeniencheres.bo.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UtilisateurAuth implements UserDetails {
    // attribut qui va contenir un utilisateur
    private Utilisateur utilisateur;

    /**
     * getAuthorities() => doit renvoyer la liste des autorisations de notre UtilisateurAuth
     * Si jamais notre utilisateur a l'attribut "admin" à true => role "admin", sinon : role "user"
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        System.out.println("UtilisateurAuth : " + utilisateur);

        if (utilisateur.getAdministrateur()) {
            // Légère différence entre authorities et rôles : autorisation "ROLE_admin" = rôle "admin"
            return List.of(new SimpleGrantedAuthority("ROLE_admin"));
        }
        else {
            return List.of(new SimpleGrantedAuthority("ROLE_user"));
        }
    }

    /**
     * Password = mot de passe de notre Utilisateur
     */
    @Override
    public String getPassword() {
        return this.utilisateur.getMotDePasse();
    }

    /**
     * Username = pseudo de notre Utilisateur
     */
    @Override
    public String getUsername() {
        return this.utilisateur.getPseudo();
    }


    /**
     * Est ce que le compte n'est pas expiré
     * On retourne true tout le temps : pas de politique d'expiration des comptes
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    /**
     * Est ce que le compte est bien non bloqué
     * On retourne true tout le temps : pas de politique de blocage des utilisateurs
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    /**
     * Est ce que l'utilisateur a un mot de passe non expiré
     * On retourne true tout le temps : pas de politique d'expiration de mot de passe
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Est ce que l'utilisateur est actif
     * On retourne true tout le temps : tous nos utilisateurs  sont actifs
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
