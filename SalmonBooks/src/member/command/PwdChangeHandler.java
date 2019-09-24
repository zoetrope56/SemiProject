package member.command;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.Member;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
//import member.service.PwdChangeService;
import mvc.command.CommandHandler;

public class PwdChangeHandler implements CommandHandler{
   private static final String FORM_VIEW = "/WEB-INF/views/pwdChangeForm.jsp";      // 여기다가 경로를 써주세연>▽<
//   private PwdChangeService changePwdSvc = new PwdChangeService();

   @Override
   public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
      if(req.getMethod().equalsIgnoreCase("GET")) {
         return processForm(req, res);
      }else if(req.getMethod().equalsIgnoreCase("POST")) {
         return processSubmit(req, res);
      }else {
         res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
         return null;
      }
   }

   private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
      HttpSession session = req.getSession(false);
      Member member = (Member)session.getAttribute("member");
      Map<String, Boolean> errors = new HashMap<>();
      req.setAttribute("errors", errors);

      String newPwd = createPwd();
      System.out.println("newPwd" + newPwd);
      session.setAttribute("password", newPwd);   //롸님을 위해 제가 쏴넣었어여 jsp에서 꺼내쓰세여 >ㅁ<

      if(newPwd.equals(null) || newPwd.isEmpty()) {
         errors.put("newPwd", Boolean.TRUE);
      }
      if(!errors.isEmpty()) {
         return FORM_VIEW;
      }

      try {
         System.out.println("[PwdChangeHandler] : "+member.getUserId()+" "+getSHA512(newPwd));
//         changePwdSvc.changePwd(member, getSHA512(newPwd));
         
//         session.invalidate();
         session.setAttribute("password", newPwd);

      }catch(InvalidPasswordException e) {
         errors.put("badCurPwd", Boolean.TRUE);
      } catch(MemberNotFoundException e) {
         res.sendError(HttpServletResponse.SC_BAD_REQUEST);
      }
      return "/WEB-INF/views/NewPwd.jsp";

   }

   private String processForm(HttpServletRequest req, HttpServletResponse res) {
      return FORM_VIEW;
   }

   private static String getSHA512(String pwd) {
      try {
         MessageDigest md = MessageDigest.getInstance("SHA-512");
         byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
         md.update(bytes);

         return Base64.getEncoder().encodeToString(md.digest());

      } catch (NoSuchAlgorithmException e) {

         System.out.println("암호화 에러 발생!");
         e.printStackTrace();
         return null;
      }
   }

   public static String createPwd() {
      StringBuffer temp = new StringBuffer();

      Random rnd = new Random();
      
      for (int i = 0; i < 10; i++) {


         int rIndex = rnd.nextInt(3);
         switch (rIndex) {
         case 0:
            // a-z
            temp.append((char) ((int) (rnd.nextInt(26)) + 97));
            break;
         case 1:
            // A-Z
            temp.append((char) ((int) (rnd.nextInt(26)) + 65));
            break;
         case 2:
            // 0-9
            temp.append((rnd.nextInt(10)));
            break;
         }        
      }
      System.out.println("[PwdChangeHandler] : "+temp.toString());
      return temp.toString();
   }




}