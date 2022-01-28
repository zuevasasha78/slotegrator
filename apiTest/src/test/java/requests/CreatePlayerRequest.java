package requests;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import static helpers.RandomHelper.getRandomNumber;

@Data
@Builder
public class CreatePlayerRequest {

    @NonNull
    @Builder.Default
    @SerializedName("username")
    private String username = "player" + getRandomNumber(6);

    @NonNull
    @Builder.Default
    @SerializedName("password_change")
    private String passwordChange = "amFuZWRvZTEyMw=";

    @NonNull
    @Builder.Default
    @SerializedName("password_repeat")
    private String passwordRepeat = "amFuZWRvZTEyMw=";

    @NonNull
    @Builder.Default
    @SerializedName("email")
    private String email = getRandomNumber(6) + "@gmail.com";

    @SerializedName("name")
    private String name;

    @SerializedName("surname")
    private String surname;

    @SerializedName("currency_code")
    private String currency_code;
}
