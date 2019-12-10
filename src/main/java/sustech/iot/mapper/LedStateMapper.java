package sustech.iot.mapper;
import sustech.iot.dto.LedState;

public interface LedStateMapper {
    /**
     * 获取led灯状态
     * @return
     */
    LedState getLedState();

    /**
     * 修改led灯状态
     * @return
     */
    boolean modifyLedState(LedState ledState);
}
