package com.HotelBooking.HotelBooking.Controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.HotelBooking.HotelBooking.Entities.Hotel;

@Controller
public class HomeController {

   @GetMapping("/")
public String index(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
    // Example hotels
  // Example usage in HomeController
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    // System.out.println("Current authentication: " + auth);
    // System.out.println("Is authenticated: " + auth.isAuthenticated());
    // System.out.println("Principal: " + auth.getPrincipal());
List<Hotel> hotels = List.of(
    new Hotel(1L, "Grand Palace", "New York", "Luxury hotel in NY", 10, null),
    new Hotel(2L, "Sea View Resort", "Goa", "Beachside resort in Goa", 5, null),
    new Hotel(3L, "Mountain Retreat", "Manali", "Cozy retreat in Manali", 7, null)
);
    model.addAttribute("hotels", hotels);

    if (oidcUser != null) {
        model.addAttribute("profile", oidcUser.getClaims());
    }
    return "index";
}
}