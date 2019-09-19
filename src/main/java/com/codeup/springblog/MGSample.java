package com.codeup.springblog;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/")
public class MGSample {

    final static String API_KEY = "";
    final static String DOMAIN_NAME = "mg.dnohomework.com";

    @PostMapping("email")
    public static JsonNode sendSimpleMessage() throws UnirestException {

        Mailgun mg = new Mailgun();
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/"+ DOMAIN_NAME +"/messages")
			.basicAuth("api", API_KEY )
                .queryString("from", "Excited User <USER@dnohomework.COM>")
                .queryString("to", "derek.noblej@gmail.com")
                .queryString("subject", "hello")
                .queryString("text", "testing")
                .asJson();
        return request.getBody();
    }


}
