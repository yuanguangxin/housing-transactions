package com.yyy.housingtransactions.util;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.URLEncoder;

public class FileUtil {
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static String accessKey = "g9c1jG2Jp9GWsLVczK_4Mzxq9wQxroBNxkzTKmNA";

    public static String secretKey = "wDZqSJylYXg8QWjY7fywcLjQOQd70aNsRbOxsHqo";

    public static String bucket = "hrbust";

    public static String upload(String key, InputStream inputStream) throws Exception {
        Configuration cfg = new Configuration(Zone.zone0());
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        UploadManager uploadManager = new UploadManager(cfg);
        Response response = uploadManager.put(inputStream, key, upToken, null, null);
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        return getUrl(putRet.key);
    }

    public static void delete(String url) {
        try {
            Configuration cfg = new Configuration(Zone.zone0());
            Auth auth = Auth.create(accessKey, secretKey);
            BucketManager bucketManager = new BucketManager(auth, cfg);
            String name = url.substring(url.lastIndexOf("/") + 1);
            if (name.indexOf("default") == -1) {
                bucketManager.delete(bucket, name);
            }
        } catch (Exception e) {
            logger.error("删除图片异常", e);
        }
    }

    public static String getUrl(String key) throws Exception {
        if (key == null) {
            return null;
        }
        String fileName = key;
        String domainOfBucket = "http://cdn.hrbust.vip";
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        return finalUrl;
    }

    public static Boolean isPic(String fileName) {
        String[] types = new String[]{".jpg", ".bmp", ".jpeg", ".png", ".gif"};
        boolean isPic = false;
        for (String type : types) {
            if (fileName.toLowerCase().endsWith(type)) {
                isPic = true;
            }
        }
        return isPic;
    }
}
