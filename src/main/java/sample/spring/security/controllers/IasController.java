package sample.spring.security.controllers;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.IasUser;
import sample.spring.security.models.IasUser;
import sample.spring.security.models.Project;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

@RestController
public class IasController {

    @RequestMapping(method = RequestMethod.POST, value = "/ias/iasUsers")
    @ResponseBody
    void createUser(@RequestBody IasUser ias) throws IOException {

        URL url = new URL ("https://aey0y39na.trial-accounts.ondemand.com/service/scim/Users");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/scim+json");
        String user = "c75aa7fe-9869-4e24-9144-531b6eb59974";
        String password = "@kzymnQBmJKfpHLxwr35QqSHkYRttBmoKp";
        String auth = user + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);
        con.setRequestProperty("Authorization", authHeaderValue);
        con.setRequestProperty("Accept", "application/scim+json");
        con.setDoOutput(true);
        String jsonInputString = "{\n" +
                "  \"emails\": [\n" +
                "    {\n" +
                "      \"primary\": true,\n" +
                "      \"value\":" + ias.getValue() + "\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": {\n" +
                "    \"familyName\":" + ias.getFamilyName() + ",\n" +
                "    \"givenName\":" + ias.getGivenName() + "\n" +
                "  },\n" +
                "  \"schemas\": [\n" +
                "    \"urn:ietf:params:scim:schemas:core:2.0:User\"\n" +
                "  ],\n" +
                "  \"userName\":" + ias.getUserName() + "\n" +
                "}";

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
}


