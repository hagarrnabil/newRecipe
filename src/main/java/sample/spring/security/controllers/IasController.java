package sample.spring.security.controllers;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.IasUser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

@RestController
public class IasController {

    @PostMapping("/iasUsers")
    void createUser(@RequestBody IasUser ias) throws IOException {

        URL url = new URL ("https://aosfletgu.trial-accounts.ondemand.com/service/scim/Users");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/scim+json");
        String user = "7173d0ab-b32f-47b2-813e-ae783dae73bf";
        String password = "rwQ9_LbnS@JYQ235ehgoevnoXT6YJjJ";
        String auth = user + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);
        con.setRequestProperty("Authorization", authHeaderValue);
        con.setRequestProperty("Accept", "application/scim+json");
        con.setDoOutput(true);
        String jsonInputString = MessageFormat.format("{\n" +
                "  \"emails\": [\n" +
                "    {\n" +
                "      \"primary\": true,\n" +
                "      \"value\": \"{0}\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": {\n" +
                "    \"familyName\": \"{1}\",\n" +
                "    \"givenName\": \"{2}\"\n" +
                "  },\n" +
                "  \"schemas\": [\n" +
                "    \"urn:ietf:params:scim:schemas:core:2.0:User\"\n" +
                "  ],\n" +
                "  \"userName\": \"{3}\"\n" +
                "}",ias.getValue(),ias.getFamilyName(),ias.getGivenName(),ias.getUserName());

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


