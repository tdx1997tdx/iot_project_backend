package sustech.iot.dto;

import lombok.Data;

@Data
public class LedState {
    private Integer id;
    private Integer state;
    public LedState(int state){
        this.state=state;
    }
}
