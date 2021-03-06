package org.aptech.t2004e.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.aptech.t2004e.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.context.ServletContextAware;

public class BaseController implements ServletContextAware {

	@Autowired
	protected AppProperties appProperties;
	
    private ServletContext servletContext;
    private MessageSourceAccessor messages;
    
    public static final String ERRORS_SESSION = "errors";
    public static final String MESSAGES_SESSION = "messages";
    
    List<String> errorList = null;
    List<String> messageList = null;
    
	public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    protected ServletContext getServletContext() {
        return servletContext;
    }
    
    @Autowired
    public void setMessages(MessageSource messageSource) {
        messages = new MessageSourceAccessor(messageSource);
    }
    public String getText(String msgKey, Locale
	 locale) {
        return messages.getMessage(msgKey, locale);
    }

    public String getText(String msgKey, String arg, Locale locale) {
        return getText(msgKey, new Object[] { arg }, locale);
    }

    public String getText(String msgKey,
	Object[] args, Locale locale) {
        return messages.getMessage(msgKey, args, locale);
    }    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addError(HttpServletRequest request, String error) {
    	List errors = (List) request.getSession().getAttribute(ERRORS_SESSION);
    	if (errors == null) {
    		errors = new ArrayList<>();
    	}
        errors.add(error);
        request.getSession().setAttribute(ERRORS_SESSION, errors);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addMessage(HttpServletRequest request, String msg) {
    	List messages = (List) request.getSession().getAttribute(MESSAGES_SESSION);
    	if (messages == null) {
    		messages = new ArrayList<>();
    	}
    	messages.add(msg);
    	request.getSession().setAttribute(MESSAGES_SESSION, messages);
    }

    
    
}

