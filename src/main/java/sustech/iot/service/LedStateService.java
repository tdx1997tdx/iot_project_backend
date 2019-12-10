package sustech.iot.service;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import sustech.iot.dto.LedState;
import sustech.iot.mapper.LedStateMapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LedStateService {
    @Resource
    private LedStateMapper ledStateMapper;

    //获取led灯状态
    public Map<String,Integer> getStateService(){
        Map<String,Integer> res=new HashMap<>();
        LedState ledState=ledStateMapper.getLedState();
        res.put("state",ledState.getState());
        return res;
    }

    //修改led灯状态
    public Map<String,String> modifyStateService(LedState ledState){
        Map<String,String> res=new HashMap<>();
        boolean isOk=ledStateMapper.modifyLedState(ledState);
        if(isOk){
            res.put("state","1");
            res.put("message","修改成功");
        }else {
            res.put("state","0");
            res.put("message","修改失败");
        }
        return res;
    }
}
