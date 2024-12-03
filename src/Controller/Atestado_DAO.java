
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


public class Atestado_DAO {
    public static void Impressão ()throws Exception {
 
        Document doc = null;
        OutputStream os = null;
        String x = JOptionPane.showInputDialog(null, "Digite o nome do paciente");
        String y = JOptionPane.showInputDialog(null, "Digite o numero de identidade do paciente");  
        String z = JOptionPane.showInputDialog(null, "Digite a data do atendimento medico ");
        String a = JOptionPane.showInputDialog(null, "Digite a data de inicio do atestado");
        String b = JOptionPane.showInputDialog(null, "Digite a data final do atestado");
        String c = JOptionPane.showInputDialog(null, "Digite a Doença do paciente");
 
   
  try {
 
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
 
            //cria a stream de saída
            os = new FileOutputStream("Atestado.pdf");
 
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
 
            //abre o documento
            doc.open();
           
 
            //adiciona o texto ao PDF
            Paragraph p1= new Paragraph ("ATESTADO MEDICO");
            p1.setAlignment(Element.ALIGN_CENTER); 
            Paragraph par1 = new Paragraph( " " ); 
            Paragraph par2 = new Paragraph("Atesto para " + " " + x + "\n " + "O SRº " + " " + x +"  " + " Portador da identidade nº " + "  " + y  + "  " + "esteve sob" + " cuidados médicos no dia " + "  " + z + "  " + "e deverá se afastar" + " de suas atividades pelo período de " + "  " + a +"  " + "até" + " " +b +  " " + "por motivos de" + " " + c);      
            par2.setAlignment(Element.ALIGN_CENTER); 
           
            
           doc.add(p1);
           doc.add(par1);
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
        Desktop.getDesktop().open(new File("Atestado.pdf"));
    }
}
