package sustech.iot.mapper;
import sustech.iot.dto.Record;

import java.util.List;

public interface RecordMapper {
    /**
     * 获取所有记录
     * @return
     */
    List<Record> getRecords();

    /**
     * 添加记录
     * @return
     */
    boolean addRecord(Record record);
}
