package vn.com.pn.common.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import vn.com.pn.common.output.BaseOutput;

import java.util.List;

public class CommonFunction {
    private static Log logger = LogFactory.getLog(CommonFunction.class);

    public static BaseOutput successOutput(List<Object> list){
        logger.info("CommonFunction.successOutput");
        BaseOutput output = new BaseOutput();
        if(list != null && list.size() > 0){
            output.setTotalRecord(list.size());
            output.setData(list);
        } else {
            output.setTotalRecord(0);
            output.setData(null);
        }
        output.setStatus(CommonConstants.STATUS.STATUS_SUCCESS);
        output.setMessage(ScreenMessageConstants.SUCCESS);
        return output;
    }

    public static BaseOutput successOutput(Object data){
        logger.info("CommonFunction.successOutput");
        BaseOutput output = new BaseOutput();
        output.setTotalRecord(1);
        output.setData(data);
        output.setStatus(CommonConstants.STATUS.STATUS_SUCCESS);
        output.setMessage(ScreenMessageConstants.SUCCESS);
        return output;
    }

    public static BaseOutput failureOutput() {
        logger.info("CommonFunction.failureOutput");
        BaseOutput output = new BaseOutput();
        output.setStatus(CommonConstants.STATUS.STATUS_FAILURE);
        output.setMessage(ScreenMessageConstants.FAILURE);
        return output;
    }

    public static String convertToJSONString(Object object) {
        logger.info("CommonFunction.convertToJSONString");
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertToJSONStringResponse(BaseOutput object){
        logger.info("CommonFunction.convertToJSONString");
        try{
            ObjectMapper mapper = new ObjectMapper();
            return "response status: " + mapper.writeValueAsString(object.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
