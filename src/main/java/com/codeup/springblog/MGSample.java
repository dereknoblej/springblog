package com.codeup.springblog;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/")
public class MGSample {

    final static String API_KEY = "";
    final static String DOMAIN_NAME = "mg.dnohomework.com";

    @PostMapping("email")
    public static JsonNode sendSimpleMessage(@RequestParam(name = "from") String from, @RequestParam(name = "to") String to, @RequestParam(name = "subject") String subject, @RequestParam(name = "text") String text) throws UnirestException {
        System.out.println(from);
        System.out.println(to);
        System.out.println(subject);
        System.out.println(text);
        Mailgun mg = new Mailgun();
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/"+ DOMAIN_NAME +"/messages")
			.basicAuth("api", API_KEY )

                .queryString("from",  from + " <USER@dnohomework.COM>")
                .queryString("to", "derek.noblej@gmail.com")
                .queryString("subject", subject)
                .queryString("text", text)
                .asJson();
        return request.getBody();
    }


}
