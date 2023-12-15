package holdings.indsys.iLabel.demo;

import com.google.gson.Gson;
import holdings.indsys.iLabel.Master.CustomerSubMaster.State.State;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/demo-controller")
@Hidden
public class DemoController {

  @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @GetMapping("apiTest")
    public ResponseEntity<?> postApi() throws Exception {

      State state1 = new State("101", "desc", "Test");
      State state2 = new State("102", "desc", "Test");
      State state3 = new State("103", "desc", "Test");
      List<State> states = new ArrayList<>();
      states.add(state1);
      states.add(state2);
      states.add(state3);

      Gson gson = new Gson();
      String joinRequest = gson.toJson(states);

      String API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrYXJhbkBnbWFpbC5jb20iLCJpYXQiOjE3MDI1MzY0OTYsImV4cCI6MTcwMjYyMjg5Nn0.A2vWKrDAyePqhtM4I08oZLLlweYZ-9Kr6refoUyjRa8";
      HttpRequest postRequest = HttpRequest.newBuilder()
              .uri(new URI("http://localhost:9000/api/v1/master/state-code"))
              .header("Authorization", "Bearer "+ API_KEY)
              .POST(HttpRequest.BodyPublishers.ofString(joinRequest))
              .build();

      HttpResponse<?> postResponse;
      try (HttpClient httpClient = HttpClient.newHttpClient()) {
        postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
      }


      return ResponseEntity.ok(postResponse);
    }

}
