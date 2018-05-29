package com.IDCard.controller;




import com.IDCard.Identify.FaceTool;
import com.IDCard.Identify.IDCard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * create by zhouchengchao on 2018/5/21
 */
//@Controller
@RestController          //@RestController=@Controller+@ResponseBody
@CrossOrigin("http://localhost:8088") //设置跨域访问
public class MethodController {

    @PostMapping("/getimage")
  //  @ResponseBody
    public IDCard getimage(@RequestParam("file")MultipartFile file){
       // file.getBytes();
      //  File target =new  File("c:/image/out.jpg");
        FaceTool ft = new FaceTool();
        IDCard idCard = new IDCard();
        try {
//            file.getBytes();
//            System.out.println("----------------------------------");
//            System.out.println(file.getBytes());
//            System.out.println(file.isEmpty());

//            System.out.println(file);
//            System.out.println(file.getOriginalFilename());
//            System.out.println(file.getSize());

            //创建临时文件
            String filepath="D:/"+file.getOriginalFilename();
            File file1=new File(filepath);
            file.transferTo(file1);


            idCard.setCard_path(filepath);
//          Img img=new Img(file.getBytes());
            ft.Identify(idCard,null);
            System.out.println("idCard:" + idCard.toString());




        }catch (Exception e){
            e.printStackTrace();
        }
//        List<IDCard> list=new LinkedList<IDCard>();
//        list.add(idCard);

        return idCard;
    }



//    @RequestMapping("/getimage")
//    @ResponseBody
//    public String getimage(HttpServletRequest request){
//        // file.getBytes();
//        String filepath=request.getParameter("file");
//        FaceTool ft = new FaceTool();
//        IDCard idCard = new IDCard();
//        try {
//            System.out.println(filepath);
//            File file=new File(filepath);
//            File file1=new File("D:/data.jpg");
//            file.renameTo(file1);
//
//            idCard.setCard_path(filepath);
//
//            ft.Identify(idCard,null);
//            System.out.println("idCard:" + idCard.toString());
//
//
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return idCard.toString();
//    }
//
//
}
