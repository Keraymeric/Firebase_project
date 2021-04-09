package com.example.florian.fichiertexteandbddtest1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

//import android.media.Image;

public class CreatePDF {

    static String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";


    public static void createPdf(String fileName, SharedPreferences loadPreparatif, SharedPreferences loadEquipeA, SharedPreferences loadEquipeB
            , SharedPreferences loadSet1, SharedPreferences loadSet2, SharedPreferences loadSet3, SharedPreferences loadSet4, SharedPreferences loadSet5,
                                 SharedPreferences loadResultat, SharedPreferences loadApprobation, Context context){

        File file = new File(DIRECTORY);
        if (!file.exists()) {
            file.mkdir();
        }

        //document
        Document document = new Document(PageSize.A4, 0f, 0f, 10f, 0f);
        try {
            String path = Environment.getExternalStorageDirectory().toString() + "/" + fileName + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(path));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //concernant la police
        FontSelector selector = new FontSelector();
        Font f1 = FontFactory.getFont(FontFactory.HELVETICA, 8);
        selector.addFont(f1);

        FontSelector selectorBigger = new FontSelector();
        Font fbigger = FontFactory.getFont(FontFactory.HELVETICA, 11);
        selectorBigger.addFont(fbigger);

        //génération du contenu

        //image entête
        // load image

        //document.open();
        Drawable d = context.getResources().getDrawable(R.drawable.pdfentete);
        BitmapDrawable bitDw = ((BitmapDrawable) d);
        Bitmap bmp = bitDw.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        Image pdfentete = null;
        try {
            pdfentete = Image.getInstance(stream.toByteArray());
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //document.add(pdfentete);
            //document.close();

        PdfPTable enteteImage = new PdfPTable(1);
        enteteImage.setWidthPercentage(90);
        try {
            enteteImage.setWidths(new int[]{1});
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        PdfPCell cellImage;
        cellImage = new PdfPCell();
        cellImage.addElement(pdfentete);
        cellImage.setBorder(Rectangle.NO_BORDER);
        enteteImage.addCell(cellImage);



        //Préparatif

        PdfPTable innertable = new PdfPTable(5);
        innertable.setWidthPercentage(90);
        try {
            innertable.setWidths(new int[]{8, 12, 1, 8, 12});
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        PdfPCell cell;
        PdfPCell bigcell;
        PdfPTable nestedTable;
        // first row
        // column 1
        cell = new PdfPCell(selectorBigger.process("Date : "));
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);
        // column 2
        cell = new PdfPCell(selectorBigger.process(loadPreparatif.getString("date", " ")));
        cell.setPaddingLeft(2);
        innertable.addCell(cell);
        // column 3
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);
        // column 4
        cell = new PdfPCell(selectorBigger.process("Compétition : "));
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);
        // column 5
        cell = new PdfPCell(selectorBigger.process(loadPreparatif.getString("competition", " ")));
        cell.setPaddingLeft(2);
        innertable.addCell(cell);
        // spacing
        cell = new PdfPCell();
        cell.setColspan(5);
        cell.setFixedHeight(3);
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);

        // second row
        // column 1
        cell = new PdfPCell(selectorBigger.process("Catégorie :"));
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);
        // column 2
        cell = new PdfPCell(selectorBigger.process(loadPreparatif.getString("categorie", " ")));
        cell.setPaddingLeft(2);
        innertable.addCell(cell);
        // column 3
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);
        // column 4
        cell = new PdfPCell(selectorBigger.process("Lieu : "));
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);
        // column 5
        cell = new PdfPCell(selectorBigger.process(loadPreparatif.getString("lieu", " ")));
        cell.setPaddingLeft(2);
        innertable.addCell(cell);
        // spacing
        cell = new PdfPCell();
        cell.setColspan(5);
        cell.setFixedHeight(3);
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);

        // third row
        // column 1
        cell = new PdfPCell(selectorBigger.process("Heure début :"));
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);
        // column 2
        cell = new PdfPCell(selectorBigger.process(loadPreparatif.getString("heureDebut", " ")));
        cell.setPaddingLeft(2);
        innertable.addCell(cell);
        // column 3
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);
        // column 4
        cell = new PdfPCell(selectorBigger.process("Heure fin : "));
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);
        // column 5
        cell = new PdfPCell(selectorBigger.process(loadResultat.getString("heureFin", ""))); //À FAIIIIIIIIIIRE <-------------------------------------------------------------------------------------------
        cell.setPaddingLeft(2);
        innertable.addCell(cell);
        // spacing
        cell = new PdfPCell();
        cell.setColspan(5);
        cell.setFixedHeight(3);
        cell.setBorder(Rectangle.NO_BORDER);
        innertable.addCell(cell);

        //table équipe A et équipe B
        PdfPTable tableEquipeEntete = new PdfPTable(new float[] {1, 1});
        tableEquipeEntete.setWidthPercentage(90);
        cell = new PdfPCell(selectorBigger.process("Équipe A : " + loadPreparatif.getString("nomEquipeA", " ")));
        cell.setBorder(Rectangle.NO_BORDER);
        tableEquipeEntete.addCell(cell);
        cell = new PdfPCell(selectorBigger.process("  Équipe B : " + loadPreparatif.getString("nomEquipeB", " ")));
        cell.setBorder(Rectangle.NO_BORDER);
        tableEquipeEntete.addCell(cell);
        tableEquipeEntete.setSpacingBefore(5);
        tableEquipeEntete.setSpacingAfter(5);

        PdfPTable tableEquipe = new PdfPTable(new float[] {1, 3, 1.5f, 0.25f, 1, 3, 1.5f});
        tableEquipe.setWidthPercentage(90);
        cell = new PdfPCell(selector.process("N° "));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process("NOMS - Prénoms "));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process("N° Licence "));
        tableEquipe.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process("N° "));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process("NOMS - Prénoms "));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process("N° Licence "));
        tableEquipe.addCell(cell);
        for(int i=1; i<=12; i++){
            cell = new PdfPCell(selector.process(loadEquipeA.getString("numA"+i, " ")));
            if(loadEquipeA.getString("numA"+i, "") == ""){
                cell = new PdfPCell(selector.process(" "));
            }
            tableEquipe.addCell(cell);
            cell = new PdfPCell(selector.process(loadEquipeA.getString("nomA"+i, " ")));
            tableEquipe.addCell(cell);
            cell = new PdfPCell(selector.process(loadEquipeA.getString("numLicenceA"+i, " ")));
            tableEquipe.addCell(cell);
            cell = new PdfPCell();
            cell.setBorder(Rectangle.NO_BORDER);
            tableEquipe.addCell(cell);
            cell = new PdfPCell(selector.process(loadEquipeB.getString("numB"+i, " ")));
            if(loadEquipeB.getString("numB"+i, "") == ""){
                cell = new PdfPCell(selector.process(" "));
            }
            tableEquipe.addCell(cell);
            cell = new PdfPCell(selector.process(loadEquipeB.getString("nomB"+i, " ")));
            tableEquipe.addCell(cell);
            cell = new PdfPCell(selector.process(loadEquipeB.getString("numLicenceB"+i, " ")));
            tableEquipe.addCell(cell);
        }
        cell = new PdfPCell(selector.process("Libéro"));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeA.getString("nomA13", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeA.getString("numLicenceA13", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process("Libéro"));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeB.getString("nomB13", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeB.getString("numLicenceB13", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process("Libéro"));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeA.getString("nomA14", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeA.getString("numLicenceA14", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process("Libéro"));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeB.getString("nomB14", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeB.getString("numLicenceB14", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process("Entraîneur"));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeA.getString("nomA15", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeA.getString("numLicenceA15", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process("Entraîneur"));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeB.getString("nomB15", " ")));
        tableEquipe.addCell(cell);
        cell = new PdfPCell(selector.process(loadEquipeB.getString("numLicenceB15", " ")));
        tableEquipe.addCell(cell);

        //table Signatures des formations
        PdfPTable tableEquipeSignature = new PdfPTable(new float[] {1,0.045f, 1});
        tableEquipeSignature.setWidthPercentage(90);
        cell = new PdfPCell(selector.process("Validation licences capitaine ou entraîneur Equipe B - Avant le match"));
        tableEquipeSignature.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableEquipeSignature.addCell(cell);
        cell = new PdfPCell(selector.process("Validation licences capitaine ou entraîneur Equipe A - Avant le match"));
        tableEquipeSignature.addCell(cell);
        Image imageSignatureEquipeA = null;
        try {
            imageSignatureEquipeA = Image.getInstance(DIRECTORY + "signatureValidationParEquipeB" + ".png");
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PdfPTable nestedSignatureA = new PdfPTable(new float[] {1, 2, 1});
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        nestedSignatureA.addCell(cell);
        cell = new PdfPCell(selector.process(" \n \n \n"));
        cell.addElement(imageSignatureEquipeA);
        cell.setBorder(Rectangle.NO_BORDER);
        nestedSignatureA.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        nestedSignatureA.addCell(cell);
        PdfPCell signatureACell = new PdfPCell();
        signatureACell.addElement(nestedSignatureA);
        tableEquipeSignature.addCell(signatureACell);

        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableEquipeSignature.addCell(cell);
        Image imageSignatureEquipeB = null;
        try {
            imageSignatureEquipeB = Image.getInstance(DIRECTORY + "signatureValidationParEquipeA" + ".png");
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PdfPTable nestedSignatureB = new PdfPTable(new float[] {1, 2, 1});
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        nestedSignatureB.addCell(cell);
        cell.addElement(imageSignatureEquipeB);
        cell.setBorder(Rectangle.NO_BORDER);
        nestedSignatureB.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        nestedSignatureB.addCell(cell);
        PdfPCell signatureBCell = new PdfPCell();
        signatureBCell.addElement(nestedSignatureB);
        tableEquipeSignature.addCell(signatureBCell);



        //Table des formations A et B

        PdfPTable tableFormationEntete = new PdfPTable(new float[] {1, 1});
        tableFormationEntete.setWidthPercentage(90);
        cell = new PdfPCell(selectorBigger.process("Formation équipe A"));
        cell.setBorder(Rectangle.NO_BORDER);
        tableFormationEntete.addCell(cell);
        cell = new PdfPCell(selectorBigger.process("  Formation équipe B"));
        cell.setBorder(Rectangle.NO_BORDER);
        tableFormationEntete.addCell(cell);
        tableFormationEntete.setSpacingBefore(5);
        tableFormationEntete.setSpacingAfter(5);

        PdfPTable tableFormation = new PdfPTable(new float[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5f, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        tableFormation.setWidthPercentage(90);
        cell = new PdfPCell(selector.process("Set "));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P1"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P2"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P3"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P4"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P5"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P6"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("T.M."));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("score"));
        tableFormation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("Set "));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P1"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P2"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P3"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P4"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P5"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("P6"));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("T.M."));
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("score"));
        tableFormation.addCell(cell);

        //set1
        cell = new PdfPCell(selector.process("1"));
        tableFormation.addCell(cell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Ap1", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementAp1", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Ap2", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementAp2", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Ap3", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementAp3", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Ap4", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementAp4", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Ap5", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementAp5", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Ap6", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementAp6", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1ChronoDebutA", " ")));
        if(loadSet1.getString("set1ChronoDebutA", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1ChronoFinA", " ")));
        if(loadSet1.getString("set1ChronoFinA", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Ascore", " ")));
        tableFormation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("1"));
        tableFormation.addCell(cell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Bp1", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementBp1", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Bp2", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementBp2", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Bp3", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementBp3", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Bp4", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementBp4", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Bp5", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementBp5", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Bp6", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1RemplacementBp6", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet1.getString("set1ChronoDebutB", " ")));
        if(loadSet1.getString("set1ChronoDebutB", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1ChronoFinB", " ")));
        if(loadSet1.getString("set1ChronoFinB", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set1Bscore", " ")));
        tableFormation.addCell(cell);

        //Set2
        cell = new PdfPCell(selector.process("2"));
        tableFormation.addCell(cell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Ap1", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementAp1", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Ap2", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementAp2", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Ap3", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementAp3", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Ap4", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementAp4", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Ap5", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementAp5", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Ap6", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementAp6", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        /*cell = new PdfPCell(selector.process(loadSet2.getString("set2ChronoDebutA", " ") + "/\n" + loadSet2.getString("set2ChronoFinA", " ")));
        tableFormation.addCell(cell);*/
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2ChronoDebutA", " ")));
        if(loadSet2.getString("set2ChronoDebutA", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2ChronoFinA", " ")));
        if(loadSet2.getString("set2ChronoFinA", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Ascore", " ")));
        tableFormation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("2"));
        tableFormation.addCell(cell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Bp1", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementBp1", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Bp2", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementBp2", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Bp3", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementBp3", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Bp4", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementBp4", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Bp5", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementBp5", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Bp6", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2RemplacementBp6", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        /*cell = new PdfPCell(selector.process(loadSet2.getString("set2ChronoDebutB", " ") + "/\n" + loadSet2.getString("set2ChronoFinB", " ")));
        tableFormation.addCell(cell);*/
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet2.getString("set2ChronoDebutB", " ")));
        if(loadSet2.getString("set2ChronoDebutB", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2ChronoFinB", " ")));
        if(loadSet2.getString("set2ChronoFinB", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        cell = new PdfPCell(selector.process(loadSet2.getString("set2Bscore", " ")));
        tableFormation.addCell(cell);


        //set3
        cell = new PdfPCell(selector.process("3"));
        tableFormation.addCell(cell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Ap1", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementAp1", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Ap2", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementAp2", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Ap3", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementAp3", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Ap4", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementAp4", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Ap5", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementAp5", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Ap6", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementAp6", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        /*cell = new PdfPCell(selector.process(loadSet3.getString("set3ChronoDebutA", " ") + "/\n" + loadSet3.getString("set3ChronoFinA", " ")));
        tableFormation.addCell(cell);*/
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3ChronoDebutA", " ")));
        if(loadSet3.getString("set3ChronoDebutA", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3ChronoFinA", " ")));
        if(loadSet3.getString("set3ChronoFinA", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        cell = new PdfPCell(selector.process(loadSet1.getString("set3Ascore", " ")));
        tableFormation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("3"));
        tableFormation.addCell(cell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Bp1", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementBp1", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Bp2", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementBp2", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Bp3", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementBp3", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Bp4", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementBp4", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Bp5", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementBp5", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Bp6", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3RemplacementBp6", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        /*cell = new PdfPCell(selector.process(loadSet3.getString("set3ChronoDebutB", " ") + "/\n" + loadSet3.getString("set3ChronoFinB", " ")));
        tableFormation.addCell(cell);*/
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet3.getString("set3ChronoDebutB", " ")));
        if(loadSet3.getString("set3ChronoDebutB", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3ChronoFinB", " ")));
        if(loadSet3.getString("set3ChronoFinB", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        cell = new PdfPCell(selector.process(loadSet3.getString("set3Bscore", " ")));
        tableFormation.addCell(cell);

        //set4
        cell = new PdfPCell(selector.process("4"));
        tableFormation.addCell(cell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Ap1", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementAp1", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Ap2", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementAp2", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Ap3", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementAp3", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Ap4", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementAp4", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Ap5", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementAp5", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Ap6", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementAp6", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        /*cell = new PdfPCell(selector.process(loadSet4.getString("set4ChronoDebutA", " ") + "/\n" + loadSet4.getString("set4ChronoFinA", " ")));
        tableFormation.addCell(cell);*/
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4ChronoDebutA", " ")));
        if(loadSet4.getString("set4ChronoDebutA", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4ChronoFinA", " ")));
        if(loadSet4.getString("set4ChronoFinA", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Ascore", " ")));
        tableFormation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("4"));
        tableFormation.addCell(cell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Bp1", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementBp1", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Bp2", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementBp2", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Bp3", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementBp3", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Bp4", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementBp4", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Bp5", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementBp5", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Bp6", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4RemplacementBp6", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        /*cell = new PdfPCell(selector.process(loadSet4.getString("set4ChronoDebutB", " ") + "/\n" + loadSet4.getString("set4ChronoFinB", " ")));
        tableFormation.addCell(cell);*/
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet4.getString("set4ChronoDebutB", " ")));
        if(loadSet4.getString("set4ChronoDebutB", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4ChronoFinB", " ")));
        if(loadSet4.getString("set4ChronoFinBset4ChronoFinB", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        cell = new PdfPCell(selector.process(loadSet4.getString("set4Bscore", " ")));
        tableFormation.addCell(cell);

        //set5
        cell = new PdfPCell(selector.process("5"));
        tableFormation.addCell(cell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Ap1", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementAp1", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Ap2", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementAp2", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Ap3", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementAp3", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Ap4", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementAp4", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Ap5", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementAp5", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Ap6", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementAp6", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        /*cell = new PdfPCell(selector.process(loadSet5.getString("set5ChronoDebutA", " ") + "/\n" + loadSet5.getString("set5ChronoFinA", " ")));
        tableFormation.addCell(cell);*/
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5ChronoDebutA", " ")));
        if(loadSet5.getString("set5ChronoDebutA", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5ChronoFinA", " ")));
        if(loadSet5.getString("set5ChronoFinA", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Ascore", " ")));
        tableFormation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableFormation.addCell(cell);
        cell = new PdfPCell(selector.process("5"));
        tableFormation.addCell(cell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Bp1", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementBp1", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Bp2", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementBp2", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Bp3", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementBp3", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Bp4", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementBp4", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Bp5", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementBp5", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Bp6", " ")));
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5RemplacementBp6", " ")));
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        /*cell = new PdfPCell(selector.process(loadSet5.getString("set5ChronoDebutB", " ") + "/\n" + loadSet5.getString("set5ChronoFinB", " ")));
        tableFormation.addCell(cell);*/
        nestedTable = new PdfPTable(new float[] {1});
        cell = new PdfPCell(selector.process(loadSet5.getString("set5ChronoDebutB", " ")));
        if(loadSet5.getString("set5ChronoDebutB", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5ChronoFinB", " ")));
        if(loadSet5.getString("set5ChronoFinB", "") == ""){
            cell = new PdfPCell(selector.process(" - "));
        }
        nestedTable.addCell(cell);
        nestedTable.setWidthPercentage(100);
        bigcell = new PdfPCell();
        bigcell.setPadding(0);
        bigcell.addElement(nestedTable);
        tableFormation.addCell(bigcell);
        cell = new PdfPCell(selector.process(loadSet5.getString("set5Bscore", " ")));
        tableFormation.addCell(cell);



        //RÉSULTATS
        PdfPTable tableResultat = new PdfPTable(new float[] {1});
        tableResultat.setWidthPercentage(90);
        cell = new PdfPCell(selectorBigger.process("Résultat"));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPaddingTop(10);
        cell.setPaddingBottom(10);
        tableResultat.setSpacingAfter(5);
        tableResultat.addCell(cell);
        cell = new PdfPCell(selector.process(loadResultat.getString("vainqueur", "....") + " bat " + loadResultat.getString("vaincu", "....") + " par " + loadResultat.getString("nbSetVainqueur", "....") + " sets à " + loadResultat.getString("nbSetVaincu", "....")));
        tableResultat.addCell(cell);


        //APPROBATIONS
        PdfPTable tableApprobationEntete = new PdfPTable(new float[] {1});
        tableApprobationEntete.setWidthPercentage(90);
        cell = new PdfPCell(selectorBigger.process("Approbations"));
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobationEntete.addCell(cell);
        tableApprobationEntete.setSpacingBefore(5);
        tableApprobationEntete.setSpacingAfter(5);

        PdfPTable tableApprobation = new PdfPTable(new float[] {1, 1, 0.5f, 1, 1, 1});
        tableApprobation.setWidthPercentage(90);
        cell = new PdfPCell(selector.process(" "));
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process("NOM - PRÉNOM"));
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process("Signatures"));
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process("N° Licence"));
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process("Club désigné"));
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process("Indemnité €/équipe"));
        tableApprobation.addCell(cell);

        //1er Arbitre
        cell = new PdfPCell(selector.process("1er Arbitre"));
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("nomArbitre1", " ")));
        tableApprobation.addCell(cell);
        Image imageSignatureArbitre1 = null;
        try {
            imageSignatureArbitre1 = Image.getInstance(DIRECTORY + "signatureArbitre1" + ".png");
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cell = new PdfPCell();
        cell.addElement(imageSignatureArbitre1);
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("numLicenceArbitre1", " ")));
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("clubDesigneArbitre1", " ")));
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("indemniteArbitre1", " ")));
        tableApprobation.addCell(cell);
        //2eme Arbitre
        cell = new PdfPCell(selector.process("2eme Arbitre"));
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("nomArbitre2", " ")));
        tableApprobation.addCell(cell);
        Image imageSignatureArbitre2 = null;
        try {
            imageSignatureArbitre2 = Image.getInstance(DIRECTORY + "signatureArbitre2" + ".png");
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cell = new PdfPCell();
        cell.addElement(imageSignatureArbitre2);
        tableApprobation.addCell(cell);
        //cell = new PdfPCell(selector.process(loadApprobation.getString("numLicenceArbitre2", "" )));
        //tableApprobation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobation.addCell(cell);
        //Capitaine A
        cell = new PdfPCell(selector.process("CAPITAINE A"));
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("nomCapitaineA", " ")));
        tableApprobation.addCell(cell);
        Image imageSignatureCapitaineA = null;
        try {
            imageSignatureCapitaineA = Image.getInstance(DIRECTORY + "signatureCapitaineA" + ".png");
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cell = new PdfPCell();
        cell.addElement(imageSignatureCapitaineA);
        tableApprobation.addCell(cell);
        //cell = new PdfPCell(selector.process(loadApprobation.getString("numLicenceArbitre1", "" )));
        //tableApprobation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobation.addCell(cell);
        //Capitaine B
        cell = new PdfPCell(selector.process("CAPITAINE B"));
        tableApprobation.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("nomCapitaineB", " ")));
        tableApprobation.addCell(cell);
        Image imageSignatureCapitaineB = null;
        try {
            imageSignatureCapitaineB = Image.getInstance(DIRECTORY + "signatureCapitaineB" + ".png");
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cell = new PdfPCell();
        cell.addElement(imageSignatureCapitaineB);
        tableApprobation.addCell(cell);
        //cell = new PdfPCell(selector.process(loadApprobation.getString("numLicenceArbitre1", "" )));
        //tableApprobation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobation.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        tableApprobation.addCell(cell);

        //Remarques
        /*PdfPTable tableRemarque = new PdfPTable(new float[] {1});
        tableRemarque.setWidthPercentage(90);
        cell = new PdfPCell(selectorBigger.process("Remarques et sanctions"));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPaddingTop(10);
        cell.setPaddingBottom(10);
        tableRemarque.setSpacingAfter(5);
        tableRemarque.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("remarque", "Aucune Remarque")));//prblème ?
        tableRemarque.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("remarque", "Aucune Remarque")));//prblème ?
        tableRemarque.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("nomArbitre1", " ")));
        cell.setPaddingBottom(10);
        tableApprobation.addCell(cell);*/

        PdfPTable tableRemarque = new PdfPTable(new float[] {1});
        tableRemarque.setWidthPercentage(90);
        cell = new PdfPCell(selectorBigger.process("Remarques et sanctions"));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPaddingTop(10);
        cell.setPaddingBottom(10);
        tableRemarque.setSpacingAfter(5);
        tableRemarque.addCell(cell);
        cell = new PdfPCell(selector.process(loadApprobation.getString("remarque", " ")));
        if(loadApprobation.getString("remarque", "") == ""){
            cell = new PdfPCell(selector.process(" "));
        }
        tableRemarque.addCell(cell);



        //Génération du document
        document.open();
        try {
            document.add(enteteImage);
            document.add(innertable);
            document.add(tableEquipeEntete);
            document.add(tableEquipe);
            document.add(tableEquipeSignature);
            document.add(tableFormationEntete);
            document.add(tableFormation);
            document.add(tableRemarque);
            document.add(tableResultat);
            //document.newPage(); //TEST saut de page
            document.add(tableApprobationEntete);
            document.add(tableApprobation);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }
}
