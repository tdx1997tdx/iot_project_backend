package sustech.iot.service;

import org.springframework.stereotype.Service;
import sustech.iot.dto.LedState;
import sustech.iot.mapper.LedStateMapper;
import sustech.iot.mapper.ModeMapper;
import sustech.iot.mqttUtil.MqttGateway;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class ModeService {
    @Resource
    private ModeMapper modeMapper;
    @Resource
    private MqttGateway mqttGateway;

    //获取led灯状态
    public Map<String,Integer> getModeService(){
        Map<String,Integer> res=new HashMap<>();
        Integer modeState=modeMapper.getModeState();
        res.put("state",modeState);
        return res;
    }

    //修改led灯状态
    public Map<String,String> modifyModeService(Integer i){
        Map<String,String> res=new HashMap<>();
        boolean isOk=modeMapper.modifyModeState(i);
        if(isOk){
            mqttGateway.sendToMqtt("mode",String.valueOf(i));
            res.put("state","1");
            res.put("message","修改成功");
        }else {
            res.put("state","0");
            res.put("message","修改失败");
        }
        return res;
    }
}
