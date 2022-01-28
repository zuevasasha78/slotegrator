package requests;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenRequest {

    @Builder.Default
    @SerializedName("grant_type")
    private String grantType = "client_credentials";
    @Builder.Default
    @SerializedName("scope")
    private String scope = "guest:default";
}
