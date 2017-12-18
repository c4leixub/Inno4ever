package com.zeetcode.systemDesign;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {
	private final static String DOMAIN = "http://tiny.url/";
    private static int ID = 0;
    private Map<Integer, String> urlMap = new HashMap<Integer, String>();
    private Map<String, String> customUrlMap = new HashMap<String, String>();
    
    
    /*
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    public String createCustom(String long_url, String key) {
        if (customUrlMap.containsKey(key)) {
            return "error";
        }
        
        if (urlMap.containsValue(long_url)
                || customUrlMap.containsValue(long_url)) {
            return "error";
        }
        
        customUrlMap.put(key, long_url);
        return DOMAIN + key;
    }

    /*
     * @param long_url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        
        if (customUrlMap.containsValue(long_url)
                || urlMap.containsValue(long_url)) {
            return "error";
        }
        
        int id = ID;
        ID++;
        urlMap.put(id, long_url);
        
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String path = "";
        while (id > 0) {
            path = chars.charAt(id % 62) + path;
            id = id / 62;
        }
        while (path.length() < 6) {
            path = "0" + path;
        }
        
        return DOMAIN + path;
    }

    /*
     * @param short_url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String short_url) {
        String path = short_url.substring(DOMAIN.length(), short_url.length());
        
        if (customUrlMap.containsKey(path)) {
            return customUrlMap.get(path);
        }
        
        int id = 0;
        for (int i = 0; i < path.length(); i++) {
            id = id * 62 + charToNum(path.charAt(i));
        }
        
        return urlMap.get(id);
    }
    
    private int charToNum(char c) {
        int re = 0; 
        if ('0' <= c && c <= '9') {
            re = c - '0';
        } else if ('a' <= c && c <= 'z') {
            re = c - 'a';
            re += 10;
        } else if ('A' <= c && c <= 'Z') {
            re = c - 'A';
            re += 36;
        }
        
        return re;
    }
}
