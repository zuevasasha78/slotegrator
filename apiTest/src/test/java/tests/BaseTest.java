package tests;

import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import static helpers.FileHelpers.readFile;

public abstract class BaseTest {

    @Step("Проверка схемы")
    public void assertValidJsonScheme(
            String expected,
            ResponseBody actual
    ) {
        String file = readFile(expected);
        JSONObject jsonExpected = new JSONObject(file);
        JSONObject jsonActual = new JSONObject(actual.asString());
        try {
            SchemaLoader.load(jsonExpected).validate(jsonActual);
        } catch ( ValidationException assertions) {
            throw new AssertionError(assertions.getCausingExceptions() + " " + assertions);
        }
    }
}
