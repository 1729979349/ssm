package com.zking.ssm.controller;

import com.zking.ssm.model.BookFile;
import com.zking.ssm.service.IBookFileService;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.vo.BookFileVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("bookFile")
public class BookFileController {

    //宗旨：文件上传和下载 ：文件从哪里来，放哪里去

    private static  final String DEFAULT_PATH="/uploads/";

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBookFileService bookFileService;

    /**
     * 图片上传
     * @param request
     * @param bookFileVo
     * @return
     */
    @RequestMapping(value = "upload",method = RequestMethod.POST )
    public String upload(HttpServletRequest request,BookFileVo bookFileVo){
        try {
            //1、将文件上传至服务器的指定位置
            MultipartFile bFile=bookFileVo.getBFile();
            //1.1拼接相对路径
            String relativePath=DEFAULT_PATH+bFile.getOriginalFilename();
            //1.2将相对路径转换为绝对路径
            String absolutePath=transforPath(request,relativePath);
            //1.3实现文件上传
            bFile.transferTo(new File(absolutePath));
            //2、将文件保存到t_book_file表中
            //3根据book_id修改书本信息中的book_image字段
            bookFileVo.setRealName(bFile.getOriginalFilename());
            bookFileVo.setContentType(bFile.getContentType());

            bookService.updateByPrimaryKeySelective(bookFileVo);


//            System.out.println(bFile.getOriginalFilename());
//            System.out.println(bFile.getContentType());
//            System.out.println(bookFileVo.getBookId());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/book/bookList";
    }

    /**
     * 图片下载
     * @param fileId
     * @param request
     * @return
     */
    @RequestMapping("download")
    public ResponseEntity<byte[]> download(String fileId,HttpServletRequest request){

        try {
            //先根据文件id查询对应图片信息
            BookFile bookFile = bookFileService.selectByPrimaryKey(fileId);

            //1.1拼接相对路径
            String relativePath=DEFAULT_PATH+bookFile.getRealName();
            //1.2将相对路径转换为绝对路径
            String absolutePath=transforPath(request,relativePath);

            //下载关键代码
            File file=new File(absolutePath);
            HttpHeaders headers = new HttpHeaders();//http头信息
            String downloadFileName = new String(bookFile.getRealName().getBytes("UTF-8"),"iso-8859-1");//设置编码
            headers.setContentDispositionFormData("attachment", downloadFileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 将相对路径转换为绝对路径
     * @param request
     * @param Path 相对路径
     * @return 绝对路径
     */
    private String transforPath(HttpServletRequest request, String Path){
        return request.getServletContext().getRealPath(Path);
    }
}
