package requests;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class AccessTokenRequest {

    @NonNull
    @Builder.Default
    @SerializedName("grant_type")
    private String grant_type = "password";

    @NonNull
    @SerializedName("username")
    private String username;

    @NonNull
    @SerializedName("password")
    private String password;
}
