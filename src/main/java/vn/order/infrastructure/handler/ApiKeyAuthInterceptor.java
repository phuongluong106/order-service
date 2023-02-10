package vn.order.infrastructure.handler;

import java.io.IOException;


import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Component
public class ApiKeyAuthInterceptor implements ClientHttpRequestInterceptor {

    private String apiKey;

    public ApiKeyAuthInterceptor(String apiKey) {
        this.apiKey = apiKey;
    }

    @NotNull
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add("x-api-key", apiKey);
        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }
}
