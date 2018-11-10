package malikin.github.io.jared;

import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTests {

    private final static String HOST = "http://localhost";

    @LocalServerPort
    private int port;

    @Test
    public void getNotesList() {
        given().when().get(HOST + ":" + port + "/notes/all").then().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void postNewNoteAndGet() {
        final String noteBody = "{\"name\": \"testNotePost\"}";

        given().when().body(noteBody).contentType(ContentType.JSON)
                .post(HOST + ":" + port + "/notes/").then().statusCode(HttpStatus.CREATED.value());
        given().when()
                .get(HOST + ":" + port + "/notes?name=testNotePost").then().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void postNewNoteInvalid() {
        final String noteBody = "{\"name\": \"\"}";

        given().when().body(noteBody).contentType(ContentType.JSON)
                .post(HOST + ":" + port + "/notes/").then().statusCode(HttpStatus.BAD_REQUEST.value());
    }
}
