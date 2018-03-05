package org.smart.framework;

import org.smart.framework.annotation.Controller;
import org.smart.framework.annotation.HelperLoader;
import org.smart.framework.bean.Handler;
import org.smart.framework.helper.BeanHelper;
import org.smart.framework.helper.ConfigHelper;
import org.smart.framework.helper.ControllerHelper;
import org.smart.framework.util.CodecUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/5.
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)//what's this?
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //初始化相关Helper
        HelperLoader.init();
        //获取ServletContext (用于注册Servlet)
        ServletContext servletContext = config.getServletContext();
        //注册处理JSP的Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath()+"*");
        //注册处理静态资源默认的Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath()+"*");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方法与请求路径
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        //获取Action处理器
        Handler handler = ControllerHelper.getHandler(requestMethod,requestPath);
        if(handler != null){
            //获取Controller类及其Bean实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controlllerBean = BeanHelper.getBean(controllerClass);
            //创建请求参数
            Map<String ,Object> paramMap = new HashMap<String, Object>();
            Enumeration<String> paramNames = req.getParameterNames();
            while (paramNames.hasMoreElements()){
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName,paramValue);
            }
            //TODO
        }


    }


}
