package home.samples.context;


public class UserContext {


    public static final String CORRELATION_ID = "correlation-id";
    public static final String AUTH_TOKEN = "Authorization";
    public static final String USER_ID = "user-id";

    private String correlationId = new String();
    private String authToken = new String();
    private String userId = new String();

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {

        this.correlationId = correlationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}