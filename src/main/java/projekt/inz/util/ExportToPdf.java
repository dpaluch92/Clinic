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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import projekt.inz.pojo.Doktor;
import projekt.inz.pojo.Pacjent;

/**
 *
 * @author depek
 */
public class ExportToPdf {

    public ExportToPdf() {

    }

    public void export(Doktor doktor, Pacjent pacjent, String przepisanieRecepty, Date dataWydania) {
        Document d = new Document(PageSize.A4);
        d.addAuthor(doktor.getImie() + " " + doktor.getNazwisko());
        try {
            PdfWriter.getInstance(d, new FileOutputStream(
                    "C:/Users/depek/OneDrive/Documents/NetBeansProjects/inz/"
                    + pacjent.getImie() + "_" + pacjent.getNazwisko() + ".pdf"));
            d.open();
            d.add(new Paragraph("Pacjent - " + pacjent.getImie() + " " + pacjent.getNazwisko() + "\n\n"));
            d.add(new Paragraph("\t"+przepisanieRecepty+"\n\n"));
            d.add(new Paragraph("Wydane przez : \n"
                    + doktor.getSpecjalnosc() + " " + doktor.getImie() + " " + doktor.getNazwisko() + "."));
            
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(ExportToPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        d.close();
    }
}
