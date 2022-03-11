package org.aptech.t2004e.util;


import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.stereotype.Component;

import freemarker.cache.StringTemplateLoader;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FreeMarkerHelper {
	
	public static String renderToString(String source, Map<String, Object> model) throws IOException, TemplateException {
		log.info("entering renderToString()...");
		
		StringTemplateLoader templateLoader = new StringTemplateLoader();
		templateLoader.putTemplate("template", source);
		
		Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		config.setTemplateLoader(templateLoader);
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		config.setObjectWrapper(new BeansWrapper(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));		
		config.setDefaultEncoding(StandardCharsets.UTF_8.name());
		
		return processTemplateIntoString(config.getTemplate("template"), model);
	}
	
	public static String processTemplateIntoString(Template template, Object model) throws IOException, TemplateException {
		log.info("entering processTemplateIntoString()...");
		
	    try (Writer writer = new StringWriter()) {
	        template.process(model, writer);
	        return writer.toString();
	    }		
	}
}
