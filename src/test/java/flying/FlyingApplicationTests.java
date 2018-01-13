package flying;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import flying.config.enums.ResponseCommonMsgEnum;
import flying.service.sparrow.basic.SpTestService;
import flying.tool.AppContextTool;
import flying.tool.WarnMsgTool;
import flying.tool.file.PictureUploadTool;
import flying.tool.nozzle.RedisServiceI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlyingApplicationTests {
	
//	@Autowired
//	private AppContextTool appService;
//	@Autowired
//	private SpTestService testService;
//	@Autowired
//	private PictureUploadTool pictureUploadTool;

	@Test
	public void contextLoads() throws IOException {
//		pictureUploadTool.test();
//		System.out.println(testService.getById(1));
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String, String> result = new HashMap<String, String>();
//		result.put("test", "hello");
//		String json = mapper.writeValueAsString(result);
//		Map<String, String> out = mapper.readValue(json, Map.class);
//		System.out.println(out);
//		RedisServiceI redisService = appService.getRedis();
//		redisService.set("test", "hello", 60);
//		System.out.println(redisService.get("test"));
//		System.out.println(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.DEVICE_NEED_UPDATE.getValue()));
	}

}
