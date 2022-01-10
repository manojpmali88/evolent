package com.example.ContactInfo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ContactInfo.model.ContactInfo;
import com.example.ContactInfo.repository.ContactInfoRepository;

@RestController
@RequestMapping("/contact")
public class ContactInfoController {
	
	@Autowired
	ContactInfoRepository lContactInfoRepository;
	
	List<ContactInfo> list = new ArrayList<ContactInfo>();
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ContactInfo> getContactInfo(){
		//return list;
		List<ContactInfo> list = new ArrayList<ContactInfo>();
		lContactInfoRepository.findAll().forEach(list::add);
		return list;
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public Optional<ContactInfo> getContactInfoId(@PathVariable("id") String id){
//		ContactInfo lContactInfo = null;
//		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).getFirstName().equals(id)){
//				lContactInfo =  list.get(i);
//			}
//		}
//		return lContactInfo;
		return lContactInfoRepository.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addContactInfo(@RequestBody ContactInfo obj) throws JSONException{
		//list.add(obj);
		JSONObject jobj = new JSONObject();
		lContactInfoRepository.save(obj);
		jobj.put("status", true);
		jobj.put("message", "Record added successfully");
		return new ResponseEntity<String>(jobj.toString(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> updateContactInfo(@RequestBody ContactInfo obj) throws JSONException{
//		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).getFirstName().equals(id)){
//				list.set(i, obj);
//			}
//		}
		JSONObject jobj = new JSONObject();
		lContactInfoRepository.save(obj);
		jobj.put("status", true);
		jobj.put("message", "Record updated successfully");
		return new ResponseEntity<String>(jobj.toString(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteContactInfo(@PathVariable("id") String id) throws JSONException{
//		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).getFirstName().equals(id)){
//				list.remove(i);
//			}
//		}
		JSONObject jobj = new JSONObject();
		lContactInfoRepository.deleteById(id);
		jobj.put("status", true);
		jobj.put("message", "Record deleted successfully");
		return new ResponseEntity<String>(jobj.toString(),HttpStatus.OK);
	}
}
