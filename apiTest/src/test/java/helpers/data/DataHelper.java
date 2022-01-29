package helpers.data;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import requests.AccessTokenRequest;
import requests.CreatePlayerRequest;
import requests.TokenRequest;

import static services.NetworkSpecification.requestSpec;

public class DataHelper {

    public static final String USER_NAME = "front_2d6b0a8391742f5d789d7d915755e09e";

    @Step("Получение токина")
    public static String getAuthToken() {
        Response response = requestSpec()
                .auth()
                .preemptive()
                .basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
                .body(TokenRequest.builder().build())
                .post("/v2/oauth2/token");
        return response.body().jsonPath().getString("access_token");
    }

    @Step("Создать игрока")
    public static Player createPlayer() {
        CreatePlayerRequest playerRequest = CreatePlayerRequest.builder().build();
        Response response = requestSpec()
                .header("Authorization", "Bearer " + getAuthToken())
                .body(playerRequest)
                .post("/v2/players");
        Player player = new Player();
        player.setId(response.body().jsonPath().getInt("id"));
        player.setUsername(playerRequest.getUsername());
        player.setPassword(playerRequest.getPasswordChange());
        return player;
    }

    @Step("Получить auth_token игрока")
    public static String getPlayerAuthToken(Player newPlayer) {
        AccessTokenRequest requestBody = AccessTokenRequest.builder()
                .username(newPlayer.getUsername())
                .password(newPlayer.getPassword())
                .build();
        Response response = requestSpec()
                .auth()
                .preemptive()
                .basic(USER_NAME, "")
                .body(requestBody)
                .post("/v2/oauth2/token");
        return response.body().jsonPath().getString("access_token");
    }
}
