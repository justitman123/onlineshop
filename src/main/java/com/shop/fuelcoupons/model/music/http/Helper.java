package com.shop.fuelcoupons.model.music.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public final class Helper {

    /**
     * Private constructor to prevent instantiation.
     */
    private Helper() {

        // do nothing
    }

    /**
     * This method is used to get a parameter string from the Map.
     *
     * @param params
     *            key-value parameters
     * @return A String containing the url parameter.
     * @throws MusixMatchException
     */
    public static String getURLString(String methodName,
                                      Map<String, Object> params) throws MusixMatchException {
        StringBuilder paramString = new StringBuilder();

        paramString.append(methodName).append("?");

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            try {
                paramString.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(),
                        "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new MusixMatchException("Problem encoding "
                        + entry.getValue(), e);
            }

            paramString.append("&");
        }

        paramString = new StringBuilder(paramString.substring(0, paramString.length() - 1));

        return paramString.toString();
    }
}
