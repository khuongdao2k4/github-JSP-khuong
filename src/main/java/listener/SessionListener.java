package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.ServletContext;

@WebListener
public class SessionListener implements HttpSessionListener {
    private static int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        synchronized (SessionListener.class) {
            sessionCount++;
            updateSessionCount(se);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        synchronized (SessionListener.class) {
            if (sessionCount > 0) sessionCount--;
            updateSessionCount(se);
        }
    }

    private void updateSessionCount(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        context.setAttribute("sessionCount", sessionCount);
    }
}
