package com.demo.spring.controller;

import java.io.*;

import com.demo.spring.service.FilmService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by web on 02/05/17.
 */
@Controller
@RequestMapping(value = "/reports")
public class ReportsController {
    @Autowired
    FilmService filmService;

    @RequestMapping(value = "/createFilmReport", method = RequestMethod.GET)
    public String createFilmReport()
    {
//        JasperReportBuilder report = DynamicReports.report();//a new report
//        report
//                .columns(
//                        Columns.column("Film Name", "filmname", DataTypes.stringType()))
//                .title(//title of the report
//                        Components.text("Film Report")
//                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
//                .pageFooter(Components.pageXofY())//show page number on the page footer
//                .setDataSource(filmService.findAll());
//
//        try {
//
//            //export the report to a pdf file
//            report.toPdf(new FileOutputStream("FilmReport.pdf"));
//        } catch (DRException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        return "redirect:/reports/viewFilmReport";
    }

    @RequestMapping(value = "/viewFilmReport", method = RequestMethod.GET)
    public void viewBrandReport(HttpServletRequest request, HttpServletResponse response)
    {

        ServletContext context = request.getServletContext();

        File report = new File("FilmReport.pdf");
        FileInputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(report);

            response.setContentType(context.getMimeType("FilmReport.pdf"));

            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s", report.getName());
            response.setHeader(headerKey, headerValue);

            outputStream = response.getOutputStream();

            IOUtils.copy(inputStream, outputStream);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
                if (null != inputStream)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}