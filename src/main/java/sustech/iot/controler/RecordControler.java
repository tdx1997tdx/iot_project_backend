package sustech.iot.controler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import sustech.iot.dto.LedState;
import sustech.iot.dto.Record;
import sustech.iot.service.LedStateService;
import sustech.iot.service.RecordService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * record模块controler层
 */
@ResponseBody
@RestController
@CrossOrigin
@RequestMapping(value = "/record")
public class RecordControler {
    @Resource
    private RecordService recordService;

    /**
     * /record/get_record 接口，分页获取记录
     */
    @RequestMapping(value = "/get_record", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getRecord(@RequestBody JSONObject jsonParam){
        int page=Integer.parseInt(jsonParam.getString("page"));
        int volume=Integer.parseInt(jsonParam.getString("volume"));
        List<Record> records=recordService.getRecordService(page,volume);
        return JSON.toJSONString(records);
    }

    /**
     * /record/add_record 接口，添加record
     */
    @RequestMapping(value = "/add_record", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String modifyState(@RequestBody JSONObject jsonParam){
        Record record = JSON.parseObject(jsonParam.toString(), Record.class);
        Map result=recordService.addRecordService(record);
        return JSON.toJSONString(result);
    }

}
