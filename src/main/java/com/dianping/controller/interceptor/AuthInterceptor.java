package com.dianping.controller.interceptor;

import com.dianping.utils.CommonUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by byebyejude on 2017/10/9.
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      if(CommonUtil.contains(request.getSession(),request.getServletPath(),request.getMethod())){
       return true;
      }
//        if (request.getHeader("x-requested-with") != null) {
//           String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
//            response.setHeader("url", basePath + "/login/noAuth");
//        } else {
//           request.getRequestDispatcher("/login/noAuth").forward(request, response);
//        }
     return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
