package com.xingjiejian.wenda.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 日志工具类
 * @author
 */
public class LogUtils {
    /**
     * 将异常堆栈信息转换成字符串，方便打印到日志文件中
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        //将异常堆栈信息添加到PrintWriter流中
        t.printStackTrace(pw);
        return sw.toString();
    }
}
