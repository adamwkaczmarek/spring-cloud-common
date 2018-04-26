package home.samples.context;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class UserContextInterceptor implements ClientHttpRequestInterceptor {

    public ClientHttpResponse intercept(HttpRequest request, byte[] body,

        ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();

        if(!headers.containsKey(UserContext.CORRELATION_ID)) headers.add(UserContext.CORRELATION_ID, UserContextHolder.getContext().getCorrelationId());
        if(!headers.containsKey(UserContext.AUTH_TOKEN))headers.add(UserContext.AUTH_TOKEN, UserContextHolder.getContext().getAuthToken());
        if(!headers.containsKey(UserContext.USER_ID))headers.add(UserContext.USER_ID, UserContextHolder.getContext().getUserId());

        return execution.execute(request, body);

    }
}