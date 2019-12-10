package sustech.iot.service;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import sustech.iot.dto.LedState;
import sustech.iot.dto.Record;
import sustech.iot.mapper.LedStateMapper;
import sustech.iot.mapper.RecordMapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordService {
    @Resource
    private RecordMapper recordMapper;

    //获取led灯状态
    public List<Record> getRecordService(int page,int volume){
        PageHelper.startPage(page, volume);
        List<Record> records=recordMapper.getRecords();
        return records;
    }

    //修改led灯状态
    public Map<String,String> addRecordService(Record record){
        Map<String,String> res=new HashMap<>();
        boolean isOk=recordMapper.addRecord(record);
        if(isOk){
            res.put("state","1");
            res.put("message","添加成功");
        }else {
            res.put("state","0");
            res.put("message","添加失败");
        }
        return res;
    }
}
