package com.xsw.construct.common.log;


/**
 * @author ShiWei.Xu
 * @className
 * @description
 * @date create in 9:41 2020/6/29
 **/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class LoggerUtil {
    private static Map<String, Logger> loggerMap = new HashMap();

    public LoggerUtil() {
    }

    public static void debug(Object message) {
        String className = getClassName();
        Logger log = getLogger(className);
        if (log.isDebugEnabled()) {
            log.debug(message == null ? "null" : message.toString());
        }

    }

    public static void debug(String tag, Object message) {
        String className = getClassName();
        Logger log = getLogger(className);
        if (log.isDebugEnabled()) {
            log.debug("【" + tag + "】" + message);
        }

    }

    public static void debug(String template, Object... parameters) {
        String className = getClassName();
        Logger log = getLogger(className);
        if (log.isDebugEnabled()) {
            log.debug(getMessage(template, parameters));
        }

    }

    public static void info(Object message) {
        String className = getClassName();
        Logger log = getLogger(className);
        if (log.isInfoEnabled()) {
            log.info(message.toString());
        }

    }

    public static void info(String template, Object... parameters) {
        String className = getClassName();
        Logger log = getLogger(className);
        if (log.isInfoEnabled()) {
            log.info(getMessage(template, parameters));
        }

    }

    public static void warn(Object message) {
        String className = getClassName();
        Logger log = getLogger(className);
        if (log.isWarnEnabled()) {
            log.warn(message.toString());
        }

    }

    public static void warn(String template, Object... parameters) {
        String className = getClassName();
        Logger log = getLogger(className);
        if (log.isWarnEnabled()) {
            log.warn(getMessage(template, parameters));
        }

    }

    public static void error(Object message, Exception e) {
        String className = getClassName();
        Logger log = getLogger(className);
        if (log.isErrorEnabled()) {
            log.error(message.toString(), e);
        }

    }

    public static void error(Object message) {
        String className = getClassName();
        Logger log = getLogger(className);
        if (log.isErrorEnabled()) {
            log.error(message.toString());
        }

    }

    public static void error(String template, Exception e, Object... parameters) {
        String className = getClassName();
        Logger log = getLogger(className);
        if (log.isErrorEnabled()) {
            log.error(getMessage(template, parameters), e);
        }

    }

    private static String getClassName() {
        Throwable th = new Throwable();
        StackTraceElement[] stes = th.getStackTrace();
        StackTraceElement ste = stes[2];
        return ste.getClassName();
    }

    private static Logger getLogger(String className) {
        Logger log = null;
        if (loggerMap.containsKey(className)) {
            log = (Logger) loggerMap.get(className);
        } else {
            try {
                log = LoggerFactory.getLogger(Class.forName(className));
                loggerMap.put(className, log);
            } catch (ClassNotFoundException var3) {
                var3.printStackTrace();
            }
        }

        return log;
    }

    private static String getMessage(String template, Object... parameters) {
        return MessageFormat.format(template, parameters);
    }
}
