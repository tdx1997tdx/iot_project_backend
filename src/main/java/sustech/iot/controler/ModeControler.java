package sustech.iot.controler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import sustech.iot.dto.LedState;
import sustech.iot.service.LedStateService;
import sustech.iot.service.ModeService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * mode模块controler层
 */
@ResponseBody
@RestController
@CrossOrigin
@RequestMapping(value = "/mode")
public class ModeControler {
    @Resource
    private ModeService modeService;

    /**
     * /mode/get_mode 接口，获取状态信息
     */
    @GetMapping(value = "/get_mode")
    public String getState(){
        Map result=modeService.getModeService();
        return JSON.toJSONString(result);
    }

    /**
     * /user/modify_state 接口，修改led灯状态
     */
    @RequestMapping(value = "/modify_mode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String modifyState(@RequestBody JSONObject jsonParam){
        int state=Integer.parseInt(jsonParam.getString("state"));
        Map result=modeService.modifyModeService(state);
        return JSON.toJSONString(result);
    }

}
