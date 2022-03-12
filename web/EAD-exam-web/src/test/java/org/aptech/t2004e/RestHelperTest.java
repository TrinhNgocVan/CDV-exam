//package org.aptech.t2004e;
//
//import java.util.List;
//
//import org.aptech.t2004e.config.ServiceProperties;
//import org.aptech.t2004e.util.RestHelper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest
//public class RestHelperTest {
//	@Autowired
//	RestHelper restHelper ;
//	@Autowired
//	ServiceProperties serviceProperties ;
//	@Test
//  public void getAllDemoEntityTest() {
////		@SuppressWarnings("unchecked")
////		public List<BarnDto> getsByFarmCode(String farmCode) {
////			log.info("****************MANAGER::gets-by-farmCode********************");
////			ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_BARNS_BY_FARMCODE.val), HttpMethod.GET, new ParameterizedTypeReference<List<BarnDto>>() {}, farmCode);
////			return (List<BarnDto>) response.getBody();
////		}
//	  ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get("api-demo-gets"), HttpMethod.GET, new ParameterizedTypeReference<List<DemoDto>>() {});
//	  List<DemoDto> demos = (List<DemoDto> ) response.getBody();
//	  System.err.println(demos);
//  }
//}
