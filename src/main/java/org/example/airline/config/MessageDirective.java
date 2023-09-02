package org.example.airline.config;

import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

@Component
public class MessageDirective implements TemplateDirectiveModel {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String code = ((SimpleScalar) params.get("code")).getAsString();
        Locale locale = env.getLocale();

        String message = messageSource.getMessage(code, null, locale);
        env.getOut().write(message);
    }
}