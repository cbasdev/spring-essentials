package api.essentials.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Component
public class ExecutionTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger= LoggerFactory.getLogger(ExecutionTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Tiempo transcurrido interceptor: preHandle ->");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        Random random = new Random();
        int timeout = random.nextInt(500);
        Thread.sleep(timeout);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        long startTime = (Long) request.getAttribute("startTime");
        long totalTime = endTime - startTime;

        if(modelAndView != null) {
            modelAndView.addObject("totalTime", totalTime);
        }

        logger.info("Tiempo transcurrido: " + totalTime);
        logger.info("Tiempo transcurrido interceptor: postHandle ->");

    }
}
