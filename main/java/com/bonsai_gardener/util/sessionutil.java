package com.bonsai_gardener.util;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;

public class sessionutil {
	public static void setAttribute(HttpServletRequest request, String key, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }
	
	public static Object getAttribute(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
        	System.out.println("SessionUtil: Session ID = " + session.getId());
            System.out.println("SessionUtil: GET key = " + key + " from session ID = " + session.getId());

            return session.getAttribute(key);
        }
        return null;
    }
	
	public static void removeAttribute(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(key);
        }
    }
	
	public static void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}

