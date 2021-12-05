package com.mario.pokeapi.aspects;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import com.mario.pokeapi.entities.Request;
import com.mario.pokeapi.services.RequestService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class PokemonRequestAspect {

    @Autowired
    private RequestService service;

    @Before("execution(* com.mario.pokeapi.endpoints.*.*(..))")
    public void before(JoinPoint joinPoint) {
        HttpServletRequest servletRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Request request = new Request();
        request.setIp(getRequestIp(servletRequest));
        request.setFecha(LocalDate.now());
        request.setMetodo(joinPoint.getSignature().toShortString());
        service.save(request);
    }

    private String getRequestIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}
