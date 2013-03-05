package com.udith.mycontacts.controller;

import com.udith.mycontacts.validators.ContactFormValidator;
import com.udith.mycontacts.bo.ContactBO;
import com.udith.mycontacts.model.User;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

  @Autowired
  private ContactBO contactBO;

  @Autowired
  private ContactFormValidator validator;

  public void setContactBO(ContactBO contactBO) {
    this.contactBO = contactBO;
  }

  @RequestMapping(value="/home", method= RequestMethod.GET)
  public String goToHomePage(){
    return "home";
  }

  @RequestMapping(value="/index" , method= RequestMethod.GET)
  public ModelAndView newUserForm(){
    ModelAndView mv = new ModelAndView("newUser");
    User user = new User();
    mv.getModelMap().put("newUser", user);
    return mv;
  }

  @RequestMapping(value="index", method =RequestMethod.POST)
    public String saveUserAndDisplay(@ModelAttribute("newUser")User user, BindingResult result,
      @RequestParam(value="image", required=false)MultipartFile image) {

        validator.validate(user, result);
        if(result.hasErrors()){
          return "newUser";
        }

        contactBO.saveContact(user);

        try{
          if(!image.isEmpty()){
            validateImage(image);
            saveImage(user.getUser_id().toString(), "jpg" , image);
          }
        }catch(ImageUploadException e){
          result.reject(e.getMessage());
          e.printStackTrace();
        }       
        return "redirect:viewAllUsers.htm";
    }

  @RequestMapping(value="/viewAllUsers")
  public String viewAllUsers(Model model){
    List<User> userList = contactBO.getAllContacts();
    model.addAttribute("userList", userList);
    return "showUsers";
  }

  @RequestMapping(value="/editUser", method= RequestMethod.GET)
  public ModelAndView displayEditUserView(@RequestParam("user_id") Integer user_id){
    ModelAndView model = new ModelAndView("editUser");
    User userToEdit = contactBO.getContactById(user_id);
    model.addObject("editUser", userToEdit);
    return model;
  }

  @RequestMapping(value="updateUser", method=RequestMethod.POST)
  public String updateUser(@ModelAttribute("editUser") User user, BindingResult result){    
    validator.validateEditUserForm(user, result);
    if(result.hasErrors()){
      return "editUser";
    }

    contactBO.updateContact(user);
    return "redirect:viewAllUsers.htm";
  }

  @RequestMapping(value="/deleteContact", method=RequestMethod.GET)
  public String deleteUser(@RequestParam("user_id") Integer user_id){
    contactBO.deleteContact(user_id);
    return "redirect:viewAllUsers.htm";
  }

  private void validateImage(MultipartFile image) throws ImageUploadException {
    if(!image.getContentType().equals("image/jpeg")){
      throw new ImageUploadException("only JPG images accepted");
    }
  }

  private void saveImage(String fileName, String fileExtention, MultipartFile image) throws ImageUploadException {
    try{
      File file = new File("c:/temp/" + fileName + "." + fileExtention);
      FileUtils.writeByteArrayToFile(file, image.getBytes());
      //ImageIO.write((RenderedImage) image,fileExtention, file);
    }catch(IOException ioe){
      throw new ImageUploadException("unable to save image" + ioe);
    }
  }

}
