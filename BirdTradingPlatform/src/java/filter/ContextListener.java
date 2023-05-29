/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import utils.PropertiesFileHelper;

/**
 * Web application lifecycle listener.
 *
 * @author Admin
 */
public class ContextListener implements ServletContextListener {

    // hỗ trợ bắt được thời điểm trước khi ứng dụng undeploy và vừa khởi tạo
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       ServletContext context = sce.getServletContext();
        // coppy trong web.xml
        String siteMapPath = context.getInitParameter("SITEMAP_PROPERTIES_FILE_PATH");
        Properties siteMapProperty = 
                PropertiesFileHelper.getProperties(context, 
                                                siteMapPath);
        context.setAttribute("SITE_MAP", siteMapProperty);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
