package com.example.administrator.myapplication.api;

import com.example.administrator.myapplication.AndroidApplication;

import java.io.File;

import okhttp3.Cache;

/**
 * Created by Administrator on 2018/3/11 0011.
 */

public class RetrofitService {
    private static final String HEAD_LINE_NEWS = "T1348647909107";

    static final long CACHE_STALE_SEC=60*60*24*1;
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    //查询网络的Cache-Control设置
    //(假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)
    static final String CACHE_CONTROL_NETWORK = "Cache-Control: public, max-age=3600";
    // 避免出现 HTTP 403 Forbidden，参考：http://stackoverflow.com/questions/13670692/403-forbidden-with-java-but-not-web-browser
    static final String AVOID_HTTP403_FORBIDDEN = "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";

    private static final String NEWS_HOST = "http://c.3g.163.com/";
    private static final String WELFARE_HOST = "http://gank.io/";
    private static final int INCREASE_PAGE = 20;

    private RetrofitService(){
        throw new AssertionError();
    }
    public static void init(){
        Cache cache = new Cache(new File(AndroidApplication.getAppContext().getCacheDir(), "HttpCache"),
                1024 * 1024 * 100);
    }
}
