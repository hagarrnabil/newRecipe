package sample.spring.security.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sample.spring.security.models.Project;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;

@RestController
public class IasController {

    @PostMapping("/iasUsers")
    void createUser() throws IOException {

        String url = "'https://aey0y39na.trial-accounts.ondemand.com/scim/Users'";
        String contentType = "Content-Type: application/scim+json";
        String authorization = "Authorization: Basic Yzc1YWE3ZmUtOTg2OS00ZTI0LTkxNDQtNTMxYjZlYjU5OTc0OkBrenltblFCbUpLZnBITHh3cjM1UXFTSGtZUnR0Qm1vS3A=";
      //  String data = MessageFormat.format("{\n" +
        //        "  \"emails\": [\n" +
          //      "    {\n" +
            //    "      \"primary\": true,\n" +
              //  "      \"{0}\": \n" +
                //"    }\n" +
               // "  ],\n" +
               // "  \"name\": {\n" +
               // "    \"{1}\": ,\n" +
               // "    \"{2}\": \n" +
               // "  },\n" +
               // "  \"schemas\": [\n" +
               // "    \"urn:ietf:params:scim:schemas:core:2.0:User\"\n" +
              //  "  ],\n" +
               // "  \"{3}\": \n" +
               // "}",value, familyName, givenName, userName);

        String data = "{\n" +
                "  \"emails\": [\n" +
                "    {\n" +
                "      \"primary\": true,\n" +
                "      \"value\": \"hagar.nabil@solex.tech\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": {\n" +
                "    \"familyName\": \"Nabill\",\n" +
                "    \"givenName\": \"Hagarr\"\n" +
                "  },\n" +
                "  \"schemas\": [\n" +
                "    \"urn:ietf:params:scim:schemas:core:2.0:User\"\n" +
                "  ],\n" +
                "  \"userName\": \"Hagarr\"\n" +
                "}";
        String[] command = {"curl", "-X", "POST" + url + "-H" + contentType + authorization + "-d" + data};
        Process process = Runtime.getRuntime().exec(command);
        process.getInputStream();
    }
}


