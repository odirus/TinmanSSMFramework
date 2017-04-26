package cn.tinman.clouds.framework.response;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ResponseList {
    private int status;
    private String info;
    private List data;
    private String dataVersion;

    private ResponseList(int status, String info, List data) {
        this.status = status;
        this.info = info;
        this.data = data;
        String dataString;
        Map tempJSONObject = new HashMap();
        tempJSONObject.put("list", data);
        if (data == null) {
            dataString = "empty";
        } else {
            dataString = new JSONObject(tempJSONObject).toJSONString();
        }
        this.dataVersion = Hashing.murmur3_128().newHasher().putString(dataString, Charsets.UTF_8).hash().toString();
    }

    public static ResponseList SuccessResponse(List data) {
        return new ResponseList(CommonCode.SUCCESS.getStatus(), CommonCode.SUCCESS.getInfo(), data);
    }

    public static Map FailResponse(int status, String info, List data) {
        ResponseList responseMap = new ResponseList(status, info, data);
        Map map = new HashMap();
        map.put("status", responseMap.getStatus());
        map.put("info", responseMap.getInfo());
        map.put("data", responseMap.getData());
        map.put("dataVersion", responseMap.getDataVersion());

        return map;
    }
}
