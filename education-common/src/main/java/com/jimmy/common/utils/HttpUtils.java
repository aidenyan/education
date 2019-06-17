package com.jimmy.common.utils;


import org.apache.commons.beanutils.ConvertUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.Asserts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author mapengwei
 * @version V1.0
 * @Title: HttpUtils.java
 * @Package net.showcoo.utils
 * @Description: http工具类
 * @date 2015年12月1日 下午4:25:00
 */
public class HttpUtils {

    private HttpUtils() {
    }

    /**
     * POST请求
     *
     * @param url          URL
     * @param parameterMap 请求参数
     * @param headerMap    设置header
     * @return 返回结果
     */
    public static String post(String url, Map<String, Object> parameterMap, Map<String, Object> headerMap) {
        Asserts.notBlank(url, "url is null");
        String siteUrl = StringUtils.lowerCase(url);
        if (siteUrl.startsWith("https")) {
            return postSSL(siteUrl, parameterMap, headerMap);
        }
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(url);
            if (null != headerMap && !headerMap.isEmpty()) {
                for (Iterator<String> iter = headerMap.keySet().iterator(); iter.hasNext(); ) {
                    String name = (String) iter.next();
                    String value = headerMap.get(name).toString();
                    httpPost.setHeader(name, value);
                }
            }
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            if (parameterMap != null) {
                for (Entry<String, Object> entry : parameterMap.entrySet()) {
                    String name = entry.getKey();
                    String value = ConvertUtils.convert(entry.getValue());
                    if (StringUtils.isNotEmpty(name)) {
                        nameValuePairs.add(new BasicNameValuePair(name, value));
                    }
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
            EntityUtils.consume(httpEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String postSSL(String url, Map<String, Object> parameterMap, Map<String, Object> headerMap) {
        Asserts.notBlank(url, "url is null");
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(1000).build();
        HttpPost httpPost = null;
        try {
            SSLContext sslContext = SSLContexts.createDefault();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            httpPost = new HttpPost(url);
            if (null != headerMap && !headerMap.isEmpty()) {
                for (Iterator<String> iter = headerMap.keySet().iterator(); iter.hasNext(); ) {
                    String name = (String) iter.next();
                    String value = headerMap.get(name).toString();
                    httpPost.setHeader(name, value);
                }
            }
            httpPost.setConfig(requestConfig);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            if (parameterMap != null) {
                for (Entry<String, Object> entry : parameterMap.entrySet()) {
                    String name = entry.getKey();
                    String value = ConvertUtils.convert(entry.getValue());
                    if (StringUtils.isNotEmpty(name)) {
                        nameValuePairs.add(new BasicNameValuePair(name, value));
                    }
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
            EntityUtils.consume(httpEntity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpPost.abort();
        }
        return result;
    }

    public static String httpsGet(String url, Map<String, Object> parameterMap, Map<String, Object> headerMap) {
        Asserts.notBlank(url, "url is null");
        HttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            if (parameterMap != null) {
                for (Entry<String, Object> entry : parameterMap.entrySet()) {
                    String name = entry.getKey();
                    String value = ConvertUtils.convert(entry.getValue());
                    if (StringUtils.isNotEmpty(name)) {
                        nameValuePairs.add(new BasicNameValuePair(name, value));
                    }
                }
            }
            httpClient = new SSLClient();
            httpGet = new HttpGet(url + (StringUtils.contains(url, "?") ? "&" : "?") + EntityUtils.toString(new UrlEncodedFormEntity(nameValuePairs, "UTF-8")));
            if (null != headerMap && !headerMap.isEmpty()) {
                for (Iterator<String> iter = headerMap.keySet().iterator(); iter.hasNext(); ) {
                    String name = (String) iter.next();
                    String value = headerMap.get(name).toString();
                    httpGet.setHeader(name, value);
                }
            }
            HttpResponse response = httpClient.execute(httpGet);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "UTF-8");
                }
                EntityUtils.consume(resEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * GET请求
     *
     * @param url          URL
     * @param parameterMap 请求参数
     * @param headerMap    设置header
     * @return 返回结果
     */
    public static String get(String url, Map<String, Object> parameterMap, Map<String, Object> headerMap) {
        Asserts.notBlank(url, "url is null");
        String result = null;
        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(globalConfig)
                .build();
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            if (parameterMap != null) {
                for (Entry<String, Object> entry : parameterMap.entrySet()) {
                    String name = entry.getKey();
                    String value = ConvertUtils.convert(entry.getValue());
                    if (StringUtils.isNotEmpty(name)) {
                        nameValuePairs.add(new BasicNameValuePair(name, value));
                    }
                }
            }
            HttpGet httpGet = new HttpGet(url + (StringUtils.contains(url, "?") ? "&" : "?") + EntityUtils.toString(new UrlEncodedFormEntity(nameValuePairs, "UTF-8")));
            if (null != headerMap && !headerMap.isEmpty()) {
                for (Iterator<String> iter = headerMap.keySet().iterator(); iter.hasNext(); ) {
                    String name = (String) iter.next();
                    String value = headerMap.get(name).toString();
                    httpGet.setHeader(name, value);
                }
            }
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
            EntityUtils.consume(httpEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String post(String url, String json) {
        return post(url, json, null);
    }

    /**
     * @param url
     * @param json
     * @return String 返回类型
     * @throws
     * @Title: post
     * @Description:
     */
    public static String post(String url, String json, String respCharSet) {
        Asserts.notBlank(url, "url is null");
        String result = null;
        if (StringUtils.isEmpty(json)) {
            return result;
        }
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            StringEntity entity = new StringEntity(json, "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity, respCharSet);
            EntityUtils.consume(httpEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String postArray(String url, Map<String, Object> parameterMap, Map<String, Object> headerMap) {
        Asserts.notBlank(url, "url is null");
        String siteUrl = StringUtils.lowerCase(url);
        if (siteUrl.startsWith("https")) {
            return postSSL(siteUrl, parameterMap, headerMap);
        }
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(url);
            if (null != headerMap && !headerMap.isEmpty()) {
                for (Iterator<String> iter = headerMap.keySet().iterator(); iter.hasNext(); ) {
                    String name = (String) iter.next();
                    String value = headerMap.get(name).toString();
                    httpPost.setHeader(name, value);
                }
            }
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            if (parameterMap != null) {
                for (Entry<String, Object> entry : parameterMap.entrySet()) {
                    String name = entry.getKey();
                    if (entry.getValue() instanceof String[]) {
                        String[] values = (String[]) entry.getValue();
                        for (String v : values) {
                            if (StringUtils.isNotEmpty(v)) {
                                nameValuePairs.add(new BasicNameValuePair(name, v));
                            }
                        }
                    }
                    String value = ConvertUtils.convert(entry.getValue());
                    if (StringUtils.isNotEmpty(name)) {
                        nameValuePairs.add(new BasicNameValuePair(name, value));
                    }
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
            EntityUtils.consume(httpEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
