// package com.HotelBooking.HotelBooking.ControllerTest;

// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.security.test.context.support.WithMockUser;
// import org.springframework.test.web.servlet.MockMvc;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// import com.HotelBooking.HotelBooking.Controller.HotelController;
// import com.HotelBooking.HotelBooking.Dtos.HotelData;
// import com.HotelBooking.HotelBooking.Entities.Hotel;
// import com.HotelBooking.HotelBooking.Services.HotelService;
// import com.fasterxml.jackson.databind.ObjectMapper;


// @WebMvcTest(HotelController.class)
// public class HotelControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//       @Mock
//     private HotelService hotelService; // Mock the HotelService

//     @InjectMocks
//     private HotelController hotelController; 

//     @Autowired
//     private ObjectMapper objectMapper;

//     // Test Case 1: Create Hotel - Success
//     @Test
//     @WithMockUser(roles = "ADMIN") // Mock the ADMIN role
//     void createHotel_Success() throws Exception {
//         // Create test data for Hotel
//         HotelData hotelData = new HotelData();
//         hotelData.setName("Hotel Paradise");
//         hotelData.setLocation("123 Main Street");
//         hotelData.setDescription("Luxury hotel");
//         hotelData.setAvailableRooms(10);
    
//         Hotel hotel = new Hotel();
//         // Mock the service method
//         Mockito.when(hotelService.CreateHotel(Mockito.any(HotelData.class)))
//                .thenReturn(hotel); // Return a new hotel entity for the test
    
//         // Perform POST request
//         mockMvc.perform(post("/hotels")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content(objectMapper.writeValueAsString(hotelData)))
//                 .andExpect(status().isCreated()) // HTTP 201
//                 .andExpect(content().json(objectMapper.writeValueAsString(hotel))); // Expect the returned hotel in response
//     }
    

//     // Test Case 2: Create Hotel - Validation Error (Missing Name)
//     @Test
//     void createHotel_ValidationError_MissingName() throws Exception {
//         HotelData hotelData = new HotelData();
//         hotelData.setName(""); // Invalid as @NotBlank is violated
//         hotelData.setLocation("123 Main Street");
//         hotelData.setDescription("Luxury hotel");
//         hotelData.setAvailableRooms(10);

//         mockMvc.perform(post("/hotels")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content(objectMapper.writeValueAsString(hotelData)))
//                 .andExpect(status().isBadRequest())
//                 .andExpect(jsonPath("$.name").value("Hotel name is required."));
//     }

//     // Test Case 3: Create Hotel - Validation Error (Invalid Rooms)
//     @Test
//     void createHotel_ValidationError_InvalidRooms() throws Exception {
//         HotelData hotelData = new HotelData();
//         hotelData.setName("Hotel Paradise");
//         hotelData.setLocation("123 Main Street");
//         hotelData.setDescription("Luxury hotel");
//         hotelData.setAvailableRooms(0); // Invalid as @Min(1) is violated

//         mockMvc.perform(post("/hotels")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content(objectMapper.writeValueAsString(hotelData)))
//                 .andExpect(status().isBadRequest())
//                 .andExpect(jsonPath("$.availableRooms").value("Available rooms must be at least 1."));
//     }

//     // Test Case 4: Create Hotel - Location Already Taken
//     @Test
//     void createHotel_LocationAlreadyExists() throws Exception {
//         HotelData hotelData = new HotelData();
//         hotelData.setName("Hotel Paradise");
//         hotelData.setLocation("123 Main Street");
//         hotelData.setDescription("Luxury hotel");
//         hotelData.setAvailableRooms(10);

//         // Simulate the scenario where a hotel with the same location already exists
//         Mockito.when(hotelService.CreateHotel(Mockito.any(HotelData.class)))
//                .thenThrow(new IllegalArgumentException("Hotel with the same address already exists."));

//         mockMvc.perform(post("/hotels")
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .content(objectMapper.writeValueAsString(hotelData)))
//                 .andExpect(status().isBadRequest()) // HTTP 409 for conflict
//                 .andExpect(content().string("Hotel with the same address already exists."));
//     }
// }
