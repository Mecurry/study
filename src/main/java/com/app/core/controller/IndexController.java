package com.app.core.controller;

import com.app.core.common.FileUploadTool;
import com.app.core.domain.FileManage;
import com.app.core.domain.PowerInfo;
import com.app.core.service.FileManageServiceImpl;
import com.app.core.service.PowerInfoServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
 import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 首页相关业务Controller
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private PowerInfoServiceImpl serviceImpl;
    @Autowired
    FileManageServiceImpl fileManageServiceImpl;

    @Value("${sys.upload.savepath}")
    private String savepath;

    /**
     * 查询列表
     * @return
     */
    @RequestMapping(value = "/list")
    public ModelAndView findAllList(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("powerList", serviceImpl.findAll());
        mv.setViewName("/index/list");
        return mv;
    }

    /**
     * 导入Excel至数据库
     */
    @RequestMapping(value = "/import_excel")
    @ResponseBody
    public String import_excel_html(HttpServletRequest request) throws Exception {
        List<Part> listPart = new ArrayList<>();
        try {
            Iterator its = request.getParts().iterator();
            while (its.hasNext()) {
                Part part = (Part) its.next();
                listPart.add(part);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        String fileName=FileUploadTool.getFileName(listPart.get(0));
            Workbook hssfWorkbook = null;
            if (fileName.endsWith("xlsx")) {
                hssfWorkbook = WorkbookFactory.create((listPart.get(0).getInputStream()));//Excel 2007
            } else if (fileName.endsWith("xls")) {
                hssfWorkbook = new HSSFWorkbook(listPart.get(0).getInputStream());//Excel 2003

            }
            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // 循环行Row  根据Excel文档的内容 从第几行开始读取
                for (int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    Row hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        Cell col1 = hssfRow.getCell(0);
                        Cell col2 = hssfRow.getCell(2);
                        Cell col3 = hssfRow.getCell(3);
                        Cell col4 = hssfRow.getCell(4);
                        Cell col5 = hssfRow.getCell(5);
                        Cell col6 = hssfRow.getCell(6);
                        Cell col7 = hssfRow.getCell(7);
                        Cell col8 = hssfRow.getCell(8);
                        Cell col9 = hssfRow.getCell(9);
                        Cell col10 = hssfRow.getCell(10);

                        PowerInfo p = new PowerInfo();
                        p.set序号(new Double(col1.getNumericCellValue()).intValue());
                        p.set厂站名(col2.getStringCellValue().trim());
                        p.set分支线路名称(col3.getStringCellValue().trim());
                        p.set项目名称(col4.getStringCellValue().trim());
                        p.set工作内容(col5.getStringCellValue().trim());
                        p.set任务来源(col6.getStringCellValue().trim());
                        p.set计划性质(col7.getStringCellValue().trim());
                        p.set工作类型(col8.getStringCellValue().trim());
                        p.set专业(col9.getStringCellValue().trim());
                        p.set工作班组(col10.getStringCellValue().trim());

                        serviceImpl.save(p);
                    }
                }
            }



    return "success";
    }




    /**
     * 附件上传页面
     * @return
     */
    @RequestMapping(value = "/upload_html")
    public ModelAndView upload_html(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index/upload");
        return mv;
    }


    /**
     * 上传附件至服务器本地
     * @param request
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public String uploadFiles(HttpServletRequest request) throws IOException, ServletException {
        String[] file_ids=(String[])(request.getParameterValues("file_id"));
        String file_id=file_ids[0];
        List<Part> listPart = new ArrayList<>();
        try {
            Iterator its = request.getParts().iterator();
            while (its.hasNext()) {
                Part part = (Part) its.next();
                listPart.add(part);
            }

            for (Part p :listPart) {
                FileUploadTool.createDirectory(savepath+file_id);
                FileUploadTool.writeToLocal(savepath+file_id+"\\"+FileUploadTool.getFileName(p),p);

                FileManage f=new FileManage();
                f.setCreateTime(new Date());
                f.setFileName(FileUploadTool.getFileName(p));
                f.setFilePath(savepath+file_id+"\\"+FileUploadTool.getFileName(p));
                f.setInfoId(Integer.parseInt(file_id));
                fileManageServiceImpl.save(f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
       return "success";
    }


    /**
     * 根据点击的信息获取当前信息的附件列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/fileList")
    @ResponseBody
    public ModelAndView fileList(HttpServletRequest request){
        String info_id= request.getParameter("info_id");
        ModelAndView mv = new ModelAndView();
        mv.addObject("fileList", fileManageServiceImpl.findByInfoId(Integer.parseInt(info_id)));
        mv.setViewName("/index/fileList");
        return mv;
    }

    /**
     * 下载附件
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/downloadFile")
    @ResponseBody
    public void downloadFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String info_id= request.getParameter("file_id");

        Optional<FileManage> f=fileManageServiceImpl.findById(Integer.parseInt(info_id));

        FileManage fm=f.orElse(null);
        FileUploadTool.downloadFile(request,response,fm.getFilePath(),fm.getFileName());


    }

    /**
     * 删除对应的附件
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/deleteFile")
    @ResponseBody
    public void deleteFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String info_id= request.getParameter("file_id");

        Optional<FileManage> f=fileManageServiceImpl.findById(Integer.parseInt(info_id));

        FileManage fm=f.orElse(null);
        FileUploadTool.deleteFile(new File(fm.getFilePath()));
        fileManageServiceImpl.delFile(fm.getId());


    }





}
