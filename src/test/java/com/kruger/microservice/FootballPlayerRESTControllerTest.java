package com.kruger.microservice;

import org.springframework.http.HttpEntity;
//import java.net.http.HttpHeaders;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jayway.jsonpath.JsonPath;
import com.kruger.microservice.model.FootBallPlayer;

import net.minidev.json.JSONArray;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

import java.io.IOException;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = MicroserviceApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FootballPlayerRESTControllerTest {

	private final HttpHeaders headers = new HttpHeaders();
	private final TestRestTemplate restTemplate = new TestRestTemplate();
	
	@LocalServerPort
	private int port; //puerto para la uri de la prueba
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	
	@Test
	 public void test_1_FindAll() throws IOException {
		System.out.println("findAll");
		//obtener datos de la api
		HttpEntity<String> entity = new HttpEntity<>(null,headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/footballplayer"),
				HttpMethod.GET, entity, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		JSONArray jsonArray = JsonPath.read(response.getBody(),"$.[*]");
        assertThat(jsonArray).isNotNull();
        assertThat(jsonArray.size()).isGreaterThan(0);
		assertThat(30).isEqualTo(jsonArray.size());
	}

	@Test
    public void test_2_Create() {
        System.out.println("create");
        FootBallPlayer player = new FootBallPlayer("Mauro", "Vocale", 38, "Juventus", "central midfielder", new BigInteger("100"));

        HttpEntity<FootBallPlayer> entity = new HttpEntity<>(
                player, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/footballplayer/save"),
                HttpMethod.POST, entity, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(
                "{\"id\":35,\"name\":\"Mauro\",\"surname\":\"Vocale\",\"age\":38,\"team\":\"Juventus\",\"position\":\"central midfielder\",\"price\":100}");

    }
	
	@Test
    public void test_3_Edit() {
        System.out.println("edit");

        ResponseEntity<FootBallPlayer> footballPlayer
                = restTemplate.getForEntity(createURLWithPort(
                        "/footballplayer/get/24"), FootBallPlayer.class); //cargando el dato
        if (footballPlayer != null && footballPlayer.getBody() != null) {
            footballPlayer.getBody().setPrice(new BigInteger("150")); //editando
            HttpEntity<FootBallPlayer> requestEntity = new HttpEntity<>(
                    footballPlayer.getBody());
            System.out.println("requestEntity" + requestEntity);
            ResponseEntity<FootBallPlayer> responsePut = restTemplate.exchange(
                    createURLWithPort("/footballplayer/update/24"),
                    HttpMethod.PUT, requestEntity,
                    FootBallPlayer.class);

            assertThat(responsePut.getStatusCode()).isEqualTo(HttpStatus.OK);
            assertThat(BigInteger.valueOf(150)).isEqualTo(responsePut.getBody().
                    getPrice());
        }

    }

    @Test
    public void test_4_Find() {
        System.out.println("find");
        ResponseEntity<FootBallPlayer> footballPlayer
                = restTemplate.getForEntity(createURLWithPort(
                        "/footballplayer/get/24"), FootBallPlayer.class);
        System.out.println("VALUE IN FIND: " + footballPlayer.getBody());
        assertThat(footballPlayer.getStatusCode()).isEqualTo(HttpStatus.OK);
        if (footballPlayer != null && footballPlayer.getBody() != null) {
            assertThat(footballPlayer.getBody().getName()).isEqualTo("Mauro");
            assertThat(footballPlayer.getBody().getSurname()).
                    isEqualTo("Vocale");
            assertThat(footballPlayer.
                    getBody().getPrice()).isEqualTo(BigInteger.valueOf(150));
        }

    }
    
    @Test
    public void test_5_Remove() {
        System.out.println("remove");
        ResponseEntity<FootBallPlayer> responseDelete = restTemplate.exchange(
                createURLWithPort(
                        "/footballplayer/delete/34"), HttpMethod.DELETE, null, FootBallPlayer.class);

        assertThat(responseDelete.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

	
	
	
}
