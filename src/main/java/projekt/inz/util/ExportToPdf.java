/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.util;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author depek
 */
public class ExportToPdf {

    public ExportToPdf() {

    }

    public void export() {
        Document d = new Document(PageSize.A4);
        d.addAuthor("dom");
        try {
            PdfWriter.getInstance(d, new FileOutputStream("C:/Users/depek/OneDrive/Documents/NetBeansProjects/inz/recepta.pdf"));
            d.open();
            d.add(new Paragraph("cos tam"));
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(ExportToPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        d.close();

    }
}
