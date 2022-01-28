package tests;

import helpers.data.Player;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import requests.AccessTokenRequest;
import requests.CreatePlayerRequest;
import requests.TokenRequest;

import static helpers.RandomHelper.getRandomNumber;
import static helpers.data.DataHelper.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static services.NetworkSpecification.requestSpec;

public class PlayerTest extends BaseTest {

    @Description("Тест на провекру токена")
    @Test
    public void getTokenTest() {
        TokenRequest requestBody = TokenRequest.builder().build();
        Response response = requestSpec()
                .auth()
                .preemptive()
                .basic(USER_NAME, "")
                .body(requestBody)
                .post("/v2/oauth2/token");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(response.statusCode()).as("Код ответа не 200").isEqualTo(200);
        softly.assertThat(response.body().jsonPath().getString("access_token"))
                .as("Ответ не содержит access_token").isNotBlank();
        softly.assertAll();
    }

    @Description("Зарегистрировать игрока")
    @Test
    public void registerPlayerTest() {
        String playerName = "player" + getRandomNumber(6);
        CreatePlayerRequest player = CreatePlayerRequest.builder()
                .username(playerName)
                .passwordChange("amFuZWRvZTEyMw=")
                .passwordRepeat("amFuZWRvZTEyMw=")
                .email(playerName + "@gmail.com")
                .name("Ivan")
                .surname("Ivanov")
                .currency_code("RUB")
                .build();

        Response response = requestSpec()
                .header("Authorization", "Bearer " + getAuthToken())
                .body(player)
                .post("/v2/players");

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(response.statusCode()).as("Код ответа не 201").isEqualTo(201);
        //Ответ соответствует документации (не увидела эту документацию так что просто проверила username и схему)
        softly.assertThat(response.body().jsonPath().getString("username"))
                .as("Имя игрока не соответствует указанному").isEqualTo(playerName);
        softly.assertAll();
        assertValidJsonScheme("jsonschemas/createPlayer.json", response.body());
    }

    @Description("Авторизоваться под созданным игроком")
    @Test
    public void authCreatedPlayerTest() {
        Player newPlayer = createPlayer();
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
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(response.statusCode()).as("Код ответа не 200").isEqualTo(200);
        softly.assertThat(response.body().jsonPath().getString("access_token"))
                .as("Ответ не содержит access_token").isNotBlank();
        softly.assertAll();
    }

    @Description("Запросить данные профиля игрока")
    @Test
    public void getPlayerProfileTest() {
        Player newPlayer = createPlayer();
        String authToken = getPlayerAuthToken(newPlayer);

        Response response = requestSpec()
                .header("Authorization", "Bearer " + authToken)
                .get("/v2/players/" + newPlayer.getId());

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(response.statusCode()).as("Код ответа не 200").isEqualTo(200);
        softly.assertThat(response.body().jsonPath().getInt("id"))
                .as("id игрка не соответствует указанному").isEqualTo(newPlayer.getId());
        softly.assertAll();
        assertValidJsonScheme("jsonschemas/playerProfile.json", response.body());
    }

    @Description("Запросить данные другого игрока")
    @Test
    public void getAnotherPlayerTest() {
        Player newPlayer = createPlayer();
        String authToken = getPlayerAuthToken(newPlayer);

        Response response = requestSpec()
                .header("Authorization", "Bearer " + authToken)
                .get("/v2/players/" + getRandomNumber(7));
        assertThat(response.statusCode()).as("Код ответа не 404").isEqualTo(404);
    }
}
