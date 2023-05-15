package com.interceptors.interceptor;

import java.io.IOException;

import com.sgt.gts.payments.utils.SanetizeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;


public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        logRequest(request, body);

        return execution.execute(request, body);
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        LOGGER.info("===========================request begin================================================");
        LOGGER.info("URI         : {}", request.getURI());
        LOGGER.info("Method      : {}", request.getMethod());
        LOGGER.info("Headers     : {}", SanetizeUtils.preventionLogForging(String.valueOf(request.getHeaders())));
        LOGGER.info("Request body: {}", new String(body, "UTF-8"));
        LOGGER.info("==========================request end================================================");

    }
}
