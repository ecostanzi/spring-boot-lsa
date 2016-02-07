package org.booty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Enrico Costanzi
 */
@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

//    @Value("${debug}") fixme
    private boolean debug;

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    ErrorJson error(HttpServletRequest request, HttpServletResponse response) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring.
        // Here we just define response body.
        return new ErrorJson(response.getStatus(),  getErrorAttributes(request, debug));
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> exceptionDetails = this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
        Throwable error = errorAttributes.getError(requestAttributes);
        if(error != null){
            String detail = error.getMessage();
            String localizedDetails= error.getLocalizedMessage();
            exceptionDetails.put("details", detail);
            exceptionDetails.put("localizedDetails", localizedDetails);
        }

        return exceptionDetails;
    }

    private static class ErrorJson {

        public Integer status;
        public String error;
        public String message;
        public String timeStamp;
        public String trace;

        public ErrorJson(int status, Map<String, Object> errorAttributes) {
            this.status = status;
            this.error = (String) errorAttributes.get("error");
            this.message = (String) errorAttributes.get("message");
            this.timeStamp = errorAttributes.get("timestamp").toString();
            this.trace = (String) errorAttributes.get("trace");
        }

    }
}

