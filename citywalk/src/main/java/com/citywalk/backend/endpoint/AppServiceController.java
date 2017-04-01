package com.citywalk.backend.endpoint;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citywalk.backend.model.AppService;
import com.citywalk.backend.service.AppServiceService;

@RestController
@RequestMapping(value="/appService/api")
public class AppServiceController {
	
	private Logger logger = Logger.getLogger(AppServiceController.class);

	@Autowired
	private AppServiceService appService;

	@RequestMapping(value="/save", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public  String save(@RequestBody AppService service) {
		JSONObject jsonObject = new JSONObject();
		try {
			appService.save(service);
			logger.info("App Service SUCCESSFULLY SAVED...");
			jsonObject.put("STATUS", "SUCCESS");
			jsonObject.put("MESSAGE", "App Service saved successfully...");
			jsonObject.put("STATUS_CODE", HttpStatus.OK);
		} catch (Exception ex) {
			logger.info("Exception raised while saving App Service...");
			try {
				jsonObject.put("STATUS", "FAILURE");
				jsonObject.put("MESSAGE", "Exception raised while saving App Service...");
				jsonObject.put("STATUS_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
				jsonObject.put("CAUSE", ex.getStackTrace());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

	@RequestMapping(value="/list", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public String listServices(@RequestBody AppService service) {
		JSONObject jsonObject = new JSONObject();
		try {
			List<AppService> services = appService.findAll();
			logger.info("AppService SUCCESSFULLY SAVED...");
			jsonObject.put("STATUS", "SUCCESS");
			jsonObject.put("MESSAGE", "AppService saved successfully...");
			jsonObject.put("STATUS_CODE", HttpStatus.OK);
			jsonObject.put("services", services);
		} catch (Exception ex) {
			logger.info("Exception raised while saving AppService...");
			try {
				jsonObject.put("STATUS", "FAILURE");
				jsonObject.put("MESSAGE", "Exception raised while saving AppService...");
				jsonObject.put("STATUS_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
				jsonObject.put("CAUSE", ex.getStackTrace());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

	@RequestMapping(value="/update", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public String update(@RequestBody AppService service) {
		JSONObject jsonObject = new JSONObject();
		try {
			AppService updatedAppService = appService.update(service);
			logger.info("ORDER SUCCESSFULLY SAVED...");
			jsonObject.put("STATUS", "SUCCESS");
			jsonObject.put("MESSAGE", "AppService saved successfully...");
			jsonObject.put("STATUS_CODE", HttpStatus.OK);
			jsonObject.put("UPDATED_AppService", updatedAppService);
		} catch (Exception ex) {
			logger.info("Exception raised while saving AppService...");
			try {
				jsonObject.put("STATUS", "FAILURE");
				jsonObject.put("MESSAGE", "Exception raised while saving AppService...");
				jsonObject.put("STATUS_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
				jsonObject.put("CAUSE", ex.getStackTrace());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public String delete(@RequestBody AppService service){
		JSONObject jsonObject = new JSONObject();
		try {
			appService.delete(service.getId());
			logger.info("AppService SUCCESSFULLY SAVED...");
			jsonObject.put("STATUS", "SUCCESS");
			jsonObject.put("MESSAGE", "AppService deleted successfully...");
			jsonObject.put("STATUS_CODE", HttpStatus.OK);
		} catch (Exception ex) {
			logger.info("Exception raised while saving AppService...");
			try {
				jsonObject.put("STATUS", "FAILURE");
				jsonObject.put("MESSAGE", "Exception raised while deleting AppService...");
				jsonObject.put("STATUS_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
				jsonObject.put("CAUSE", ex.getStackTrace());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

}