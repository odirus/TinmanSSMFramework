package cn.tinman.clouds.framework.response;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseMap {
    private int status;
    private String info;
    private Map data;
    private String dataVersion;

    private ResponseMap(int status, String info, Map data) {
        this.status = status;
        this.info = info;
        this.data = data;
        String dataString;
        if (data == null) {
            dataString = "empty";
        } else {
            dataString = new JSONObject(this.data).toJSONString();
        }
        this.dataVersion = Hashing.murmur3_128().newHasher().putString(dataString, Charsets.UTF_8).hash().toString();
    }

    private ResponseMap(int status, String info, JSONObject data) {
        this.status = status;
        this.info = info;
        this.data = data;
        String dataString;
        if (data == null) {
            dataString = "empty";
        } else {
            dataString = data.toJSONString();
        }
        this.dataVersion = Hashing.murmur3_128().newHasher().putString(dataString, Charsets.UTF_8).hash().toString();
    }

    public static ResponseMap SuccessResponse(Map data) {
        return new ResponseMap(CommonCode.SUCCESS.getStatus(), CommonCode.SUCCESS.getInfo(), data);
    }

    public static ResponseMap SuccessResponse(JSONObject data) {
        return new ResponseMap(CommonCode.SUCCESS.getStatus(), CommonCode.SUCCESS.getInfo(), data);
    }

    public static Map FailResponse(int status, String info, Map data) {
        ResponseMap responseMap = new ResponseMap(status, info, data);
        Map map = new HashMap();
        map.put("status", responseMap.getStatus());
        map.put("info", responseMap.getInfo());
        map.put("data", responseMap.getData());
        map.put("dataVersion", responseMap.getDataVersion());

        return map;
    }
}
