package br.com.emmanuelneri.utils;

import com.google.common.collect.Maps;
import net.sf.jett.tag.Tag;
import net.sf.jett.tag.TagLibrary;
import net.sf.jett.transform.ExcelTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.omnifaces.util.Faces;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class JettUtil {

    private JettUtil() {
    }

    public static void gerarExcel(final String templateResourcePath, final String fileName, final Map<String, Object> values) throws IOException, InvalidFormatException {

        final File templateFile = new File(Faces.getRealPath(templateResourcePath));

        final ByteArrayOutputStream bout = new ByteArrayOutputStream();
        final ExcelTransformer transformer = new ExcelTransformer();
        final Workbook workbook = WorkbookFactory.create(templateFile);

        transformer.transform(workbook, values);
        workbook.write(bout);

        Faces.sendFile(bout.toByteArray(), fileName, false);
    }

    public static void gerarExcelComMultiplasAbas(final String templateResourcePath, final String fileName, 
                                                  final List<String> templateSheetNamesList, final List<String> newSheetNamesList, final List<Map<String, Object>> values) 
    throws IOException, InvalidFormatException {

        final File templateFile = new File(Faces.getRealPath(templateResourcePath));

        final ByteArrayOutputStream bout = new ByteArrayOutputStream();
        final ExcelTransformer transformer = new ExcelTransformer();
        final Workbook workbook = WorkbookFactory.create(templateFile);

        transformer.transform(workbook, templateSheetNamesList, newSheetNamesList, values);
        workbook.write(bout);

        Faces.sendFile(bout.toByteArray(), fileName, false);
    }

    public static void gerarExcelComTags(final String templateResourcePath, final String fileName, final Map<String, Object> values) throws IOException, InvalidFormatException {

        final File templateFile = new File(Faces
        .getRealPath(templateResourcePath));

        final ByteArrayOutputStream bout = new ByteArrayOutputStream();
        final ExcelTransformer transformer = new ExcelTransformer();
        transformer.registerTagLibrary("emmanuelneri", new TagLibrary() {
            @Override
            public Map<String, Class<? extends Tag>> getTagMap() {
                Map<String, Class<? extends Tag>> mapTags = Maps.newHashMap();
                mapTags.put("trafficCell", JettTrafficCellTag.class);

                return null;
            }
        });

        final Workbook workbook = WorkbookFactory.create(templateFile);

        transformer.transform(workbook, values);
        workbook.write(bout);

        Faces.sendFile(bout.toByteArray(), fileName, false);
    }

}
