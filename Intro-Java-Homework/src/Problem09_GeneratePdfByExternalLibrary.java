import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Problem09_GeneratePdfByExternalLibrary {
	public static void main(String[] args) throws Exception { 
		Document document=new Document(); 
		PdfWriter.getInstance(document,new FileOutputStream("AllCards.pdf")); 
		document.open(); 
		BaseFont myArial = BaseFont.createFont("./font/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font myUnicodeFont = new Font(myArial, 12);
	    PdfPTable bigTable= new PdfPTable(4);
        float cellWidth = 80/bigTable.getNumberOfColumns();
        float cellHeight = cellWidth*5.5f;
        
        for (int i = 2; i < 15; i++)
        {
            for (int s = 0; s < 4; s++)
            {
            	String cardToPrint="";
                String Suit;
                switch (s)
                {
                    case 0: { Suit = "\u2663";myUnicodeFont.setColor(BaseColor.BLACK); break; }
                    case 1: { Suit = "\u2666";myUnicodeFont.setColor(BaseColor.RED); break; }
                    case 2: { Suit = "\u2665";myUnicodeFont.setColor(BaseColor.RED); break; }
                    case 3: { Suit = "\u2660";myUnicodeFont.setColor(BaseColor.BLACK); break; }
                    default: Suit = "no"; break;
                }
                if (i <= 10)
                {
                    System.out.printf("%s%s\t", i, Suit);          
                    bigTable.addCell(addCell(i+Suit, myUnicodeFont,cellHeight));
                }
                else
                {
                    switch (i)
                    {
                        case 11: cardToPrint="J"; break;
                        case 12: cardToPrint="Q"; break;
                        case 13: cardToPrint="K"; break;
                        case 14: cardToPrint="A"; break;
                    }
                   System.out.printf("%s%s\t", cardToPrint, Suit);
                   bigTable.addCell( addCell(cardToPrint+Suit, myUnicodeFont,cellHeight));
                }
            }
            System.out.println();

        }  
        document.add(bigTable);
		document.close();
	}

    public static PdfPCell addCell(String Card, Font myUnicodeFont,float cellHeigth) throws DocumentException {
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell =new PdfPCell();

        cell.setFixedHeight(cellHeigth);
        cell.setPaddingTop(-5);
        Paragraph myParagraph = new Paragraph(Card, myUnicodeFont);
        cell.setBorderWidthBottom(0);
        cell.addElement(myParagraph);
        table.addCell(cell);
        
        cell =new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        myParagraph.setAlignment(Element.ALIGN_RIGHT); 
        cell.setBorderWidthTop(0f);
        cell.addElement(myParagraph);
        table.addCell(cell);
        
        PdfPCell theNewCell = new PdfPCell(table);
        theNewCell.setBorder(Rectangle.NO_BORDER);   // removes border
        theNewCell.setPadding(5);
        return theNewCell;
    }
}
