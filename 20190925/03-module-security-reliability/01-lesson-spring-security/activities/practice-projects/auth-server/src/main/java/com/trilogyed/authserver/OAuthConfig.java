package com.trilogyed.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager;

    @Autowired
    public OAuthConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("HTML5")
                .authorizedGrantTypes("password")
                .scopes("ROLE_LVL1", "ROLE_LVL2")
                .secret("$2a$10$rp51QSFk3wVbqrDzTISJ1u/MSJdr79iia3it8IK0q.Op6YhlMgbVe")
                .and()
                .inMemory()
                .withClient("Android")
                .authorizedGrantTypes("password")
                .scopes("ROLE_LVL1", "ROLE_LVL2", "ROLE_ADMIN")
                .secret("$2a$10$MNVjthVg/OcUlsVPK7afleOTsS7FLBq4GdSaCJEk.dZZ/IAmgvG1i")
                .and()
                .inMemory()
                .withClient("iPhone")
                .authorizedGrantTypes("password")
                .scopes("ROLE_LVL1", "ROLE_LVL2", "ROLE_ADMIN")
                .secret("$2a$10$j82kLmgARXN71PXMNTx3ZOflGjnCMmDO03/UoM2GenNFMr/np30mC");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager);
    }
}


//Clients:
//  * HTML5
//    * Grant Type: Password
//    * Scopes: ROLE_LVL1, ROLE_LVL2
//    * Secret (Bcrypt hashed): html_5_secret
//  * Android
//    - Grant Type: Password
//    - Scopes: ROLE_LVL1, ROLE_LVL2, ROLE_ADMIN
//    - Secret (Bcrypt hashed): android_secret
//  * iPhone
//    - Grant Type: Password
//    - Scopes: ROLE_LVL1, ROLE_LVL2, ROLE_ADMIN
//    - Secret (Bcrypt hashed): i_phone_secret
//* Users:
//  * jdoe
//    * Password (Bcrypt hashed): jdoeRoCkS!!!
//    * Authorities: ROLE_ADMIN
//  * ssmith
//    * Password (Bcrypt hashed): pwdPWDpwd!
//    * Authorities: ROLE_LVL1