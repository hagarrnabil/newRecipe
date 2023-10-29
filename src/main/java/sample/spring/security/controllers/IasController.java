package sample.spring.security.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sample.spring.security.models.Project;

@RestController
public class IasController {

    @PostMapping("/iasUsers")
    void createUser() {

        String url = "https://aey0y39na.trial-accounts.ondemand.com/scim/Users";
        String localhost = "localhost:8080/iasUsers";
        String contentType = "'Content-Type: application/scim+json'";
        String authorization = "'Authorization: Basic @{{token}}'";
        String userData = "'{\n" +
                "  \"emails\": [\n" +
                "    {\n" +
                "      \"primary\": true,\n" +
                "      \"value\": \"abc@domain.com\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"active\":\"True\",\n" +
                "  \"name\": {\n" +
                "    \"familyName\": \"Muthaiah\",\n" +
                "    \"givenName\": \"Yogananda\"\n" +
                "  },\n" +
                "  \"schemas\": [\n" +
                "    \"urn:ietf:params:scim:schemas:core:2.0:User\"\n" +
                "  ],\n" +
                "  \"userName\": \"yoga\"\n" +
                "}'";


        String[] command = {"curl", "-X", "POST" + localhost + "-H" + contentType + authorization + "-d" + userData };

    }


}
