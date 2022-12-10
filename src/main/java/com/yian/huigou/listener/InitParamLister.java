package com.yian.huigou.listener;

import com.yian.huigou.commons.SystemParamTool;
import com.yian.huigou.service.SystemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-08-20:23
 */
@WebListener
public class InitParamLister implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(context);
        SystemParamService paramService = wac.getBean(SystemParamService.class);
        String staticSource = paramService.findSystemParamValueByParamName(SystemParamTool.STATIC_SOURCE);
        String mainImg = paramService.findSystemParamValueByParamName(SystemParamTool.MAIN_IMG);
        String mainLogo = paramService.findSystemParamValueByParamName(SystemParamTool.MAIN_LOGO);
        String smallLogo = paramService.findSystemParamValueByParamName(SystemParamTool.SMALL_LOGO);
        context.setAttribute("static_source", staticSource);
        context.setAttribute("main_img", mainImg);
        context.setAttribute("main_logo", mainLogo);
        context.setAttribute("small_logo", smallLogo);
        System.out.println("初始化完成......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
