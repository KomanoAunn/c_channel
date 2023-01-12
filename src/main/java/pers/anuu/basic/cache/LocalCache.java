package pers.anuu.basic.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pangxiong
 * @title: LocalCache
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/714:42
 */
public class LocalCache {
    private static final Map<String, CacheBean> map = new HashMap<String, CacheBean>();

    public static String getStringValue(String key) {
        CacheBean<String> cacheBean = map.get(key);
        if (cacheBean == null) {
            return null;
        }
        if (cacheBean.getExpireTime() != null && cacheBean.getExpireTime() < System.currentTimeMillis()) {
            map.remove(key);
            return null;
        }
        return String.valueOf(cacheBean.getValue());
    }

    /**
     *
     * @param key
     * @param value
     * @param expireTime 失效时间时间戳，不是再过多久失效
     * @return
     */
    public static boolean put(String key, Object value, Long expireTime) {
        CacheBean cacheBean = new CacheBean();
        cacheBean.setValue(value);
        cacheBean.setVersion(1);
        if (expireTime != null && expireTime > System.currentTimeMillis()) {
            cacheBean.setExpireTime(expireTime);
        }
        map.put(key, cacheBean);
        return Boolean.TRUE;
    }

    //TODO 清理过期数据
}
