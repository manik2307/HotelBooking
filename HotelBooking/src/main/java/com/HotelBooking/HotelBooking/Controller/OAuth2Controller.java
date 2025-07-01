package com.HotelBooking.HotelBooking.Controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2Controller {

    @GetMapping("/oauth2/success")
    public String oauth2Success(OAuth2AuthenticationToken authentication) {
        OidcUser user = (OidcUser) authentication.getPrincipal();
        String email = user.getEmail();
        String name = user.getFullName();
        return "Welcome, " + name + "! Your email is " + email + ". You have successfully logged in with Okta.";
    }
}