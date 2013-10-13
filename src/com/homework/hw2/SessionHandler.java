/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homework.hw2;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Ets
 */
public class SessionHandler implements HttpSessionListener{

    public static int ACTIVE_SESSION_COUNT;
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ACTIVE_SESSION_COUNT++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ACTIVE_SESSION_COUNT--;
    }
    
}
