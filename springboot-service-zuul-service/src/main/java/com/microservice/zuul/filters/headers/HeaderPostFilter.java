package com.microservice.zuul.filters.headers;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;

@Component
public class HeaderPostFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(HeaderPostFilter.class);

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();

        // Log de encabezados antes de la eliminación
        log.info("Encabezados antes de la eliminación de la respuesta:");
        printHeaders(response);

        // Eliminar encabezados sensibles de la respuesta
        response.setHeader("X-Sensible-Header", null);
        // Puedes agregar más encabezados según sea necesario

        // Log de encabezados después de la eliminación
        log.info("Encabezados después de la eliminación de la respuesta:");
        printHeaders(response);

        log.info("Encabezados sensibles eliminados de la respuesta");

        return null;
    }

    private void printHeaders(HttpServletResponse response) {
        if (response != null) {
            Collection<String> headerNames = response.getHeaderNames();
            if (headerNames != null) {
                for (String headerName : headerNames) {
                    Collection<String> headers = response.getHeaders(headerName);
                    for (String headerValue : headers) {
                        log.info(String.format("%s: %s", headerName, headerValue));
                    }
                }
            } else {
                log.warn("La colección de nombres de encabezados es nula.");
            }
        } else {
            log.warn("La respuesta es nula.");
        }
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 3;
    }
}
