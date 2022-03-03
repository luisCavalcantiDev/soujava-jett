package br.com.emmanuelneri.utils;

import com.google.common.collect.Lists;
import net.sf.jett.exception.TagParseException;
import net.sf.jett.model.Block;
import net.sf.jett.tag.BaseTag;
import net.sf.jett.tag.TagContext;
import net.sf.jett.util.AttributeUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class JettTrafficCellTag extends BaseTag {

    public static final String ATTRIBUTE_VALUE = "value";

    private static final List<String> REQUIRED_ATTRIBUTES =
            Lists.newArrayList(ATTRIBUTE_VALUE);

    private BigDecimal enteredValue;

    @Override
    public boolean process() {
        TagContext context = getContext(); // Jett
        Sheet sheet = context.getSheet(); //Jett
        Block block = context.getBlock(); //Jett

        Cell cell = sheet.getRow(block.getTopRowNum()).getCell(block.getLeftColNum()); // POI
        
        //TODO: incompativel com a v0.11.0 do Jett em relação a v0.6.0
        //SheetUtil.setCellValue(cell, enteredValue, getAttributes().get(ATTRIBUTE_VALUE)); // Jett
        cell.setCellStyle(getCellColorByEnteredValue(sheet.getWorkbook(), enteredValue));
        return true;
    }

    @Override
    public String getName() {
        return "trafficCell";
    }

    @Override
    protected List<String> getRequiredAttributes() {
        List<String> reqAttrs = super.getRequiredAttributes();
        reqAttrs.addAll(REQUIRED_ATTRIBUTES);
        return reqAttrs;
    }

    @Override
    protected List<String> getOptionalAttributes() {
        return super.getOptionalAttributes();
    }

    @Override
    public void validateAttributes() {
        super.validateAttributes();
        TagContext context = getContext();
        Map<String, Object> beans = context.getBeans();
        Map<String, RichTextString> attributes = getAttributes();

        if (!isBodiless()) {
            throw new TagParseException("Traffic Cell tags must not have a body.");
        }

        //TODO: incompativel com a v0.11.0 do Jett em relação a v0.6.0
        //enteredValue = BigDecimal.valueOf(AttributeUtil.evaluateDouble(attributes.get(ATTRIBUTE_VALUE), beans, ATTRIBUTE_VALUE, 0));

    }

    private CellStyle getCellColorByEnteredValue(final Workbook workbook, BigDecimal enteredValue) {
        CellStyle cellStyle = cellStyle = workbook.createCellStyle();
        // TODO
        if(enteredValue.compareTo(BigDecimal.ZERO) == 0) {

        }

        return cellStyle;
    }
}
