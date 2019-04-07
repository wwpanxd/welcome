package com.bootdo.welcome.publish.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.utils.FileUtil;
import com.bootdo.system.domain.FileDataDO;
import com.bootdo.system.service.FileDataService;
import com.bootdo.welcome.utils.RF;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("welcome/publish/file")
@Api(value="文件上传下载",description="文件上传下载")
public class PFileController {

	@Autowired
	FileDataService filedataservice;
	
	@Log("单个文件上传")
	@ResponseBody
	@PostMapping("/upload/one")
	@ApiOperation(value="单个文件上传", notes="单个文件上传,MultipartFile 的 file")
	RF upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String	fileName = FileUtil.renameToUUID(file.getOriginalFilename());
		try {
			  FileDataDO ipd= new FileDataDO();
//			  ipd.setFdata(Base64Utils.byte2Base64StringFun(file.getBytes()));
			  ipd.setFdata(file.getBytes());
			  ipd.setFname(fileName);
			  ipd.setFoname(file.getOriginalFilename());
			  if(fileName.contains(".")) ipd.setFtype(fileName.substring(fileName.lastIndexOf('.')+1));
			  ipd.setCtime(new Date());
			  filedataservice.save(ipd);
			  
		} catch (Exception e) {
			return  new RF(1,"上传失败",null);
		}
		
		List<String> furl= new ArrayList<String>();
		furl.add(fileName);
		
		return new RF(0,"上传成功",furl);
	}

	@Log("多文件上传")
	@PostMapping(value = "/upload/batch") 
	@ResponseBody
	@ApiOperation(value="多文件上传", notes="多文件上传,List<MultipartFile> 的 file")
	public RF handleFileUpload(MultipartHttpServletRequest request) { 
	    List<MultipartFile> files = request.getFiles("file"); 
	    MultipartFile file = null; 
	    
	    RF rf=new RF(0,"上传成功",new ArrayList<String>());
	    
	    for (int i = 0; i < files.size(); ++i) { 
	      file = files.get(i); 
	      if (!file.isEmpty()) { 
	    	  try {
	    		  
	    		  String fileName = FileUtil.renameToUUID(file.getOriginalFilename());				
				  FileDataDO ipd= new FileDataDO();
//				  ipd.setFdata(Base64Utils.byte2Base64StringFun(file.getBytes()));
				  ipd.setFdata(file.getBytes());
				  ipd.setFname(fileName);
				  ipd.setFoname(file.getOriginalFilename());
				  if(fileName.contains(".")) ipd.setFtype(fileName.substring(fileName.lastIndexOf('.')+1));
				  ipd.setCtime(new Date());
				  filedataservice.save(ipd);
				
				  rf.getUrl().add(fileName);
	    	  } catch (IOException e) {
				return  new RF(1,"上传失败",null);
			}
	      } 
	    } 
	    if(files.size()==0) return   new RF(1,"无上传文件",null);
	    return rf;
	  } 
	
	@Log("单个图片的url显示")
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/show/{filename:.+}",produces="image/webp")
	@ApiOperation(value="单个图片的,url显示", notes="单个图片的,url显示")
	 public ResponseEntity<?> showPIC(@PathVariable String filename) { 
	 try { 
		 FileDataDO ipd= filedataservice.getbyfname(filename);
		 ByteArrayResource r= new ByteArrayResource(ipd.getFdata());
		 return ResponseEntity  
	                .ok()  
//	                .headers(headers)  
//	                .contentType(MediaType.parseMediaType("application/octet-stream"))  
	                .body(r);  
		 
	 } catch (Exception e) { 
	  return ResponseEntity.notFound().build(); 
	 } 
	 } 
	
	@Log("单个文件的下载")
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/download/{filename:.+}")
	@ApiOperation(value="单个文件的下载", notes="单个文件的下载")
	 public ResponseEntity<?> downloadFile(@PathVariable String filename) { 
	 try { 
		 FileDataDO ipd= filedataservice.getbyfname(filename);
//		 ByteArrayResource r= new ByteArrayResource(Base64Utils.base64String2ByteFun(ipd.getFdata()));
		 ByteArrayResource r= new ByteArrayResource(ipd.getFdata());
		 
		 HttpHeaders headers = new HttpHeaders();  
		 	headers.add("content-type", "application/octet-stream");
	        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");  
//	        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", ipd.getFoname()));  
//	        headers.add("Content-Disposition", "attachment;filename="+ipd.getFoname());  
	        headers.add("Content-Disposition", "attachment;filename="+new String(ipd.getFoname().getBytes("GB2312"),"ISO-8859-1"));  
	        headers.add("Pragma", "no-cache");  
	        headers.add("Expires", "0"); 
		 
		 return ResponseEntity  
	                .ok()  
	                .headers(headers)  
	                .contentType(MediaType.parseMediaType("application/octet-stream"))  
//	                .body(new InputStreamResource(r.getInputStream()));  //并发下载时，使用InputStreamResource报错
		 			.body(r);  
		 
	 	} catch (Exception e) { 
	 		return ResponseEntity.notFound().build(); 
	 	} 
	 } 
	
}
