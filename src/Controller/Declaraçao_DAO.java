
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


public class Declaraçao_DAO {
    public static void Impressão3 ()throws Exception {
 
        Document doc = null;
        OutputStream os = null;
        String x = JOptionPane.showInputDialog(null, "Digite o motivo da declaração ");
        String z = JOptionPane.showInputDialog(null, "Digite o nome da pessoa ");
        String y = JOptionPane.showInputDialog(null, "Digite o dia de atendimento"); 
        String a = JOptionPane.showInputDialog(null, "Digite quanto tempo foi esse atendimento");
      
 
   
  try {
 
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
 
            //cria a stream de saída
            os = new FileOutputStream("Declaração.pdf");
 
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
 
            //abre o documento
            doc.open();
           
 
            //adiciona o texto ao PDF
            Paragraph p1= new Paragraph ("DECLARAÇÃO DE COMPARECIMENTO");
            p1.setAlignment(Element.ALIGN_CENTER); 
            Paragraph par1 = new Paragraph( " " ); 
            Paragraph par2 = new Paragraph("Declaro para fins de" + " " + x + " " + "que o (a) SR.(a) " + " " + z + " " + "esteve em consulta no dia" + " " + y +" " + "durante o período " + " " + a);      
           
            
           doc.add(p1);
           doc.add(par1);
           doc.add(par1);
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
        Desktop.getDesktop().open(new File("Declaração.pdf"));
    }
}

