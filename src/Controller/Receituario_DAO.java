
package Controller;

import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;


public class Receituario_DAO {
    public static void Impressão2 ()throws Exception {
 
        Document doc = null;
        OutputStream os = null;
        String x = JOptionPane.showInputDialog(null, "Digite o nome do médico ");
        String z = JOptionPane.showInputDialog(null, "Digite o CRM do médico ");
        String y = JOptionPane.showInputDialog(null, "Digite o nome do paciente");  
      
 
   
  try {
 
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
 
            //cria a stream de saída
            os = new FileOutputStream("Receituario.pdf");
 
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
 
            //abre o documento
            doc.open();
           
 
            //adiciona o texto ao PDF
            Paragraph p3= new Paragraph ("Nome:" + " " + x);
            Paragraph p4= new Paragraph ("CRM:" + " " + y);
            Paragraph p1= new Paragraph ("RECEITÁRIO");
            p1.setAlignment(Element.ALIGN_CENTER); 
            Paragraph par1 = new Paragraph( " " ); 
            Paragraph par2 = new Paragraph("Paciente" + " " + y);      
           
            
           doc.add(p3);
           doc.add(p4);
           doc.add(par1);
           doc.add(p1);
           doc.add(par2); 
         
           
        } finally {
 
            if (doc != null) {
 
                //fechamento do documento
                doc.close();
            }
 
            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }
        }
        Desktop.getDesktop().open(new File("Receituario.pdf"));
    }
}
