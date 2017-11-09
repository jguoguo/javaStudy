/*
 * Created on 2004-10-16
 *
 * http://www.open-v.com 提供代码的维护工作
 */
package com.openv.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class HelloWorld implements IHelloWorld {
    protected static final Log log = LogFactory.getLog(HelloWorld.class);

    public String getContent(String helloworld) {
        log.info(helloworld);

        return helloworld;
    }
}
