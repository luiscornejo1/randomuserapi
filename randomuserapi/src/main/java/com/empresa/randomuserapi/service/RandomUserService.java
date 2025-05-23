package com.empresa.randomuserapi.service;

import com.empresa.randomuserapi.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandomUserService {

    private final String API_URL = "https://randomuser.me/api/?results=10";

    public List<UserDTO> fetchUsers() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(API_URL, String.class);

        JSONObject json = new JSONObject(response);
        JSONArray results = json.getJSONArray("results");

        List<UserDTO> users = new ArrayList<>();

        for (int i = 0; i < results.length(); i++) {
            JSONObject u = results.getJSONObject(i);
            UserDTO user = new UserDTO();

            String fullName = u.getJSONObject("name").getString("first") + " " +
                              u.getJSONObject("name").getString("last");

            String gender = u.getString("gender");
            String location = u.getJSONObject("location").getString("country");
            String email = u.getString("email");
            String birthDate = u.getJSONObject("dob").getString("date").substring(0, 10);
            String picture = u.getJSONObject("picture").getString("medium");

            user.setFullName(fullName);
            user.setGender(gender);
            user.setLocation(location);
            user.setEmail(email);
            user.setBirthDate(birthDate);
            user.setPicture(picture);

            users.add(user);
        }

        return users;
    }
}
