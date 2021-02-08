package cc.mrbird.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationSucessHandler implements AuthenticationSuccessHandler {

     private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    //
//     @Autowired
//     private ObjectMapper mapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

//        System.err.println("---------------onAuthenticationSuccess---------------");

        //返回json(适合前后端分离)
//         response.setContentType("application/json;charset=utf-8");
//         response.getWriter().write(mapper.writeValueAsString(authentication));

        //返回前一个页面
//         SavedRequest savedRequest = requestCache.getRequest(request, response);
//         System.out.println(savedRequest.getRedirectUrl());
//         redirectStrategy.sendRedirect(request, response, savedRequest.getRedirectUrl());

        //返回index.html
        redirectStrategy.sendRedirect(request, response, "/index");
    }
}
