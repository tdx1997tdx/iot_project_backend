package sustech.iot.controler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import sustech.iot.dto.LedState;
import sustech.iot.service.LedStateService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * led模块controler层
 */
@ResponseBody
@RestController
@CrossOrigin
@RequestMapping(value = "/led")
public class LedStateControler {
    @Resource
    private LedStateService ledStateService;

    /**
     * /led/get_state 接口，获取led灯状态
     */
    @GetMapping(value = "/get_state")
    public String getState(){
        Map result=ledStateService.getStateService();
        return JSON.toJSONString(result);
    }

    /**
     * /user/modify_state 接口，修改led灯状态
     */
    @RequestMapping(value = "/modify_state", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String modifyState(@RequestBody JSONObject jsonParam){
        int state=Integer.parseInt(jsonParam.getString("state"));
        LedState ledState=new LedState(state);
        Map result=ledStateService.modifyStateService(ledState);
        return JSON.toJSONString(result);
    }

}
