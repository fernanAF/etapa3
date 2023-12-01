package com.microservice.zuul.filters.headers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class HeaderPreFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(HeaderPreFilter.class);

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        // Obtener el tiempo de inicio de la solicitud del filtro anterior
        Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");

        // Agregar un encabezado personalizado a la solicitud
        ctx.addZuulRequestHeader("X-Tiempo-Inicio", tiempoInicio.toString());

        log.info(String.format("Encabezado X-Tiempo-Inicio agregado: %s", tiempoInicio));

        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }
}