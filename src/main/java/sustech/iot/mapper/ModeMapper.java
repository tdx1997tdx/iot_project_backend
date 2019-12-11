package sustech.iot.mapper;

public interface ModeMapper {
    /**
     * 获取led灯状态
     * @return
     */
    Integer getModeState();

    /**
     * 修改led灯状态
     * @return
     */
    boolean modifyModeState(Integer i);
}
