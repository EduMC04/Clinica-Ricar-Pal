package com.clinica.ricardo_palma.service;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openpdf.text.pdf.PdfPCell;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import org.openpdf.text.*;

import com.clinica.ricardo_palma.model.EstadisticaDoctorDTO;

@Service
public class ReportePdfService {
    
    public byte[] generarReporteGeneral(List<EstadisticaDoctorDTO>lista,String titulo) {

        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            
            PdfWriter.getInstance(document, outputStream);

            document.open();

            Font negrita = new Font(Font.HELVETICA,12,Font.BOLD, Color.CYAN);

            Paragraph datosEmpresa = new Paragraph();

            Image logo = Image.getInstance(getClass().getResource("/imagenes/clinica-ricardo-palma.png"));

            logo.scaleToFit(120, 60);

            Date date = new Date();

            String fechaActual = new SimpleDateFormat("yyy/MM/dd").format(date);

            String datosEmpre = """
                                    Ruc: 20100121809
                                    Clínica Ricardo Palma
                                    Telefono: 224·2224 / 224·2226
                                    Direccion: Av. Javier Prado Este 1066, San Isidro 15036
                                    """;

            datosEmpresa.add(datosEmpre);

            PdfPTable tablaencabezado = new PdfPTable(4);
            tablaencabezado.setWidthPercentage(100);
            tablaencabezado.getDefaultCell().setBorder(0);
            tablaencabezado.setHorizontalAlignment(Element.ALIGN_CENTER);

            float[] tamañoCeldas = new float[]{20f, 22f, 70f, 40f};
            tablaencabezado.setWidths(tamañoCeldas);

            PdfPCell celdaImagen = new PdfPCell(logo);
            celdaImagen.setBorder(0);
            celdaImagen.setHorizontalAlignment(Element.ALIGN_LEFT);
            celdaImagen.setVerticalAlignment(Element.ALIGN_MIDDLE);

            tablaencabezado.addCell(celdaImagen);

            tablaencabezado.addCell("");

            PdfPCell celdadatos = new PdfPCell(datosEmpresa);
            celdadatos.setBorder(0);
            celdadatos.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdadatos.setVerticalAlignment(Element.ALIGN_MIDDLE);

            tablaencabezado.addCell(celdadatos);

            PdfPCell celdaFecha = new PdfPCell(new Phrase(fechaActual));
            celdaFecha.setBorder(0);
            celdaFecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celdaFecha.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tablaencabezado.addCell(celdaFecha);

            document.add(tablaencabezado);

            document.add(new Paragraph(" "));
            Font negro = new Font(Font.HELVETICA,12,Font.BOLD, Color.BLACK);
            Paragraph tituloParrafo = new Paragraph(titulo, negro);
            tituloParrafo.setAlignment(Element.ALIGN_CENTER);
            document.add(tituloParrafo);
            document.add(new Paragraph(" "));

            /* Datos de doctores en tabla */

            //datos 
            PdfPTable tablaCabecera = new PdfPTable(7);
            tablaCabecera.setWidthPercentage(100);
            tablaCabecera.getDefaultCell().setBorder(0);
            tablaCabecera.setHorizontalAlignment(Element.ALIGN_CENTER);

            float[] tamañoCeldas6 = new float[]{10f, 30f, 30f, 20f, 20f, 20f,20f};
            tablaCabecera.setWidths(tamañoCeldas6);

            //cabeza
            PdfPCell celdaId = new PdfPCell(new Paragraph("N°", negrita));
            celdaId.setBackgroundColor(Color.WHITE);
            celdaId.setBorderWidthTop(0);
            celdaId.setBorderWidthBottom(0);
            celdaId.setBorderWidthLeft(1f);
            celdaId.setBorderWidthRight(1f);
            tablaCabecera.addCell(celdaId);

            PdfPCell celdaNombres = new PdfPCell(new Paragraph("Nombres", negrita));
            celdaNombres.setBackgroundColor(Color.WHITE);
            celdaNombres.setBorderWidthTop(0);
            celdaNombres.setBorderWidthBottom(0);
            celdaNombres.setBorderWidthLeft(0);
            celdaNombres.setBorderWidthRight(1f);
            tablaCabecera.addCell(celdaNombres);

            PdfPCell celdaApellidos = new PdfPCell(new Paragraph("Apellidos", negrita));
            celdaApellidos.setBackgroundColor(Color.WHITE);
            celdaApellidos.setBorderWidthTop(0);
            celdaApellidos.setBorderWidthBottom(0);
            celdaApellidos.setBorderWidthLeft(0);
            celdaApellidos.setBorderWidthRight(1f);
            tablaCabecera.addCell(celdaApellidos);

            PdfPCell celdaPunt = new PdfPCell(new Paragraph("Promedio Puntualidad", negrita));
            celdaPunt.setBackgroundColor(Color.WHITE);
            celdaPunt.setBorderWidthTop(0);
            celdaPunt.setBorderWidthBottom(0);
            celdaPunt.setBorderWidthLeft(0);
            celdaPunt.setBorderWidthRight(1f);
            tablaCabecera.addCell(celdaPunt);

            PdfPCell celdaTrato = new PdfPCell(new Paragraph("Promedio Trato", negrita));
            celdaTrato.setBackgroundColor(Color.WHITE);
            celdaTrato.setBorderWidthTop(0);
            celdaTrato.setBorderWidthBottom(0);
            celdaTrato.setBorderWidthLeft(0);
            celdaTrato.setBorderWidthRight(1f);
            tablaCabecera.addCell(celdaTrato);

            PdfPCell celdaCumpli = new PdfPCell(new Paragraph("Promedio Cumplimiento", negrita));
            celdaCumpli.setBackgroundColor(Color.WHITE);
            celdaCumpli.setBorderWidthTop(0);
            celdaCumpli.setBorderWidthBottom(0);
            celdaCumpli.setBorderWidthLeft(0);
            celdaCumpli.setBorderWidthRight(1f);
            tablaCabecera.addCell(celdaCumpli);

            PdfPCell celdaServi = new PdfPCell(new Paragraph("Promedio Servicio", negrita));
            celdaServi.setBackgroundColor(Color.WHITE);
            celdaServi.setBorderWidthTop(0);
            celdaServi.setBorderWidthBottom(0);
            celdaServi.setBorderWidthLeft(0);
            celdaServi.setBorderWidthRight(1f);
            tablaCabecera.addCell(celdaServi);

            int n = 1;
            for (EstadisticaDoctorDTO dto : lista) {
                tablaCabecera.addCell(new Phrase(String.valueOf(n)));
                tablaCabecera.addCell(new Paragraph(dto.getNombre()));
                tablaCabecera.addCell(new Paragraph(dto.getApellidos()));

                PdfPCell celdaPuntu = new PdfPCell(new Paragraph(dto.getPromedioPuntualidad().toString()));
                celdaPuntu.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaPuntu.setBorder(PdfPCell.NO_BORDER);

                PdfPCell celdaTra = new PdfPCell(new Paragraph(dto.getPromedioTrato().toString()));
                celdaTra.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaTra.setBorder(PdfPCell.NO_BORDER);

                PdfPCell celdaCumplim = new PdfPCell(new Paragraph(dto.getPromedioCumplimiento().toString()));
                celdaCumplim.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaCumplim.setBorder(PdfPCell.NO_BORDER);

                PdfPCell celdaServ = new PdfPCell(new Paragraph(dto.getPromedioServicio().toString()));
                celdaServ.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaServ.setBorder(PdfPCell.NO_BORDER);

                tablaCabecera.addCell(celdaPuntu);
                tablaCabecera.addCell(celdaTra);
                tablaCabecera.addCell(celdaCumplim);
                tablaCabecera.addCell(celdaServ);

                n++;
            }

            document.add(tablaCabecera);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (document.isOpen()) {
                document.close();
            }
        }

        return outputStream.toByteArray();

    }

}
